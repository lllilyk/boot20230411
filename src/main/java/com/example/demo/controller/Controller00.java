package com.example.demo.controller;

import java.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub00")
public class Controller00 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	//조회
	//경로 : /sub00/link1?id=18
	@RequestMapping("link1")
	public void method01(int id, Model model) throws Exception{
		String sql = """
				SELECT 
						EmployeeID,
						FirstName,
						LastName,
						BirthDate,
						Photo,
						Notes
				FROM Employees
				WHERE EmployeeID = ?
				""";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, id);
			
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt("employeeId"));
					employee.setFirstName(rs.getString("firstName"));
					employee.setLastName(rs.getString("lastName"));
					employee.setPhoto(rs.getString("photo"));
					employee.setNotes(rs.getString("notes"));
					
					model.addAttribute("employee", employee);
				}
			}
		}
		

	}
	
	//수정
	@RequestMapping("link2")
	public void method02(Employee employee) throws Exception{
		String sql = """
				UPDATE Employees
				SET 
					FirstName = ?,
					LastName = ?,
					BirthDate = ?,
					Photo = ?,
					Notes = ?
				WHERE EmployeeID = ?	
				""";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getBirthDate());
			pstmt.setString(4, employee.getPhoto());
			pstmt.setString(5, employee.getNotes());
			pstmt.setInt(6, employee.getId());
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "번 직원 수정");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
