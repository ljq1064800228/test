package com.ak1ak1.service;

import com.ak1ak1.entity.MyManage;
import com.ak1ak1.entity.query.MyManageQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.entity.query.Result;

public interface MyManageService {

	QueryResult<MyManage> getMyManages(MyManageQuery myManageQuery);

	Result createItem(MyManage myManage);

}
