package com.info.amq;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * 从 WEB 平台收到消息
 * Created by olive on 2017/1/5.
 */
public class PlatformMessageConsumer {

	AbstractMessageProducer upLayer;

	@SuppressWarnings({ "unused", "rawtypes" })
	public void receive(Object object) {

		if (object instanceof ObjectMessage) {
			ObjectMessage message = (ObjectMessage) object;
			try {
				Serializable obj = message.getObject();
				if (obj == null) {
					return;
				}
				System.out.println("从队列1" + obj);

			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		if (object instanceof HashMap) {
			HashMap message = (HashMap) object;
			if (message == null) {
				return;
			}
			System.out.println("从队列2" + message.get("data"));

		}
	}

	public AbstractMessageProducer getUpLayer() {
		return upLayer;
	}

	public void setUpLayer(AbstractMessageProducer upLayer) {
		this.upLayer = upLayer;
	}
}
