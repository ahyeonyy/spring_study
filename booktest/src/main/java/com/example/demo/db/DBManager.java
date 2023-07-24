package com.example.demo.db;

import java.io.InputStream;

public class DBManager {
	static {
		try {
			String resource = "org/mybatis/example/mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
	}
}
