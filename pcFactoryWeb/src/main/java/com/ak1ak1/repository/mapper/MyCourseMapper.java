package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ak1ak1.entity.MyCourse;

import com.ak1ak1.entity.query.MyCourseQuery;

import tk.mybatis.mapper.common.Mapper;

public interface MyCourseMapper extends Mapper<MyCourse>{

	int getCoursesCount(@Param("query")MyCourseQuery myCourseQuery);

	List<MyCourse> getCourses(@Param("query")MyCourseQuery myCourseQuery);

	void updateStatus(@Param("course_id")Long course_id, @Param("course_status")int course_status);

	void inset(MyCourse myCourse);


}
