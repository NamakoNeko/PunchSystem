package service;

import model.employee.Employee;

public interface EmployeeExtendService
{
	//Create
	public String createEmployee(Employee employee);
	
	//Update
	public String updateEmployee(Employee employee);
	
	//Delete
	public String deleteEmployee(Employee employee, String currentUserEmployee_no);
}