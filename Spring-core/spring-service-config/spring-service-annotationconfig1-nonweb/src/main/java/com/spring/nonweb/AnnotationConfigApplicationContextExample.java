package com.spring.nonweb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.nonweb.beans.SpringBean1;
import com.spring.nonweb.configuration.ConfigurationStatic;

/**
 * Without componentscan
 */
public class AnnotationConfigApplicationContextExample {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConfigurationStatic.class);
		SpringBean1 bean=  context.getBean(SpringBean1.class);
		bean.sayHello();

	}

}
