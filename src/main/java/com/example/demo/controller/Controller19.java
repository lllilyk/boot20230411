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
@RequestMapping("sub19")
public class Controller19 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method01() throws Exception {
		String sql = """
				INSERT INTO MyTable30 (Col1, Co12)
				VALUES (?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 첫 번째 물음표: Col1은 INT타입이니까 setInt
			pstmt.setInt(1, 99);

			// 두 번째 물음표: Co12은 VARCHAR타입이니까 setString
			pstmt.setString(2, "hello");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link2")
	public void method02() throws Exception {
		String sql = """
				INSERT INTO MyTable30 (Col1, Co12)
				VALUES (?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 첫 번째 물음표: Col1은 INT타입이니까 setInt
			// 엄격하지 않으니까 변경되는 타입으로 작성해도 상관은 없지만 지양
			pstmt.setString(1, "888");

			// 두 번째 물음표: Co12은 VARCHAR타입이니까 setString
			pstmt.setString(2, "hello");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link3")
	public void method03() throws Exception {
		String sql = """
				INSERT INTO MyTable31 (Col1, Col2)
				VALUES (?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 첫 번째 물음표: Col1은 DATE타입이니까 setString
			pstmt.setString(1, "1923-03-01");

			// 두 번째 물음표: Col2은 DATETIME타입이니까 setString
			pstmt.setString(2, "1811-11-12 23:50:49");

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link4")
	public void method04() throws Exception {
		String sql = """
				INSERT INTO MyTable31 (Col1, Col2)
				VALUES (?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 첫 번째 물음표: Col1은 DATE타입이니까 정석은 setDATE
			pstmt.setDate(1, Date.valueOf("2023-03-01"));

			// 두 번째 물음표: Col2은 DATETIME타입이니까 setTimestamp
			pstmt.setTimestamp(2, Timestamp.valueOf("2000-01-01 22:22:11"));

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	// 경로 /sub19/link5
	// MyTable32에 새 레코드 추가하는 메소드 완성

	@RequestMapping("link5")
	public void method05() throws Exception {
		String sql = """
				INSERT INTO MyTable32 (Name, Age, Price, Birth, Inserted)
				VALUES (?, ?, ?, ?, ?)
				""";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// 첫 번째 물음표: Name은 VARCHAR타입이니까 
			pstmt.setString(1, "HANGYODONG");

			// 두 번째 물음표: Age은 Int타입이니까 
			pstmt.setInt(2, 85);

			// 세 번째 물음표: Price은 DEC타입이니까 
			pstmt.setDouble(3, 1000.003);;

			// 네 번째 물음표: Birth은 DATE타입이니까 
			pstmt.setDate(4, Date.valueOf("1985-03-14"));

			// 다섯 번째 물음표: Inserted은 DATETIME타입이니까 
			pstmt.setTimestamp(5, Timestamp.valueOf("1985-03-14 12:12:12"));

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
		}
	}

	@RequestMapping("link6")
	public void method06() {
		// forward to form
		// WEB-INF/views/sub19/link6
	}
	
	@RequestMapping("link7")
	public void method07(
			// 아래와 같이 여러번 동일작업하는 것을 간단히 하기 위해서 javabean 사용
							@RequestParam("name")
							String name,
							@RequestParam("age")
							String age,
							@RequestParam("price")
							String price,
							@RequestParam("birth")
							String birth,
							@RequestParam("inserted")
							String inserted) throws Exception {
		
		String sql = """
				INSERT INTO MyTable32 (Name, Age, Price, Birth, Inserted)
				VALUES (?, ?, ?, ?, ?)
				""";
		
		try(
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, price);
			pstmt.setString(4, birth);
			pstmt.setString(5, inserted);
			pstmt.executeUpdate();
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력됨");
			
		}
	}
	
	@RequestMapping("link8")
	public void method08(
						@RequestParam("name") String name,
						@RequestParam("age") Integer age,
						@RequestParam("price") Double price,
						@RequestParam("birth") LocalDate birth,
						@RequestParam("inserted") LocalDateTime inserted
			) throws Exception{
		
		String sql = """
					INSERT INTO MyTable32 (Name, Age, Price, Birth, Inserted)
					VALUES (?, ?, ?, ?, ?)
					""";
		
		try(
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, price);
			pstmt.setDate(4, Date.valueOf(birth));
			pstmt.setTimestamp(5, Timestamp.valueOf(inserted));
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행 입력 완료");
		}
		
	}
	
