package com.abhilash.employeemanagement;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
	public void addEmployee(Employee emp)throws SQLException{
	String sql = "Insert INTO employees(name, email, salary) VALUES(?,?,?)";
	try(Connection conn=DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
		stmt.setString(1, emp.getName());
		stmt.setString(2, emp.getEmail());
		stmt.setDouble(3, emp.getSalary());
		stmt.executeUpdate();
		
	}
	}
	
	public List<Employee> getAllEmployees() throws SQLException{
		List<Employee> emp = new ArrayList<>();
		String sql = "SELECT * FROM employees";
		try(Connection conn =DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)){
			while(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEmail(rs.getString("email"));
				e.setName(rs.getString("Name"));
				e.setSalary(rs.getDouble("Salary"));
				emp.add(e);
			}
		}
		return emp;
				
		
	}
	
	public Employee getEmployeeByID(int id) throws SQLException{
		String sql ="SELECT * FROM employees WHERE id=?";
		try(Connection conn= DBConnection.getConnection();
				PreparedStatement stmt= conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEmail(rs.getString("email"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("Salary"));
				return e;
				
				
			}
		}
		return null;
		
	}
	
	public void UpdateEmployee(Employee emp) throws SQLException{
		String sql ="UPDATE employees SET name=?, email=?, salary=?, WHERE id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql)){
			stmt.setString(1, emp.getName());
			stmt.setString(2, emp.getEmail());
			stmt.setDouble(3, emp.getSalary());
			stmt.setInt(4, emp.getId());
			stmt.executeUpdate();
		}
	}
	
	public void deleteEmployee(int id) throws SQLException{
		String sql="DELETE FROM employees WHERE id=?";
		try(Connection conn=DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

}
