package Business;

import Model.Employee;

public class SalaryCalculator {
	public double getGrossSalary(Employee e, double actualSalary) {
		double grossSalary=0.00;
		double perDaySalary = (actualSalary/30);
		grossSalary= perDaySalary*30; // can give number of attended days by initializing variable as no of attended days
		return grossSalary;
		
	}
	
	public void calculateNetSalary(Employee e, double actualSalary) {
		double grossSalary = getGrossSalary(e, actualSalary);
		double incomeTax=1000;
		double pf=800;
		double gratuity=100;
		double netSalary = grossSalary - (incomeTax + pf + gratuity);
		System.out.println("\n==========================================");
		System.out.println("==========================================");
		System.out.println("Employee Salary Details");
		System.out.println("Empid : " + e.getEmpid());
		System.out.println("Empname : " + e.getEmpname());
		System.out.println("Designation : " + e.getDesignation());
		System.out.println("PF, Income tax and Gratuity : " + 800+","+ 1000 +" and " + 100);
		System.out.println("Deductions : " + (pf+ incomeTax + gratuity));
		System.out.println("Gross Salary : " + grossSalary);
		System.out.println("Net Salary : " + netSalary);
		System.out.println("==========================================");
		System.out.println("==========================================");
		
	}

}
