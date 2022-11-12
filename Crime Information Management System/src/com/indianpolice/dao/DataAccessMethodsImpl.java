package com.indianpolice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.indianpolice.db.DataBase;
import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;
import com.indianpolice.model.CriminalDetails;

public class DataAccessMethodsImpl implements DataAccessMethods {

	
	@Override
	public List<CriminalDetails> getCriminalDetails(String crimeType) throws CriminalDetailsException {

		List<CriminalDetails> criminalList = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" select * from criminaldetails where crime_type=? order by age");
			
			preparedStatement.setString(1,crimeType);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
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
		
		return criminalList;
	}
	

	@Override
	public List<CrimeDetails> getCrimeDetails(String criminalName) throws CrimeDetailsException {

		List<CrimeDetails> crimeList = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where main_suspect=? order by date desc;");
			
			preparedStatement.setString(1, criminalName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
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
				
		return crimeList;
	}

	
	@Override
	public List<CrimeDetails> getCrimeRecord(int departmentId) throws CrimeDetailsException {
		
		List<CrimeDetails> crimeRecord = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where department_id="+departmentId+" order by date desc");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
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
		
		return crimeRecord;
	}
	

	@Override
	public List<CriminalDetails> getCriminalRecord(int departmentId) throws CriminalDetailsException {

		List<CriminalDetails> criminalRecord = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from criminaldetails where department_id=? order by age");
			
			preparedStatement.setInt(1, departmentId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
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
		
		return criminalRecord;
	}

	
	@Override
	public List<CrimeDetails> getFirStatus(String victim) throws CrimeDetailsException {

		List<CrimeDetails> firStatus = new ArrayList<>();
		
		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement(" select * from crimedetails where victims=? order by date desc");
			
			preparedStatement.setString(1, victim);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
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
		
		return firStatus;
	}

	
	@Override
	public List<CrimeDetails> getFirStatusOfDate(String firDate) throws CrimeDetailsException {
		
		List<CrimeDetails> firStatus = new ArrayList<>();

		try(Connection connection = DataBase.getConnection()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where date=? order by department_id");
			
			preparedStatement.setString(1, firDate);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
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
		
		
		return firStatus;
	}

	
	@Override
	public List<CrimeDetails> getMonthlyCrimeReport(int departmentId, int month, int year) throws DepartmentException {
		
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
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crimedetails where date>='?-?-01' AND date<='?-?-?' having department_id=? order by date");
			
			preparedStatement.setInt(1, year);
			preparedStatement.setInt(2, month);
			preparedStatement.setInt(3, year);
			preparedStatement.setInt(4, month);
			preparedStatement.setInt(5, endDate);
			preparedStatement.setInt(6, departmentId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
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
		
		return monthlyReport;
	}

	
	@Override
	public List getReportOfDepartment(int departmentId) throws DepartmentException {

		return null;
	}

	@Override
	public List getCrimeStatus(String status) throws CrimeDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCriminalDataOfAge(int age) throws CriminalDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCriminalDataBetweenAge(int age1, int age2) throws CriminalDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCriminalOfGender(String gender) throws CriminalDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrimeDetails> totalCrime() throws CrimeDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriminalDetails> totalCriminal() throws CriminalDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDepartmentDetails() throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCrimeDetails() throws CrimeDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCriminalDetails() throws CriminalDetailsException {
		// TODO Auto-generated method stub
		return null;
	}

}
