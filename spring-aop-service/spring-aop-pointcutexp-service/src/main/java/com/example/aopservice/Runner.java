package com.example.aopservice;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopservice.beans.DepartmentRepository;
import com.example.aopservice.beans.HelloChildBean;
import com.example.aopservice.beans.ITaxBean;
import com.example.aopservice.beans.TaxBean2;
import com.example.aopservice.ds.Department;
import com.example.aopservice.ds.Person;

public class Runner {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		context.registerShutdownHook();
		
		HelloChildBean springBean = context.getBean(HelloChildBean.class);
		springBean.sayHello("John",6);
		springBean.validateName("John");
		springBean.saveCounterValue(2);
		springBean.savePerson(new Person());
		
		ITaxBean taxBean1 = context.getBean(ITaxBean.class);
		taxBean1.calculateTax(5f);
		
		TaxBean2 taxBean2 = context.getBean(TaxBean2.class);
		taxBean2.calculateTax(10f);
		
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
		Department department = departmentRepository.findDepartment("DEPA%");
		departmentRepository.updateDepartment(5, department);
	}

}
