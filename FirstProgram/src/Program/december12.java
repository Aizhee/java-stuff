package Program;

import java.util.Scanner;

public class december12 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String loop_again;
		
		do {
			input_values();
		 
			loop_again = "";
			while (!(loop_again.equals("y")|loop_again.equals("n"))) {
				//Ending statement
				System.out.print("\nDo you wish to start the program again (y/n): ");
				loop_again = input.next();
			}
			
		} while (loop_again.equals("y"));
		input.close();
		System.out.print("\nThank you for using our Program");
	}
	
	//Method for inputing feet and inch
	public static void input_values (){
		int leght_foot,leght_inch;
		
		Scanner input = new Scanner(System.in);
		System.out.print(column_lines("=") + "\n|\t\t\tImperial to Metric Calculator (length)\t\t\t|\n" + column_lines("=") + "\nThis program lets you convert feet and inches to meters and centimeter \n" + "\n\nType any character to proceed... ");
		input.next();
		System.out.print("\nLet's do this!\r\nEnter the Length (feet): ");
		leght_foot = input.nextInt();
		System.out.print("Enter the Length (inches): ");
		leght_inch = input.nextInt();
		converter(leght_foot, leght_inch);
		
	}
	
	//Method for converting
	public static void converter (int feet, int inch) {
		double meter=0,centimeter=0; 
		
		meter=((feet)*0.3048);
		centimeter=(inch*2.54);
		output_method (meter,centimeter,feet,inch);
	}
	
	//Output method
	public static void output_method (double meter, double centimeter,int feet,int inch) {
		//To return the computed values 
		System.out.println(column_lines(".")+"\nThe converted value for "+feet+" ft. "+inch+" in."+" is "+ meter +" meter/s and " + centimeter +" centimeter/s");
	}
	
	//Method for displaying column lines depending on character input
	public static String column_lines (String Starting_char) {
		String Output = "";
			for (int value=0; value<=80; value++) {
				Output += Starting_char;
			}
		return (Output);
	}
}
