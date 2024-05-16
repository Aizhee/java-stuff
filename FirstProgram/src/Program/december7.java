package Program;

import java.util.Scanner;

public class december7 {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int weight, activity_quantity;
		String loop_again;
		
		do {
			
			System.out.print(column_lines("=") + "\n|\t\t\t    Burned Calories Calculator   \t\t\t|\n" + column_lines("=") + "\nThis program calculates the calories burned as you do the select activities\n" + "this program can do (Jumping rope, Walking, House Cleaning, Running,\n" + "Swimming)\n\nType any character to proceed... ");
			input.next();
			System.out.print("\nLet's do this!\r\n" + "Enter your Weight (in pounds): ");
			weight = input.nextInt();
			//Display the table
			System.out.print("\nGreat! now let me know the activities you did today?\n"+ column_lines(".")+"\n.  No.	.\t\tActivities\t\t.\tCalories/Hour/Pound\t.\n"+column_lines(".")+"\n.   1 	.\t\tJumping Rope\t\t.\t\t3.8\t\t.\n.   2	.\t\tWalking\t\t\t.\t\t2.4\t\t.\n.   3	.\t\tHouse Cleaning\t\t.\t\t1.6\t\t.\n.   4	.\t\tRunning\t\t\t.\t\t2.5\t\t.\n.   5	.\t\tSwimming\t\t.\t\t3.8\t\t.\n"+ column_lines(".")+"\n\nHow many activities did you do?: ");
			activity_quantity = input.nextInt();
			//Call main calorie calculator method and display the result string 
			System.out.print(calorie_calculator(activity_quantity,weight));
			//To make sure loop_again input string is is != to y|n 
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
	
	//Method for displaying column lines depending on character input
	public static String column_lines (String Starting_char) {
		String Output = "";
		for (int value=0; value<=80; value++) {
			Output += Starting_char;
		}
		return (Output);
	}
	
	//Main calories burned calculation method
	public static String calorie_calculator (int quantity_of_activities, int weight) {
		Scanner input = new Scanner(System.in);
		int current_input, hours;
		double calories_burned = 0;
		int[] activity_array = new int[quantity_of_activities];
		
		System.out.print("Enter which Activity/s you did: ");
		
		//Store activities input in an array 
		for (int value=0;value<quantity_of_activities;value++) 
			activity_array[value] = input.nextInt();
		//Add space	
		System.out.println();
		
		/*	- check the inside of the array and ask the user the hour they spent depending on the selected activity  
		 * 	- do the computations and add it all together 
		 */
		for (int value=0;value<quantity_of_activities;value++) {
			current_input = activity_array[value];
			
			switch (current_input) {
			case 1:
				System.out.print("Enter the hour/s you did Jumping Rope: ");
				hours = input.nextInt();
				calories_burned += (weight * hours * 3.8);
				break;
			case 2:
				System.out.print("Enter the hour/s you did Walking: ");
				hours = input.nextInt();
				calories_burned +=  (weight * hours * 2.4);
				break;	
			case 3:
				System.out.print("Enter the hour/s you did House Cleaning: ");
				hours = input.nextInt();
				calories_burned += (weight * hours * 1.6);
				break;
			case 4:
				System.out.print("Enter the hour/s you did Running: ");
				hours = input.nextInt();
				calories_burned += (weight * hours * 2.5);
				break;
			case 5:
				System.out.print("Enter the hour/s you did Swimming: ");
				hours = input.nextInt();
				calories_burned += (weight * hours * 3.8);
				break;	
			default:
				System.out.println("Invalid Input. \"" + current_input +"\" does not exist in the table, please refer to the table nextime.");
			}
		}
		//To return the computed values 
		return (column_lines(".")+"\nGreat! You burned "+ calories_burned +" calories in total.");
	}
	
}

