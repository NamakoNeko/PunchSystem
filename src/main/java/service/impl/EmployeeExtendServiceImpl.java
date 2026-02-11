package service.impl;

import dao.employee.impl.AdminDaoImpl;
import model.employee.Employee;
import service.EmployeeExtendService;

public class EmployeeExtendServiceImpl implements EmployeeExtendService
{

	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	
	@Override
	public String createEmployee(Employee employee)
	{
		String errorEmployeeMessage = getEmployeeErrorMessage(employee);
		if (!errorEmployeeMessage.isEmpty())
		{
			return errorEmployeeMessage;
		}
		
		if (adminDaoImpl.findEmployee(employee.getEmployee_no()) != null)
		{
			return "無法新增既有的員工資料!!";
		}
		
		adminDaoImpl.createEmployee(employee);
		
		return "新增成功";
	}

	@Override
	public String updateEmployee(Employee employee)
	{
		String errorEmployeeMessage = getEmployeeErrorMessage(employee);
		if (!errorEmployeeMessage.isEmpty())
		{
			return errorEmployeeMessage;
		}
		
		Employee findEmployee = adminDaoImpl.findEmployee(employee.getEmployee_no());
		if (findEmployee == null)
		{
			return "找不到指定的員工資料";
		}
		
		adminDaoImpl.updateEmployee(employee);
		
		return "更新成功";
	}

	@Override
	public String deleteEmployee(Employee employee, String currentUserEmployee_no)
	{
		if(employee.getEmployee_no().isEmpty())
		{
			return "員工編號不可為空";
		}
		
		if(employee.getEmployee_no().equals(currentUserEmployee_no))
		{
			return "不可刪除當前使用者的資料";
		}
		
		Employee findEmployee = adminDaoImpl.findEmployee(employee.getEmployee_no());
		if (findEmployee == null)
		{
			return "找不到指定的員工資料";
		}
		
		adminDaoImpl.deleteEmployee(employee);
		
		return "刪除成功!!";
	}
	
	private String getEmployeeErrorMessage(Employee employee)
	{
		if(employee.getEmployee_no().isEmpty())
		{
			return "員工編號不可為空";
		}
		
		if (employee.getEmployee_name().isEmpty())
		{
			return "員工姓名不可為空";
		}
		
		if (employee.getDepartment().isEmpty())
		{
			return "部門名稱不可為空";
		}
		
		if (employee.getPassword().isEmpty())
		{
			return "密碼不可為空";
		}
		
		return "";
	}
}
