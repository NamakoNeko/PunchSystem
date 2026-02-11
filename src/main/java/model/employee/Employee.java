package model.employee;

import java.io.Serializable;

public class Employee implements Serializable
{
	private int id;
	private String employee_no;	
	private String employee_name;
	private String department;
	private String password;
	private boolean admin;
	
	public Employee()
	{
		super();
	}

	public Employee(String employee_no, String employee_name, String department, String password, boolean admin)
	{
		super();
		this.employee_no = employee_no;
		this.employee_name = employee_name;
		this.department = department;
		this.password = password;
		this.admin = admin;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmployee_no()
	{
		return employee_no;
	}

	public void setEmployee_no(String employee_no)
	{
		this.employee_no = employee_no;
	}

	public String getEmployee_name()
	{
		return employee_name;
	}

	public void setEmployee_name(String employee_name)
	{
		this.employee_name = employee_name;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isAdmin()
	{
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}
}

