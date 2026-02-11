package model.employee;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CheckInRecord implements Serializable
{
	private int id;
	private String employee_no;
	private LocalDateTime check_datetime;
	
	public CheckInRecord()
	{
		super();
	}

	public CheckInRecord(String enployee_no, LocalDateTime check_datetime)
	{
		super();
		this.employee_no = enployee_no;
		this.check_datetime = check_datetime;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEnployee_no()
	{
		return employee_no;
	}

	public void setEnployee_no(String enployee_no)
	{
		this.employee_no = enployee_no;
	}

	public LocalDateTime getCheck_datetime()
	{
		return check_datetime;
	}

	public void setCheck_datetime(LocalDateTime check_datetime)
	{
		this.check_datetime = check_datetime;
	}
}