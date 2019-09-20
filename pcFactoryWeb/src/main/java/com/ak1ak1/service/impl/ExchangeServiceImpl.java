package com.ak1ak1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ak1ak1.entity.ExchangeCode;
import com.ak1ak1.entity.query.ExchangeCodeQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.repository.mapper.ExchangeCodeMapper;
import com.ak1ak1.service.ExchangeCodeService;

@Transactional
@Service
public class ExchangeServiceImpl implements ExchangeCodeService{
	
	@Autowired
	private ExchangeCodeMapper exchangeCodeMapper;
	
	@Override
	public QueryResult<ExchangeCode> getCodes(ExchangeCodeQuery codeQuery) {
		Integer size = exchangeCodeMapper.getCodesCount(codeQuery);
		if(size<=0){
			return null;
		}
		List<ExchangeCode>  list = exchangeCodeMapper.getCodes(codeQuery);
		QueryResult<ExchangeCode> result = new QueryResult<>(list,size,codeQuery.getPage());
		return result;
	}

	@Override
	public List<ExchangeCode> exportCodeInfo(ExchangeCodeQuery codeQuery) {
		return exchangeCodeMapper.exportCodeInfo(codeQuery);
	}

}
