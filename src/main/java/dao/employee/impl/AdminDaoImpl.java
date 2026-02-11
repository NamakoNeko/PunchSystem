package dao.employee.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.employee.EmployeeExtendDao;
import model.employee.Employee;

public class AdminDaoImpl extends EmployeeDaoImpl implements EmployeeExtendDao
{

	@Override
	public void createEmployee(Employee employee)
	{
		String sql = "insert into employee (employee_no, employee_name, department, password, admin) values (?, ?, ?, ?, ?)";
		setDataToDatabase(employee, sql, false);
	}

	@Override
	public void updateEmployee(Employee employee)
	{
		String sql = "update employee set employee_no = ?, employee_name = ?, department = ?, password = ?, admin = ? where employee_no = ?";
		setDataToDatabase(employee, sql, true);
	}

	@Override
	public void deleteEmployee(Employee employee)
	{
		String sql = "delete from employee where employee_no = ?";
		try
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getEmployee_no());
			statement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setDataToDatabase(Employee employee, String sql, boolean findByEmployeeNumber)
	{
		try
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, employee.getEmployee_no());
			statement.setString(2, employee.getEmployee_name());
			statement.setString(3, employee.getDepartment());
			statement.setString(4, employee.getPassword());
			statement.setBoolean(5, employee.isAdmin());
			
			if (findByEmployeeNumber)
			{
				statement.setString(6, employee.getEmployee_no());
			}
			
			statement.executeUpdate();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}