package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import ch.qos.logback.core.recovery.*;

@Controller
@RequestMapping("sub12")
public class Controller12 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public void method01() {
		String sql = "SELECT LastName FROM Employees";
	
		try {
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){			
			System.out.println(rs.next()); //true
			String name1 = rs.getString("LastName");
			System.out.println(name1);
			
			System.out.println(rs.next()); //true
			String name2 = rs.getString("LastName");
			System.out.println(name2);
			
			System.out.println(rs.next()); //true
			String name3 = rs.getString("LastName");
			System.out.println(name3);
			
			System.out.println(rs.next()); //true
			String name4 = rs.getString("LastName");
			System.out.println(name4);
			
			System.out.println(rs.next()); //true
			String name5 = rs.getString("LastName");
			System.out.println(name5);
			
			System.out.println(rs.next()); //true
			String name6 = rs.getString("LastName");
			System.out.println(name6);
			
			System.out.println(rs.next()); //true
			String name7 = rs.getString("LastName");
			System.out.println(name7);
			
			System.out.println(rs.next()); //true
			String name8 = rs.getString("LastName");
			System.out.println(name8);
			
			System.out.println(rs.next()); //true
			String name9 = rs.getString("LastName");
			System.out.println(name9);
			
			System.out.println(rs.next()); //true
			String name10 = rs.getString("LastName");
			System.out.println(name10);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//위의 코드를 반복문으로 간결하게
	@RequestMapping("link2")
	public void method02() {
		String sql = "SELECT LastName FROM Employees";
	
		try {
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){			
			while(rs.next()) {
				System.out.println(rs.getString("LastName"));
				}	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//연습
	@RequestMapping("link3")
	public void method03(Model model) {
		String sql = "SELECT ShipperName FROM Shippers";
		
		List<String> list = new ArrayList<>();
		
		try {
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){
			while(rs.next()) {
				list.add(rs.getString("ShipperName"));
			}
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("name1", list );
	}
	
	@RequestMapping("link4")
	public void method04() {
		String sql = "SELECT * FROM Customers";
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try(con; stmt; rs;){
				//행 옮기기
				rs.next();
				//컬럼 가져오기
				System.out.println(rs.getString("CustomerName"));
				//다른 컬럼의 값을 가지고 오고 싶으면 getString 메소드 사용
				System.out.println(rs.getString("ContactName"));
				System.out.println(rs.getString("country"));
				
				rs.next();
				System.out.println(rs.getString("CustomerName"));
				System.out.println(rs.getString("ContactName"));
				System.out.println(rs.getString("country"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link5")
	public void method05() {
	String sql = "SELECT * FROM Customers";
		
		try {
			
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try (con; stmt; rs;) {
				while (rs.next()) {
					System.out.println("################");
					System.out.println(rs.getString("customerName"));
					System.out.println(rs.getString("contactName"));
					System.out.println(rs.getString("country"));
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link6")
	public void method06() {
		String sql = "SELECT * FROM Products";
		
		try {
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){
			while(rs.next()) {
				//int 타입 꺼낼 수 있음
				System.out.println(rs.getString("ProductId"));
				//String 타입 꺼낼 수 있음
				System.out.println(rs.getString("ProductName"));
				//double 타입 꺼낼 수 있음
				System.out.println(rs.getString("Price"));
				
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//getString으로도 꺼낼 수는 있지만 이왕이면 
	//메소드가 다 있으니까 적절한 메소드 사용
	@RequestMapping("link66")
	public void method066() {
		String sql = "SELECT * FROM Products";
		
		try {
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){
			while(rs.next()) {
				//처음부터 getInt 메소드 사용해서 int 타입 꺼내기
				System.out.println(rs.getInt("ProductId"));
				//처음부터 getString 메소드 사용해서 String 타입 꺼내기
				System.out.println(rs.getString("ProductName"));
				//처음부터 getDouble 메소드 사용해서 double 타입 꺼내기
				System.out.println(rs.getDouble("Price"));
				
			}
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link7")
	public void method07() {
		String sql = "SELECT * FROM Customers WHERE CustomerID < 4";
		
		
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try(con; stmt; rs;){
				while(rs.next()) {
					/*
					//column Name으로 값 얻기
					System.out.println(rs.getInt("CustomerID"));
					System.out.println(rs.getString("CustomerName"));
					 */
					//column index로 값 얻기
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	@RequestMapping("link8")
	public void method08() {
		String sql = """
				SELECT LastName, FirstName
				FROM Employees
				WHERE EmployeeID < 4
				""";
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();			
			ResultSet rs = stmt.executeQuery(sql);
			try(con; stmt; rs;){
				while(rs.next()) {
					String lastName = rs.getString(1);
					String firstName = rs.getString(2);
					
					System.out.println(lastName + ", " + firstName);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("link9")
	public void method09() {
		String sql = """
				SELECT CustomerID, CustomerName, Country 
				FROM Customers WHERE CustomerID < 4;
				""";
		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			try(con; stmt; rs;){
				while(rs.next()) {
					int customerId = rs.getInt(1);
					String customerName = rs.getString(2);
					String country = rs.getString(3);
					System.out.println(customerId +", " + customerName + ", " + country);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

