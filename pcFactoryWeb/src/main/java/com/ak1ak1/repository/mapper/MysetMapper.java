package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ak1ak1.entity.MySet;
import com.ak1ak1.entity.query.MysetQuery;

import tk.mybatis.mapper.common.Mapper;

public interface MysetMapper extends Mapper<MySet>{

	Integer getMySetsCount(@Param("query")MysetQuery mysetQuery);

	List<MySet> getMySets(@Param("query")MysetQuery mysetQuery);

	void updateVideo(@Param("video_ids")Long[] video_ids);

}
