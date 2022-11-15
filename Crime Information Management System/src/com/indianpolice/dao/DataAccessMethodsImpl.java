package com.indianpolice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.indianpolice.db.DataBase;
import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;
import com.indianpolice.model.CriminalDetails;
import com.indianpolice.model.Department;

public class DataAccessMethodsImpl implements DataAccessMethods {

	
	@Override
	public List<CriminalDetails> getCriminalDetails(String crimeType) throws CriminalDetailsException {
		
		int count = 0;

		List<CriminalDetails> criminalList = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" select * from criminaldetails where crime_type=? order by age;");
			
			preparedStatement.setString(1,crimeType);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int departmentId = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, departmentId);

				criminalList.add(criminalData);
				
			}
			
		} catch (SQLException e) {
			
			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return criminalList;
	}
	

	@Override
	public List<CrimeDetails> getCrimeDetails(String criminalName) throws CrimeDetailsException {
		
		int count = 0;

		List<CrimeDetails> crimeList = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where main_suspect=? order by date desc;");
			
			preparedStatement.setString(1, criminalName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victim = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int departmentId = resultSet.getInt("department_id");
				String status = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victim, crimeDescription, mainSuspect, departmentId, status);
				
				crimeList.add(crimeData);	
			}
			
		} catch (SQLException e) {
			
			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
				
		return crimeList;
	}

	
	@Override
	public List<CrimeDetails> getCrimeRecord(int departmentId) throws CrimeDetailsException {
		
		int count = 0;
		
		List<CrimeDetails> crimeRecord = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where department_id="+departmentId+" order by date desc");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victim = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int id = resultSet.getInt("department_id");
				String status = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victim, crimeDescription, mainSuspect, id, status);
				
				crimeRecord.add(crimeData);
			}
			
		} catch (SQLException e) {
			
			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return crimeRecord;
	}
	

	@Override
	public List<CriminalDetails> getCriminalRecord(int departmentId) throws CriminalDetailsException {
		
		int count = 0;

		List<CriminalDetails> criminalRecord = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails where department_id=? order by age");
			
			preparedStatement.setInt(1, departmentId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int id = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, id);

				criminalRecord.add(criminalData);
				
			}
			
			
		} catch (SQLException e) {
			
			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return criminalRecord;
	}

	
	@Override
	public List<CrimeDetails> getFirStatus(String victim) throws CrimeDetailsException {
		
		int count = 0;

		List<CrimeDetails> firStatus = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" select * from crimedetails where victims=? order by date desc");
			
			preparedStatement.setString(1, victim);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victimName = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int id = resultSet.getInt("department_id");
				String status = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victimName, crimeDescription, mainSuspect, id, status);
				
				firStatus.add(crimeData);
			}
			
		} catch (SQLException e) {

			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return firStatus;
	}

	
	@Override
	public List<CrimeDetails> getFirStatusOfDate(String firDate) throws CrimeDetailsException {
		
		int count = 0;
		
		List<CrimeDetails> firStatus = new ArrayList<>();

		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where date=? order by department_id");
			
			preparedStatement.setString(1, firDate);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victimName = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int id = resultSet.getInt("department_id");
				String status = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victimName, crimeDescription, mainSuspect, id, status);
				
				firStatus.add(crimeData);
			}
			
			
		} catch (SQLException e) {
			
			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return firStatus;
	}

	
	@Override
	public List<CrimeDetails> getMonthlyCrimeReport(int departmentId, int month, int year) throws DepartmentException {
		
		int count = 0;
		
		int endDate=0;
		
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			endDate=31;
		}
		else if(month==2) {
			if(year%4==0)
				endDate = 29;
			else
				endDate = 28;
		}
		else {
			endDate = 30;
		}
		

		List<CrimeDetails> monthlyReport = new ArrayList<>();
		
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where date>='"+year+"-"+month+"-01' AND date<='"+year+"-"+month+"-"+endDate+"' having department_id=? order by date");
			
