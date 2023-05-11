package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

// get방식 request
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
	
	@GetMapping("link2")
	public void method02() {
		System.out.println("get 요청 link2");
	}
	
	@GetMapping("link3")
	public void method03(@RequestParam("name") String name) {
		System.out.println("link3 메소드 일함");
		System.out.println("name : " + name);
	}
	
	@GetMapping("link4")
	public void method04(String address) {
		System.out.println("link4 메소드 일함");
		System.out.println("address : " + address);
	}
	
	// /sub34/link5?name=명헌&age=19
	@GetMapping("link5")
	public void method05(String name, Integer age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
	@GetMapping("link6")
	public void method06(String food, Double price) {
		System.out.println("food : " + food);
		System.out.println("price : " + price);
	}
	
	// 자바빈을 내부 클래스로 만들기(쉽게 보려고)
	@Data
	static class Dto01{
		private String address;
		private String name;
		private Integer age;
	}
	
	// /sub34/link7/address=akita&name=ppyong&age=19
	@GetMapping("link7")
	public void method07(@ModelAttribute Dto01 dto) {
		// @ModelAttribute 어노테이션 생략가능
		// java beans property명과 parameter명이 같으면 자동으로 바인딩
		System.out.println(dto);
	}
	
	@Data
	static class Dto02{
		private Double price;
		private String product;
		private String category;
	}
	
	// /sub34/link8/price=1.0&product=ramen&category=food
	@GetMapping("link8")
	public void metho08(Dto02 dto) {
		System.out.println(dto);
	}
	
}
