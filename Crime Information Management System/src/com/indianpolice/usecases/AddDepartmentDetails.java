package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.Department;

public class AddDepartmentDetails {

	public void values() {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter department id");
		int departmentId = input.nextInt();
		
		input.nextLine();
		System.out.println("Enter department area");
		String area = input.nextLine();

		System.out.println("Enter department city");
		String city = input.next();
		
		System.out.println("Enter zone of department");
		String zone = input.next();
		
		System.out.println("Enter state of department");
		String state = input.next();
		
		Department department = new Department(departmentId, area, city, state, zone);
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		try {
			String message = dao.addDepartmentDetails(department);
			
			System.out.println(message);
			
		} catch (DepartmentException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
		
	}

}
