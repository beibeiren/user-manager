package com.training.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author ri
 * 获取数据库连接公共类
 *
 */
public class DBUtil {

	static {
		try {
			// 加载数据库驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("加载数据库驱动成功...");
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败...");
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		Connection conn = null;
		try {
			// 加载属性文件
			// TODO 静态方法中路径问题 
			// prop.load(new FileInputStream("jdbc.properties"));
			prop.load(DBUtil.class.getResourceAsStream("jdbc.properties")); // 相对路径，相对于当前路径（静态方法中）
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("获取数据库连接成功...");
		} catch (SQLException e) {
			System.out.println("获取数据库连接失败...");
			e.printStackTrace();
			throw e;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
