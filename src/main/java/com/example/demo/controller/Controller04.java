package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub4")
public class Controller04 {
	// method argument(parameter)
	
	//경로 : /sub04/link1
	@RequestMapping("link1")
	public void method01(HttpServletRequest request) {
		
		//1. request parameter 수집 / 가공
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		
		//2. business logic
		
		//3. add attribute
		
		//4. forward / redirect
	}
	
	//경로 : /sub4/link2?address=seoul&email=korea@gmail.com
	@RequestMapping("link2")
	public void method02(HttpServletRequest request) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		System.out.println("address : " + address);
		System.out.println("email : " + email);
	}
	
	/*
	@RequestMapping("link3")
	public void method03(HttpServletRequest request) {
		String address = request.getParameter("address");
		System.out.println("address : " + address);
	}
	*/
	
	@RequestMapping("link3")
	public void method03(@RequestParam("address") String address) {
		System.out.println("address : " + address);
	}
	
	@RequestMapping("link4")
	public void method04(@RequestParam("age") String myage) {
		System.out.println("age: " + myage);
		
		int age = Integer.parseInt(myage);
		
		System.out.println("int age : " + age);
	}
	
	@RequestMapping("link5")
	public void method05(@RequestParam("score") int score) {
		System.out.println("score : " + score);
	}
	
	//경로 : /sub4/link6?email=son@gmail.com
	/*
	@RequestMapping("link6")
	public void method06(@RequestParam("email") String email) {
		System.out.println(email);
	}
	*/
	
	@RequestMapping("link6")
	public void method06(@RequestParam String email) {
		System.out.println(email);
	}
	
	// 경로 : /sub4/link7?age=33
	@RequestMapping("link7")
	public void method07(@RequestParam int age) {
		System.out.println(age);
	}
	
	// 경로 : /sub4/link8?address=seoul
	@RequestMapping("link8")
	public void method08(String address) {
		System.out.println(address);
	}
	
	// 경로 : /sub4/link9?score=99.7
	@RequestMapping("link9")
	public void method09(double score) {
		System.out.println(score);
	}
}
