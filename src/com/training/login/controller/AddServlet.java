package com.training.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.login.dao.UserDao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddServlet() {
        super();
    }
    
    private UserDao userDao = new UserDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取客户端（浏览器）请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			userDao.addUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 重定向方式跳转到首页
		response.sendRedirect("top?requestUsername=" + username); // ?requestUsername=XXX重定向传递参数
	}

}
