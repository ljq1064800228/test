package com.ak1ak1.entity.query;

public class MyCourseQuery extends PageQuery{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4777973941365061373L;
	
	private  String course_name;
	
	private  Integer course_sort;
	
	private  Integer course_mark;
	
	private  Integer course_status;

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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

	public Integer getCourse_status() {
		return course_status;
	}

	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}
}
