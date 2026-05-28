package com.spring.nonweb.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean3 {

	public SpringBean3() {
		System.out.println(getClass().getSimpleName() + " :constructor");
	}
	
	public void sayHello3() {
		System.out.println("Hello from Spring Bean3..");
	}
}
