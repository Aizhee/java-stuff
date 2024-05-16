package OOP;
//New topic: File class
//File class is used to represent a file or directory in the file system
//File class is used to create, delete, and rename files and directories
//File class is used to get file information
//Import the File class
import java.io.File;


public class ActivityElevenPt1 {
	public static void main(String[] args) {
		//Create a File object
		File file = new File("C:\\Users\\aizhar\\Documents");
		//Display file information
		System.out.println("Does it exist? " + file.exists());
		System.out.println("Can it be read? " + file.canRead());
		System.out.println("Can it be written? " + file.canWrite());
		System.out.println("Is it a directory? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Is it absolute? " + file.isAbsolute());
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("What is its absolute path? " + file.getPath());
		System.out.println("What is its name? " + file.getName());
		//Date class is used to get the date and time information from returned long value
		System.out.println("When was it modified? " + new java.util.Date(file.lastModified()));
		System.out.println("What is its length? " + file.length() + " bytes");
	}
}
