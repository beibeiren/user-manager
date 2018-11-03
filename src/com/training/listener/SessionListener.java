package com.training.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("---------session创建---------");
		ServletContext application = event.getSession().getServletContext();
		Integer currentCount = (Integer) application.getAttribute("currentCount");
		currentCount ++;
		application.setAttribute("currentCount", currentCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("---------session销毁---------");
		ServletContext application = event.getSession().getServletContext();
		Integer currentCount = (Integer) application.getAttribute("currentCount");
		currentCount --;
		application.setAttribute("currentCount", currentCount);
	}

}
