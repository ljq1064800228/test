package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyUserQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.repository.mapper.MyUserMapper;
import com.ak1ak1.service.MyUserService;


@Transactional
@Service
public class MyUserServiceImpl implements MyUserService{
	
	@Autowired
	private MyUserMapper myUserMapper;

	@Override
	public QueryResult<MyUser> getMyUsers(MyUserQuery userQuery) {
		Integer size = myUserMapper.getMyUsersCount(userQuery);
		if(size<=0){
			return null;
		}
		List<MyUser>  list = myUserMapper.getMyUsers(userQuery);
		QueryResult<MyUser> result = new QueryResult<>(list,size,userQuery.getPage());
		return result;
	}

	@Override
	public List<MyUser> exportMyUserInfo(MyUserQuery userQuery) {
		return myUserMapper.exportMyUserInfo(userQuery);
	}

	@Override
	public Result updateStatus(Long user_id, int status) {
		myUserMapper.updateStatus(user_id,status);
		return new Result(true, "状态更新成功");
	}

}
