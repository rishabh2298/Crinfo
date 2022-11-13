package com.indianpolice.operation;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.indianpolice.usecases.AddCrimeDetails;
import com.indianpolice.usecases.AddCriminalDetails;
import com.indianpolice.usecases.AddDepartmentDetails;
import com.indianpolice.usecases.GetCrimeDetails;
import com.indianpolice.usecases.GetCrimeRecord;
import com.indianpolice.usecases.GetCrimeStatus;
import com.indianpolice.usecases.GetCriminalDataBetweenAge;
import com.indianpolice.usecases.GetCriminalDataOfAge;
import com.indianpolice.usecases.GetCriminalDetails;
import com.indianpolice.usecases.GetCriminalRecord;
import com.indianpolice.usecases.GetCriminalsOfGender;
import com.indianpolice.usecases.GetFirStatusByDate;
import com.indianpolice.usecases.GetFirStatusByVictim;
import com.indianpolice.usecases.GetMonthlyCrimeReport;
import com.indianpolice.usecases.TotalCrime;
import com.indianpolice.usecases.TotalCriminal;
import com.indianpolice.usecases.UpdateCrimeDetails;
import com.indianpolice.usecases.UpdateCriminalDetails01;
import com.indianpolice.usecases.UpdateCriminalDetails02;
import com.indianpolice.usecases.UpdateDepartment01;
import com.indianpolice.usecases.UpdateDepartment02;

public class UserOperations {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("..........Welcome to Crinfo..........");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println();
		System.out.println();
		
		System.out.println("Please Select Command");
		System.out.println("=====================");
		System.out.println("Continue = To make changes in data");
		System.out.println("Exit = To stop the application");
		System.out.println();
		System.out.println();
		
		String command = scanner.next();
		
		if(!command.equalsIgnoreCase("Exit")) {
			
			System.out.println();
			System.out.println();
			
			System.out.println("Select Options");
			System.out.println("==============");
			System.out.println(" 1. To add department details");
			System.out.println(" 2. To add crime details");
			System.out.println(" 3. To add criminal details");
			System.out.println(" 4. To get List of Criminal Details based on crime type");
			System.out.println(" 5. To get List of Crime Details based on Criminal");
			System.out.println(" 6. To get crime record based on department-id");
			System.out.println(" 7. To get criminal record based on department-id");
			System.out.println(" 8. To get FIR Status based on victim");
			System.out.println(" 9. To get List of FIR bases on date");
			System.out.println("10. To get Monthly Crime Report of department");
			System.out.println("11. To get Report bases on status of case");
			System.out.println("12. To get Criminal data of specific age");
			System.out.println("13. To get Criminal data between certain age groups");
			System.out.println("14. To get Criminal data based on gender");
			System.out.println("15. To get Total Crime Records");
			System.out.println("16. To get Total Criminal Records");
			System.out.println("17. To update department details (with character values)");
			System.out.println("18. To update department details (with numerical values)");
			System.out.println("19. To update criminal details (with character values)");
			System.out.println("20. To update criminal details (with numerrical values");
			System.out.println("21. To update crime details");
			
			int choice = scanner.nextInt();
			
			System.out.println();
			System.out.println();
			
			switch (choice) {
			
				case 1:{
					new AddDepartmentDetails().values();
				}
				break;
				
				case 2:{
					new AddCrimeDetails().values();
				}
				break;
				
				case 3:{
					new AddCriminalDetails().values();
				}
				break;
				
				case 4:{
					new GetCriminalDetails().values();
				}
				break;
				
				case 5:{
					new GetCrimeDetails().values();
				}
				break;
				
				case 6:{
					new GetCrimeRecord().values();
				}
				break;
				
				case 7:{
					new GetCriminalRecord().values();
				}
				break;
				
				case 8:{
					new GetFirStatusByVictim().values();
				}
				break;
				
				case 9:{
					new GetFirStatusByDate().values();
				}
				break;
				
				case 10:{
					new GetMonthlyCrimeReport().values();
				}
				break;
				
				case 11:{
					new GetCrimeStatus().values();
				}
				break;
				
				case 12:{
					new GetCriminalDataOfAge().values();
				}
				break;
				
				case 13:{
					new GetCriminalDataBetweenAge().values();
				}
				break;
				
				case 14:{
					new GetCriminalsOfGender().values();
				}
				break;
				
				case 15:{
					new TotalCrime().values();
				}
				break;
				
				case 16:{
					new TotalCriminal().values();
				}
				break;
				
				case 17:{
					new UpdateDepartment01().values();
				}
				break;
				
				case 18:{
					new UpdateDepartment02().values();
				}
				break;
				
				case 19:{
					new UpdateCriminalDetails01().values();
				}
				break;
				
				case 20:{
					new UpdateCriminalDetails02().values();
				}
				break;
				
				case 21:{
					new UpdateCrimeDetails().values();
				}
				break;
			}
			
//			System.out.println();
//			System.out.println();
//			System.out.println("+++++++++++++++++++++++++++++");
//			System.out.println("+++++++++++++++++++++++++++++");
//			System.out.println();
//			System.out.println("Please Select Command");
//			System.out.println("=====================");
//			System.out.println("Continue = To make changes in data");
//			System.out.println("Exit = To stop the application");
//			System.out.println();
			
//			command = scanner.next();
			
			System.out.println("++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++");
		}
		
		System.out.println();
		System.out.println("...Thankyou for visiting here......");
		System.out.println("===================================");
		System.out.println();
		System.out.println();
		
		scanner.close();
		
	}

}
