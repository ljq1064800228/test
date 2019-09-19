package com.ak1ak1.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.User;
import com.ak1ak1.repository.mapper.UserServerMapper;
import com.ak1ak1.service.UserServer;




/**
 * 用户管理
 * @author 肖建福
 *
 */

@Transactional
@Service
public class UserServerImpl implements UserServer{
	
	@Resource
	private UserServerMapper userServerMapper;

	@Override
	public User getUsersByUserName(String userName) {		
		User user = userServerMapper.getUsersByUserName(userName);
		return user;
	}

	@Override
	public int updatePassword(User user) {
		int num = userServerMapper.updatePassword(user);
		return num;
	}

}
