package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="my_order")
public class MyOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3408406344598208925L;

	//主键
	@Id
	@Column(name="id")
	private  Long id;

	//订单id
	@Column(name="order_id")
	private  Long order_id;

	//课程id
	@Column(name="course_id")
	private  Long course_id;

	//用户id
	@Column(name="user_id")
	private  Long user_id;

	//订单编号
	@Column(name="order_num")
	private  Integer order_num;

	//下单时间
	@Column(name="created")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Integer created;

	//订单价格
	@Column(name="payment")
	private  Integer payment;

	//支付方式
	@Column(name="payment_type")
	private  Integer payment_type;

	//支付时间
	@Column(name="pay_time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date pay_time;

	//订单来源
	@Column(name="source")
	private  Integer source;

	//支付状态
	@Column(name="status")
	private  Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
