package com.ak1ak1.service.impl;

import java.util.Date;
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

import tk.mybatis.mapper.entity.Example;

@Transactional
@Service
public class MyUserServiceImpl implements MyUserService{
	
	@Autowired
	private MyUserMapper klUserMapper;

	@Override
	public QueryResult<MyUser> getMyUsers(MyUserQuery userQuery) {
		Integer size = klUserMapper.getMyUsersCount(userQuery);
		if(size<=0){
			return null;
		}
		List<MyUser>  list = klUserMapper.getMyUsers(userQuery);
		QueryResult<MyUser> result = new QueryResult<>(list,size,userQuery.getPage());
		return result;
	}

	@Override
	public List<MyUser> exportMyUserInfo(MyUserQuery userQuery) {
		return klUserMapper.exportMyUserInfo(userQuery);
	}

	@Override
	public Result insertMyUsers(MyUser klUser) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Result insertKlUsers(MyUser klUser) {
		Example phone = new Example(MyUser.class);
		phone.createCriteria().andEqualTo("phone", klUser.getPhone());
		List<MyUser> klUsers = klUserMapper.selectByExample(phone);
		if(klUsers!=null && klUsers.size()>0){
			return new Result(false, "已添加过");
		}
		klUser.setCreated(new Date());
		int num = klUserMapper.insertSelective(klUser);
		if(num>0){			
			return new Result(true, "添加成功");
		}
		return new Result(false, "添加失败");
	}*/

}
