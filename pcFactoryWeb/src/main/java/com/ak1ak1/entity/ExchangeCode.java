package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="exchange_code")
public class ExchangeCode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3879810013327712564L;

	//主键
	@Id
	@Column(name="id")
	private Long id;
	
	//批次
	@Column(name="batch")
	private String batch;
	
	//兑换码
	@Column(name="change_code")
	private String change_code;
	
	//状态
	@Column(name="status")
	private Integer status;
	
	//用户id
	@Column(name="user_id")
	private Long user_id;
	
	//激活时间
	@Column(name="activated_time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date activated_time;
	
	//二维码
	@Column(name="QR_code")
	private String QR_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getChange_code() {
		return change_code;
	}

	public void setChange_code(String change_code) {
		this.change_code = change_code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getActivated_time() {
		return activated_time;
	}

	public void setActivated_time(Date activated_time) {
		this.activated_time = activated_time;
	}

	public String getQR_code() {
		return QR_code;
	}

	public void setQR_code(String qR_code) {
		QR_code = qR_code;
	}
}
