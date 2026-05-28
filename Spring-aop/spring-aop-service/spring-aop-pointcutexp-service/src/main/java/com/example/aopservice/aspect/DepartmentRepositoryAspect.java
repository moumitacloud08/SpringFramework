package com.example.aopservice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DepartmentRepositoryAspect {
	/**
	 * @within – matches method executions inside classes annotated with specified
	 *         annotation General Form:@within([annotation_type]) [annotation_type]
	 *         – type of annotation used on top of class, inside which method
	 *         execution should be matched
	 */
	@Before("@within(com.example.aopservice.annotation.MonitoredRepository)")
	public void annotationWithinExample() {
		System.out.println("Before - annotationWithinExample");
	}

	/**
	 * @target – matches method executions inside proxied target class that is
	 *         annotated with specific annotation General
	 *         Form:@target([annotation_type]) [annotation_type] – type of
	 *         annotation used on top of proxied class, inside which method
	 *         execution should be matched
	 */
	@Before("@target(com.example.aopservice.annotation.MonitoredRepository)")
	public void annotationTargetExample() {
		System.out.println("Before - annotationTargetExample");
	}

}
