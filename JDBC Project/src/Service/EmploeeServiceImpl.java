package Service;

import java.util.List;

import Dao.EmployeeDAOMySql;
import Dao.EmployeeDao;
import Model.Employee;
import Utility.EmployeeNotFoundException;

public class EmploeeServiceImpl implements EmployeeService {
	
	private EmployeeDao empDao = new EmployeeDAOMySql();

	@Override
	public void addEmployee(Employee e) {
		
		empDao.addEmployee(e);
	}

	@Override
	public void deleteEmployee(int empid) {
		
		empDao.deleteEmployee(empid);
	}

	@Override
	public void updateEmployee(Employee e) {
		
		empDao.updateEmployee(e);
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		
		return empDao.findEmployee(e);
	}

	@Override
	public List<Employee> showAllEmployees() {
		
		return empDao.showAllEmployees();
	}

}