//			preparedStatement.setInt(1, year);
//			preparedStatement.setInt(2, month);
//			preparedStatement.setInt(3, year);
//			preparedStatement.setInt(4, month);
//			preparedStatement.setInt(5, endDate);
			preparedStatement.setInt(1, departmentId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victimName = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int id = resultSet.getInt("department_id");
				String status = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victimName, crimeDescription, mainSuspect, id, status);
				
				monthlyReport.add(crimeData);
				
			}
			
			
		} catch (SQLException e) {
			
			throw new DepartmentException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return monthlyReport;
	}

	
	public List<CrimeDetails> getCrimeStatus(String status) throws CrimeDetailsException {
		
		int count = 0;
		
		List<CrimeDetails> crimeStatus = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where status=? order by department_id");

			preparedStatement.setString(1, status);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victim = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int departmentId = resultSet.getInt("department_id");
				String stat = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victim, crimeDescription, mainSuspect, departmentId, stat);
				
				crimeStatus.add(crimeData);
				
			}
			
		} catch (SQLException e) {

			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return crimeStatus;
	}


	@Override
	public List<CriminalDetails> getCriminalDataOfAge(int criminalAge) throws CriminalDetailsException {
		
		int count = 0;

		List<CriminalDetails> criminals = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails where age=? order by department_id");
			
			preparedStatement.setInt(1, criminalAge);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int departmentId = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, departmentId);

				criminals.add(criminalData);
				
			}
			
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return criminals;
	}

	@Override
	public List<CriminalDetails> getCriminalDataBetweenAge(int age1, int age2) throws CriminalDetailsException {
		
		int count = 0;
		
		List<CriminalDetails> criminals = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails where age>=? AND age<=? order by age");
			
			preparedStatement.setInt(1, age1);
			preparedStatement.setInt(2, age2);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int departmentId = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, departmentId);

				criminals.add(criminalData);
				
			}			
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return criminals;
	}

	@Override
	public List<CriminalDetails> getCriminalOfGender(String criminalGender) throws CriminalDetailsException {
		
		int count = 0;
		
		List<CriminalDetails> criminals = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails where gender=? order by age");
			
			preparedStatement.setString(1, criminalGender);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int departmentId = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, departmentId);

				criminals.add(criminalData);
				
			}			
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return criminals; 
	}


	@Override
	public List<Department> totalDepartments() throws DepartmentException {
		
		int count = 0;
		
		List<Department> totalDepartments = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from department order by department_id");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				count++;
				
				int departmentId = resultSet.getInt("department_id");
				String area = resultSet.getString("area");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zone = resultSet.getString("zone");
				
				Department department = new Department(departmentId, area, city, state, zone);
				
				totalDepartments.add(department);
			
			}
			
		} catch (SQLException e) {

			throw new DepartmentException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return totalDepartments;
	}
	
	
	@Override
	public List<CrimeDetails> totalCrime() throws CrimeDetailsException {
		
		int count = 0;

		List<CrimeDetails> totalCrimes = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails order by department_id");
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				count++;
				
				String date = resultSet.getString("date");
				String place = resultSet.getString("place");
				String crimeType = resultSet.getString("crime_type");
				String victim = resultSet.getString("victims");
				String crimeDescription = resultSet.getString("crime_description");
				String mainSuspect = resultSet.getString("main_suspect");
				int departmentId = resultSet.getInt("department_id");
				String stat = resultSet.getString("status");
				
				CrimeDetails crimeData = new CrimeDetails(date, place, crimeType, victim, crimeDescription, mainSuspect, departmentId, stat);
				
				totalCrimes.add(crimeData);
				
			}			
			
		} catch (SQLException e) {
			
			throw new CrimeDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return totalCrimes;
	}
	

	@Override
	public List<CriminalDetails> totalCriminal() throws CriminalDetailsException {
		
		int count = 0;
		
		List<CriminalDetails> totalCriminals = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails order by department_id");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				count++;
				
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String identifyMark = resultSet.getString("identify_marks");
				String arrestedArea = resultSet.getString("arrested_area");
				String crime = resultSet.getString("crime_type");
				int departmentId = resultSet.getInt("department_id");
				
				CriminalDetails criminalData = new CriminalDetails(name, age, gender, address, identifyMark, arrestedArea, crime, departmentId);

				totalCriminals.add(criminalData);
				
			}
			
		} catch (SQLException e) {
			
			throw new CriminalDetailsException(e.getMessage());
		}
		
		System.out.println("Total Result = "+count);
		
		return totalCriminals;
	}

	@Override
	public String addDepartmentDetails(Department department) throws DepartmentException {
		
		String message = "Department not added.....";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into department values(?,?,?,?,?)");
			
			preparedStatement.setInt(1, department.getDepartmentId());
			preparedStatement.setString(2, department.getArea());
			preparedStatement.setString(3, department.getCity());
			preparedStatement.setString(4, department.getState());
			preparedStatement.setString(5, department.getZone());
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0) {
				message = "Department added successfully...";
			}
			
		} catch (SQLException e) {

			throw new DepartmentException(e.getMessage());
		}
		
		return message;
	}

	
	@Override
	public String addCrimeDetails(CrimeDetails crime) throws CrimeDetailsException {
		
		String message = "Fail to add Crime Details....";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" insert into crimedetails values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, crime.getDate());
			preparedStatement.setString(2, crime.getPlace());
			preparedStatement.setString(3, crime.getCrimeType());
			preparedStatement.setString(4, crime.getVictim());
			preparedStatement.setString(5, crime.getCrimeDescription());
			preparedStatement.setString(6, crime.getMainSuspect());
			preparedStatement.setInt(7, crime.getDepartmentId());
			preparedStatement.setString(8, crime.getStatus());
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0)
				message = "Crime Details added successfully....";
			
		} catch (SQLException e) {

			throw new CrimeDetailsException(e.getMessage());
		}
		
		return message;
	}

	
	@Override
	public String addCriminalDetails(CriminalDetails criminal) throws CriminalDetailsException {
		
		String message = "Fail to add Criminal Details....";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into criminaldetails values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, criminal.getName());
			preparedStatement.setInt(2, criminal.getAge());
			preparedStatement.setString(3, criminal.getGender());
			preparedStatement.setString(4, criminal.getAddress());
			preparedStatement.setString(5, criminal.getIdentifyMark());
			preparedStatement.setString(6, criminal.getArrestedArea());
			preparedStatement.setString(7, criminal.getCrimeType());
			preparedStatement.setInt(8, criminal.getDepartmentId());
			
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0)
				message = "Criminal data added successfully....";
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public String updateDepartment(String column, String value, int id) throws DepartmentException {
		
		String message = "Fail to update the department...";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = null;
			
			if(column.equalsIgnoreCase("area")) {
				preparedStatement = connection.prepareStatement(" update department set area=? where department_id=?");
			}
			else if(column.equalsIgnoreCase("city")) {
				preparedStatement = connection.prepareStatement(" update department set city=? where department_id=?");
			}
			else if(column.equalsIgnoreCase("state")) {
				preparedStatement = connection.prepareStatement(" update department set state=? where department_id=?");
			}
			else if(column.equalsIgnoreCase("zone")) {
				preparedStatement = connection.prepareStatement(" update department set zone=? where department_id=?");
			}
		
			
//			preparedStatement.setString(1, column);
			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, id);
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0)
				message = "Department "+id+" updated successfully...";
			
		} catch (SQLException e) {

			throw new DepartmentException(e.getMessage());
		}
		
		return message;
	}
	
	
	@Override
	public String updateDepartment(String column, int value, int id) throws DepartmentException {

		String message = "Fail to update the department...";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" update department set department_id=? where department_id=?");
			
