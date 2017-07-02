package com.info.back.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.info.back.domain.User;
import com.info.back.service.IUserService;
import com.info.utils.JMSsendMessageUtil;

import redis.clients.jedis.JedisCluster;

/**
 * @author lyq
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	public UserController() {
		System.out.println("UserController");
	}

	@Resource
	private IUserService userService;
	@Autowired
	private JedisCluster jedisCluster;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model) {
		System.out.println("UserController showUser");
		System.out.println("测试redis集群："+jedisCluster.get("RD_RUNDOCKIN0_ID"));
		int id = Integer.parseInt(request.getParameter("id"));  
        User user = userService.getUserById(id);  
        model.addAttribute("user", user);  
        return "showUser";  
	}
	
}
