package com.ak1ak1.service;

import com.ak1ak1.entity.User;

public interface UserServer {
	
	//登录查询 
	User getUsersByUserName(String userName);
	
	int updatePassword(User user);

}
