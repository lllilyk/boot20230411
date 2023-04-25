package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping("sub25")
public class Controller25 {
	// value와 path는 같은 역할을 수행
	// GET : 주소창에 경로를 넣어서 요청하는 방법
	// POST : 
	@RequestMapping(path = "link1", method = RequestMethod.POST)
	public void method01() {
		System.out.println("/sub25/link1에서 메소드 일함"); 
		// url에 요청경로 넣고 실행하면 오류 발생. Post방식은 Get방식요청을 지원하지 않으니까
	}
	
	//@RequestMapping(value = "lin2k", method = RequestMethod.GET)
	@GetMapping("lin2k")
	public void method02() {
		System.out.println("/sub25/link2 GET에서 메소드 일함");
	}
	
	//@RequestMapping(value = "link3", method = RequestMethod.POST)
	@PostMapping("link3")
	public void method03() {
		System.out.println("/sub25/link3 POST에서 메소드 일함");
	}
	
	// /sub25/link4/abc
	// /sub25/link4/def
	@GetMapping("link4/{var1}")
	public void method04(@PathVariable("var1") String p1) { //p1에 abc, def값이 들어감
		System.out.println("var1: " + p1);
	}
	
	// /sub25/link5/abc/55
	@GetMapping("link5/{id}/{age}")
	public void method05(@PathVariable("id") String id, //id에는 abc, 
						 @PathVariable("age") int age) { //age에는 55가 들어감
		System.out.println(id + ", " + age);
	}
	
	// /sub25/link6/id/7/name/park
	// /sub25/link6/id/3/name/son
	@GetMapping("link6/id/{var1}/name/{var2}")
	public void method06(@PathVariable("var1") String id, //3은 id		
						 @PathVariable("var2") String name) { // son은 name에 들어감
		System.out.println(id + ", " + name);
	}
	
	// /sub25/link7
	@GetMapping("link7")
	public String method07() { //return 타입을 String으로 하면 return값이 jsp(view)의 이름이 된다.
		return "hello";// /WEB-INF/views/hello.jsp
	}
	
	// redirect를 하고자 하는 경우 return 타입을 String으로 하고 앞에 prefix(redirect:) 붙여주기!
	@GetMapping("link8")
	public String method08() {
		return "redirect:/sub25/link7";
	}
	
	@GetMapping("link9")
	public String method09(Model model) {
		// model에 담아둔 값을 view로 연결해주려면 request 요청이 필요한데 여기서는 request가 아니라 redirect를 했으므로 view로 연결되지 못함
		model.addAttribute("attr1", "value1");
		return "redirect:link10";
	}
	
	// link9-10
	@GetMapping("link10")
	public void method10() {
		
	}
	
	// /sub25/link11 -> link10
	@GetMapping("link11")
	// link9 - 10의 연결 불가를 해결하기 위해서 RedirectAttributes의 addFlashAttribute라는 메소드를 사용할 수 있음
	public String method11(RedirectAttributes rttr) {
		rttr.addFlashAttribute("attr1", "redirect attribute!!");
		return "redirect:link10";
	}
	
	// /sub25/link12 -> link13
	@GetMapping("link12")
	public String method12(RedirectAttributes rttr) {
		rttr.addFlashAttribute("list", List.of("강백호", "서태웅"));
		// 목적지("redirect:link13)의 model attribute로 연결해준 것 
		return "redirect:link13";
	}
	
	@GetMapping("link13")
	public void method13() {
		
	}
	
	@GetMapping("link14")
	public String method14(RedirectAttributes rttr) {
		// 목적지의 Model Attribute로
		// rttr.addFlashAttribute(null, rttr);
		
		//쿼리 스트링으로 붙어서
		rttr.addAttribute("address", "seoul");
		
		return "redirect:link15";
	}
	
	// /sub25/link15로 요청 보내면 link16의 파라미터값이 잘 들어가도록
	@GetMapping("link15")
	public String method15(RedirectAttributes rttr) {
		//아래와 같이 작성해두면 요청을 보내면 link16으로 리다이렉트되면서 쿼리스트링값도 같이 보내짐
		rttr.addAttribute("email", "lilk@naver.com"); 
		rttr.addAttribute("location", "seoul");
		return "redirect:link16";
	}
	
	@GetMapping("link16")
	public void method16(@RequestParam("email") String email,
						 @RequestParam("location") String location) {
		System.out.println("email: " + email);
		System.out.println("location: " + location);
	}
	
	
}

