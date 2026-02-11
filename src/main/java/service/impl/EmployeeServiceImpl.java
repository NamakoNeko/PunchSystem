package service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dao.employee.impl.EmployeeDaoImpl;
import model.employee.CheckInRecord;
import model.employee.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService
{
	EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
	
	@Override
	public void addCheckData(Employee employee)
	{
		LocalDateTime currentTime = LocalDateTime.now();
		employeeDaoImpl.addCheckData(employee.getEmployee_no(), currentTime);
		
	}

	@Override
	public Employee findEmployee(String emoloyee_no, String password)
	{
		return employeeDaoImpl.findEmployee(emoloyee_no, password);
	}

	@Override
	public List<CheckInRecord> findRecordDatas(Employee employee)
	{
		return employeeDaoImpl.findRecordDatas(employee);
	}

	@Override
	public List<CheckInRecord> findRecordDatasByDate(Employee employee, LocalDate startDate,
			LocalDate endDate)
	{
		return employeeDaoImpl.findRecordDatasByDateTime(employee, startDate.atStartOfDay(),  endDate.atTime(23, 59, 59));
	}

	@Override
	public CheckInRecord findFirstRecordDatas(Employee employee)
	{
		List<CheckInRecord> records = employeeDaoImpl.findRecordDatas(employee);
		if (records.size() > 0)
		{
			return records.get(0);
		}
		
		return null;
	}
}
