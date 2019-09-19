package com.ak1ak1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.query.MyCourseQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.service.MyCourseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/course")
public class MyCourseController {

	@Autowired
	private MyCourseService myCourseService;

	// 查询所有课程信息
	@RequestMapping(value ="getCourses")
	@ResponseBody
	public Map<String, Object> getCourses(MyCourseQuery query){
		Map<String, Object> map = new HashMap<>();	
		QueryResult<MyCourse> data = myCourseService.getCourses(query);
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

	// 下架课程
	@RequestMapping(value ="instock")
	@ResponseBody
	public Result instockItem(Long course_id) {
		try {
			int course_status = 2;  //下架
			return myCourseService.updateStatus(course_id,course_status);
		} catch (Exception e) {
			throw new RuntimeException("修改状态失败"+e);
		}
	}
	
	// 上架课程
	@RequestMapping(value ="reshelf")
	@ResponseBody
	public Result reshelfItem(Long course_id) {
		try {
			int course_status = 1;  //上架
			return myCourseService.updateStatus(course_id,course_status);
		} catch (Exception e) {
			throw new RuntimeException("修改状态失败"+e);
		}
	}
	
	// 添加课程
	@RequestMapping(value ="save")
	@ResponseBody
	public Result saveItem(MyCourse myCourse) {
		try {
			return myCourseService.saveItem(myCourse);
		} catch (Exception e) {
			throw new RuntimeException("添加课程失败"+e);
		}
		
	}
	
	// 编辑课程
	@RequestMapping(value ="update")
	@ResponseBody
	public Result updateItem(MyCourse myCourse) {
		try {
			return myCourseService.updateItem(myCourse);
		} catch (Exception e) {
			throw new RuntimeException("更新课程失败"+e);
		}
		
	}
}
