package com.ak1ak1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.MySet;
import com.ak1ak1.entity.query.MysetQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.service.MySetService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/myset") 
public class MySetController {
	
	@Autowired
	private MySetService mySetService;
	
	// 配置课程查询
	@RequestMapping(value ="getMysets")
	@ResponseBody
	public Map<String, Object> getMysets(MysetQuery query){
		Map<String, Object> map = new HashMap<>();	
		QueryResult<MySet> data = mySetService.getMyUsers(query);
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
	
	// 保存视频所有配置信息
	@RequestMapping(value ="save")   
	@ResponseBody
	public Result saveItem(Long[] video_ids) {
		try {
			return mySetService.saveItem(video_ids);
		} catch (Exception e) {
			throw new RuntimeException("添加视频失败"+e);
		}
	}
}
