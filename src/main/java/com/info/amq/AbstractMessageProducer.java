package com.info.amq;

import java.io.Serializable;

public abstract class AbstractMessageProducer {
	public abstract void sendMessage(String serialId, Serializable message);
}
