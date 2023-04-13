package com.example.demo.controller;

import java.sql.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub11")
public class Controller11 {
	
	@RequestMapping("link1")
	public void method1() {
		// 1. request param
		// 2. business logic

		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;
		
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";
			
		// db 연결
		Connection connection = DriverManager.getConnection(url, name, password);
		// Statement 객체 생성
		Statement statement = connection.createStatement();
		// 쿼리 실행
		// 쿼리 실행 결과 얻고
		ResultSet resultSet = statement.executeQuery(sql);
		// 쿼리 실행 결과 가공
		if(resultSet.next()) {			
			String name = resultSet.getString("CustomerName");
		
		}
		
		//3. add attribute
		
		//4. forward/ redirect
	}
	
}
