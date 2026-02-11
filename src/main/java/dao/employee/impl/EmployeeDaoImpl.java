package dao.employee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.employee.EmployeeDao;
import model.employee.CheckInRecord;
import model.employee.Employee;
import util.Utility;

public class EmployeeDaoImpl implements EmployeeDao
{
	protected Connection connection = Utility.getConnection();
	
	/*
	public static void main(String[] args)
	{
		
	}
	//*/
	
	
	@Override
	public void addCheckData(String employee_no, LocalDateTime localDateTime)
	{
		String sql = "insert into check_in_record (employee_no, check_time) values(?, ?)";
		try
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee_no);
			statement.setObject(2, localDateTime);
			//statement.setString(3, checkType);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Employee findEmployee(String employee_no)
	{
		String sql = "select * from employee where employee_no = ?";
		try
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee_no);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
			{
				return new Employee(
					resultSet.getString("employee_no"),
					resultSet.getString("employee_name"),
					resultSet.getString("department"),
					resultSet.getString("password"),
					resultSet.getBoolean("admin")
				);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee findEmployee(String employee_no, String password)
	{
		String sql = "select * from employee where employee_no = ? and password = ?";
		try
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee_no);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next())
			{
				return new Employee(
					resultSet.getString("employee_no"),
					resultSet.getString("employee_name"),
					resultSet.getString("department"),
					resultSet.getString("password"),
					resultSet.getBoolean("admin")
				);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<CheckInRecord> findRecordDatas(Employee employee)
	{
		return commonFindDataByDateTime(employee, null, null);
	}

	@Override
	public List<CheckInRecord> findRecordDatasByDateTime(Employee employee, LocalDateTime startDateTime, LocalDateTime endDateTime)
	{
		return commonFindDataByDateTime(employee, startDateTime, endDateTime);
	}
	
	private List<CheckInRecord> commonFindDataByDateTime(Employee employee, LocalDateTime startTime, LocalDateTime endTime)
	{
		List<CheckInRecord> records = new ArrayList<>();
		try
		{
			String sql;
			PreparedStatement statement;
			if(startTime != null && endTime != null)
			{
				sql = "select * from check_in_record where employee_no = ? and check_time >= ? and check_time < ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, employee.getEmployee_no());
				statement.setObject(2, startTime);
				statement.setObject(3, endTime);				
			}
			else
			{
				sql = "select * from check_in_record where employee_no = ?";
				statement = connection.prepareStatement(sql);
				statement.setString(1, employee.getEmployee_no());
			}
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				CheckInRecord record = new CheckInRecord();
				record.setId(resultSet.getInt("id"));
				record.setEnployee_no(resultSet.getString("employee_no"));
				record.setCheck_datetime((LocalDateTime)resultSet.getObject("check_time"));
				records.add(record);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	}
}
