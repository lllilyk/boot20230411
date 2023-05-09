package com.example.demo.controller;

import org.springframework.security.access.prepost.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("sub33")
public class Controller33 {

	@GetMapping("mylogin")
	public void loginForm() {
		
	}
	
	@GetMapping("loginSuccess")
	public void loginSuccess() {
		
	}

	@GetMapping("viewAuth")
	public void viewAuth(Authentication authentication) {
		System.out.println("로그인 정보 확인 하기");
		System.out.println(authentication);
		System.out.println(authentication.getName()); //user1으로 로그인했으면 user1
	}
	
	@GetMapping("customCheck")
	@PreAuthorize("@securityUtil.checkBoardWriter(authentication, #id)")
	public void customCheck(String id) {
		System.out.println("customCheck 메소드 실행중");
	}
	

}
