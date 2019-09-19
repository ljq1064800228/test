package com.ak1ak1.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ak1ak1.entity.MyUser;
import com.ak1ak1.entity.query.MyUserQuery;

import tk.mybatis.mapper.common.Mapper;

// Mapper接口解决单表CRUD不需要写SQL语句
@Repository
public interface MyUserMapper extends Mapper<MyUser>{
	
	List<MyUser> getMyUsers(@Param("query")MyUserQuery userQuery);
	
	int getMyUsersCount(@Param("query")MyUserQuery userQuery);
	
	List<MyUser> exportMyUserInfo(@Param("query")MyUserQuery userQuery);

	void updateStatus(@Param("user_id")Long user_id,@Param("status") int status);

}
