package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub21")
public class Controller21 {
	
	@Autowired
	private Mapper02 mapper;
//  여러 레코드에 하나의 컬럼	
	@RequestMapping("link1")
	public void method01() {
		/* 쿼리는 mapper에
		String sql = """
				SELECT CustomerName FROM Customers
				""";
		*/
		List<String> list = mapper.sql01(); //sql01은 메소드명
		/*
		List<String> list = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			list.add(rs.getString(1));
		}
		*/
//		System.out.println(list);
		list.forEach(System.out::println);
	}
	
	// 경로 : /sub21/link2
	// 모든 직원의 lastname 출력
	
	@RequestMapping("link2")
	public void method02() {
		List<String> list = mapper.sql02();
		list.forEach(System.out::println);
	}
	
// 여러 레코드에 여러 컬럼	
	@RequestMapping("link3")
	public void method03() {
		List<Dto07> names = mapper.sql03();
		names.forEach(System.out::println);
	}

	@RequestMapping("link4")
	public void method04() {
		/*
		List<Dto08> two = mapper.sql04();
		two.forEach(System.out::println);
		*/
		mapper.sql04().forEach(System.out::println);
	}
	
	@RequestMapping("link5")
	public void method05(@RequestParam("cid") Integer cid) {
		List<String> names = mapper.sql05(cid);
		names.forEach(System.out::println);
	}
	
	// /sub21/link6?country=uk
	// /sub21/link6?country=canada
	// 각 국가에 있는 고객명이 콘솔에 출력
	@RequestMapping("link6")
	public void method06(@RequestParam("cty") String cty) {
		List<String> names = mapper.sql06(cty);
		names.forEach(System.out::println);
	}
	
	@RequestMapping("link7")
	public void method07(@RequestParam("cid") Integer cid) {
		List<Dto08> values = mapper.sql07(cid);
		values.forEach(System.out::println);
	}
	
}
