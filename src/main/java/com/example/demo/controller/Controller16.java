package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub16")
public class Controller16 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	// 경로 : /sub16/link1?id=30
	@RequestMapping("link1")
	public void method01(@RequestParam("id") int id) throws Exception {
		String sql = """
				DELETE FROM Suppliers
				WHERE SupplierID = ?
				""";
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt;){			
			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			
			System.out.println(cnt + "개 데이터 삭제됨");
		}
	}
	
	// 경로 /sub16/link2?id=91
	// 고객 테이블의 데이터 삭제
	@RequestMapping("link2")
	public void method02(int id) throws Exception {
		String sql = """
				DELETE FROM Customers
				WHERE CustomerID = ?
				""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt;){
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "data deleted");
		}
	}
	
	@RequestMapping("link3")
	public void method03(int id) throws Exception {
		String sql = """
				DELETE FROM Employees
				WHERE EmployeeID = ?
				""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		try(con; pstmt;){
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "개 행 삭제됨");
		}
	}
}
