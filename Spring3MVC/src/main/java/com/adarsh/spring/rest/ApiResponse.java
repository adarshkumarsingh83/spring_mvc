
package com.adarsh.spring.rest;

import com.adarsh.spring.viewtype.BaseView;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * 
 * @author Anand
 *
 */
public class ApiResponse<T> extends BaseApiResponse<T> implements Serializable {
	
	private static final long serialVersionUID = -4120646924237227702L;
	private String uniqueKey;
	private String token;
	private Boolean explicitDismissal;
	T data;
	
	@JsonView(BaseView.class)
	public String getUniqueKey() {
		return uniqueKey;
	}
	
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
	@JsonView(BaseView.class)
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	@JsonView(BaseView.class)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonView(BaseView.class)
	public Boolean isExplicitDismissal() {
		return explicitDismissal;
	}

	public void setExplicitDismissal(Boolean explicitDismissal) {
		this.explicitDismissal = explicitDismissal;
	}
}