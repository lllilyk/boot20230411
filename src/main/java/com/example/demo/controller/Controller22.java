package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub22")
public class Controller22 {

	@Autowired
	private Mapper03 mapper;
	
	@RequestMapping("link1")
	public void method01() {
		int cnt1 = mapper.sql01(77, "java");
		int cnt2 = mapper.sql01(88, "spring");
		int cnt3 = mapper.sql01(99, "css");
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	
	@RequestMapping("link2")
	public void method02() {
		System.out.println(mapper.sql02(7.7, "hello mybatis"));
		System.out.println(mapper.sql02(2.2, "hi weekend"));
	}
	
	// /sub22/link3?val1=2.2&val2=송태섭
	@RequestMapping("link3")
	public void method03(Double var1, String var2) {
		System.out.println(mapper.sql02(var1, var2));
	}
	
	@RequestMapping("link4")
	public void method04() {
		Dto09 dto = new Dto09();
		dto.setProp1(300);
		dto.setProp2("hello mybatis");
		dto.setProp3(33.33);
	
		int cnt = mapper.sql03(dto);
		System.out.println(cnt);
	}
	
	@RequestMapping("link5")
	public void method05() {
		Dto10 dto = new Dto10();
		dto.setAge(17);
		dto.setName("이명헌");
		dto.setScore(100.00);
		
		int cnt = mapper.sql04(dto);
		System.out.println(cnt);
	}
	
	// /sub22/link6?age=77&name=park&score=88.88
	@RequestMapping("link6")
	public void method06(@ModelAttribute Dto10 dto) {
		int cnt = mapper.sql04(dto);
		System.out.println(cnt + "개 행 입력됨");
	}

	// /sub22/link7?prop1=4&prop2=뿡&prop3=9.9
	@RequestMapping("link7")
	public void method07(Dto09 dto) {
		int cnt = mapper.sql03(dto);
		System.out.println(cnt + "개 행 입력됨");
	}

	@RequestMapping("link8")
	public void method08() {
		Dto09 dto01 = new Dto09();
		Dto10 dto02 = new Dto10();
		dto01.setProp1(479);
		dto02.setName("이명헌");
		dto01.setProp3(99.99);
		int cnt = mapper.sql05(dto01, dto02);
		System.out.println(cnt + "행 추가됨");
	}

	@RequestMapping("link9")
	public void method09() {
		Dto09 dto01 = new Dto09();
		Dto10 dto02 = new Dto10();
		dto01.setProp1(4);
		dto02.setAge(18);
		dto01.setProp2("이명헌");
		dto02.setName("산왕");
		dto01.setProp3(100.00);
		dto02.setScore(1.1);
		
		int cnt = mapper.sql06(dto01, dto02);
		System.out.println(cnt + "행 추가됨");
	}

	// /sub22/link10?prop1=7&prop2=lunch&prop3=3.14&age=8&name=SONG&score=3.14
	@RequestMapping("link10")
	// annotation을 붙이지 않으면 model attribute로 간주되어서 해당하는 파라미터의 프로퍼티명에 맞게 들어감
	public void method10(Dto09 p1, Dto10 p2) {
		int cnt = mapper.sql06(p1, p2);
		System.out.println(cnt + "행 입력!");
	}
	
	// /sub22/link11?prop2=mybatis&prop3=321
	@RequestMapping("link11")
	public String method11(Dto11 dto) {
		System.out.println("prop1:" + dto.getProp1());
		int cnt = mapper.sql07(dto);
		System.out.println(cnt + "행 입력 완료!");
		System.out.println("prop1:" + dto.getProp1());
		
		return dto.getProp1() + "번째 데이터 입력완료";
	}
	
	// /sub22/link12?age=40&name=son&score=9.9
	// 요청시 MyTable40에 데이터 추가되도록 코드 작성
	@RequestMapping("link12")
		public String method12(Dto12 dto) {
		System.out.println("id : "+ dto.getId());
		int cnt = mapper.sql08(dto);
		System.out.println(cnt + "행 입력됨!");
		System.out.println("id : "+ dto.getId());
		
		return dto.getId() + "번째 데이터 입력끝~";
	}
	
	
}
