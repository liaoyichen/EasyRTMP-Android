package org.easydarwin.util;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.easydarwin.easypusher.StreamActivity;
import org.easydarwin.util.uart.ComAssistant;
import org.easydarwin.util.uart.ComBean;
import org.easydarwin.util.uart.MyFunc;
import org.easydarwin.util.uart.SerialHelper;

import static org.easydarwin.util.UartUtil.UartHelper.gotID;

public class UartUtil {

	public static String port = "/dev/ttyS1";// 接收端口
	public final static String BaudRate = "19200";
	public final static String TxtOrHexMode = ComAssistant.txtMode;

	public static String[] temporaryAndPMSerialRec;
	public static ComAssistant uartComAssistant = null;
	public static UartHelper uartHelper = new UartHelper();

	public static Integer TEMPORARY;
	public static Integer PM25;
	public static Integer HUMIDITY;
	private static Context context;

	// 温湿度串口类
	public static class UartHelper extends SerialHelper {
		private static String pre = "";
		public static Boolean gotID = false;

		@Override
		protected void onDataReceived(final ComBean ComRecData) {
			try {
				String rec = new String(ComRecData.bRec);
				if(rec.length() < 4){
					pre = pre + rec;
					return;
				}
				rec = pre + rec;
				Log.e("uart receive", rec);
				if(rec.startsWith("url:")){
					String url = rec.substring(4);
					gotID = true;
					//开始推流
					Intent mIntent = new Intent(StreamActivity.ACTION_NAME);
					mIntent.putExtra("command", "start");
					mIntent.putExtra("url",url);
					Log.e("command","start");
					Log.e("push stream url",url);
					//发送广播
					context.sendBroadcast(mIntent);
				}else if(rec.startsWith("stop")){
					//停止推流
					Intent mIntent = new Intent(StreamActivity.ACTION_NAME);
					mIntent.putExtra("command", "stop");
					//发送广播
					context.sendBroadcast(mIntent);
					gotID = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 打开温湿度端口
	 */
	public static void openComPort(Context mContext) {
		context = mContext;
		try {
			if (uartComAssistant == null) {
				uartComAssistant = new ComAssistant(uartHelper, port, BaudRate,
						TxtOrHexMode);
			}
			if (uartComAssistant != null && !uartComAssistant.getSerialHelper().isOpen()) {
				uartComAssistant.OpenComPort();
				while(!gotID){
					uartComAssistant.sendPortData("r");
					try{
						Thread.sleep(5000);
					}catch (Exception e){
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
