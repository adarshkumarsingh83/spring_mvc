/**
 * 
 */
package com.adarsh.spring.rest;

import java.io.Serializable;

/**
 * @author Prafull
 *
 */
public class ApiRequest<T> implements Serializable {

	T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
