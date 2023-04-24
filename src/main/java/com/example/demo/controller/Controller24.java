package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub24")
public class Controller24 {

	@Autowired
	private Mapper05 mapper;
	
	@RequestMapping("link1")
	public void method01() {
		int cnt = mapper.sql01();
		System.out.println(cnt + "개 행 수정됨");
	}
	
	@RequestMapping("link2")
	public void method02() {
		int cnt = mapper.sql02(5, "마이바티스", 98765);
		System.out.println(cnt + "개 행 변경됨");
	}
	
	@RequestMapping("link3")
	public void method03() {
		int cnt = mapper.sql03(10, "새로운 고객명", "대한민국");
		System.out.println(cnt + "개 행 변경됨");
	}
	
	@RequestMapping("link4")
	public void method04() {
		Customer customer = new Customer();
		customer.setId(9);
		customer.setCity("서울");
		customer.setCountry("대한민국");
		customer.setAddress("신촌");
		customer.setContactName("강백호");
		customer.setName("서태웅");
		customer.setPostalCode("333333");
		int cnt = mapper.sql04(customer);
		System.out.println(cnt +"개 행 수정됨");
	}

	@RequestMapping("link5")
	public void method05(Customer customer) {
		int cnt = mapper.sql04(customer);
		System.out.println(cnt + "개 행 수정됨");
	}
	
	// /sub24/link6?id=9
	@RequestMapping("link6")
	public void method06(Integer id, Model model) {
		Customer customer = mapper.sql05(id);
		model.addAttribute("customer", customer);
	}

	//직원 조회 및 수정 코드 작성
	//조회 
	//경로 : /sub24/link7?id=12
	@RequestMapping("link7")
	public void method7(Integer id, Model model) {
		Employee emp = mapper.sql06(id);
		model.addAttribute("employee", emp);
	}

	//수정
	//경로 : /sub24/link8
	@RequestMapping("link8")
	public void method8(Employee e) {
		int cnt = mapper.sql07(e);
		System.out.println(cnt + "개 행 수정됨");
	}

}

