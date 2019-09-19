package com.ak1ak1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyOrderQuery;
import com.ak1ak1.entity.query.MyUserQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.service.MyOrderService;
import com.ak1ak1.service.MyUserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/order")
public class MyOrderController {
	
	@Autowired
	private MyOrderService myOrderService;
	
	// 查询所有订单
	@RequestMapping(value ="getOrders")
	@ResponseBody
	public Map<String, Object> getOrders(MyOrderQuery query){
		Map<String, Object> map = new HashMap<>();	
		QueryResult<MyUser> data = myOrderService.getMyUsers(query);
		if(data==null){
			map.put("code", "0");
			map.put("msg", "");
			map.put("count",0);
			map.put("data", null);
			return map;		
		}
		map.put("code", "0");
		map.put("msg", "");
		map.put("count",data.getmRecords());
		map.put("data", data.getmItems());
		return map;	
}
	
	// 导出全部数据
	
	
	// 导出筛选数据
	
	
	// 导出本页数据
	
}