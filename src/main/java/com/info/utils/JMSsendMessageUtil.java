package com.info.utils;

import java.util.Map;

/**
 * 公用jms发送方法
 * 
 * @author Administrator
 *
 */
public class JMSsendMessageUtil {

	/**
	 * jms发送的方法
	 * 
	 * @param map
	 */
	public static void sendMes(Map<String, Object> map) {
		JMSProducer jms = null;
		try {
			jms = new JMSProducer();
			jms.send(map);
		} catch (Exception e) {
		}
	}

}
