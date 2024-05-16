package OOP;

import java.util.Scanner;
public class mainStudent {

	public static void main(String[] args) {

	//declare a new object (MUST BE CHILD OF PARENT CLASS)
	Marks mark = new Marks();

	//Method call
	mark.setMarks();
	mark.getMarks();
	}
}

//Adding a 'parent' class or base class named 'Student'
//It contains the data: roll_no and name

class Student {
	public int roll_no;
	public String name;
	
	public static void Sget() {
		
	}
	
	public static void Sdisp() {
			
	}
}


//Adding a class that extends 'Student' class (child of Student class) named 'Marks'
class Marks extends Student {
	//For Inputs
	Scanner input = new Scanner(System.in);	
	
	//For the Variables m1,m2,m3,percentage and total
	public int m1,m2,m3;
	public int percentage;
	public int total;
	
	//Method to set values 
	public void setMarks() {
		System.out.print("Enter Roll Number:");
		roll_no = input.nextInt();
		
		System.out.print("Enter Student Name:");
		name = input.next();
		
		System.out.print("Enter m1:");
		m1 = input.nextInt();
		
		System.out.print("Enter m2:");
		m2 = input.nextInt();
		
		System.out.print("Enter m3:");
		m3 = input.nextInt();
		
		System.out.print("Enter total: ");
		total = input.nextInt();
		
		System.out.print("Enter percentage: ");
		percentage = input.nextInt();
		
	}
	
	//display what has been inputed
	public void getMarks() {
		System.out.println("\nRoll no: "+ roll_no);
		System.out.println("Name: "+ name);
		System.out.println("m1: "+ m1);
		System.out.println("m2: "+ m2);
		System.out.println("m2: "+ m3);
		System.out.println("Total: "+ total);
		System.out.println("Percentage: "+ percentage);
	}
	
}

