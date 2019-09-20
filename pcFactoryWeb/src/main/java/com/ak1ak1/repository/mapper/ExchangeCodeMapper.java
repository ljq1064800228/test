package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ak1ak1.entity.ExchangeCode;
import com.ak1ak1.entity.query.ExchangeCodeQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ExchangeCodeMapper extends Mapper<ExchangeCode>{

	int getCodesCount(@Param("query")ExchangeCodeQuery codeQuery);

	List<ExchangeCode> getCodes(@Param("query")ExchangeCodeQuery codeQuery);

	List<ExchangeCode> exportCodeInfo(@Param("query")ExchangeCodeQuery codeQuery);

}
