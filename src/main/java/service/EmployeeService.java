package service;

import java.time.LocalDate;
import java.util.List;

import model.employee.CheckInRecord;
import model.employee.Employee;

public interface EmployeeService
{
	//Create
	public void addCheckData(Employee employee);
		
	//Read
	public Employee findEmployee(String employee_no, String password);
	public List<CheckInRecord> findRecordDatas(Employee employee);
	public List<CheckInRecord> findRecordDatasByDate(Employee employee, LocalDate startDate, LocalDate endDate);
	public CheckInRecord findFirstRecordDatas(Employee employee);
}