	// form이 있는 view로 포워드
	@RequestMapping("link9")
	public void method09() {
		// /WEB-INF/views/sub19/link9.jsp
	}
	
	// 전송된 데이터를 MyTable33에 추가
	@RequestMapping("link10")
	public void method10(
						@RequestParam("title") String title,
						@RequestParam("published") LocalDate published,
						@RequestParam("price") Integer price,
						@RequestParam("updated") LocalDateTime updated,
						@RequestParam("weight") Double weight
			) throws Exception {
		
		String sql = """
				INSERT INTO MyTable33(Title, Published, Price, Updated, Weight)
				VALUES (?, ?, ?, ?, ?)
				""";
		
		try(
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, title);
			pstmt.setDate(2, Date.valueOf(published));
			pstmt.setInt(3, price);
			pstmt.setTimestamp(4,  Timestamp.valueOf(updated));
			pstmt.setDouble(5, weight);
		
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 입력 끝~");
		}
	}
	
	@RequestMapping("link11")
	public void method11() throws Exception{
		String sql = """
					SELECT Title, Published, Price, Updated, Weight
					FROM MyTable33
				""";
		
		try(
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);				
				){
			if(rs.next()) {
				String title = rs.getString("title");
				String published = rs.getString("published");
				String price = rs.getString("price");
				String updated = rs.getString("updated");
				String weight = rs.getString("weight");
				
				System.out.println("제목 :" + title);
				System.out.println("출판일 :" + published);
				System.out.println("가격 :" + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);
			}
		}
	}
	
	@RequestMapping("link12")
	public void method12() throws Exception{
		String sql = """
					SELECT Title, Published, Price, Updated, Weight
					FROM MyTable33
				""";
		
		try(
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);				
				){
			if(rs.next()) {
				String title = rs.getString("title");
				LocalDate published = rs.getDate("published").toLocalDate();
				Integer price = rs.getInt("price");
				LocalDateTime updated = rs.getTimestamp("updated").toLocalDateTime();
				Double weight = rs.getDouble("weight");
				
				System.out.println("제목 :" + title);
				System.out.println("출판일 :" + published);
				System.out.println("가격 :" + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);
			}
		}
	}
	
	// MyTable32의 데이터 조회 후 출력하는 13번 메소드 작성
	@RequestMapping("link13")
	public void method13() throws Exception {
		String sql = """
				SELECT Name, Age, Price, Birth, Inserted
				FROM MyTable32
				""";
		
		try(
				Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			if(rs.next()) {
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				Double price = rs.getDouble("price");
				LocalDate birth = rs.getDate("birth").toLocalDate();
				LocalDateTime inserted = rs.getTimestamp("inserted").toLocalDateTime();
				
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
				System.out.println("가격 : " + price);
				System.out.println("생일 : " + birth);
				System.out.println("추가 : " + inserted);
			}
		}
	}
	
	@RequestMapping("link14")
	public void method14(Model model) throws Exception {
		// 1. request param 수집/ 가공
		// 2. business logic(CRUD)
		String sql = """
				SELECT Name, Age, Price, Birth, Inserted
				FROM MyTable32
				""";
		
		List<Dto05> list = new ArrayList<>();
		
		try(	Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			while (rs.next()) {
				//javabean 사용
				Dto05 o = new Dto05();
				o.setName(rs.getString("name"));
				o.setAge(rs.getInt("age"));
				o.setPrice(rs.getDouble("price"));
				o.setBirth(rs.getDate("birth").toLocalDate());
				o.setInserted(rs.getTimestamp("inserted").toLocalDateTime());
				
				list.add(o);
			}
		}
		// 3. add attribute
		model.addAttribute("memberList", list);
		
		// 4. forward / redirect
	}
	
	// sub19/link15
	// MyTable33에 있는 데이터들 jsp에서 보여주기
	// 메소드, javabean, jsp
	
	// 선택 link9에서 데이터 더 넣기
	
	@RequestMapping("link15")
	public void method15(Model model) throws Exception{
		
		String sql = """
				SELECT Title, Published, Price, Updated, Weight
				FROM MyTable33
				""";
		
		List<Dto06> list = new ArrayList<>();
		
		try(
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			while(rs.next()) {
				Dto06 o = new Dto06();
				o.setTitle(rs.getString("title"));
				o.setPublished(rs.getDate("published").toLocalDate());
				o.setPrice(rs.getInt("price"));
				o.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
				o.setWeight(rs.getDouble("weight"));
				
				list.add(o);
			}
			
			model.addAttribute("bookList", list);
		}
	}
	
	
	
	
	
	
	
	
	
	
}