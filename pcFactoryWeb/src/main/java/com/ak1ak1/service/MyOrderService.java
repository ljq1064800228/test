package com.ak1ak1.service;

import java.util.List;

import com.ak1ak1.entity.MyOrder;
import com.ak1ak1.entity.query.MyOrderQuery;
import com.ak1ak1.entity.query.QueryResult;

public interface MyOrderService {

	QueryResult<MyOrder> getMyOrders(MyOrderQuery query);

	List<MyOrder> exportMyOrderInfo(MyOrderQuery orderquery);


}
