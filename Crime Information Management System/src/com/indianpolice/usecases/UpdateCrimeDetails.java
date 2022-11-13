package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CrimeDetailsException;

public class UpdateCrimeDetails {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter department Id where update required");
		int departmentId = input.nextInt();
		
		input.nextLine();
		System.out.println("Enter Main suspect of FIR");
		String mainSuspect = input.nextLine();
		
		System.out.println("Enter of victim of FIR");
		String victim = input.nextLine();
		
		System.out.println("Enter column name in which update required");
		String column = input.next();
		
		input.nextLine();
		System.out.println("Enter new value");
		String value = input.nextLine();
		
		
		DataAccessMethods dao  = new DataAccessMethodsImpl();
		
		
		try {
			
			String message = dao.updateCrimeDetails(column, value, victim, mainSuspect, departmentId);
		
			System.out.println(message);
			
		} catch (CrimeDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
		
	}

}
