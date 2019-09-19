package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyOrderQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.repository.mapper.MyOrderMapper;
import com.ak1ak1.service.MyOrderService;

@Transactional
@Service
public class MyOrderServiceImpl implements MyOrderService{

	@Autowired
	private MyOrderMapper myOrderMapper;
	
	@Override
	public QueryResult<MyUser> getMyUsers(MyOrderQuery orderQuery) {
		Integer size = myOrderMapper.getMyOrdersCount(orderQuery);
		if(size<=0){
			return null;
		}
		List<MyUser>  list = myOrderMapper.getMyOrders(orderQuery);
		QueryResult<MyUser> result = new QueryResult<>(list,size,orderQuery.getPage());
		return result;
	}

}
