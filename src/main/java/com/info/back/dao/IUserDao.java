package com.info.back.dao;

import org.springframework.stereotype.Repository;

import com.info.back.domain.User;

@Repository
public interface IUserDao {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}