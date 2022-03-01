package Model;

public class Employee {
	private int empid;
	private String empname;
	private int age;
	private String designation;
	private double salary;
	private int empexperience;
	public Employee() {
		super();
		
	}
	public Employee(int empid, String empname, int age, String designation, double salary, int empexperience) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.empexperience = empexperience;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getEmpexperience() {
		return empexperience;
	}
	public void setEmpexperience(int empexperience) {
		this.empexperience = empexperience;
	}
	

}
