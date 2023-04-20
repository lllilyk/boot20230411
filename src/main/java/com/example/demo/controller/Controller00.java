package com.example.demo.controller;

import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.*;

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
			//pstmt.setString(3, employee.getBirthDate());
			pstmt.setString(4, employee.getPhoto());
			pstmt.setString(5, employee.getNotes());
			pstmt.setInt(6, employee.getId());
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "번 직원 수정");
		}
	}
	
	// 존재하기만 하는 테이블의 각 컬럼에 데이터 넣기
	// UPDATE
	// 값을 받을 form을 가진 메소드(view와 연결)
	@RequestMapping("link3")
	public void method03() {
		
	}
	
	// 포워딩 받을 메소드
	@RequestMapping("link4")
	public void method04(
						 @RequestParam("number") Integer num,
						 @RequestParam("sDate") LocalDate sDate,
						 @RequestParam("trip") LocalDateTime trip,
						 @RequestParam("school") String school,
						 @RequestParam("scoreAvg") Double scoreAvg
			) throws Exception {
		String sql = """
				INSERT INTO PPPYONG (Number, Sdate, Trip, School, ScoreAvg)
				VALUES (?, ?, ?, ?, ?) 
				""";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, num);
			pstmt.setDate(2, Date.valueOf(sDate));
			pstmt.setTimestamp(3, Timestamp.valueOf(trip));
			pstmt.setString(4, school);
			pstmt.setDouble(5, scoreAvg);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨!");
		}
	}
	
	// 테이블 생성했고, 각 컬럼에 맞는 데이터 넣었으니 
	// 모든 레코드 조회해보기
	// SELECT
	
	@RequestMapping("link5")
	public void method05(Model model) throws Exception {
		String sql = """
				SELECT Number, 
					   Sdate, 
					   Trip, 
					   School, 
					   ScoreAvg
				FROM PPPYONG
				""";
		
		List<Ppong> list = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			
			while(rs.next()) {
				Ppong p = new Ppong();
				p.setNumber(rs.getInt("number"));
				p.setSdate(rs.getDate("sdate").toLocalDate());
				p.setTrip(rs.getTimestamp("trip").toLocalDateTime());
				p.setSchool(rs.getString("school"));
				p.setScoreAvg(rs.getDouble("scoreAvg"));
				
				list.add(p);
			}
			
			model.addAttribute("love", list);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
