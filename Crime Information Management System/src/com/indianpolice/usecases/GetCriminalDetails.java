package com.indianpolice.usecases;

import java.util.List;
import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.model.CriminalDetails;

public class GetCriminalDetails {

	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter crime type to get criminal details");
		String crimeType = input.next();
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		try {
			
			List<CriminalDetails> criminals = dao.getCriminalDetails(crimeType);
			
			criminals.forEach(s -> {
				System.out.println();
				System.out.println("Name = "+s.getName());
				System.out.println("Age = "+s.getAge());
				System.out.println("Gender = "+s.getGender());
				System.out.println("Address = "+s.getAddress());
				System.out.println("Identify Mark = "+s.getIdentifyMark());
				System.out.println("Arrested Area = "+s.getArrestedArea());
				System.out.println("Crime type = "+s.getCrimeType());
				System.out.println("Department Id = "+s.getDepartmentId());
				System.out.println("===========================================");
			});
			
		} catch (CriminalDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
	}
	
}
