package com.training.test;

import java.sql.SQLException;

import org.junit.Test;

import com.training.util.DBUtil;

public class TestDBUtil {

	@Test
	public void testConnection() {
		try {
			DBUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
