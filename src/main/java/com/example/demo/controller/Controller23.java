package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub23")
public class Controller23 {

	@Autowired
	private Mapper04 mapper;
	
	@RequestMapping("link1")
	public void method01() {
		
		int cnt = mapper.sql01();
		System.out.println(cnt + "개 행 삭제됨");
	}

	//sub23/link2?id=3
	@RequestMapping("link2")
	public void method02(Integer id) {
		
		int cnt = mapper.sql02(id);
		System.out.println(cnt + "개 행 삭제됨");
	}
	
	// /sub23/link3?key=7
	@RequestMapping("link3")
	public void method03(Integer key) {
		
		int cnt = mapper.sql03(key);
		System.out.println(cnt + "행 삭제!");
	}
}
