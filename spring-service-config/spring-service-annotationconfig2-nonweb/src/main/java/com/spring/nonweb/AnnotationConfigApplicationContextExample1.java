package com.spring.nonweb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.nonweb.beans.ConfigurationComponentScan;
import com.spring.nonweb.beans.SpringBean1;

/**
 * With componentscan
 */
public class AnnotationConfigApplicationContextExample1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConfigurationComponentScan.class);
		SpringBean1 bean=  context.getBean(SpringBean1.class);
		bean.sayHello();

	}

}
