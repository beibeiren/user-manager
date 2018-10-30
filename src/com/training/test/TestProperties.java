package com.training.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class TestProperties {

	@Test
	public void getProperties() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("jdbc.properties")); // 相对路径，相对于项目路径（非静态方法中）
		String username = prop.getProperty("jdbc.username");
		System.out.println(username);
	}

//TODO 静态方法中路径待确认
//	@Test
//	public static void testStaticPath() {
//		try {
//			String path = new File(".").getAbsolutePath();
//			System.out.println(path);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public static void testStaticPath2() {
//		String path = DBUtil.class.getClassLoader().getResource("").getPath();
//		System.out.println(path);
//	}
}
