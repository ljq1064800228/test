package com.ak1ak1.service;

import com.ak1ak1.entity.MySet;
import com.ak1ak1.entity.query.MysetQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;

public interface MySetService {

	QueryResult<MySet> getMyUsers(MysetQuery query);

	Result saveItem(Long[] video_ids);

}
