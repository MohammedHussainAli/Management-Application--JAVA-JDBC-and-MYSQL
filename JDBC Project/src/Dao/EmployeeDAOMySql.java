package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Model.Employee;
import Utility.EmployeeNotFoundException;

public class EmployeeDAOMySql implements EmployeeDao {

	private Connection cn=null;
	private PreparedStatement pst= null;
	private ResultSet rs= null;
	
	//place holders (??)
	//CRUD OPERATIONS
	public static final String INS_COMMAND = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE employee SET empname=?, age=?, designation=?, salary=?, empexperience=? WHERE empid=?";
	public static final String DELETE_COMMAND = "DELETE FROM employee WHERE empid=?";
	public static final String FIND_COMMAND = "SELECT * FROM employee WHERE empid=?";
	public static final String SELECT_ALL = "SELECT * FROM employee";
	
	public EmployeeDAOMySql() {
		try {
			cn=DriverManager.getConnection(EmployeeDao.URL, EmployeeDao.USERNAME, EmployeeDao.PASSWORD);
		} catch (SQLException e) {
			
			System.out.println("\nSQL Message-----Unable to establish the Connection with Database");
			e.printStackTrace();
		}
	}
	@Override
	public void addEmployee(Employee e) {
		
		int i=0;
		try {
			pst=cn.prepareStatement(INS_COMMAND);
			pst.setInt(1,  e.getEmpid());
			pst.setString(2, e.getEmpname());
			pst.setInt(3, e.getAge());
			pst.setString(4, e.getDesignation());
			pst.setDouble(5, e.getSalary());
			pst.setInt(6, e.getEmpexperience());
			
			i=pst.executeUpdate();
			
		} catch (SQLException e1) {
			
			System.out.println("\nSQL Message-----Adding Record failed... Unable to execute INS Command.");
			e1.printStackTrace();
		}
		finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		if(i>1) {
			System.out.println("\nSQL Message-----Record Added.....");
		}
	}

	@Override
	public void deleteEmployee(int empid) {
		
		int i=0;
		try {
			pst=cn.prepareStatement(DELETE_COMMAND);
			pst.setInt(1, empid);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println("\nSQL Message-----Delete Operation Failed... Unable to execute delete command");
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("\nSQL Message-----Record Deleted Succesfully");
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {
		
		int i=0;
		try {
			pst= cn.prepareStatement(UPDATE_COMMAND);
			pst.setInt(6,  e.getEmpid());
			pst.setString(1, e.getEmpname());
			pst.setInt(2, e.getAge());
			pst.setString(3, e.getDesignation());
			pst.setDouble(4, e.getSalary());
			pst.setInt(5, e.getEmpexperience());
			
			i=pst.executeUpdate();
		} catch (SQLException e1) {
			
			System.out.println("\nSQL Message-----Update Operation Failed...Unable to Update the record.");
			e1.printStackTrace();
		}
		finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("------------------------------------------------------------------------------------------------------");
			System.out.println("\nSQL Message----Record Updated Succesfully");
		}
		
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		
		Employee findTemp = null;
		try {
			pst=cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, e.getEmpid());
			rs=pst.executeQuery();
			if(!rs.next()) {
				throw new EmployeeNotFoundException(e.getEmpid());
				
			}
			findTemp = new Employee();
			findTemp.setEmpname(rs.getString("empname"));
			findTemp.setAge(rs.getInt("age"));
			findTemp.setDesignation(rs.getString("designation"));
			findTemp.setSalary(rs.getDouble("Salary"));
			findTemp.setEmpexperience(rs.getInt("empexperience"));
			findTemp.setEmpid(e.getEmpid());
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} catch (EmployeeNotFoundException e1) {
			
			e1.printStackTrace();
		}
		finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
		
		return findTemp;
	}

	@Override
	public List<Employee> showAllEmployees() {
		
		Employee selectAllTemp=null;
		List <Employee> elist = new LinkedList<>();
		try {
			pst=cn.prepareStatement(SELECT_ALL);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				selectAllTemp = new Employee();
				selectAllTemp.setEmpid(rs.getInt("empid"));
				selectAllTemp.setEmpname(rs.getString("empname"));
				selectAllTemp.setAge(rs.getInt("age"));
				selectAllTemp.setDesignation(rs.getString("designation"));
				selectAllTemp.setSalary(rs.getDouble("Salary"));
				selectAllTemp.setEmpexperience(rs.getInt("empexperience"));
				elist.add(selectAllTemp);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return elist;
	}
	
	
}
