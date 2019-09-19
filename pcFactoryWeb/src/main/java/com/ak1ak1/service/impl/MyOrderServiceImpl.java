package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyOrder;
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
	public QueryResult<MyOrder> getMyOrders(MyOrderQuery orderQuery) {
		Integer size = myOrderMapper.getMyOrdersCount(orderQuery);
		if(size<=0){
			return null;
		}
		List<MyOrder>  list = myOrderMapper.getMyOrders(orderQuery);
		QueryResult<MyOrder> result = new QueryResult<>(list,size,orderQuery.getPage());
		return result;
	}

	@Override
	public List<MyOrder> exportMyOrderInfo(MyOrderQuery orderquery) {
		return myOrderMapper.exportMyOrderInfo(orderquery);
	}


}
