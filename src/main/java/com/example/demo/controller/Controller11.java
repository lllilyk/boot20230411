package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub11")
public class Controller11 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.name}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public void method1(Model model) {
		// 1. request param
		// 2. business logic

		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;
		
		// 아이디 1인 고객이름 조회
		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";
			
		try(
		// db 연결
		Connection connection = DriverManager.getConnection(url, name, password);
		// Statement 객체 생성
		Statement statement = connection.createStatement();
		// 쿼리 실행
		// 쿼리 실행 결과 얻고
		ResultSet resultSet = statement.executeQuery(sql);
		){		
		// 쿼리 실행 결과 가공
		String name = "";
		if(resultSet.next()) {			
			name = resultSet.getString("CustomerName");
		}
		
		//3. add attribute
		model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//4. forward/ redirect
		
	}
	
	@RequestMapping("link2")
	public void method02() {
		String employeeName = "";
		//2. business logic
		//아이디 3인 직원의 last name조회
		
		String sql = "SELECT lastName FROM Employees WHERE EmployeeId = 3";
		
		//jdbc가 하는 일
		try(
		//1. 연결하기
		Connection con = DriverManager.getConnection(url, name, password);
		//2. statement 생성하기
		Statement stmt = con.createStatement();
		//3. 쿼리 실행 후 resultSet 얻기
		ResultSet rs = stmt.executeQuery(sql);
		//4. resultSet에 결과 있는지 확인하고
		){
		if(rs.next()) {			
			//5. 결과 꺼내서 담기
			employeeName = rs.getString("lastName");
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(employeeName);
	}
	
	//products
	//id가 5인 상품 이름 조회
	@RequestMapping("link3")
	public void method03(Model model) {
		
		String productName = "";
		String sql = "SELECT ProductName FROM Products WHERE ProductID = 5";
		
		//jdbc가 하는일
		try{
		//1. 연결하기
		Connection con = DriverManager.getConnection(url, name, password);
		//2. statement 생성하기
		Statement stmt = con.createStatement();
		//3. 쿼리 실행 후 resultSet 얻기
		ResultSet rs = stmt.executeQuery(sql);
		//4. resultSet에 결과 있는지 확인하고
		
		try (con; stmt; rs;){
			if(rs.next()) {
				productName = rs.getString("productName");				
			}
		}
		
		System.out.println(productName);
	
		model.addAttribute("productName", productName);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link4")
		// 1. request param 수집
	public void method04(Model model) {
		// 2. business logic
		// 고객 이름들을 조회하기
		String sql = "SELECT CustomerName FROM Customers";
		
		// 91명이나 되니까 List로 담기
		List<String> list = new ArrayList<>();
		
		//try-catch문으로 오류 잡기
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try (con; stmt; rs;) {
				//list에 고객 이름들을 담기
				while(rs.next()) {
					list.add(rs.getString("CustomerName"));
				}
			} //잡을 오류 없으면 catch 필요x
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. add attribute
		model.addAttribute("CustomerNames", list);
		
		// 4. forward
	}
	
	@RequestMapping("link5")
	public void method05(Model model) {
		String sql = "SELECT FirstName From Employees";
		
		List<String> list = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try(con; stmt; rs;){
				while(rs.next()) {
					list.add(rs.getString("FirstName"));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("FN", list);
	}
	
	@RequestMapping("link0")
		// 1. get request parameter
	public void method00(Model model) {
		// 2. business logic
		//어떤 값을 조회할 것인가?
		String sql = "SELECT CustomerID FROM Orders";
		
		//830개의 row가 return되었다고 하니 String으로는 무리
		List<String> list = new ArrayList<>();
		
		try {
			// DataBase에 연결
			Connection con = DriverManager.getConnection(url, name, password);
			// statement 객체 생성
			Statement stmt = con.createStatement();
			// 쿼리 실행 후 쿼리 실행 결과(ResultSet) 얻기
			ResultSet rs = stmt.executeQuery(sql);
			// ResultSet에 결과가 있는지 확인하고
			try(con; stmt; rs;){
				while(rs.next()) {
					// 결과를 꺼내서 담기
					list.add(rs.getString("CustomerID"));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		// 3. add attribute
		model.addAttribute("CustomerIDs", list);
	}
		// 4. forward
	
	
	
}
