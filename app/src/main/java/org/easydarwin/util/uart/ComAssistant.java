package org.easydarwin.util.uart;

import java.io.IOException;
import java.security.InvalidParameterException;

import android_serialport_api.SerialPortFinder;

/**
 * serialport api和jni取自http://code.google.com/p/android-serialport-api/
 * 
 * @author benjaminwan 程序载入时自动搜索串口设备 n,8,1，没得选
 */
public class ComAssistant {
	public final static String txtMode = "txtMode";
	public final static String hexMode = "hexMode";
	String txtOrHexMode = ComAssistant.hexMode;
	SerialHelper ComA;
	SerialPortFinder mSerialPortFinder;// 串口设备搜索
	int iRecLines = 0;// 接收区行数

	/** Called when the activity is first created. */
	public ComAssistant(SerialHelper serialHelper, String serialport, String baudRate, String txtOrHexMode) {
		this.txtOrHexMode = txtOrHexMode;
		ComA = serialHelper;
		ComA.setPort(serialport);
		ComA.setBaudRate(baudRate);
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			CloseComPort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.finalize();
		}
	};

	public SerialHelper getSerialHelper() {
		return this.ComA;
	}

	// ----------------------------------------------------串口发送
	public void sendPortData(String sOut) {
		if (ComA != null && ComA.isOpen()) {
			if (this.txtOrHexMode.equalsIgnoreCase(ComAssistant.txtMode)) {
				ComA.sendTxt(sOut);
			} else if (this.txtOrHexMode.equalsIgnoreCase(ComAssistant.hexMode)) {
				ComA.sendHex(sOut);
			}
		}
	}

	// ----------------------------------------------------关闭串口
	public void CloseComPort() {
		if (ComA != null) {
			ComA.stopSend();
			ComA.close();
		}
	}

	// ----------------------------------------------------打开串口
	public void OpenComPort() throws Exception {
		try {
			ComA.open();
		} catch (SecurityException e) {
			throw new Exception("打开串口" + ComA.getPort() + "失败:没有串口读/写权限!");
		} catch (IOException e) {
			throw new Exception("打开串口" + ComA.getPort() + "失败:未知错误!");
		} catch (InvalidParameterException e) {
			throw new Exception("打开串口" + ComA.getPort() + "失败:参数错误!");
		}
	}

}