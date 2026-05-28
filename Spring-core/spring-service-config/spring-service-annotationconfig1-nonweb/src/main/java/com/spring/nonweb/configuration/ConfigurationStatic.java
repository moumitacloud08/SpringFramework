package com.spring.nonweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.nonweb.beans.SpringBean1;
import com.spring.nonweb.beans.SpringBean2;
import com.spring.nonweb.beans.SpringBean3;

@Configuration
public class ConfigurationStatic {
	
	@Bean
	public SpringBean1 getSpringBean1() {
		return new SpringBean1();
	}
	
	@Bean
	public SpringBean2 getSpringBean2() {
		return new SpringBean2();
	}
	
	@Bean
	public SpringBean3 getSpringBean3() {
		return new SpringBean3();
	}

}
