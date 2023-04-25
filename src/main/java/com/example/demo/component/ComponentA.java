package com.example.demo.component;

public class ComponentA {
	
	private ComponentB comp; //componentA가 componentB를 필드로 가지고 있음
	
	public ComponentA(ComponentB comp) {
		this.comp = comp;
	}
	
	public void setComp(ComponentB comp) {
		this.comp =  comp;
	}
	
	public ComponentB getComp() {
		return comp;
	}
}
