package com.adarsh.spring.view;


import com.adarsh.spring.viewtype.BaseView;

public class PojoView implements DataView {

	private Object data;
	private Class<? extends BaseView> view;
	public PojoView(Object result, Class<? extends BaseView> viewClass) {
		this.data = result;
		this.view = viewClass;
	}
	public boolean hasView() {
		return true;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Class<? extends BaseView> getView() {
		return view;
	}
	public void setView(Class<? extends BaseView> view) {
		this.view = view;
	}
	
}
