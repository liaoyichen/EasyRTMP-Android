package org.easydarwin.util.uart;


public class CheckinUtil {
	

	
	/*
	public static void sendCheckinData(final String cardCode){  //提交数据线程
        Thread sendThread = new Thread(new Runnable() {
			@Override
			public void run() {
				//上传环境数据
				if(Contants.MyTerminalInfo.getIsLogin() && Contants.MyTerminalInfo.getId()!=null){
					CheckinInfoEntity entity = new CheckinInfoEntity();
					entity.setTerminalid(Contants.MyTerminalInfo.getId());
					entity.setCheckinTime(Calendar.getInstance().getTime());
					entity.setEmployeeCard(cardCode);
					HttpClient.saveCheckinData(entity, new JsonResponseHandler() {
						@Override
						protected void handleSuccessMessage(int statusCode, Headers headers, String responseBody) {
							AjaxJson result = JSON.parseObject(responseBody, AjaxJson.class);
							if(result!=null&&result.isSuccess()){
								Log.i("saveCheckinData", "上传打卡数据成功");
							}else{
								Log.e("saveCheckinData", "上传打卡数据失败");
								if(result!=null){
									Log.e("saveCheckinData", result.getMsg());
								}
							}
						}
						@Override
						protected void handleFailureMessage(Request request, IOException e) {
							Log.e("打卡", e.getMessage(), e);
						}
					});
				}
			}
        });
        sendThread.start();
    }
*/

}
