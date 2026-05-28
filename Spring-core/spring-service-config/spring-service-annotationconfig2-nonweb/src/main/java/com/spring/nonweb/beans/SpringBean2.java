package com.spring.nonweb.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {

	public SpringBean2() {
		System.out.println(getClass().getSimpleName() + " :constructor");
	}

	
	public void sayHello2() {
		System.out.println("Hello from Spring Bean2..");
	}	
}
