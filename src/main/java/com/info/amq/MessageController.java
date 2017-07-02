package com.info.amq;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.utils.JMSsendMessageUtil;

/**
 * Created by Administrator on 2017/1/5.
 */
@Controller
@RequestMapping("/Message")
public class MessageController {

	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	@Resource
	PlatformMessageProducer platformQueueProducer;

	@RequestMapping(value = "/SendMessage")
	@ResponseBody
	public void send(HttpServletRequest request, Model model) {
		logger.info(Thread.currentThread().getName() + "------------send to jms Start");
		platformQueueProducer.sendMessage("321", "123asdfsdf似的发射点发射点真的非常的");
		logger.info(Thread.currentThread().getName() + "------------send to jms End");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", "数据000000000");
		map.put("dasdasdas", "数据11111111");
		map.put("dasdgfdbrb", "数据22222222");
		JMSsendMessageUtil.sendMes(map);
//	        try {
//				Sender.pro();
//			} catch (JMSException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
