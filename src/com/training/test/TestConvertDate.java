package com.training.test;


import java.util.Calendar;

import org.junit.Test;

import com.training.util.ConvertUtil;

public class TestConvertDate {
	
	@Test
	public void testUtilDateToSqlDate() {
		java.sql.Date date = ConvertUtil.utilDateToSqlDate(new java.util.Date());
		System.out.println(date);
	}
	
	@Test
	public void testSqlDateToUtilDate() {
		Calendar cal = Calendar.getInstance();
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		java.util.Date date = ConvertUtil.sqlDateToUtilDate(sqlDate);
		System.out.println(date);
	}
}
