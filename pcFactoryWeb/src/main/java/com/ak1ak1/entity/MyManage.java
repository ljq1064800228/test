package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="my_manage")
public class MyManage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5734834937198736493L;

	//主键
	@Id
	@Column(name="id")
	private  Long id;

	//课程id
	@Column(name="course_id")
	private  Long course_id;

	//批次id
	@Column(name="batch_id")
	private  Long batch_id;
	
	//批次
	@Column(name="batch")
	private  String batch;

	//生成数量
	@Column(name="create_num")
	private  Integer create_num;

	//免费观看
	@Column(name="free_watch")
	private  Integer free_watch;

	//备注
	@Column(name="remark")
	private  String remark;

	//创建时间
	@Column(name="created")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date created;

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

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	
	public Long getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(Long batch_id) {
		this.batch_id = batch_id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}
	
	public Integer getCreate_num() {
		return create_num;
	}

	public void setCreate_num(Integer create_num) {
		this.create_num = create_num;
	}

	public Integer getFree_watch() {
		return free_watch;
	}

	public void setFree_watch(Integer free_watch) {
		this.free_watch = free_watch;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
