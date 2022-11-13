package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.model.CriminalDetails;

public class AddCriminalDetails {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter criminal name");
		String name = input.nextLine();
		
		System.out.println("Enter criminal age");
		int age = input.nextInt();
		
		System.out.println("Enter criminal gender");
		String gender = input.next();
		
		input.nextLine();
		System.out.println("Enter criminal address");
		String address = input.nextLine();

		System.out.println("Enter criminal Identify marks");
		String identifyMark = input.nextLine();
		
		System.out.println("Enter criminal arrested area");
		String arrestedArea = input.nextLine();
		
		System.out.println("Enter crime type");
		String crimeType = input.nextLine();
		
		System.out.println("Enter police department Id");
		int departmentId = input.nextInt();
		
		CriminalDetails criminal = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crimeType, departmentId);
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
			String message = dao.addCriminalDetails(criminal);
			
			System.out.println(message);
			
		} catch (CriminalDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
		
	}

}
