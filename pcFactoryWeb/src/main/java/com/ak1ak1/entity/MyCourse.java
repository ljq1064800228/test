package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="my_course")
public class MyCourse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2079196930375559266L;

	//主键
	@Id
	@Column(name="id")
	private  Long id;

	//课程编号
	@Column(name="course_id")
	private  String course_id;

	//课程名称
	@Column(name="course_name")
	private  String course_name;

	//课程封面
	@Column(name="course_image")
	private  Integer course_image;

	//课程分类
	@Column(name="course_sort")
	private  Integer course_sort;

	//课程标签
	@Column(name="course_mark")
	private  Integer course_mark;

	//课程价格
	@Column(name="course_price")
	private  Long course_price;

	//课程状态
	@Column(name="course_status")
	private  Integer course_status;

	//创建时间
	@Column(name="created")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date created;

	//更新时间
	@Column(name="updated")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date updated;
	
	// 课程介绍
	@Column(name="course_intro")
	private  String course_intro;
	
	// 课程详情
	@Column(name="course_info")
	private  String course_info;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Integer getCourse_image() {
		return course_image;
	}

	public void setCourse_image(Integer course_image) {
		this.course_image = course_image;
	}

	public Integer getCourse_sort() {
		return course_sort;
	}

	public void setCourse_sort(Integer course_sort) {
		this.course_sort = course_sort;
	}

	public Integer getCourse_mark() {
		return course_mark;
	}

	public void setCourse_mark(Integer course_mark) {
		this.course_mark = course_mark;
	}

	public Long getCourse_price() {
		return course_price;
	}

	public void setCourse_price(Long course_price) {
		this.course_price = course_price;
	}

	public Integer getCourse_status() {
		return course_status;
	}

	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}
