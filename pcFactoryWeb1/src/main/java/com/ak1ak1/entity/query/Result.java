package com.ak1ak1.entity.query;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 统一封装结果
 * @author xiaojf
 *
 */
public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4640814594091471852L;
	private boolean success;
	private String message;
	private Object data;

	public Result() {
		this(false);
	}

	public Result(boolean success) {
		this(success, null, null);
	}

	public Result(boolean success, Object data) {
		this(success, null, data);
	}
	
	public Result(boolean success, String message) {
		this(success, message, null);
	}

	public Result(boolean success, String message,
			Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
