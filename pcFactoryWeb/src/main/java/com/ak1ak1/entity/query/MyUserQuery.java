package com.ak1ak1.entity.query;

import java.util.Date;

public class MyUserQuery extends PageQuery{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4027886086500497967L;

	private  Long user_id;
	
	private String nickname;
	
	private  String telPhone;
	
	private  Integer type;
	
	private  Date created;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
