package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub30")
public class Controller30 {
	@Autowired
	private Mapper10 mapper;
	
	@GetMapping("link1")
	public void method01() {
		// A고객의 돈 500원 차감
		mapper.minusA();
		
		// B고객의 돈 500원 증가
		mapper.plusB();
	}
	
	@GetMapping("link2")
	public void method02() {
		// A고객의 돈만 500원 차감됨
		mapper.minusA();
		
		int a = 3 / 0; //runtime exception 일부러 발생시킴
		
		// B고객의 돈은 그대로
		mapper.plusB();
	}
	
	@GetMapping("link3")
	// transactional이라는 annotation만 붙여두면 runtimeException이 발생했을 때 rollback하기 때문에 바뀌지 않음
	@Transactional
	public void method03() {
		// A고객의 돈도 그대로
		mapper.minusA();
		
		int a = 3 / 0; //runtime exception 일부러 발생시킴
		
		// B고객의 돈은 그대로
		mapper.plusB();
	}
	
	@GetMapping("link4")
	@Transactional
	public void method04() throws Exception{
		// A고객의 돈만 500원 차감됨
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // checked Exception을 일부러 발생시킴
		
		// B고객의 돈은 그대로
		mapper.plusB();
	}
	
	@GetMapping("link5")
	//annotation Interface Transactional은
	//If no custom rollback rules are configured in this annotation, 
	//the transaction will roll back on RuntimeException and Error but not on checked exceptions.
	//따라서 기본적으로는 checked exception에는 rollback하지 않지만 아래와 같이 설정하면
	//exception이 발생하면 checkedException도 rollback됨!
	@Transactional(rollbackFor = Exception.class)
	public void method05() throws Exception{
		// A고객의 돈도 그대로
		mapper.minusA();
		
		Class.forName("java.lang.String2"); // checked Exception을 일부러 발생시킴
		
		// B고객의 돈은 그대로
		mapper.plusB();
	}
}
