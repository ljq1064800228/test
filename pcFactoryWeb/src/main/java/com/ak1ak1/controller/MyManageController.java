package com.ak1ak1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak1ak1.entity.MyManage;
import com.ak1ak1.entity.query.MyManageQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.service.MyManageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/manage") 
public class MyManageController {

	@Autowired
	private MyManageService myManageService;
	
	// 查询课程所有批次
	@RequestMapping(value ="getManages")
	@ResponseBody
	public Map<String, Object> getManages(MyManageQuery query){
		Map<String, Object> map = new HashMap<>();	
		QueryResult<MyManage> data = myManageService.getMyManages(query);
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
	
	// 推广管理--生成课程
	@RequestMapping(value ="create")
	@ResponseBody
	public Result createItem(MyManage myManage) {
		try {
			return myManageService.createItem(myManage);
		} catch (Exception e) {
			throw new RuntimeException("修改状态失败"+e);
		}
	}
}
