package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
public class testController {
	// 변수가 1개인 경우
	@GetMapping("/today/{home}")
	public String goHome(@PathVariable("home") String home) {
		return "Home: " + home;
	}
	
	// 변수가 여러개인 경우
	@GetMapping("/today/{movie}/{home}")
	public String goHomeAndMovie(@PathVariable("movie") String movie, @PathVariable("home") String home) {
		return "Movie: " + movie + ", Home: " + home;
	}
}

