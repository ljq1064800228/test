package com.ak1ak1.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.query.MyCourseQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.repository.mapper.MyCourseMapper;
import com.ak1ak1.service.MyCourseService;

@Transactional
@Service
public class MyCourseServiceImpl implements MyCourseService{
	 
	@Autowired
	private MyCourseMapper myCourseMapper;
	
	@Override
	public QueryResult<MyCourse> getCourses(MyCourseQuery myCourseQuery) {
		Integer size = myCourseMapper.getCoursesCount(myCourseQuery);
		if(size<=0){
			return null;
		}
		List<MyCourse>  list = myCourseMapper.getCourses(myCourseQuery);
		QueryResult<MyCourse> result = new QueryResult<>(list,size,myCourseQuery.getPage());
		return result;
	}

	@Override
	public Result updateStatus(Long course_id, int course_status) {
		myCourseMapper.updateStatus(course_id,course_status);
		return new Result(true, "状态更新成功");
	}

	@Override
	public Result saveItem(MyCourse myCourse) {
		String course_id = "KC" + (Math.random()*9+1)*1000000;
		myCourse.setCourse_id(course_id);
		myCourse.setCourse_status(1); //改课程正常
		myCourse.setCreated(new Date());
		myCourse.setUpdated(myCourse.getCreated());
		myCourseMapper.inset(myCourse);
		return new Result(true, "课程新增成功");
	}

	@Override
	public Result updateItem(MyCourse myCourse) {
		myCourse.setUpdated(new Date());
		myCourseMapper.updateByPrimaryKeySelective(myCourse);
		return new Result(true, "课程更新成功");
	}

}
