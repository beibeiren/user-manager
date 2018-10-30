package com.training.login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * 
 * @author ri
 * 登录后首页
 *
 */
@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopServlet() {
        super();
    }

    private UserDao userDao = new UserDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取客户端请求的参数值
		String requestUsername = request.getParameter("requestUsername");
		System.out.println(requestUsername);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println("[TopServlet#session]:" + user);
		session.setAttribute("sessionUsername", user.getUsername());
		// 请求转发方式跳转到登录页面
		RequestDispatcher rd = request.getRequestDispatcher("jsp/top.jsp");
		// 向首页面传递参数
		request.setAttribute("servletUsername", user.getUsername());
		List<User> userList = new ArrayList<User>();
		try {
			userList = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("userList", userList);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
