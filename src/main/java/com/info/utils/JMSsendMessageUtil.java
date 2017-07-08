package com.info.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公用jms发送方法
 * 
 * @author Administrator
 *
 */
public class JMSsendMessageUtil {

private static Logger logger = LoggerFactory.getLogger(JMSsendMessageUtil.class);
	
	private static volatile JMSProducer jms;

	public JMSsendMessageUtil() {
		if (jms == null) {
			logger.info("jms获取为空，构造方法中重新获取");
			jms = new JMSProducer();
		}
	}
	
	/**
	 * jms发送的方法
	 * @param map
	 */
	public static void sendMes(Map<String,Object> map){
		if (jms == null) {
			logger.info("jms获取为空，sendMes中重新获取");
			jms = new JMSProducer();
		}
		try {
			jms.send(map);
		} catch (Exception e) {
			logger.error("JMSsendMessageUtil发送队列异常", e);
		}
	}

}
