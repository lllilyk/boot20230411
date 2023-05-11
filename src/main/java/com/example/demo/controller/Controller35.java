package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@Controller
@RequestMapping("sub35")
public class Controller35 {
	
	@GetMapping("ajax1")
	public void view() {
		
	}
	
	@PostMapping("link1")
	public void method01() {
		System.out.println("포스트 요청 잘 받음");
	}
	
	@PostMapping("link2")
	public void method02() {
		System.out.println("메소드 2 일함");
	}
	
	// 쿼리스트링에 붙여서 post방식으로 보내기
	// /sub35/link3?name=ppyong
	@PostMapping("link3")
	public void method03(String name) {
		System.out.println("name : " + name);
	}
//	js
//	$("#button3").click(function(){
//	$.ajax("/sub35/link3?name=ppyong", {method:"post"});
//});
	
	
	// 몸통에 붙여서 post방식으로 보내기
	@PostMapping("link4")
	public void method04(String address, Integer price) {
		System.out.println("address : " + address);
		System.out.println("price : " + price);
	}
	
	@Data
	static class Dto01{
		private String name;
		private Integer number;
		private String email;
	}
	
	@PostMapping("link5")
	public void method05(Dto01 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto02 {
		private String address;
		private String product;
		private Double price;
	}
	
	@PostMapping("link6")
	public void method06(Dto02 dto) {
		System.out.println(dto);
	}
	
	//json 요청 데이터는
	//@RequestBody Map이나(key=value쌍)
	//@RequestBody JavaBean으로 받음
	@PostMapping("link7")
	public void method07(@RequestBody Map map) {
		System.out.println("메소드 실행됨");
		System.out.println(map);
		System.out.println(map.get("name")); //값 출력
	}
	
	@PostMapping("link8")
	public void method08(@RequestBody Map data) {
		System.out.println(data.get("address")); //값 출력
		System.out.println(data.get("name")); //값 출력
	}
	
	// {"age": "19", "name": "ppyong", "married": "false"}
	@PostMapping("link9")
	public void method09(@RequestBody Map data) {
		System.out.println(data.get("name"));
		System.out.println(data.get("age"));
		System.out.println(data.get("married"));
		
		System.out.println(data.get("age").getClass().getSimpleName());
		System.out.println(data.get("name").getClass().getSimpleName());
		System.out.println(data.get("married").getClass().getSimpleName());
	}
	
	@PostMapping("link10")
	public void method10(@RequestBody Map<String, Object> map) {
		System.out.println(map);
	}
	
	@PostMapping("link11")
	public void method11(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		System.out.println(map.get("book"));
		System.out.println(map.get("book").getClass().getSimpleName());
		
		Map<String, Object> book = (Map<String, Object>) map.get("book");
		System.out.println(map.get("title"));
		System.out.println(map.get("price"));
	}
	
	@PostMapping("link12")
	public void method12(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		System.out.println(map.get("food").getClass().getSimpleName());
		
		// 각 아이템을 꺼내고 싶을 때 
		ArrayList<Object> foods = (ArrayList<Object>) map.get("food");
		System.out.println(foods.get(0));
		System.out.println(foods.get(1));
		System.out.println(foods.get(2));
	}
}

