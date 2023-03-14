package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmpDao 
{

	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		
		Connection con = DataBaseConnection.getConnection();
		return con;
	}
	
	public EmpDto getEmployeeDto(int id) throws SQLException, ClassNotFoundException
	{
		String sql = "Select * from employees where id=?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		EmpDto dto = new EmpDto();
		
		while(rs.next())
		{
			dto.setId(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setRole(rs.getString(3));
			dto.setContact(rs.getInt(4));
			dto.setEmail(rs.getString(5));
		}
		
		return dto;
		
	}
	
	
	
	
	

	public List<EmpDto> getAllData() 
	{
		List<EmpDto> list = null;
		EmpDto dto = null;
		
		try
		{
			list = new ArrayList<EmpDto>();
			String sql = "Select * from employees";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				dto = new EmpDto();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setRole(rs.getString(3));
				dto.setContact(rs.getInt(4));
				dto.setEmail(rs.getString(5));
				
				list.add(dto);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
}
