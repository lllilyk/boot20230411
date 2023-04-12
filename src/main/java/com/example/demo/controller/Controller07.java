package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub7")
public class Controller07 {
	
	@RequestMapping("link1")
	public void method01(HttpServletRequest req) {
		
		//1. 
		//2. 
		//3. add attribute
		req.setAttribute("myName", "서태웅");
		
		//4. /WEB-INF/views/sub7/link1.jsp로 포워드
		
	}
	
	@RequestMapping("link2")
	public String method02(Model model) {
		
		//3. add attribute
		model.addAttribute("myName", "채치수");
		
		//4. forward / redirect
		return "/sub7/link1";
	}
	
	//경로 : /sub7/link3
	@RequestMapping("link3")
	public String method03(Model model) {
		model.addAttribute("sannnoh", "이명헌");
		return "/sub7/link3";
	}
	
	@RequestMapping("link4")
	public void method04(Model model) {
		model.addAttribute("list", List.of("java", "spring"));
		
	}
	
	// map으로 값을 넣어도 되고,
	@RequestMapping("link5")
	public void method05(Model model) {
		Map<String, Object> obj = new HashMap<>();
		obj.put("name", "woosung");
		obj.put("age", "17");
		obj.put("address", "akita");
		model.addAttribute("myMap", obj);
	}
	
	/*
	@RequestMapping("link5")
	public void method05(Model model) {
		model.addAttribute("myMap", Map.of("name", "woosung","age","17", "address", "akita"));
	}
	*/
	
	//list로 값을 넣어도 되고,
	@RequestMapping("link6")
	public void method06(Model model) {
		model.addAttribute("name", "이한나");
		model.addAttribute("job", "매니저");
		model.addAttribute("hobby", List.of("영화", "독서", "tv"));
	}
	
	//배열로 값을 넣어도 됨.
	@RequestMapping("link7")
	public void method07(Model model) {
		model.addAttribute("age", "17");
		model.addAttribute("country", "japan");
		model.addAttribute("movieList", new String[] {"앤트맨", "마블스", "스파이더맨"});
	}
	
	@RequestMapping("link8")
	public void method08(Model model) {
		Dto01 o1 = new Dto01();
		o1.setAge(40);
		o1.setName("박지성");
		
		model.addAttribute("player", o1);
	}
	
	@RequestMapping("link9")
	public void method09(Model model) {
		Dto02 o1 = new Dto02();
		o1.setModel("car1");
		o1.setPrice(3000);
		o1.setCompany("kia");
		
		model.addAttribute("value", o1);
	}
	
	@RequestMapping("link10")
	public void method10(Model model) {
		Dto04 obj = new Dto04();
		obj.setName("송태섭");
		obj.setAge(20);
		
		model.addAttribute("val", obj);
		
	}
	
}
