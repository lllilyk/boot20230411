package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@Controller
@RequestMapping("sub36")
public class Controller36 {

	@GetMapping("view")
	public void method() {
		
	}

	@Data
	static class Dto01{
		private String name;
		private Integer age;
	}
	
	@PostMapping("link1")
//	public void method01(@RequestBody Map<String, Object> map) {
	public void method01(@RequestBody Dto01 map) {
	System.out.println(map);
	}
	
	@Data
	static class Dto02{
		private String name;
		private String email;
		private Double score;
		private Boolean married;
	}
	
	@PostMapping("link2")
	public void method02(@RequestBody Dto02 dto) {
		System.out.println(dto); 
	}
	
	@Data
	static class Dto03 {
		private String name;
		private List<String> hobby;
	}
	
	@PostMapping("link3")
	public void method03(@RequestBody Dto03 dto) {
		System.out.println(dto);
	}
	
	@Data
	static class Dto04{
		private List<String> phone;
	}
	
	// {"phone:["apple", "samsung", "shaomi"]}
	@PostMapping("link4")
	public void method04(@RequestBody Dto04 dto) {
		System.out.println(dto);
		System.out.println(dto.getPhone().get(2));
	}
	
	@Data
	static class Dto05{
		private String title;
		private String publisher;
//		private Map<String, Object> writer; // 이렇게 Map으로 담거나
		private Dto01 writer; // 객체 안에 객체를 담는 것 둘 중에 하나
	}
	
	@PostMapping("link5")
	public void method05(@RequestBody Dto05 dto) {
		System.out.println(dto);
	}

	@Data
	static class Dto06{
		private String city;
		private Integer price;
		private Dto02 etc;
	}
	
	@PostMapping("link6")
	public void method06(@RequestBody Dto06 dto) {
		System.out.println(dto);
	}
	
	@PostMapping("link7")
	public void method07(@RequestBody List<Dto01> dto) {
		dto.forEach(System.out::println);
	}
	
}
