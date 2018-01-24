/*
	Copyright (c) 2013-2016 EasyDarwin.ORG.  All rights reserved.
	Github: https://github.com/EasyDarwin
	WEChat: EasyDarwin
	Website: http://www.easydarwin.org
*/

package org.easydarwin.config;

import java.util.UUID;

/**
 * 类Config的实现描述：
 */
public class Config {

    public static final String SERVER_IP = "serverIp";
    public static final String SERVER_PORT = "serverPort";
    public static final String STREAM_ID = "streamId";
    public static final String STREAM_ID_PREFIX = "";
    public static final String DEFAULT_SERVER_IP = "192.168.1.106";
    public static final String DEFAULT_SERVER_PORT = "1945";
    public static final String DEFAULT_STREAM_ID = "live/stream";
    public static final String PREF_NAME = "easy_pref";
    public static final String K_RESOLUTION = "k_resolution";



    public static final String SERVER_URL = "serverUrl";
    public static String DEFAULT_SERVER_URL = "rtmp://192.168.1.106:1945/live/stream" + UUID.randomUUID().toString().substring(0, 2);

}
