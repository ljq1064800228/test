package com.ak1ak1.service;

import java.util.List;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyUserQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;

public interface MyUserService {
	
	QueryResult<MyUser> getMyUsers(MyUserQuery userQuery);
	
	List<MyUser> exportMyUserInfo(MyUserQuery userQuery);

	Result updateStatus(Long user_id, int status);
	
	/* Result insertMyUsers(MyUser klUser); */

}
