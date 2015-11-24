package com.adarsh.spring.view;


import com.adarsh.spring.viewtype.BaseView;

public interface DataView {
	boolean hasView();
	Class<? extends BaseView> getView();
	Object getData();
}
