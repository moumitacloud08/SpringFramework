package com.spring.nonweb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.nonweb.beans.SpringBean1;

public class ClassPathXmlApplicationContextExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		SpringBean1 springBean1= context.getBean(SpringBean1.class);
		
		springBean1.sayHello();
	}

}
