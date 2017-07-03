package com.info.amq;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 消息转换类
 *  Created by olive on 2017/1/5.
 */
public class PlatformObjectMessageConverter implements MessageConverter {

	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		ObjectMessage obj = null;
		if (message instanceof ObjectMessage) {
			obj = (ObjectMessage) message;
		}
		return obj;
	}

	public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
		/*
		 * ObjectMessage obj = null; if (object instanceof ObjectMessage) { obj
		 * = (ObjectMessage) object; } return obj;
		 */
		ObjectMessage obj = session.createObjectMessage();
		Map<String, Object> map = (Map<String, Object>) object;
		obj.setObject((Serializable) map.get("value"));
		obj.setJMSCorrelationID((String) map.get("key"));

		return obj;
	}
}
