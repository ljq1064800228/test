package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//javax.persistence包使得实体类与数据库中的表建立映射关系，是ORM框架

@Table(name="my_user")
public class MyUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1999245413603392073L;

	//主键
	@Id
	@Column(name="id")
	private  Long id;
	
	//用户id
	@Column(name="user_id")
	private  Long user_id;
	
	//用户类型
	@Column(name="type")
	private  Integer type;

	//用户姓名
	@Column(name="name")
	private  String name;

	//用户昵称
	@Column(name="nickname")
	private  String nickname;

	//用户状态
	@Column(name="status")
	private  Integer status;  //商品分类信息  1正常，2禁用，3删除

	//注册时间
	@Column(name="created")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date created;

	//用户手机
	@Column(name="telPhone")
	private  String telPhone;
	
	@Column(name="updated")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Long updated;

	public Long getUpdated() {
		return updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

}
