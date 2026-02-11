package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Utility
{
	public enum AdminStatementCategory
	{
		
	}
	/*
	public static void main(String[] args)
	{
		Integer year = 2024;
		int month = 2;
		String[] years = getYears(year);
		for(String _year : years)
		{
			System.out.println(_year);
		}
		
		System.out.println("YIndex = " + getIndexOfYear(2024) );
	}
	//*/
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/punchsystem";
		String user = "root";
		String password = "1234";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void saveObject(Object dataObject, String fileName)
	{
		try
		{
			FileOutputStream fileStream = new FileOutputStream(fileName + ".txt");
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(dataObject);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object readObject(String fileName)
	{
		try
		{
			FileInputStream fileStream = new FileInputStream(fileName + ".txt");
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			return objectStream.readObject();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String[] getYears(Integer startYear)
	{
		List<String> yearList = new ArrayList<>();
		Integer currentYear = LocalDate.now().getYear();
		
		if (startYear <= 0)
		{
			startYear = currentYear;
		}
		
		do
		{
			yearList.add(startYear.toString());
		}
		while(++startYear <= currentYear);
		
		return yearList.toArray(new String[yearList.size()]);
	}
	
	public static String[] getDays(int year, int month)
	{
		Integer day = 1;
		Integer cacheMonth = month;
		List<String> dayList = new ArrayList<>();
		LocalDate currentDate = LocalDate.of(year, month, day);
		
		while(cacheMonth <= month)
		{
			day = currentDate.getDayOfMonth();
			dayList.add(day.toString());	
			currentDate = currentDate.plusDays(1);
			cacheMonth = currentDate.getMonthValue();
		}
		
		return dayList.toArray(new String[dayList.size()]);
	}
	
	public static int getIndexOfCurrentYear(Integer startYear)
	{
		return getYears(startYear).length - 1;
	}
	
	public static int getIndexOfCurrentMonth()
	{
		return LocalDate.now().getMonthValue() - 1;
	}
	
	public static int getIndexOfCurrentDay()
	{
		return LocalDate.now().getDayOfMonth() - 1;
	}
	
	public static int getIndexOfDay(int year, int month, int day)
	{
		int maxDay = YearMonth.of(year, month).lengthOfMonth();
		if (day > maxDay)
		{
			day = maxDay;
		}
		
		return LocalDate.of(year, month, day).getDayOfMonth() - 1;
	}
	
	public static boolean isDateVaild(LocalDate startDate, LocalDate endDate)
	{
		return startDate.isEqual(endDate) || startDate.isBefore(endDate);
	}
}
