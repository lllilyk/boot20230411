package com.example.demo.component;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ComponentE {

	@Autowired
	private ComponentD comp; //spring bean으로 만들었던 객체를 자동으로 할당(injection)해줌
	
	public ComponentD getComp() {
		return comp;
	}
	
}
