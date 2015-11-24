package com.adarsh.spring.view;


import com.adarsh.spring.viewtype.BaseView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseView {
	public Class<? extends BaseView> value();
}
