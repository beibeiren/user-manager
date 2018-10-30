package com.training.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.training.common.BaseDao;
import com.training.entity.User;
import com.training.util.ConvertUtil;
import com.training.util.DBUtil;

public class UserDao extends BaseDao {

	// 根据用户名和用户密码查询用户sql
	public static final String SQL_FIND_USER_BY_USERNAME_PASSWORD = ""
			+ "select [id], [username], [password], [created_time], [modified_time]" 
			+ "  from [user] " 
			+ " where [username] = ?"
			+ "   and [password] = ?";
	
	// 添加用户sql
	public static final String SQL_ADD_USER = ""
			+ "insert into [user] ([username], [password], [created_time], [modified_time])"
			+ " values (?, ?, ?, ?)";
	
	// 修改用户sql
	public static final String SQL_UPDATE_USER = ""
			+ "update [user] "
			+ "   set [username] = ?, "
			+ "       [password] = ?, "
			+ "       [modified_time] = ?"
			+ "where id = ?";
	
	// 删除用户sql
	public static final String SQL_DELETE_USER = ""
			+ "delete [user] where id = ?";
	
	// 查询所有用户sql
	public static final String SQL_FIND_ALL_USER = ""
			+ "select * from [user]";
			
	
	
	private Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;

	/**
	 * 查询用户
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 用户
	 * @throws Exception
	 */
	public User findUserByUsernameAndPassword(String username, String password) throws Exception {
		User user = null;
		try {
			// 下标
			int index = 1; 
			// 获取数据库连接
			conn = DBUtil.getConnection();
			System.out.println("[ sql ]:" +  SQL_FIND_USER_BY_USERNAME_PASSWORD);
			// 创建PreparedStatement
			stat = conn.prepareStatement(SQL_FIND_USER_BY_USERNAME_PASSWORD);
			// 参数设定
			stat.setString(index++, username);
			stat.setString(index++, password);
			// 执行sql，获取查询结果
			rs = stat.executeQuery();
			index = 1;
			if(rs.next()) {
				// 将查询结果设定到User实体类中
				user = new User();
				Integer id = rs.getInt(index++);
				user.setId(id);
				String name = rs.getString(index++);
				user.setUsername(name);
				String pass = rs.getString(index++);
				user.setPassword(pass);
				Date createdTime = rs.getDate(index++);
				user.setCreatedTime(createdTime);
				Date modifiedTime = rs.getDate(index++);
				user.setModifiedTime(modifiedTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭并释放资源
			closeDB(conn, stat, rs);
		}
		return user;
	}

	/**
	 * 用户添加
	 * @param username 用户名
	 * @param password 用户密码
	 * @return true添加成功，false：添加失败
	 * @throws Exception
	 */
	public boolean addUser(String username, String password) throws Exception {
		boolean isAdded = false;
		try {
			// 下标
			int index = 1;
			// 获取数据库连接
			conn = DBUtil.getConnection();
			System.out.println("[ sql ]:" + SQL_ADD_USER);
			// 创建PreparedStatement
			stat = conn.prepareStatement(SQL_ADD_USER);
			// 参数设定
			stat.setString(index++, username);
			stat.setString(index++, password);
			stat.setDate(index++, ConvertUtil.utilDateToSqlDate(new Date()));
			stat.setDate(index++, ConvertUtil.utilDateToSqlDate(new Date()));
			// 执行sql，获取查询结果
			int i = stat.executeUpdate();
			if (i>0) {
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 关闭并释放资源
			closeDB(conn, stat, rs);
			throw e;
		}
		return isAdded;
	}
	
	/**
	 * 用户修改
	 * @param user 用户信息
	 * @return true：修改成功， false修改失败
	 * @throws Exception
	 */
	public boolean updateUser(User user) throws Exception {
		boolean isUpdate = false;
		try {
			// 下标
			int index = 1;
			// 获取数据库连接
			conn = DBUtil.getConnection();
			System.out.println("[ sql ]:" + SQL_UPDATE_USER);
			// 创建PreparedStatement
			stat = conn.prepareStatement(SQL_UPDATE_USER);
			// 参数设定
			stat.setString(index++, user.getUsername());
			stat.setString(index++, user.getPassword());
			stat.setDate(index++, ConvertUtil.utilDateToSqlDate(new Date()));
			stat.setInt(index, user.getId());
			// 执行sql，获取查询结果
			int i = stat.executeUpdate();
			if (i>0) {
				isUpdate = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 关闭并释放资源
			closeDB(conn, stat, rs);
			throw e;
		}
		return isUpdate;
	}
	
	/**
	 * 用户删除
	 * @param id 用户ID
	 * @return true：删除成功， false：删除失败
	 * @throws Exception
	 */
	public boolean deleteUser(Integer id) throws Exception {
		boolean isDelete = false;
		try {
			// 下标
			int index = 1;
			// 获取数据库连接
			conn = DBUtil.getConnection();
			System.out.println("[ sql ]:" + SQL_DELETE_USER);
			// 创建PreparedStatement
			stat = conn.prepareStatement(SQL_DELETE_USER);
			// 参数设定
			stat.setInt(index, id);
			// 执行sql，获取查询结果
			int i = stat.executeUpdate();
			if (i>0) {
				isDelete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 关闭并释放资源
			closeDB(conn, stat, rs);
			throw e;
		}
		return isDelete;
	}

	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> findAll() throws Exception {
		List<User> userList = new ArrayList<User>();
		try {
			// 获取数据库连接
			conn = DBUtil.getConnection();
			System.out.println("[ sql ]:" +  SQL_FIND_ALL_USER);
			// 创建PreparedStatement
			stat = conn.prepareStatement(SQL_FIND_ALL_USER);
			// 执行sql，获取查询结果
			rs = stat.executeQuery();
			while(rs.next()) {
				int index = 1;
				// 将查询结果设定到User实体类中
				User user = new User();
				Integer id = rs.getInt(index++);
				user.setId(id);
				String name = rs.getString(index++);
				user.setUsername(name);
				String pass = rs.getString(index++);
				user.setPassword(pass);
				Date createdTime = rs.getDate(index++);
				user.setCreatedTime(createdTime);
				Date modifiedTime = rs.getDate(index++);
				user.setModifiedTime(modifiedTime);
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 关闭并释放资源
			closeDB(conn, stat, rs);
			throw e;
		}
		return userList;
	}
}
