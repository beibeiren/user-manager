package com.training.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener()
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("#########系统关闭#########");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("#########系统启动#########");
		ServletContext application = event.getServletContext();
		application.setAttribute("currentCount", 0);
	}

}
