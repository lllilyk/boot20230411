package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub6")
public class Controller06 {
	
	@RequestMapping("link1")
	public String method01() {
		System.out.println("link1 메소드 일함");
		return "forward:/sub6/link2";
	}
	
	@RequestMapping("link2")
	public void method02() {
		System.out.println("link2 메소드 일함");
	}
	
	// 경로 : /sub6/link3
	// method03 작성
	// forward : /sub6/link2
	
	@RequestMapping("link3")
	public String method03() {
		System.out.println("link3 메소드 일함");
		return "forward:/sub6/link2";
	}
	
	@RequestMapping("link4")
	public void method04(HttpServletRequest req, HttpServletResponse res) 
			throws Exception{
		
		System.out.println("link4 메소드 일함");
		
		String view = "/WEB-INF/views/abc.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}
	
	//33~41 코드를 이렇게 간단하게!
	@RequestMapping("link5")
	public String method05() {
		
		System.out.println("link5 메소드 일함");
		
		return "forward:/WEB-INF/views/abc.jsp";
	}
	
	@RequestMapping("link6")
	public String method06() {
		System.out.println("link6에서 일함");
		return "abc";
	}
	
	//경로 : /sub6/link7
	@RequestMapping("link7")
	public String method07() {
		System.out.println("link7에서 일함");
		return "def";
	}
	
	//경로 : /sub6/link8
	@RequestMapping("link8")
	public String method08() {
		System.out.println("link8 메소드 일함");
		//view name 명시
		return "/sub6/link8";
	}
	//method08 == method09
	
	@RequestMapping("link9")
	public void method09() {
		System.out.println("link9 메소드 일함");
		// default view name : /sub6/link8
	}
	
	@RequestMapping("link10")
	public String method10() {
		System.out.println("link10 메소드 일함");
		return null;
	}
	
	// 경로 : /sub6/link11
	// /WEB-INF/views/sub6/link11.jsp 로 포워드
	@RequestMapping("link11")
	public String method11(){
		System.out.println("link11 메소드 일함");
		return null;
	}
	
	// 경로 : /sub6/link12?name=park&age=33
	// 1. request param 수집 / 가공
	// 2. business logic(생략)
	// 3. add attribute(생략)
	// 4. /WEB-INF/views/sub6/link12.jsp로 포워드
	@RequestMapping("link12")
	public void method12(String name, int age) {
		
	}
}
