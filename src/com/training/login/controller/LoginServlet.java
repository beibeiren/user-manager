package com.training.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.entity.User;
import com.training.login.dao.UserDao;

/**
 * @author ri
 * 用户登录 servlet
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 构造函数
    public LoginServlet() {
        super();
    }
    
    private UserDao userDao = new UserDao();

	/**
	 * 登录画面表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 请求转发方式跳转到登录页面
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * 登录操作
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取客户端（浏览器）请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user;
		try {
			user = userDao.findUserByUsernameAndPassword(username, password);
			System.out.println("[LoginServlet#userDao]:" + user);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				// 重定向方式跳转到首页
				response.sendRedirect("top?requestUsername=tom"); // ?username=tom重定向传递参数
			}else {
				// 重定向方式跳转到登录页面
				response.sendRedirect("index.jsp"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
