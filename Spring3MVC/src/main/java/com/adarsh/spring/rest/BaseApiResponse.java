/**
 * Copyright (c) Lucas Systems LLC
 */
package com.adarsh.spring.rest;

import com.adarsh.spring.Level;
import com.adarsh.spring.viewtype.BaseView;
import com.fasterxml.jackson.annotation.JsonView;

public class BaseApiResponse<T> {

	private String status = "success";
	private String code = "200";
	private String message = "Request processed successfully";
	private Level level;
	
	@JsonView(BaseView.class)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonView(BaseView.class)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@JsonView(BaseView.class)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonView(BaseView.class)
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}

}
