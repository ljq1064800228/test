package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.MyManage;
import com.ak1ak1.entity.query.MyManageQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.repository.mapper.MyManageMapper;
import com.ak1ak1.service.MyManageService;

@Transactional
@Service
public class MyManageServiceImpl implements MyManageService{

	@Autowired
	private MyManageMapper myManageMapper;
	
	@Override
	public QueryResult<MyManage> getMyManages(MyManageQuery myManageQuery) {
		Integer size = myManageMapper.getMyManagesCount(myManageQuery);
		if(size<=0){
			return null;
		}
		List<MyManage>  list = myManageMapper.getMyManages(myManageQuery);
		QueryResult<MyManage> result = new QueryResult<>(list,size,myManageQuery.getPage());
		return result;
	}

	@Override
	public Result createItem(MyManage myManage) {
		String batch = "DH" + (Math.random()*9+1)*10000000;
		double batch_id = (Math.random()*9+1)*1000;
		MyCourse myCourse = new MyCourse();
		String course_name = myCourse.getCourse_name();
		Long course_id = myManageMapper.getCourseId(course_name);
		myManage.setCourse_id(course_id);
		myManage.setBatch_id((long) batch_id);
		myManage.setBatch(batch);
		myManageMapper.createItem(myManage);
		return new Result(true, "状态更新成功");
	}

}
