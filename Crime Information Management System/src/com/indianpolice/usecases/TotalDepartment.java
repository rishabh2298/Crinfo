package com.indianpolice.usecases;

import java.util.List;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.Department;

public class TotalDepartment {
	
	public void values() {
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
			
			List<Department> departments = dao.totalDepartments();
			
			departments.forEach(s -> {
				System.out.println();
				System.out.println("Department Id = "+s.getDepartmentId());
				System.out.println("Area = "+s.getArea());
				System.out.println("City = "+s.getCity());
				System.out.println("State = "+s.getState());
				System.out.println("Zone = "+s.getZone());
				System.out.println();
				System.out.println("=================================================");
			});
			
		} catch (DepartmentException e) {

			System.out.println(e.getMessage());
		}
		
	}

}
