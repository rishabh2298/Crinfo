package com.indianpolice.operation;

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
import com.indianpolice.usecases.TotalDepartment;
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
			System.out.println("15. To get Total Department Records");
			System.out.println("16. To get Total Crime Records");
			System.out.println("17. To get Total Criminal Records");
			System.out.println("18. To update department details (with character values)");
			System.out.println("19. To update department details (with numerical values)");
			System.out.println("20. To update criminal details (with character values)");
			System.out.println("21. To update criminal details (with numerrical values)");
			System.out.println("22. To update crime details");
			System.out.println("23. To Exit");
			
			System.out.println("Enter your choice");
			
			int choice = 0;
			
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println();
			System.out.println();
			
			switch (choice) {
			
				case 1:{
					try {
						new AddDepartmentDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 2:{
					try {
						new AddCrimeDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 3:{
					try {
						new AddCriminalDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 4:{
					try {
						new GetCriminalDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 5:{
					try {
						new GetCrimeDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 6:{
					try {
						new GetCrimeRecord().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 7:{
					try {
						new GetCriminalRecord().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 8:{
					try {
						new GetFirStatusByVictim().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 9:{
					try {
						new GetFirStatusByDate().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 10:{
					try {
						new GetMonthlyCrimeReport().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 11:{
					try {
						new GetCrimeStatus().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 12:{
					try {
						new GetCriminalDataOfAge().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 13:{
					try {
						new GetCriminalDataBetweenAge().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 14:{
					try {
						new GetCriminalsOfGender().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 15:{
					try {
						new TotalDepartment().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 16:{
					try {
						new TotalCrime().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 17:{
					try {
						new TotalCriminal().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 18:{
					try {
						new UpdateDepartment01().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 19:{
					try {
						new UpdateDepartment02().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 20:{
					try {
						new UpdateCriminalDetails01().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 21:{
					try {
						new UpdateCriminalDetails02().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 22:{
					try {
						new UpdateCrimeDetails().values();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
				case 23:{
					command = "Exit";
				}
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
			
//			try {
//				command = scanner.next();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
			
			System.out.println();
			System.out.println();
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
