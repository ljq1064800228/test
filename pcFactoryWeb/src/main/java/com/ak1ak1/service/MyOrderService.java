package com.ak1ak1.service;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyOrderQuery;
import com.ak1ak1.entity.query.QueryResult;

public interface MyOrderService {

	QueryResult<MyUser> getMyUsers(MyOrderQuery query);

}
