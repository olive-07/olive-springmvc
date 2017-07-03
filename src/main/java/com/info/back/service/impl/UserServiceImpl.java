package com.info.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.back.dao.IUserDao;
import com.info.back.domain.User;
import com.info.back.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}

	public User getUserById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

}
