package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import com.example.demo.component.*;
import com.example.demo.controller.domain.*;

@SpringBootApplication
public class Boot20230411Application {

	public static void main(String[] args) {
		// Spring bean : 스프링이 관리하는 객체들
		ApplicationContext context = SpringApplication.run(Boot20230411Application.class, args);
		// context 객체 안에 우리가 만든 bean1이라는 객체가 들어있음
		// 실제로 그런지 확인
		Object o = context.getBean("bean1");
		System.out.println("1" + o); //java.lang.Object@2069fb6f
		
		Object o2 = context.getBean("employee");
		System.out.println("2" + o2);
		//Employee(id=0, lastName=null, firstName=null, birth=null, photo=null, notes=null)
		
		Object o3 = context.getBean("employee");
		System.out.println("3" + o3);
		
		Object o4 = context.getBean("bean2");
		Object o5 = context.getBean("bean3");
		
		System.out.println("4" + o4); //com.example.demo.component.ComponentA@3d9883ed
		System.out.println("5" + o5); //com.example.demo.component.ComponentB@1535e7e2
		
		ComponentA c1 = (ComponentA) o4;
		System.out.println("6" + c1.getComp());
		
		//spring bean은 전체를 통틀어서 하나만 만들어짐 그러니까 참조값도 같음
		// c1과 o4의 참조값은 동일 : com.example.demo.component.ComponentB@2765f4e4
	
		ComponentA c2 = (ComponentA) o4;
		System.out.println("7" + c2.getComp());
		ComponentC c3 = (ComponentC) context.getBean("bean4");
		System.out.println("8" + c3.getCom()); 
	
		Object c4 = context.getBean("componentD");
		System.out.println(c4);
		ComponentE c5 = (ComponentE) context.getBean("componentE");
		System.out.println(c5.getComp());
		
	}
	
	// 우리가 객체를 직접 만들 때
	public void legacy() {
		Object o = new Object(); // 직접 만든 객체
		Employee e = new Employee(); // 직접 만든 객체
		
		e.setId(100); // 프로퍼티 직접 할당
		
		// 설정파일은 보통 config 패키지 안에 만듦
		
	}
}
