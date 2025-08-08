package com.flm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flm.model.Employee;
import com.flm.utils.Constants;
import com.flm.utils.DBConnection;

public class EmployeeDao {
	
	public List<Employee> getAllEmployees()  {
		 List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_ALL_EMPLOYEES);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int empId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String email = resultSet.getString(4);
				String phonenumber = resultSet.getString(5);
				double salary = resultSet.getDouble(6);
				
				Employee emp = new Employee(empId, name, age, email, phonenumber, salary);
				employees.add(emp);
			}
			return employees;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
  public void addEmployee(Employee employee) {
	   try {
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(Constants.SAVE_EMPLOYEE);
	    statement.setString(1,employee.getName());
	    statement.setInt(2, employee.getAge());
	    statement.setString(3, employee.getEmail());
	    statement.setString(4, employee.getPhoneNumber());
	    statement.setDouble(5, employee.getSalary());
	    statement.executeUpdate();
	    } catch (ClassNotFoundException | SQLException e) {
	         e.printStackTrace();
	   }
  }
  
    public Employee getEmployee(int empid) {
    	Connection connection;
    	Employee emp = null;
		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.GET_EMPLOYEE);	
			statement.setInt(1, empid);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String email = resultSet.getString(4);
				String phonenumber = resultSet.getString(5);
				double salary = resultSet.getDouble(6);
				
			 emp = new Employee(empid, name, age, email, phonenumber, salary);
				
			}
			return emp;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return emp;

    }
    
    public void updateEmployee(Employee employee) {
    	try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);
			statement.setString(1,employee.getName());
		    statement.setInt(2,  employee.getAge());
		    statement.setString(3, employee.getEmail());
		    statement.setString(4, employee.getPhoneNumber());
		    statement.setDouble(5, employee.getSalary());
		    statement.setInt(6, employee.getEmpid());
		    statement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		}
    }
  
    public void deleteEmployee(int id) {
    	try {
			Connection connection = DBConnection.getConnection();
	        PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE);
	        statement.setInt(1, id);
	        statement.executeUpdate();
    	
    	} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }

}
