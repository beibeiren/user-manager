package com.training.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	/**
	 * 资源关闭并释放
	 */
	public static void closeDB(Connection conn, PreparedStatement stat, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (rs != null) {
				rs.close();
			}
			System.out.println("资源关闭并释放成功...");
		} catch (SQLException e) {
			System.out.println("资源关闭并释放失败...");
			e.printStackTrace();
		}

	}
}
