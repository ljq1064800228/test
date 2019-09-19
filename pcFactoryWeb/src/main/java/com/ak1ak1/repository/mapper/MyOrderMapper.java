package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ak1ak1.entity.MyOrder;
import com.ak1ak1.entity.query.MyOrderQuery;

import tk.mybatis.mapper.common.Mapper;

public interface MyOrderMapper extends Mapper<MyOrder>{

	int getMyOrdersCount(@Param("query")MyOrderQuery orderQuery);

	List<MyOrder> getMyOrders(@Param("query")MyOrderQuery orderQuery);

	List<MyOrder> exportMyOrderInfo(@Param("query")MyOrderQuery orderquery);

}
