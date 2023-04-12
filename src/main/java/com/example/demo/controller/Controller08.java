package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub8")
public class Controller08 {

	@RequestMapping("link1")
	public String method01(@ModelAttribute("val") Dto04 dto04) {

		dto04.setName("채소연");
		dto04.setAge(22);

		return "/sub7/link10";
	}

	@RequestMapping("link2")
	public void method02(@ModelAttribute("product") Dto02 obj) {
		obj.setCompany("apple");
		obj.setModel("ipad");
		obj.setPrice(300);
	}

	@RequestMapping("link3")
	public void method03(Model model) {
		Dto02 dto02 = new Dto02();
		Dto03 dto03 = new Dto03();
		model.addAttribute("product", dto02);
		model.addAttribute("member", dto03);
	}

	@RequestMapping("link4")
	public void method04(@ModelAttribute("product") Dto02 dto02,
						 @ModelAttribute("member") Dto03 dto03) {
		// 위의 코드는 아래의 3, 4번이 생략된 것
		// 3. add attribute
		// 4. forward
	}

	@RequestMapping("link5")
	// model attribute의 이름을 생략x : 내가 정한 클래스명으로 들어옴
	public void method05(@ModelAttribute("dto02") Dto02 dto02,
						 @ModelAttribute("dto03") Dto03 dto03) {
		//3. add attribute
		dto02.setCompany("microsoft");
		dto03.setName("bill gates");
		//4. forward
	}
	
	@RequestMapping("link6")
	// model attribute의 이름을 생략 : 클래스 명이 lowerCamelCase 형식에 맞춰 들어옴
	// 예) CompanyMember -> companyMember myName02
	public String method06(@ModelAttribute Dto02 dto02,
							@ModelAttribute Dto03 dto03) {
		//3. add attribute
		dto02.setCompany("apple");
		dto03.setName("steve jobs");
		//4. forward
		return "/sub8/link5";
	}

}
