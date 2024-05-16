package Program;

//Mente, Trina Alyssa R.
import java.util.Scanner;
public class FinalProject {
	public static void main (String[]args) 
	{
		Scanner input = new Scanner (System.in);
		
	//method call for the Design
		Design();
	}
	
	public static void Design()
	{
		Scanner input = new Scanner (System.in);
		
		System.out.print("****************************************************"
				+ "************************************************************"
				+ "***********\n\t\t\t\t\tSalary of a Part-Time Professor per Month\n"
				+ "************************************************************"
				+ "*****************************************************************\n");
		
	//user-input
		System.out.print("Specify the month(in numbers): ");
		int month=input.nextInt();
		
		System.out.print("How much is your salary per hour?");
		double per_hour=input.nextDouble();
		
		System.out.print("\nArrival Time: \n\tWhat time did you arrive at school?"
				+ "\n\t\thours:");
		double arrive_hour=input.nextDouble();
		
		System.out.print("\t\tminutes:");
		double arrive_minute=input.nextDouble();
		
		System.out.print("Leaving Time: \n\tWhat time did you left school?"
				+ "\n\t\thours:");
		double left_hour=input.nextDouble();
		
		System.out.print("\t\tminutes:");
		double left_minute=input.nextDouble();
		
	//method call for the number of hours at school
		double total_time=hours_at_school(arrive_hour, arrive_minute, left_hour, left_minute);
		System.out.println("You have spent "+total_time+" hours at school");
		
		System.out.print("\nIn a month, \n\tHow many holidays did you encounter?");
		int holiday=input.nextInt();
		
		System.out.print("\tHow many days did you take a half day?");
		int half_day=input.nextInt();
		
		System.out.print("\tHow many times did you not attend school?");
		int absent=input.nextInt();
		
	//method call for the computation of monthly salary
		double salary=Monthly(per_hour, holiday, half_day, absent, total_time, month);
		System.out.print("Your Salary for the Month is " + salary);
		
	System.out.print("\n\nWould you like to know your total salary including the tax and loans?(1. Yes, 2. No)\nEnter your choice: ");	
	int decision=input.nextInt();
	
	if (decision==1)
		System.out.print("\nEnter your tax_rate: ");
		double tax_rate=input.nextDouble();
	
		System.out.print("Enter your loan_rate: ");
		double loan_rate=input.nextDouble();
		
	//method call for the salary breakdown
		System.out.print("\nYour total salary for the Month, including the tax and loans, is " + TotalSalary (salary, tax_rate, loan_rate));
	}
	
	//method to compute the number of hours at school
	public static double hours_at_school(double arrive_hour, double arrive_minute, double left_hour, double left_minute) {
		
		double elapsed_hours=(left_hour+12)-arrive_hour;
		double HoursToMinutes=elapsed_hours*60;
		double elapsed_minutes=(left_minute)-arrive_minute;
		double total_time=(HoursToMinutes+elapsed_minutes)/60;
		return (total_time);
	}
	
	//method to compute the monthly salary
	public static double Monthly(double per_hour1, int holiday1, int half_day1, int absent1, double total_time1, int month1) {
		
		double working_hours = 0;
		double salary = 0;
		
		switch (month1) {
		case 1, 3, 5, 7, 8, 10, 12:
			working_hours=total_time1*(31-holiday1-(0.5*half_day1)-absent1);
			salary=per_hour1*working_hours;
			break;
		case 2:
			working_hours=total_time1*(29-holiday1-(0.5*half_day1)-absent1);
			salary=per_hour1*working_hours;
			break;
		case 4, 6, 9, 11:
			working_hours=total_time1*(30-holiday1-(0.5*half_day1)-absent1);
			salary=per_hour1*working_hours;
			break;
		default:
			System.out.print("Invalid Input. Kindly check what you type");
		}
		return salary;
	}
	
	//method for salary breakdown
	public static double TotalSalary(double salary1, double tax_rate1, double loan_rate1) {
		double tax_reduced=salary1*tax_rate1;
		double loan_reduced=salary1*loan_rate1;
		System.out.print("\nAmount of deduction from your salary:\n\tTax: "+tax_reduced+"\n\tLoan: "+loan_reduced);
		
		double TotalSalary=salary1-(tax_reduced+loan_reduced);
		return (TotalSalary);
	}
}