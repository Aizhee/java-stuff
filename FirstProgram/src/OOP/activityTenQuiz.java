package OOP;

import java.util.Scanner;
//String manipulation and comparison using equalsIgnoreCase()
//String Class methods
public class activityTenQuiz {
	//Main Method 
	public static void main(String[] args) {
		Quiz myQuiz = new Quiz();
	}

}

class Quiz {
	//Default Constructor
	Quiz(){
		System.out.println("--Quiz Time--");
		System.out.println("Lets test your knowledge:\n");
		System.out.println("\nYou Scored:"+check(inputUser())+"/10");
	}
	
	//Method to check the answers
	public int check(String[] Inp) {
		int correct = 0;
		String[] answerArr = {
				"Manila",
	            "Tokyo",
	            "Seoul",
	            "Beijing",
	            "Bangkok",
	            "Sun",
	            "Anime",
	            "USA",
	            "Paris",
	            "Apollo",
	    };
		
		for (int x=0;x<Inp.length;x++) {
			//Using trim() to remove any whitespace
			//Using equalsIgnoreCase() to ignore case
			//If the user input is equal to the answer ignoring the case, increment the correct variable by 1
			if((Inp[x].trim()).equalsIgnoreCase(answerArr[x])) 
				correct += 1;
		}
		//Return the number of correct answers 
		return correct;
	}
	
	//Method to get the user input
	public String[] inputUser() {
		Scanner input = new Scanner(System.in);
		
		String[] questionArr = {
				"1. What is the capital of the Philippines? ",
	            "2. What is the capital of Japan? ",
	            "3. What is the capital of South Korea? ",
	            "4. What is the capital of China? ",
	            "5. What is the capital of Thailand? ",
	            "6. What is the closest Star ",
	            "7. A famous Artstyle in Japan ",
	            "8. Where is Volleyball Originated? ",
	            "9. Where in France is the Eiffel Tower Located? ",
	            "10. What mission was the first moon-landing? ",
	    };
		
		//Array to store the user input
		String[] Inp = new String[10];
		
		for (int x=0;x<questionArr.length;x++) {
			System.out.print(questionArr[x]);
			//Get the user input and store it in the array
			Inp[x] = input.next();
		}
		//Return the user input array 
		return Inp;
	}
	
	
}

