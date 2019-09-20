package com.ak1ak1.service;

import java.util.List;

import com.ak1ak1.entity.ExchangeCode;
import com.ak1ak1.entity.query.ExchangeCodeQuery;
import com.ak1ak1.entity.query.QueryResult;

public interface ExchangeCodeService {

	QueryResult<ExchangeCode> getCodes(ExchangeCodeQuery codeQuery);

	List<ExchangeCode> exportCodeInfo(ExchangeCodeQuery codeQuery);

}
