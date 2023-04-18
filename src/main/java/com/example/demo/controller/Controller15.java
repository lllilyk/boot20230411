package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub15")
public class Controller15 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public void method01() throws Exception {
		// 새 고객데이터 추가
		
		String sql = """
				INSERT INTO Customers (CustomerID, CustomerName, City)
				VALUES (93, '서태웅', '부산')
				""";
		
		// INSERT, UPDATE, DELETE는 
		// Statement의 executeUpdate 메소드 사용
		// 리턴 값은 영향을 미친 레코드 수
		
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		//insert 쿼리는 테이블 형식으로 결과를 반환하지 x
		//stmt.executeQuery(); << select 쿼리일 때 사용
		int count = stmt.executeUpdate(sql);
		try(con; stmt;) {
			
		}
		System.out.println(count + "개 행 추가됨");
	}
	
	// 경로 : /sub15/link2
	// 10번째 직원 추가
	@RequestMapping("link2")
	public void method02() throws Exception{
		String sql = """
				INSERT INTO Employees(EmployeeID, LastName, FirstName)
				VALUES (10, 'adfsdfsf', 'fdsasffa')
				""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);
		try(con; stmt;){
			
		}
		System.out.println(count + "명 추가됨");
	}
	
	
	// 경로 : /sub15/link3?customerName=서태웅&city=제주&country=대한민국
	@RequestMapping("link3")
	public void method03(@RequestParam("customerName") String customerName,
						 @RequestParam("city") String city,
						 @RequestParam("country") String country
						 ) throws Exception{
		
		// 나중에 채워넣고 싶은 값은 ?로 대체
		String sql = """
				INSERT INTO Customers(CustomerName, City, Country)
				VALUES (?, ?, ?)
				""";
		
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				try(con; pstmt;){
				pstmt.setString(1, customerName);
				pstmt.setString(2, city);
				pstmt.setString(3, country);
				int count = pstmt.executeUpdate();
				}	
		
	}
	
	@RequestMapping("link4")
	public void method04(String firstName, String lastName) throws Exception {
		String sql = """
				INSERT INTO Employees(FirstName, LastName)
				VALUES (?, ?)
				""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt;){			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			int count = pstmt.executeUpdate();
		}
		
	}
	
	@RequestMapping("link5")
	public void method05() {
		// form이 있는 view로 포워드
		// view : WEB-INF/views/sub15/link5.jsp
		
	}
	
	@RequestMapping("link6")
	public void method06(@RequestParam("firstName") String firstName, 
						 @RequestParam("lastName") String lastName) throws Exception{
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		String sql = """
				INSERT INTO Employees (FirstName, lastName)
				VALUES(?, ?)
				""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		try(con; pstmt;){
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행 입력");
		}
	}
	
	@RequestMapping("link7")
	public void method07() {
		
	}
	
	@RequestMapping("link8")
	public void method08(@RequestParam("name") String name,
						 @RequestParam("city") String city,
						 @RequestParam("country") String country) throws Exception {
		 
		String sql = """
				INSERT INTO Suppliers (SupplierName, City, Country)
				VALUES (?, ?, ?)
				""";
		
		Connection con = DriverManager.getConnection(url, this.name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		try(con; pstmt;){			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setString(3, country);
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행 입력");
		}
	}
	
	@RequestMapping("link9")
	public void method09() {
		
	}
	
	@RequestMapping("link10")
	//public void method10(@ModelAttribute("customer") Customer customer) {
	public void method10(Customer customer) throws Exception {
		
		String sql = """
				INSERT INTO Customers(CustomerName, ContactName, Address)
				VALUES(?, ?, ?)
				""";
		
		Connection con = DriverManager.getConnection(url,name,password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		try(con; pstmt;){
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getContactName());
			pstmt.setString(3, customer.getAddress());
			int count = pstmt.executeUpdate();
		}
	}
	
	@RequestMapping("link11")
	public void method11() {
		
	}
	
	@RequestMapping("link12")
	@ResponseBody
	public String method12(Supplier supplier) throws Exception{
		
		String sql = """
				INSERT INTO Suppliers
				(SupplierName, ContactName, City, PostalCode, Phone, Country, Address)
				VALUES(?, ?, ?, ?, ?, ?, ?)
				""";
		
		Connection con = DriverManager.getConnection(url, this.name, password);
		PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		try(con; pstmt;) {
			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			int count = pstmt.executeUpdate();
			
			// 자동생성된 컬럼(키) 값 얻기
			ResultSet key = pstmt.getGeneratedKeys();
			
			int keyValue = 0;
			if(key.next()) {				
				keyValue = key.getInt(1);
			}
			
			System.out.println(count + "개 데이터 입력됨");
			System.out.println(keyValue + "번 공급자 데이터 입력됨");
	
			return keyValue + "번 공급자 데이터 입력됨";
		}
	}
}
