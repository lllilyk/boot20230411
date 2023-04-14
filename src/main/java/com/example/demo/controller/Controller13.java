package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub13")
public class Controller13 {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping("link1")
	public void method01(Model model) throws Exception{
		//고객 주소 추가
		//jsp에서 테이블 형식으로 보여주기
		String sql = """
					SELECT CustomerID, CustomerName, Address 
					From Customers
					WHERE CustomerID
					""";
		
		List<Customer> obj = new ArrayList<>();

		
			Connection con = DriverManager.getConnection(url, name, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			try(con; stmt; rs;){
				//1. request parameter
				//2. business logic
				
				while(rs.next()) {
					int id = rs.getInt("customerId");
					String name = rs.getString("CustomerName");
					String address = rs.getString("Address");
					System.out.println(id + ":" + name + ":" + address); 
				
					Customer customer = new Customer();
					customer.setId(id);
					customer.setName(name);
					customer.setAddress(address);
					obj.add(customer);
					}
				}
		
		//3. add attribute
		model.addAttribute("customerList", obj);
		//4. forward
		
	}
	
	@RequestMapping("link2")
	public void method02(Model model) throws Exception {
		String sql = """
					SELECT EmployeeId,
							LastName,
							FirstName
					FROM Employees
					""";
		
		List<Employee> list = new ArrayList<>();
		
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		try(con; stmt; rs;){
			while(rs.next()) {
				int id = rs.getInt("EmployeeId");
				String lastName = rs.getString("LastName");
				String firstName = rs.getString("FirstName");
				System.out.println(id + ":" + lastName + "," + firstName);
			
				Employee employee = new Employee();
				employee.setId(id);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				//list에 bean 더 해주는 것 잊지말기!!
				list.add(employee);
			}
		}
		model.addAttribute("employees", list);
	}
	
	
	// 경로 : /sub13/link3?id=5 or 1=1
	// 위와 같이  sql injection이 동작해서 전체 리스트 출력됨
	//sql에 파라미터로 받을 id를 연결연산자로 더해주기
	//sql injection 위험이 있으므로 위험한 코드임
	@RequestMapping("link3")
	public String method03(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = """;
		sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}
		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}
	
	// 경로 : /sub13/link4?id=5
	@RequestMapping("link4")
	public String method04(@RequestParam String id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = ? """;
		//연결연산자로 직접 넣도록 하는 것이 아니라 preparedStatement interface의 
		//set 메소드들을 사용하면 안전
		//sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}
		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}
	
	//경로 : /sub13/link5?id=3
	@RequestMapping("link5")
	public String method05(@RequestParam String id, Model model) throws Exception{
		//사용자에게 직원 id입력 받아서 쿼리 완성하고 실행 후에 
		// /sub13/link2로 포워딩해서 직원 1명의 정보 출력
		
		List<Employee> list = new ArrayList<>();
		
		String sql = """
				 	SELECT EmployeeId
				 			lastName,
				 			firstName
				 	FROM Employees
				 	WHERE EmployeeId = ?
					""";
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		try(con; pstmt; rs;){
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("employeeId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				
				list.add(employee);
			}
		}
		
		model.addAttribute("employees", list);
		
		return "/sub13/link2";
	}
}
