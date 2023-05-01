package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub27")
public class Controller27 {

	@Autowired
	private Mapper07 mapper;
	
	// 경로 : /sub27/link1?s=ell
	@GetMapping("link1")
	// 만약 이름에 ell이 없으면 빈값을 받으면 됨
	public String method01(Model model,
				@RequestParam(value="s", defaultValue="") String keyword) {

		//mapper.sql01("%" + keyword + "%");
		//위의 코드 대신 mapper창에서 <bind>와 <script> 사용
		
		model.addAttribute("customerList", mapper.sql01(keyword));
		
		return "/sub13/link1";
	}
	
	// 경로 : /sub27/link2?search=eve
	@GetMapping("link2")
	public String method02(Model model,
					@RequestParam(value="search", defaultValue="") String s) {
		// search 리퀘스트 파라미터로 직원 lastName, firstName검색
		
		// 아래와 같이 작성해도 되고
		//s = "%" + s + "%";
		
		// 아니면 mapper에서 아예 LIKE {s}이렇게 값을 받아도 되고 
		List<Employee> list = mapper.sql02(s);
		model.addAttribute("employeeList", list);
		return "/sub13/link2"; //직원 lastName, firstName
	}
	
	@GetMapping("link3")
	public void method3() {
		mapper.sql3();
	}

	@GetMapping("link4")
	public void method4() {
		mapper.sql4("eve");
	}

	@GetMapping("link5")
	public void method5() {
		mapper.sql4(null);
	}

	@GetMapping("link6")
	public void mehtod6() {
		// 3번 카테고리 상품의 평균 가격
		Double avg = mapper.sql5(3);
	}

	@GetMapping("link7")
	public void method7() {
		// 모든 상품의 평균 가격
		Double avg = mapper.sql5(0);
	}
}