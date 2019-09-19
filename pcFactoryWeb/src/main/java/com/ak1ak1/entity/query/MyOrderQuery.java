package com.ak1ak1.entity.query;

public class MyOrderQuery extends PageQuery{

	/**
	 * 
	 */
	private static final long serialVersionUID = 553545289613291517L;

	private  Integer order_num;
	
	private  Integer course_name;
	
	private  String name;
	
	private  Integer created;
	
	private  Integer source;
	
	private  Integer payment_type;

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getCourse_name() {
		return course_name;
	}

	public void setCourse_name(Integer course_name) {
		this.course_name = course_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	
}
