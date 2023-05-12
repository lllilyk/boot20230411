package com.example.demo.controller;

import java.time.*;
import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import lombok.*;

@Controller
@RequestMapping("sub37")
public class Controller37 {
	
	@GetMapping("view")
	public void view() {
		
	}
	
	// @ResponseBody
	// ResponseEntity<B>
	
	@GetMapping("link1")
	public ResponseEntity mehtod01() {
		ResponseEntity res = new ResponseEntity(HttpStatusCode.valueOf(200));
		return res;
	}
	
	@GetMapping("link2")
	public ResponseEntity method02() {
		ResponseEntity res = ResponseEntity.ok().build();
		return res;
		
	}
	
	@GetMapping("link3")
	public ResponseEntity method03() {
		ResponseEntity res = ResponseEntity.notFound().build();
		return res;
	}
	
	@GetMapping("link4")
	public ResponseEntity method04() {
		HttpHeaders header = new HttpHeaders();
		header.add("my-header1", "my-value1"); //key-value쌍 추가
		header.add("my-header2", "my-value2");
		
		ResponseEntity res = new ResponseEntity(header, HttpStatusCode.valueOf(200));
				
		return res;
	}
	
	@GetMapping("link5")
	public ResponseEntity method05() {
		ResponseEntity<String> res = new ResponseEntity<>("hello response", HttpStatusCode.valueOf(200));
		
		return res;
	}
	
	@GetMapping("link6")
	public ResponseEntity method06() {
		
		return ResponseEntity.ok("hello response@@@");
	}
	
	@GetMapping("link7")
	public ResponseEntity method07() {
		String date = LocalDate.now().toString();
		return ResponseEntity.ok(date);
	}

	@GetMapping("link8")
	@ResponseBody
	public String method08(){
		String dateTime = LocalDateTime.now().toString();
		return dateTime;
	}
	
	@GetMapping("link9")
	@ResponseBody
	public String method09() {
		//return 하는 String이 view가 아니라 응답본문
		String time = LocalTime.now().toString();
		return time;
	}
	
	// 그냥 텍스트로 인식
	@GetMapping("link10")
	@ResponseBody
	public String method10() {
		String data = """
				{"name": "lee", "age": 30}
				""";
		
		return data;
	}
	
	// json을 인식하고 syntax highlight
	@GetMapping("link11")
	public ResponseEntity method11() {
		String data = """
				{"name": "lee", "age": 30}
				""";
		
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		
		return new ResponseEntity(data, header, 200);
	}
	
	@GetMapping("link12")
	@ResponseBody 
	// annotation을 붙인 상태에서 returnType이 Map이거나 JavaBean이면 Json String으로 변환
	// + Content-type header도 application Json으로 세팅해줌
	public Map method12() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "이명헌");
		map.put("age", 19);
		
		return map;
	}
	
	@GetMapping("link13")
	@ResponseBody 
	public Map method13() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("address", "seoul");
		map.put("price", 3.14);
		
		return map;
	}
	
	@GetMapping("link14")
	@ResponseBody
	public Map<String, Object> method14(){
		// var : 변수 타입이 눈으로 확인될 정도의 코드에서만 사용하기
		var data = new HashMap<String, Object>();
		
		data.put("name", "신현철");
		data.put("score", 100.00);
		data.put("married", false);
		data.put("position", null);
		data.put("child", List.of("baby1", "baby2"));
		data.put("food", Map.of("meal", "chicken"));
		return data;
	}
	
	static class Dto01 {
		public String getName() {
			return "이명헌";
		}
		public Integer getAge() {
			return 19;
		}
	}
	
	@GetMapping("link15")
	@ResponseBody
	public Dto01 method15() {
		Dto01 data = new Dto01();
		
		return data;
	}

	static class Dto02 {
		public String getCity() {
			return "jeju";
		}
		public Double getScore() {
			return 3.3;
		}
		public Boolean isCap() {
			return true;
		}
		public List<String> getFood(){
			return List.of("pizza", "chicken", "burger");
		}
		//다른 객체 담기
		public Dto01 getSub1() {
			return new Dto01();
		}
		//map안에 list담기
		public Map<String, Object> getSub2(){
			return Map.of("model", List.of("abc", "def"), "price", 3.14);
		}
	}
	
	@GetMapping("link16")
	@ResponseBody
	public Dto02 method16() {
		
		return new Dto02(); //{"city":"jeju", "score":3.3, "cap":true}
	}
	
	@GetMapping("link17")
	@ResponseBody
	public List<String> method17(){
		return List.of("java", "css", "html");
	}
	
	@GetMapping("link18")
	@ResponseBody
	public List<Map<String, Object>> method18(){
		return List.of(Map.of("name","강백호"),
						Map.of("name","채치수"),
						Map.of("name","정대만"));
	}
	
	@GetMapping("link19")
	@ResponseBody
	public List<Dto02> method19(){
		return List.of(new Dto02(), new Dto02());
	}
	
	
	
	
}
