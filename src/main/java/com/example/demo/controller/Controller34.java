package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub34")
public class Controller34 {
	
	@GetMapping("ajax1")
	public void ajax1() {
		
	}
	
	@GetMapping("link1")
	@ResponseBody
	public String method01() {
		System.out.println("헬로 ajax");
		
		return "첫번째 응답 데이터";
	}
}
