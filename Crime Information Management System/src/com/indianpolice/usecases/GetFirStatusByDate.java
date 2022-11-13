package com.indianpolice.usecases;

import java.util.List;
import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.model.CrimeDetails;

public class GetFirStatusByDate {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter date(yyyy-mm-dd) to get FIR status");
		String date = input.next();
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		try {
			
			List<CrimeDetails> crimes = dao.getFirStatusOfDate(date);
			
			crimes.forEach(s -> {
				System.out.println();
				System.out.println("Date = "+s.getDate());
				System.out.println("Place = "+s.getPlace());
				System.out.println("Crime Type = "+s.getCrimeType());
				System.out.println("Victim = "+s.getVictim());
				System.out.println("Crime Description = "+s.getCrimeDescription());
				System.out.println("Main suspect = "+s.getMainSuspect());
				System.out.println("Department Id = "+s.getDepartmentId());
				System.out.println("Status = "+s.getStatus());
				System.out.println("=================================================");
			});
			
		} catch (CrimeDetailsException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
	}

}