//			preparedStatement.setString(1, column);
			preparedStatement.setInt(1, value);
			preparedStatement.setInt(2, id);
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0)
				message = "Department "+id+" updated successfully...";
			
		} catch (SQLException e) {

			throw new DepartmentException(e.getMessage());
		}
		
		return message;
	}
	
	
	@Override
	public String updateCriminalDetails(String column, int value, String name, int departmentId) throws CriminalDetailsException {

		String message = "Fail to update criminal details......";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = null;
			
			if(column.equalsIgnoreCase("age")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set age=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("department_id")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set department_id=? where name=? AND department_id=?");
			}
			
//			preparedStatement.setString(1, column);
			preparedStatement.setInt(1, value);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, departmentId);
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0) {
				message = "Criminal record has been updated....";
			}
			
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		return message;
	}	


	@Override
	public String updateCriminalDetails(String column, String value, String name, int departmentId) throws CriminalDetailsException {
		
		String message = "Fail to update criminal details......";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = null;
			
			if(column.equalsIgnoreCase("Name")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set name=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("gender")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set gender=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("address")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set gender=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("identify_marks")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set identify_marks=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("arrested_area")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set arrested_area=? where name=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("crime_type")) {
				preparedStatement = connection.prepareStatement("update criminaldetails set crime_type=? where name=? AND department_id=?");
			}
			
//			preparedStatement.setString(1, column);
			preparedStatement.setString(1, value);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, departmentId);
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0) {
				message = "Criminal record has been updated...";
			}
			
			
		} catch (SQLException e) {

			throw new CriminalDetailsException(e.getMessage());
		}
		
		return message;
	}


	@Override
	public String updateCrimeDetails(String column, String value, String victim, String mainSuspect , int departmentId) throws CrimeDetailsException {

		String message = "Fail to update crime details....";
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = null;
			
			if(column.equalsIgnoreCase("date")) {
				preparedStatement = connection.prepareStatement("update crimedetails set date=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("place")) {
				preparedStatement = connection.prepareStatement("update crimedetails set place=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("crime_type")) {
				preparedStatement = connection.prepareStatement("update crimedetails set crime_type=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("victims")) {
				preparedStatement = connection.prepareStatement("update crimedetails set victims=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("crime_description")) {
				preparedStatement = connection.prepareStatement("update crimedetails set crime_description=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("main_suspect")) {
				preparedStatement = connection.prepareStatement("update crimedetails set main_suspect=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("status")) {
				preparedStatement = connection.prepareStatement("update crimedetails set status=? where victims=? AND main_suspect=? AND department_id=?");
			}
			else if(column.equalsIgnoreCase("department_id")) {
				preparedStatement = connection.prepareStatement("update crimedetails set department_id=? where victims=? AND main_suspect=? AND department_id=?");
			}
			
			preparedStatement.setString(1, column);
			preparedStatement.setString(2, value);
			preparedStatement.setString(3, victim);
			preparedStatement.setString(4, mainSuspect);
			preparedStatement.setInt(5, departmentId);
			
			int status = preparedStatement.executeUpdate();
			
			if(status>0)
				message = "Crime Record has been updated...";
			
			
		} catch (SQLException e) {

			throw new CrimeDetailsException(e.getMessage());
		}
		
		return message;
	}


}
