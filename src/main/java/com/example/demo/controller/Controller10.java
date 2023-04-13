package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;

@Controller
@RequestMapping("sub10")
public class Controller10 {

	@RequestMapping("link1")
	//아래 두 줄의 코드는 동일
	//public void method01(@RequestParam String name){
	public void method01(String name) {
		/*
		<RequestParam을 작성함으로써 생략된 부분> 
		↓ requestparameter로부터 받은 파라미터값을 변수에 세팅
		String name = request.getParameter("name");
		*/
	}

	@RequestMapping("link2")
	//아래 두 줄의 코드는 동일
	//public void method02(@ModelAttribute Dto04 dto) {
	public void method02(Dto04 dto) {
		/*
		<ModelAttribute를 작성함으로써 생략된 부분> 
		Dto04 dto = new  Dto04();
		
		↓ requsetparameter로부터 받은 파라미터값을 attribute에 세팅
		dto.setName(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		
		request.setAttribute("dto04", dto)
		*/
	}
	
	// /sub10/link3?model=ray&price=3.14&name=son&age=22
		@RequestMapping("link3")
		public void method3(
							@ModelAttribute("model")
							String model, 
							@ModelAttribute("price")
							double price,
							Dto04 obj,
							Model modelMap) {
			/*
			modelMap.addAttribute("model", model);
			modelMap.addAttribute("price", price);
			*/
		}
	
	@RequestMapping("link4")
	public void method04() {
		//1. request param 수집 / 가공
		
		
		//2. business logic ★★★내가 집중할 것은 2번!!
		//crud
		//data를 생성(create), 읽기(read), 수정(update), 삭제(delete)
		
		//3. add attribute
		
		
		//4. forward
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
