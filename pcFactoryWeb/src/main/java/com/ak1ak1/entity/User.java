package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 登录
 * @author 肖建福
 *
 */

@Table(name="user")
public class User implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4135469246396191931L;
   
	 @Id
	 @Column(name="userId")
     private  String userId;
    
	 @Column(name="userName")
     private  String userName;
    
	 @Column(name="password")
     private  String password;
    
	 @Column(name="cateTime")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
     private  Date cateTime;
    
	 @Column(name="status")
     private  Integer status;
    
	 @Column(name="telPhone")
     private  String telPhone;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCateTime() {
		return cateTime;
	}

	public void setCateTime(Date cateTime) {
		this.cateTime = cateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	 
	 

}
