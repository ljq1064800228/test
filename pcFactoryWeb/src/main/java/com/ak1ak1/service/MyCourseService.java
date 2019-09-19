package com.ak1ak1.service;

import com.ak1ak1.entity.MyCourse;
import com.ak1ak1.entity.query.MyCourseQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;

public interface MyCourseService {

	QueryResult<MyCourse> getCourses(MyCourseQuery query);

	Result updateStatus(Long course_id, int course_status);

	Result saveItem(MyCourse myCourse);

	Result updateItem(MyCourse myCourse);

}
