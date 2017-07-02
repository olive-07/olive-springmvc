package com.info.amq;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.ObjectMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

/**
 * 发送消息到 WEB 平台
 */
public class PlatformMessageProducer extends AbstractMessageProducer {

	private ActiveMQQueue destination;

	private List<JmsTemplate> jmsTemplate;

	private Serializable product;

	/**
	 * 原子整型计数（CAS），可以不使用同步 private volatile int value;
	 */
	private AtomicInteger current = new AtomicInteger(0);

	/**
	 * 轮询算法解决负载均衡
	 */
	private JmsTemplate findJmsTemplate() {
		int cur = current.getAndIncrement();
		int index = cur % jmsTemplate.size();
		return jmsTemplate.get(index);
	}

	/**
	 * 发送消息
	 */
	public void sendMessage(String serialId, Serializable message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", serialId);
		map.put("value", message);

		this.findJmsTemplate().convertAndSend(destination, map);
	}

	public ActiveMQQueue getDestination() {
		return destination;
	}

	public void setDestination(ActiveMQQueue destination) {
		this.destination = destination;
	}

	public List<JmsTemplate> getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(List<JmsTemplate> jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Serializable getProduct() {
		return product;
	}

	public void setProduct(Serializable product) {
		this.product = product;
	}

}
