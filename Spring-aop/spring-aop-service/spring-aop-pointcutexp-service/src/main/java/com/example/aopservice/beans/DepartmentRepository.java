package com.example.aopservice.beans;

import org.springframework.stereotype.Component;

import com.example.aopservice.annotation.MonitoredRepository;
import com.example.aopservice.ds.Department;

@Component
@MonitoredRepository
public class DepartmentRepository {

	public Department findDepartment(String pattern) {
		return new Department();
	}

	public void updateDepartment(int id, Department department) {

	}
}
