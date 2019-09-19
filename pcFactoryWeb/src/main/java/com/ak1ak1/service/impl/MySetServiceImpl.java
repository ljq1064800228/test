package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.MySet;
import com.ak1ak1.entity.query.MysetQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;
import com.ak1ak1.repository.mapper.MysetMapper;
import com.ak1ak1.service.MySetService;

@Transactional
@Service
public class MySetServiceImpl implements MySetService{

	@Autowired
	private MysetMapper mysetMapper;
	
	@Override
	public QueryResult<MySet> getMyUsers(MysetQuery mysetQuery) {
		Integer size = mysetMapper.getMySetsCount(mysetQuery);
		if(size<=0){
			return null;
		}
		List<MySet>  list = mysetMapper.getMySets(mysetQuery);
		QueryResult<MySet> result = new QueryResult<>(list,size,mysetQuery.getPage());
		return result;
	}

	@Override
	public Result saveItem(Long[] video_ids) {
		MyCourse myCourse = new MyCourse();
		MySet mySet = new MySet();
		mySet.setCourse_id(myCourse.getCourse_id());
		mysetMapper.updateVideo(video_ids);
		return new Result(true, "视频更新成功");
	}

}
