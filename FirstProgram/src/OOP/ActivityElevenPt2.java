package OOP;

//import the File class
import java.io.File;
//import the Scanner class
import java.util.Scanner;
//import the PrintWriter class
//PrintWriter class is used to write formatted text to a file
//PrintWriter class is used to write text to a file
import java.io.PrintWriter;

public class ActivityElevenPt2 {
	//Add throws Exception to the main method to handle exceptions for the File objects
	public static void main(String[] args) throws Exception {
			//Create a FileCopier object
			FileCopier copy = new FileCopier();
	}

}

class FileCopier {
	//Constructor
	FileCopier() throws Exception{
		//Create a File object for the directory(folder)
		File file = new File("C:\\Users\\aizhar\\Documents\\JavaAct11");
		//Create an import File object to stuff1.txt
		File fileStart = new File(file, "stuff1.txt");
		//Create an Export File object to stuff2.txt
		File fileEnd = new File(file, "stuff2.txt");
		
		//Check if the file already exists
		if (fileEnd.exists()) {
			System.out.println("File already exist.");
			//Exit the program
			System.exit(0);
		}
		
		//Check if the start file exists, if not, create a new file
		if (!fileStart.exists()) {
			System.out.println("File does not exist or is not found... \n\nCreating own File");
			//Call the makeFile method and pass the fileStart object
			makeFile(fileStart);
			//Call the copyFile method and pass the fileStart and fileEnd objects to copy the file
			copyFile(fileStart, fileEnd);
		} else {
			//If the file exists go to the copyFile method
			//Call the copyFile method and pass the fileStart and fileEnd objects to copy the file
			copyFile(fileStart, fileEnd);
		}
	}
		
		
	//Method to copy the file
	public static void copyFile(File fileStart, File fileEnd) throws Exception {
		//Create a Scanner object to read the fileStart object (the file to be copied)
		Scanner input = new Scanner(fileStart);
		//Create a PrintWriter object to write to the fileEnd object (the file to store the copied file)
		PrintWriter output = new PrintWriter(fileEnd);
		
		//Design
		System.out.println("\n\nCopying");
		for (int x=0; x<10; x++) 
			System.out.print("▐");
		
		//While there is still a line to read from the fileStart object, write it to the fileEnd object
		//hasnext() method returns true if there is another line to read in the file, else it returns false
		while (input.hasNext()) 
			//Write the line in the fileStart to the fileEnd object
			output.println(input.nextLine());
		
		//Close the input and output objects
		input.close();
		output.close();
	}
	//Method to create a file
	public static void makeFile(File fileStart) throws Exception {
		//Create a PrintWriter object to write to the fileStart object
		PrintWriter output = new PrintWriter(fileStart);
		
		//Design and write to the fileStart object
		for (int x=0; x<10; x++) {
			//Write to the fileStart object 10 times
			output.println("==SAMPLE TEXT ONLY==");
			//Design
			System.out.print("▐");
		}
		//Close the output object
		output.close();
	}
}


