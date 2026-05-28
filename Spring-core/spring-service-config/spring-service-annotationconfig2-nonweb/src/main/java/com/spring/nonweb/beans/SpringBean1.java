package com.spring.nonweb.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {
	
	//@Autowired
	private SpringBean2 springBean2;
	//@Autowired
	private SpringBean3 springBean3;
	
	public SpringBean1() {
		System.out.println(getClass().getSimpleName() + ":constructor");
	}
	
	public void sayHello() {
		System.out.println("Hello Spring..");
		springBean2.sayHello2();
		springBean3.sayHello3();
	}	
	
	@Autowired
	public void setSpringBean2(SpringBean2 springBean2) {
		System.out.println(getClass().getSimpleName()+" :setSpringBean2");
		this.springBean2 = springBean2;
	}
	
	@Autowired
	public void setSpringBean3(SpringBean3 springBean3) {
		System.out.println(getClass().getSimpleName()+" :setSpringBean3");
		this.springBean3 = springBean3;
	}
	
	

}
