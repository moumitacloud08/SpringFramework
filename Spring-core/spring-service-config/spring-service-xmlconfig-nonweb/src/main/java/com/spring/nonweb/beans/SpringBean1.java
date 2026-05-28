package com.spring.nonweb.beans;

public class SpringBean1 {
	private SpringBean2 springBean2;
	private SpringBean3 springBean3;
	
	public SpringBean1() {
		System.out.println(getClass().getSimpleName() + ":constructor");
	}
	
	public void sayHello() {
		System.out.println("Hello Spring..");
	}	

	public void setSpringBean2(SpringBean2 springBean2) {
		System.out.println(getClass().getSimpleName()+" :setSpringBean2");
		this.springBean2 = springBean2;
	}
	
	public void setSpringBean3(SpringBean3 springBean3) {
		System.out.println(getClass().getSimpleName()+" :setSpringBean3");
		this.springBean3 = springBean3;
	}
	
	

}
