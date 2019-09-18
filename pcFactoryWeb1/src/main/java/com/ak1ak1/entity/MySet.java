package com.ak1ak1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="my_set")
public class MySet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7443827249834335695L;

	//主键
	@Id
	@Column(name="id")
	private  Long id;

	//课程编号
	@Column(name="course_id")
	private  Long course_id;

	//视频名称
	@Column(name="video_name")
	private  Integer video_name;

	//视频序号
	@Column(name="video_num")
	private  Integer video_num;

	//视频url
	@Column(name="video_url")
	private  Integer video_url;

	//试听状态
	@Column(name="video_status")
	private  Integer video_status;

	//更新时间
	@Column(name="created")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Date created;

	//创建时间
	@Column(name="updated")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private  Long updated;

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

	public Integer getVideo_name() {
		return video_name;
	}

	public void setVideo_name(Integer video_name) {
		this.video_name = video_name;
	}

	public Integer getVideo_num() {
		return video_num;
	}

	public void setVideo_num(Integer video_num) {
		this.video_num = video_num;
	}

	public Integer getVideo_url() {
		return video_url;
	}

	public void setVideo_url(Integer video_url) {
		this.video_url = video_url;
	}

	public Integer getVideo_status() {
		return video_status;
	}

	public void setVideo_status(Integer video_status) {
		this.video_status = video_status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getUpdated() {
		return updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	
}
