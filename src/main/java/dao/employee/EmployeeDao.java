package dao.employee;

import java.time.LocalDateTime;
import java.util.List;

import model.employee.CheckInRecord;
import model.employee.Employee;

public interface EmployeeDao
{
	//Create
	public void addCheckData(String employee_no, LocalDateTime dateTime);
		
	//Read
	public Employee findEmployee(String emoloyee_no);
	public Employee findEmployee(String emoloyee_no, String password);
	public List<CheckInRecord> findRecordDatas(Employee employee);
	public List<CheckInRecord> findRecordDatasByDateTime(Employee employee, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
