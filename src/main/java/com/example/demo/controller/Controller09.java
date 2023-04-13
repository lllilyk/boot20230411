package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

import jakarta.servlet.http.*;

@Controller
@RequestMapping("sub9")
public class Controller09 {

	@RequestMapping("link1")
	public String method01(HttpServletRequest req, Model model) {
		// 1. request parameter 수집 / 가공
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));

		Dto04 obj = new Dto04();
		obj.setName(name);
		obj.setAge(age);

		// 2. business logic 실행

		// 3. add attribute
		model.addAttribute("value", obj);

		// 4. forward / redirect
		// /WEB-INF/views/sub9/link1.jsp로 포워드 (void로 넣으면 생략 가능)
		return "/sub9/link1";
	}

	// /sub9/link2?name=park&age=40
	@RequestMapping("link2")
	public String method02(@ModelAttribute("value") Dto04 obj) {
		// @ModelAttribute("value") annotation을 작성한 것만으로
		// 아래의 네 줄 코드를 작성한 것과 동일한 효과

		// Dto04 obj = new Dto04();

		// ModelAttribute가 파라미터로 받는 값과 변수명이 동일하면 생략가능
		// 따라서 아래의 두 줄도 생략 가능
		// obj.setName(name);
		// obj.setAge(age);

		// ModelAttribute의 속성명을 "value"라고 명시했으므로 아래의 코드를 작성한 것과 동일
		// model.addAttribute("value", obj);
		return "/sub9/link1";
	}

	@RequestMapping("link3")
	public void method03(@ModelAttribute("attr") Dto04 dto) {
		// 1. request param 수집 / 가공
		// Dto04 객체 만듦
		// name 요청 파라미터를 위 객체에 Setting
		// age 요청 파라미터 위 객체에 Setting

		// 3. add attribute 추가
		// 위 객체를 attr 이름으로 model 추가

		// 4. forward/ redirect
		// /WEB-INF/views/sub9/link3.jsp로 포워드
	}

	
	//경로 : /sub9/link4?name=son&age=50
	@RequestMapping("link4")
	public void method04(Dto04 dto) {
		//@ModelAttribute를 아예 생략해도 동일하게 간주
		
		// 1. request param 수집 / 가공
		// Dto04 객체 만듦
		// name 요청 파라미터를 위 객체에 Setting
		// age 요청 파라미터 위 객체에 Setting

		// 3. add attribute 추가
		// 속성명 안썼으니까 lowCamelCase 변수명 법칙에 따라
		// Dto04라는 클래스명을 dto04라는 이름으로 model 추가

		// 4. forward/ redirect
		// /WEB-INF/views/sub9/link3.jsp로 포워드
	}

	//경로 : /sub9/link5?
	@RequestMapping("link5")
	public void method05(Dto02 dto) {
		
	}
	
}
