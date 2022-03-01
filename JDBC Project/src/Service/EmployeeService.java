package Service;

import java.util.List;

import Model.Employee;
import Utility.EmployeeNotFoundException;

public interface EmployeeService {
	
    public abstract void addEmployee(Employee e);
	
	public abstract void deleteEmployee(int empid);
	
	public abstract void updateEmployee(Employee e);
	
	public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
	
	public List<Employee> showAllEmployees();
}
