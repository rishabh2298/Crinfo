package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CriminalDetailsException;

public class UpdateCriminalDetails01 {

	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter department Id");
		int departmentId = input.nextInt();
		
		input.nextLine();
		System.out.println("Enter criminal name");
		String criminalName = input.nextLine();
		
		System.out.println("Enter column in which update required");
		String column = input.next();
		
		input.nextLine();
		System.out.println("Enter new value");
		String value = input.nextLine();
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
			
			String message = dao.updateCriminalDetails(column, value, criminalName, departmentId);
		
			System.out.println(message);
			
		} catch (CriminalDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
	}
	
}
