package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.DepartmentException;

public class UpdateDepartment01 {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter department id");
		int id = input.nextInt();
		
		System.out.println("Enter Column name");
		String column = input.next();
		
		input.nextLine();
		System.out.println("Enter new value");
		String value = input.nextLine();
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
			String message = dao.updateDepartment(column, value, id);
			
			System.out.println(message);
			
		} catch (DepartmentException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
	}

}
