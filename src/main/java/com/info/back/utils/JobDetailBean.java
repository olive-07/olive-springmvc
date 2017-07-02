package com.info.back.utils;

import java.lang.reflect.Method;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobDetailBean extends QuartzJobBean {
	Logger logger = LoggerFactory.getLogger(getClass());
	private String targetObject;
	private String targetMethod;
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Object bean;
		Method m;
		try {
			bean = ctx.getBean(targetObject);
			m = bean.getClass().getMethod(targetMethod);
			m.invoke(bean, null);
		} catch (Exception e) {
			logger.error("executeInternal error ", e);
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.ctx = applicationContext;
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
}
