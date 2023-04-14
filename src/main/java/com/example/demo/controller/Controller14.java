package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub14")
public class Controller14 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;
	
	// 추가업무 : ContactName에도 조회 키워드 추가
	// 1. 쿼리 수정
	// 2. pstmt 2번째 물음표에 set 하는 코드 추가
	// 3. Customer 자바빈의 contactName 프로퍼티 추가
	// 4. /sub/link1 뷰에 contactName 속성 출력하는 테이블 열 추가
	
	// 경로 : /sub14/link1?keyword=or
	@RequestMapping("link1")
	public String method01(String keyword, Model model) throws Exception{
		String sql = """
					SELECT CustomerID, CustomerName, Address, ContactName
					FROM Customers
					WHERE CustomerName LIKE ?
						OR ContactName LIKE ?
					""";
	
		List<Customer> list = new ArrayList<>();
		
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pstmt = con.prepareStatement(sql);
		// ?에 set 하는 코드
		pstmt.setString(1,  "%" + keyword + "%");
		pstmt.setString(2, "%" + keyword + "%");
		
		ResultSet rs = pstmt.executeQuery();
		try(con; pstmt; rs;){
			while(rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("customerId"));
				c.setAddress(rs.getString("address"));
				c.setName(rs.getString("customerName"));
				c.setContactName(rs.getString("contactName"));
				list.add(c);
			}
		}
		model.addAttribute("customerList", list);
		
		return "/sub13/link1";
	}
}
