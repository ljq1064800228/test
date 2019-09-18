package com.ak1ak1.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ak1ak1.entity.User;
import tk.mybatis.mapper.common.Mapper;



@Repository
public interface UserServerMapper extends Mapper<User>{
	
	User getUsersByUserName(@Param("userName")String userName);
	
	int updatePassword(@Param("user")User user);

}
