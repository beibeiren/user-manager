package com.training.util;

import java.util.Calendar;

public class ConvertUtil {
	
	public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
		if(date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
		return sqlDate;
	}
	
	public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {
		if(date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		java.util.Date utilDate = new java.util.Date(cal.getTimeInMillis());
		return utilDate;
	}
}
