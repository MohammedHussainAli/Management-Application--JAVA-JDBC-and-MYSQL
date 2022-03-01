package Controller;

import java.util.List;
import java.util.Scanner;

import Business.SalaryCalculator;
import Model.Employee;
import Service.EmploeeServiceImpl;
import Service.EmployeeService;
import Utility.EmployeeNotFoundException;



public class EmployeeMain {
	static boolean order=true;
	public static void menu()
	{
		System.out.println();
		System.out.println("************************* HEPTAGON TECHNOLOGIES - Employee Managment System ****************************\n"
        		+ "\n1. Add Employee \n "
        		+ "\n2. View Employee \n"
        	    + "\n3. Update Employee \n"
        		+ "\n4. Delete Employee \n"
        		+ "\n5. View All Employee \n"
        		+ "\n6. Salary Details \n"
        		+ "\n7. Exit \n");
	}
	

	public static void main(String[] args) {
		String userName="Mohammed";
    	String userPass="Ali@0044";
    	String msg=("If you are a new-user kindly contact support for your new login cardential, THANK YOU !");
        Scanner sc = new Scanner(System.in);
        String sp=" ";
	    
        System.out.println("======================================================================================================");
        System.out.println("**************** Welcome to HEPTAGON TECHNOLOGIES - Employee Managment Application *******************");
        System.out.println("======================================================================================================\n\n");
        System.out.println("**************************** Kindly LOGIN to enter into the application ******************************");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println(msg);
        System.out.println("------------------------------------------------------------------------------------------------------");
        boolean flag=true;
        while(flag) {
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("\nEnter the Username => ");  
        String uname = sc.next();
        sc.nextLine();
        System.out.println("\nEnter the Password => ");
        String upass = sc.next();
        sc.nextLine();
        System.out.println("\n------------------------------------------------------------------------------------------------------");
		
		if(uname.equals(userName) && upass.equals(userPass)){
            System.out.println("Welcome "+userName+" you have Logged-in Successfully");
            System.out.println("------------------------------------------------------------------------------------------------------");
		    EmployeeService eservice = new EmploeeServiceImpl();
		
		do {
			//Method call
			menu();
			System.out.println("\n>>>>>> Enter your Choice only in Numbers from (1 - 7) =>");
			int choice=0;
			try {
		
			choice=sc.nextInt();
			}
			catch (Exception e){
				System.out.println("Invalid Choice, kindly enter choice in Numbers not in words or in any other format..");
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("Kindly Login Again >> !!!");
				break;
			}
			//Switch case for each choice
			switch(choice) {

			//Adding Employee
			case 1:
				//System.out.println("Add Employee Details : ");
				Scanner scan = new Scanner(System.in);
				int empId;
				String empName;
				int age;
				String empDesignation;
				double empSalary;
				int empExperience;
				
				System.out.println("\nEnter the number of Employees you want to add =>>> ");
				int n=scan.nextInt();
				for(int i=0; i<n; i++)
				{
					System.out.println("\nAdd Employee Details : ");
				    System.out.println("------------------------------------------------------------------------------------------------------");
				    System.out.println("Enter Employee Id:");
					empId = scan.nextInt();
					System.out.println("Enter name: ");
					empName = scan.next();
					scan.nextLine();
					System.out.println("Enter Employee Age: ");
					age=scan.nextInt();
					System.out.println("Enter Desiganation: ");
					empDesignation = scan.next();
					System.out.println("Enter Salary: ");
					empSalary = scan.nextDouble();
					System.out.println("Enter Experience: ");
					empExperience = scan.nextInt();
					
			eservice.addEmployee(new Employee(empId,empName,age,empDesignation,empSalary,empExperience));
			System.out.println(" ");
				}
			List<Employee> elist = eservice.showAllEmployees();
			
			for(Employee e: elist)
			{
				System.out.println("=================================="+"\n"+ "Employee ID: " + e.getEmpid() + "\n" + "Employee Name: " + e.getEmpname() + "\n" + "Employee Age: " + e.getAge() + "\n" + "Employee Designation: " + e.getDesignation() + "\n" + "Employee Salary: " + e.getSalary() + "\n" + "Employee Experience: " + e.getEmpexperience()+ "\n==================================");
			}
			System.out.println("\n Employee Added Succesfully");
				 System.out.println("------------------------------------------------------------------------------------------------------");
				break;
				
			//View Employee by id
			case 2:
				System.out.println("Enter Employee ID to view details of respective employee =>>> ");
				int viewid=sc.nextInt();
				boolean found2=false;
				List<Employee> elist4 = eservice.showAllEmployees();
				for(Employee e:elist4) {
					if(e.getEmpid()==viewid) {
				try {
				Employee temp=eservice.findEmployee(new Employee (viewid, null, 0, null , 0, 0));
				System.out.println("\n------------------------------------------------------------------------------------------------------");
				System.out.println("Employee ID: " +temp.getEmpid()+ "\n" + "Employee Name: " + temp.getEmpname() + "\n" + "Employee Age: " + temp.getAge() + "\n" + "Employee Designation: " + temp.getDesignation()+ "\n"
				+ "Employee Salary: " + temp.getSalary()+ "\n" + "Employee Experience: " + temp.getEmpexperience());
			         } 
				catch (EmployeeNotFoundException e1) {
				
				          e1.printStackTrace();
			         }
				found2=true;
					}
				}
				if(!found2) {
					System.out.println("\n------------------------------------------------------------------------------------------------------");
					System.out.println("Employee with this ID is not present, kindly recheck your Employee-ID...");
				}
				 System.out.println("------------------------------------------------------------------------------------------------------");
				break;
				
			//Update Employee Details
			case 3:
				System.out.println("Enter ID of an Employee whose details needed to be updated =>>> ");
				int idup=sc.nextInt();
				boolean found1=false;
				List<Employee> elist3 = eservice.showAllEmployees();
				for(Employee e:elist3) {
					if(e.getEmpid()==idup) {

				System.out.println("Enter new name for Employee of ID " + idup + ": ");
				String newname=sc.next();
				System.out.println("Enter new age for Employee of ID " + idup + ": ");
				int newage=sc.nextInt();
				System.out.println("Enter new designation for Employee of ID " + idup + ": ");
				String newdesignation=sc.next();
				System.out.println("Enter new Salary for Employee of ID " + idup + ": ");
				double newsal=sc.nextDouble();
				System.out.println("Enter new Experience for Employee of ID " + idup + ": ");
				int newexp=sc.nextInt();
				
				eservice.updateEmployee(new Employee (idup, newname, newage, newdesignation,newsal,newexp));
				
				System.out.println("------------------------------------------------------------------------------------------------------");
				found1=true;
					}
				}
				if(!found1) {
					System.out.println("\n=======================================================================================================");
					System.out.println("Employee with this ID is not present, kindly recheck your Employee-ID...\n");
			
				}
				else {
					System.out.println("\n=======================================================================================================");
					System.out.println("Employee details updated successfully !!\n");
					
				}
				break;
				
			//Delete Employee Details
			case 4:
				System.out.println("Enter Employee Id to delete Employee record permanently =>>> ");
				int delId=sc.nextInt();
				boolean found=false;
				Employee empdelete=null;
				List<Employee> elist2 = eservice.showAllEmployees();
				for(Employee e:elist2) {
					if(e.getEmpid()==delId) {
						empdelete=e;
						found=true;
					}
				}
				if(!found) {
					System.out.println("\n=======================================================================================================");
					System.out.println("Employee with this ID is not present, kindly recheck your Employee-ID...");

				}
				else {
					eservice.deleteEmployee(delId);
					System.out.println("\n=======================================================================================================");
					System.out.println("Employee deleted successfully!!\n");

				}
			
				 System.out.println("------------------------------------------------------------------------------------------------------");
				break;
				
			//View All Employees
			case 5:
				System.out.println("All Employees List : \n");
				
				List<Employee> elist1 = eservice.showAllEmployees();
				for(Employee e: elist1)
				{
					System.out.println("=================================="+"\n"+ "Employee ID: " + e.getEmpid() + "\n" + "Employee Name: " + e.getEmpname() + "\n" + "Employee Age: " + e.getAge() + "\n"
				+ "Employee Designation: " + e.getDesignation() +"\n"+ "Employee Salary: " + e.getSalary() + "\n" + "Employee Experience: " + e.getEmpexperience() +"\n==================================");
				}
				 System.out.println("------------------------------------------------------------------------------------------------------");
				break;
				
				
				
		    //Salary Details
			case 6:
				System.out.println("Enter Employee Details: \n");
				System.out.println("Enter Employee Id:");
				int empId1 = sc.nextInt();
				boolean found3=false;
				List<Employee> elist5 = eservice.showAllEmployees();
				for(Employee e:elist5) {
					if(e.getEmpid()==empId1) {
				System.out.println("Enter name: ");
				String empName1 = sc.next();
				System.out.println("Enter Employee Age: ");
				int age1=sc.nextInt();
				System.out.println("Enter Desiganation: ");
				String empDesignation1 = sc.next();
				System.out.println("Enter Salary: ");
				double empSalary1 = sc.nextDouble();
				System.out.println("Enter Experience: ");
				int empExperience1 = sc.nextInt();
				SalaryCalculator calc = new SalaryCalculator();
				calc.calculateNetSalary(new Employee(empId1, empName1, age1, empDesignation1, empSalary1, empExperience1), empSalary1);
				found3=true;
					}
				}
				if(!found3) {
					System.out.println("\n------------------------------------------------------------------------------------------------------");
					System.out.println("Employee with this ID is not present, kindly recheck your Employee-ID...\n");
				}
				 System.out.println("------------------------------------------------------------------------------------------------------");
				break;
			//Exit Message	
			case 7:
				System.out.println("\n=======================================================================================================");
				System.out.println("Thank you for using Employee Management application  - Heptagon technologies!!");
				System.out.println("=======================================================================================================");
				System.exit(0);
				
				
			default:
				System.out.println("\n=======================================================================================================");
				System.out.println("Please enter a valid choice");
				System.out.println("=======================================================================================================\n");
				break;
			}
			
		}
		
	while(order);
		}
		
		else{
            System.out.println("Username or Password Mismatch, Please Try again !!" + "\n"+ "Want to register? , Contact Support for further assistance, THANK YOU !");
            flag=true;
		}
    
        }
	}
	
}

