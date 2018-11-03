package com.training.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttrListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("添加参数:[" + event.getName() + "=" + event.getValue() +"]");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("删除参数:[" + event.getName() + "=" + event.getValue() +"]");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("参数重写:[" + event.getName() + "=" + event.getValue() +"]");
	}

}
