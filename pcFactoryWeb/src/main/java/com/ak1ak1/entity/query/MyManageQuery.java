package com.ak1ak1.entity.query;

import java.util.Date;

public class MyManageQuery extends PageQuery{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7718627267359579667L;
	
	private  String batch;
	
	private String change_code;
	
	private  Date created;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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
	
}
