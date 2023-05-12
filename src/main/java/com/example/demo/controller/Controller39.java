package com.example.demo.controller;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.Controller39.*;
import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub39")
public class Controller39 {
	
	@GetMapping("view")
	public void view() {
		
	}
	
	@GetMapping("link1")
	@ResponseBody
	public String method01() {
		return "hello ajax";
	}
	
	@GetMapping("link2")
	@ResponseBody
	public ResponseEntity method2() {
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("link3")
	@ResponseBody
	public ResponseEntity method03() {
		return ResponseEntity.ok().build();
	}

	@GetMapping("link4")
	@ResponseBody
	public ResponseEntity method04() {
		return ResponseEntity.internalServerError().build();
	}

	/*
	@GetMapping("link5")
	public ResponseEntity method5() {
		boolean ok = service.method();
		if (ok) {
			return ResponseEntity.ok();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	*/
	
	@GetMapping("link9")
	@ResponseBody
	public String method09() {
//		return "hello ajax!";
		return """
				{"name":"채치수", "age":30}
				""";
	}

	@GetMapping("link10")
	@ResponseBody
	public String method10() {
		return LocalTime.now().toString();
	}
	
	@GetMapping("link11")
	@ResponseBody
	public Map<String, Object> method11() {
		return Map.of("name","채소연", "age", 23);
	}
	
	/*내가 한 것
	@GetMapping("link12")
	@ResponseBody
	public String method12() {
		return """
				{"address":"japan", "city":"akita", "phone":"apple"}
				""";
	}
	*/
	
	static class Dto1 {
		public String getCity() {
			return "seoul";
		}
		public String getAddress() {
			return "jeju";
		}
		public String getPhone() {
			return "apple";
		}
	}
	
	@GetMapping("link12")
	@ResponseBody
	public Dto1 method12() {
		
		return new Dto1();
	}
	
	@GetMapping("link13")
	@ResponseBody
	public List<String> method13() {
		return List.of("강백호", "채치수", "송태섭");
	}
	
	@Autowired
	private Mapper02 mapper02;
	
	@GetMapping("link14")
	@ResponseBody
	public List<Dto08> method14(Integer cid) {
		return mapper02.sql07(cid);
	}
	
	
	
}
