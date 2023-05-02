package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub31")
public class Controller31 {

	@Autowired
	private Mapper11 mapper;

	// 경로 : localhost:8082/sub31/link1?id=3
	@GetMapping("link1")
	public void method01(int id) {
		// 1번 카테고리 정보
		Category category = mapper.sql01(id);

		System.out.println(category);
		category.getProducts().forEach(System.out::println);
	}
	
	// 경로 : localhost:8082/sub31/link2?id=3
	@GetMapping("link2")
	public void method02(int id) {
		// 1번 카테고리 정보
		Category category = mapper.sql02(id);

		System.out.println(category);
		category.getProducts().forEach(System.out::println);
	}
	
	// 경로 : localhost:8082/sub31/link3?id=3
	@GetMapping("link3")
	public void method03(int id) {
		Supplier supplier = mapper.sql03(id);
		
		System.out.println(supplier);
		supplier.getProducts().forEach(System.out::println);
	}	
	
}
