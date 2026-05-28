package com.spring.nonweb;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.nonweb.beans.SpringBean1;

public class FileSystemXmlApplicationContextExample {

	public static void main(String[] args) {
		String beansXmlLocationOnFileSystem = FileSystemXmlApplicationContextExample.class.getResource("/beans.xml").toExternalForm();
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(beansXmlLocationOnFileSystem);
		SpringBean1 springBean1 =   context.getBean(SpringBean1.class);
		springBean1.sayHello();

	}

}
