//package Controller;
//
//import java.util.Scanner;
//
//import Business.SalaryCalculator;
//import Model.Employee;
//
//public class EmployeeSalaryMain {
//	public static void main(String[] args){
//		Scanner scan=new Scanner(System.in);
//	System.out.println("Enter Employee Details: ");
//	System.out.println("Enter Employee Id:");
//	int empId1 = Integer.parseInt(scan.nextLine());
//	System.out.println("Enter name: ");
//	String empName1 = scan.nextLine();
//	System.out.println("Enter Employee Age: ");
//	int age1=scan.nextInt();
//	System.out.println("Enter Desiganation: ");
//	String empDesignation1 = scan.next();
//	System.out.println("Enter Salary: ");
//	double empSalary1 = scan.nextDouble();
//	System.out.println("Enter Experience: ");
//	int empExperience1 = scan.nextInt();
//	SalaryCalculator calc = new SalaryCalculator();
//	calc.calculateNetSalary(new Employee(empId1, empName1, age1, empDesignation1, empSalary1, empExperience1), empSalary1);
//	}
//}
