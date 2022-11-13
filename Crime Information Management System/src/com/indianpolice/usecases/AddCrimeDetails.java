package com.indianpolice.usecases;

import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.model.CrimeDetails;

public class AddCrimeDetails {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter Date of Crime in (yyyy-mm-dd) formate");
		String date = input.next();
		
		input.nextLine();
		System.out.println("Enter place of crime");
		String place = input.nextLine();
		
		System.out.println("Enter crime type");
		String crimeType = input.next();
		
		input.nextLine();
		System.out.println("Enter victims of crime");
		String victim = input.nextLine();
		
		System.out.println("Enter crime description");
		String crimeDescription = input.nextLine();
		
		System.out.println("Enter Main Suspect");
		String mainSuspect = input.next();
		
		System.out.println("Enter department Id");
		int departmentId = input.nextInt();
		
		System.out.println("Enter status solved/unsolved");
		String status = input.next();
		
		CrimeDetails crime = new CrimeDetails(date, place, crimeType, victim, crimeDescription, mainSuspect, departmentId, status);
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
			String message = dao.addCrimeDetails(crime);
			
			System.out.println(message);
			
		} catch (CrimeDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
		
	}

}
