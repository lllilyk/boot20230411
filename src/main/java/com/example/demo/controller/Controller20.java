package com.example.demo.controller;

import java.time.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub20")
public class Controller20 {
	
	@Autowired
	private Mapper01 mapper;
	
	@RequestMapping("link1")
	public void method01() {
		
		String name = mapper.method01();
		System.out.println(name);

		System.out.println(mapper.method02());
	}
	
	@RequestMapping("link2")
	public void method02() {
		
		// mapper01에 method03 작성
		// 1번 공급자의 공급자명
		System.out.println(mapper.method03());
	}
	
	@RequestMapping("link3")
	public void method03() {
		//3번 고객 이름을 조회하겠다.
		//String name = mapper.method04(3);
		
		//5번 고객 이름을 조회하겠다.
		String name = mapper.method04(5);
		System.out.println(name);
	}
	
	// link4?id=70
	@RequestMapping("link4")
	public void method04(
			@RequestParam("id") Integer customerId) {
		String name = mapper.method04(customerId);
		System.out.println(name);
	}
	
	
	//link5?id=2
	//2번 직원의 lastName을 콘솔에 출력
	@RequestMapping("link5")
//  public void method05(@RequestParam("id") Integer id){ 
//  55, 57번 코드는 같은 코드
//  @RequestParam의 파라미터명과 변수명이 동일하면 requestparam의 파라미터명 생략가능 
	// @RequestParam Integer id
//  기본타입이나 wrapper타입이면 @RequestParam으로 간주하므로 annotation도 생략가능
	public void method05(Integer id) {
		System.out.println(mapper.method05(id));
	}
	
	@RequestMapping("link6")
	public void method06() {
		Integer price = mapper.method06();
		System.out.println(price);
		
		//mapper01에 method07 작성
		//하나의 row의 weight 컬럼의 값 리턴
		Double weight = mapper.method07();
		System.out.println(weight);
		
		LocalDate published = mapper.method08();
		System.out.println(published);
		
		LocalDateTime updated = mapper.method09();
		System.out.println(updated);
	}
	
	@RequestMapping("link7")
	public void method07() {
		Dto06 res = mapper.method10();
		System.out.println(res);
	}
	
	@RequestMapping("link8")
	public void method08() {
		Dto05 res = mapper.method11();
		System.out.println(res);
	}
	
	@RequestMapping("link9")
	public void method09() {
		Customer res = mapper.method12();
		System.out.println(res);
	}

	@RequestMapping("link10")
	public void method10() {
		Supplier sup = mapper.method13();
		System.out.println(sup);
	}
	
	@RequestMapping("link11")
	public void method11() {
		Employee emp = mapper.method14();
		System.out.println(emp);
	}
}
