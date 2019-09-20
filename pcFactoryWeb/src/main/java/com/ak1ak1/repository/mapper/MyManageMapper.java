package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ak1ak1.entity.MyManage;
import com.ak1ak1.entity.query.MyManageQuery;

import tk.mybatis.mapper.common.Mapper;

public interface MyManageMapper extends Mapper<MyManage>{

	int getMyManagesCount(@Param("query")MyManageQuery myManageQuery);

	List<MyManage> getMyManages(@Param("query")MyManageQuery myManageQuery);

	Long getCourseId(String course_name);
	
	void createItem(MyManage myManage);
}
