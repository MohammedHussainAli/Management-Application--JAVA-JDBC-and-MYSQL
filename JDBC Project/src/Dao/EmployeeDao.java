package Dao;

import java.util.List;

import Model.Employee;
import Utility.EmployeeNotFoundException;

public interface EmployeeDao {
	public abstract void addEmployee(Employee e);
	
	public abstract void deleteEmployee(int empid);
	
	public abstract void updateEmployee(Employee e);
	
	public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
	
	public List<Employee> showAllEmployees();
	
	public static final String URL="jdbc:mysql://localhost:3306/mysql_project";
	public static final String USERNAME="root";
	public static final String PASSWORD="Allahtheone@0044";
	public static final String DRIVER_CLASSNAME="com.mysql.jdbc.Driver";

}
