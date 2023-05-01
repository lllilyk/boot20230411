package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("sub26")
public class Controller26 {
	
	@Autowired
	private Mapper06 mapper;
	
	// 경로 : /sub26/link1?page=3 -> 3페이지
	// 경로 : /sub26/link1?page=1 -> 1페이지
	// 경로 : /sub26/link1        -> 1페이지
	@GetMapping("link1")
	public String method01(@RequestParam(value="page", defaultValue="1") Integer page, Model model) {
		System.out.println(page);
		
		// 쿼리에서 사용하는 시작 인덱스
		Integer startIndex = (page -1) * 20;
		
		// 페이지네이션 가장 왼쪽번호, 오른쪽번호 구하기
		Integer leftPageNumber = (page - 1) / 10 * 10 + 1;
		Integer rightPageNumber = leftPageNumber + 9;
		
		// 이전 버튼, 다음 버튼 페이지 번호 구하기
		Integer prevPageNumber = leftPageNumber - 10;
		Integer nextPageNumber = rightPageNumber + 1;
		
		// 마지막 페이지 구하기 : (레코드수 - 1) / 20 + 1
		Integer numOfRecord = mapper.countAll();
		Integer lastPageNumber = (numOfRecord - 1) / 20 + 1;
		
		// 오른쪽 페이지 번호가 마지막 페이지 번호보다 클 수 없음
		rightPageNumber = Math.min(rightPageNumber, lastPageNumber);
		
		List<Customer> list = mapper.listCustomer(startIndex);
		model.addAttribute("customerList", list);
		model.addAttribute("leftPageNumber", leftPageNumber);
		model.addAttribute("rightPageNumber", rightPageNumber);
		model.addAttribute("prevPageNumber", prevPageNumber);
		model.addAttribute("nextPageNumber", nextPageNumber);
		model.addAttribute("lastPageNumber", lastPageNumber);
		model.addAttribute("currentPageNumber", page);
		return "/sub13/link1";
	// 경로 : /sub26/link1?page=7 -> 7페이지:717번부터!
	// 경로 : /sub26/link1?page=5 -> 5페이지:757번부터!
		
	}
	
}
