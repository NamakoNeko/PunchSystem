package dao.employee;

import model.employee.Employee;

public interface EmployeeExtendDao
{
	//Create
	public void createEmployee(Employee employee);
	
	//Update
	public void updateEmployee(Employee employee);
	
	//Delete
	public void deleteEmployee(Employee employee);
}