package com.example.aopservice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TaxBeanAspect {
	
	@Before("this(com.example.aopservice.beans.ITaxBean)")
	public void thisTaxBean1Example1() {
		System.out.println("Before - thisTaxBean1Example1");
	}
	
	@Before("this(com.example.aopservice.beans.TaxBean1)")
	public void thisTaxBean1Example2() {
		System.out.println("Before - thisTaxBean1Example2");
	}
	
	@Before("target(com.example.aopservice.beans.ITaxBean)")
	public void targetTaxBean1Example1() {
		System.out.println("Before - targetTaxBean1Example1");
	}
	@Before("target(com.example.aopservice.beans.TaxBean1)")
	public void targetTaxBean1Example2() {
		System.out.println("Before - targetTaxBean1Example2");
	}
	
	@Before("this(com.example.aopservice.beans.TaxBean2)")
	public void thisTaxBean2Example() {
		System.out.println("Before - thisTaxBean2Example");
	}
	@Before("target(com.example.aopservice.beans.TaxBean2)")
	public void targetTaxBean2Example() {
		System.out.println("Before - targetTaxBean2Example");
	}

}
