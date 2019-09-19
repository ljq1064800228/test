package com.ak1ak1.repository.mapper;

import java.util.List;

import com.ak1ak1.entity.MyOrder;
import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyOrderQuery;

import tk.mybatis.mapper.common.Mapper;

public interface MyOrderMapper extends Mapper<MyOrder>{

	Integer getMyOrdersCount(MyOrderQuery orderQuery);

	List<MyUser> getMyOrders(MyOrderQuery orderQuery);

}
