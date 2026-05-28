package com.spring.nonweb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.nonweb.beans.SpringBean1;

public class AnnotationConfigApplicationContextExample3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.nonweb.beans");
		context.refresh();
		
		SpringBean1 bean =  context.getBean(SpringBean1.class);
		bean.sayHello();
	}
}
