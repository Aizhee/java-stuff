package Program;
import java.util.Scanner;
public class Excersise_Schedule_Generator {
	//JAMILANO, Aizhar T.
	//BSCpE II-GF
	
	/*
	 *  MAIN METHOD
	 */
	public static void main(String[] args) {
		char endindCommand;
		//Main do-while
		do {
			//Output the Headers
			outputHeaders();
			
			//Get Values for rating abilities and time to start schedule using the user's inputs
			int[] numberofExercises = inputRatingVariables();
			int[] time = inputTimeVariables();
			
			//Generate Exercise suggestions do-while
			do {
				//Main Exercise suggestions Generator
				generateExerciseSuggestions(numberofExercises, time);
				
				// Ending request
				System.out.print("\nEnter g to regenerate another excersise schedule suggestion, x to exit the program, or r to rerun the program: ");
				endindCommand = scannerValidationChar();
				
			} while (endindCommand =='g');
			
		} while (endindCommand == 'r');
		
		//Ending statement
		outputLine('=');
		System.out.println("\nThankyou for choosing Exercise Schedule Generator! \r\n"
				+ "Remember, \"The journey of a thousand miles begins with a single step.\" - Lao Tzu");
	}
	
	
	/*
	 * METHODS
	 */
	
	// FOR OUTPUTING THE LOGO, HEADER, & INSTRUCTIONS
	public static void outputHeaders() {
		Scanner input = new Scanner(System.in);
		outputLine('=');
		System.out.println("    ______                    _              _____      __             __      __        \n   / ____/  _____  __________(_)_______     / ___/_____/ /_  ___  ____/ /_  __/ /__      \n  / __/ | |/_/ _ \\/ ___/ ___/ / ___/ _ \\    \\__ \\/ ___/ __ \\/ _ \\/ __  / / / / / _ \\     \n / /____>  </  __/ /  / /__/ (__  )  __/   ___/ / /__/ / / /  __/ /_/ / /_/ / /  __/     \n/_____/_/|_|\\___/_/   \\___/_/____/\\___/   /____/\\___/_/ /_/\\___/\\__,_/\\__,_/_/\\___/      \n  / ____/__  ____  ___  _________ _/ /_____  _____                                       \n / / __/ _ \\/ __ \\/ _ \\/ ___/ __ `/ __/ __ \\/ ___/                                       \n/ /_/ /  __/ / / /  __/ /  / /_/ / /_/ /_/ / /                                           \n\\____/\\___/_/ /_/\\___/_/   \\__,_/\\__/\\____/_/                                            \n                                                                                         ");
		System.out.println("============================= Exercise Schedule Generator =============================");
		System.out.println("\nThe \"Exercise Schedule Generator\" is a Java program crafting personalized \ndaily workout routines for elderly individuals, covering stretching, walking, yoga,\nand light aerobics with random durations from 10 to 30 minutes. It enhances \nsenior health, mobility, and well-being through tailored exercises, fostering engagement \nin regular physical activity.\n\nPress Enter to continue... ");
		input.nextLine();
		System.out.println("Great! now lets first check your abilities(rate from 1-10)\n");
	}
	
	// FOR INPUTING RATING OF THE ABILITIES OF THE USER
	public static int[] inputRatingVariables() {
		int[] numberofExercises = new int[4];// each slot representing the type of exercise
		
		//multiplied to 0.3 to make sure there is a maximum of 3 exercises per type
		System.out.print("Rate your Endurance: ");
		numberofExercises[0] = (int)(scannerValidationInt(1,10)*0.3);
		System.out.print("Rate your Strength: ");
		numberofExercises[1] = (int)(scannerValidationInt(1,10)*0.3);
		System.out.print("Rate your Balance: ");
		numberofExercises[2] = (int)(scannerValidationInt(1,10)*0.3);
		System.out.print("Rate your Flexibility: ");
		numberofExercises[3] = (int)(scannerValidationInt(1,10)*0.3);
		
		System.out.print("\n");
		outputLine('=');
		
		
		return numberofExercises;
	}
	
	
	// FOR INPUTTING THE START TIME OF THE SCHEDULE SUGGESTION
	public static int[] inputTimeVariables() {
		int[] time = new int[2];
		
		System.out.println("\nWhat time would you be starting your routine?(24-hour format) ");
		System.out.print("  ►Hour: ");
		time[0] = scannerValidationInt(0,24);
		System.out.print("  ►Minute: ");
		time[1] = scannerValidationInt(0,59);
		System.out.print("\n");
		outputLine('=');
      
		return time;
	}
	
	// MAIN GENERATION OF EXERCISE SCHEDULE SUGGESTIONS
	public static void generateExerciseSuggestions(int[] numberofExercises, int[] time) {
		int hour_start = time[0];
		int minute_start = time[1];
		
		//sum the total exercises
		int totalExcercises = 0;
       for (int var = 0; var<4; var++) {
       	totalExcercises += numberofExercises[var];
       }
		
       /* REFERENCE FOR USING 150 MINUTES TO DIVIDE TIME
        * 	National Institute on Aging: At least 150 minutes of moderate-intensity aerobic activity
        * 		(brisk walking, swimming, cycling) or 75 minutes of vigorous-intensity activity (jogging, running)
        * 		per week, along with muscle-strengthening exercises for all major muscle groups at least 2 days per week.
        * 		( https://www.nia.nih.gov/health/exercise-and-physical-activity )
        *
        * 	World Health Organization: At least 150 minutes of moderate-intensity aerobic activity or 75
        * 		minutes of vigorous-intensity activity per week, plus muscle-strengthening exercises on 2 or
        * 		more non-consecutive days.
        * 		( https://www.who.int/publications-detail-redirect/9789240015128 )
        */
       int minutesPerActivity = (int)(150/totalExcercises);
		
      /* {String Arrays}
       * REFERENCE ON EXERCISES & DEFINITIONS
       * https://www.mayoclinic.org/healthy-lifestyle/fitness/basics/fitness-basics/hlv-20049447
       * https://www.nia.nih.gov/health/exercise-and-physical-activity/four-types-exercise-can-improve-your-health-and-physical
       */
      
       //String array for enduranceExercises
       String[] enduranceExercises = {
				"► Brisk Walking: 						     |\n|\t\t| Aim for a pace where you can hold a conversation but feel slightly |\n|\t\t| breathless.							     |",
				"► Swimming: 							     |\n|\t\t| Gentle laps or water walking in a heated pool.		     |",
				"► Dancing: 							     |\n|\t\t| Put on your favorite tunes and move your body!		     |",
				"► Stationary Bike: 						     |\n|\t\t| Adjust the resistance for a comfortable challenge and pedal.       |",
				"► Gardening: 							     |\n|\t\t| Bending, planting, and weeding can be great cardio exercise with   |\n|\t\t| added outdoor benefits.					     |",
				"► Pilates: 							     |\n|\t\t| Engage in controlled movements to improve flexibility, strength,   |\n|\t\t| and endurance.					             |",
				"► Chair Yoga: 						     |\n|\t\t| Practice yoga while seated, focusing on breathing and gentle       |\n|\t\t| stretches.							     |",
				"► Elliptical Trainer: 					     |\n|\t\t| Use low-impact equipment for a full-body cardiovascular workout.   |",
				"► Cycling: 							     |\n|\t\t| Use a stationary bike or a regular bicycle, ensuring a comfortable |\n|\t\t| pace and terrain.						     |"
			};
		
       //String array for strengthExercises
		String[] strengthExercises = {
				"► Chair Squats (10-12 reps): 					     |\n|\t\t| Stand behind a chair, hold on for support, and slowly lower 	     |\n|\t\t| yourself as if sitting down, hold, then push back up.	             |",
				"► Bicep Curls (10-12 reps per arm): 				     |\n|\t\t| Use light weights (soup cans or water bottles) and curl them 	     |\n|\t\t| towards your shoulders. 					     |",
				"► Wall Push-Ups (5-10 reps): 					     |\n|\t\t| Stand facing a wall at arm's length, lean in and perform push-ups  |\n|\t\t| with knees bent or straight, modify based on your ability.         |",
				"► Lunges (10-12 reps per leg): 				     |\n|\t\t| Step forward with one leg, lower hips like kneeling, push back up  |\n|\t\t| and repeat with the other leg.				     |",
				"► Resistance Bands: 						     |\n|\t\t| Use elastic bands for various exercises like bicep curls, shoulder |   \n|\t\t| presses, customize the resistance  for your strength level.	     |",
				"► Leg Raises (10-12 reps): 					     |\n|\t\t| While seated, straighten and lift one leg at a time, hold briefly, |\n|\t\t| and lower.							     |",
				"► Theraband Exercises: 					     |\n|\t\t| Utilize resistance bands for gentle strength training to improve   |\n|\t\t| muscle tone.							     |"	,
				"► Chair Dips (5-10 reps): 					     |\n|\t\t| Sit on the edge of a chair, grip the edge, slide off, lower 	     |\n|\t\t| yourself, and push back up.					     |",
				"► Ankle Flexes (10-12 reps per foot): 			     |\n|\t\t| While seated, lift one foot off the ground and flex the ankle up   |\n|\t\t| and down.							     |",
				"► Knee Extensions (10-12 reps per leg): 			     |\n|\t\t| Sit upright, extend one leg straight out, hold briefly, and lower. |"
			};
		
		//String array for balanceExercises
		String[] balanceExercises = {
				"► Heel-Toe Walking: 						     |\n|\t\t| Walk slowly, focus on lifting your heel high and touching your     | \n|\t\t| toes to the ground.						     |",
				"► Tree Pose: 							     |\n|\t\t| Stand on one leg, bend the other knee and place your foot on       |\n|\t\t| your inner thigh or calf, hold.				     |",
				"► Tandem Walking: 						     |\n|\t\t| Place one foot directly in front of the other and walk slowly,     |\n|\t\t| focusing on maintaining control.				     |",
				"► Side-to-Side Stepping: 					     |\n|\t\t| Take side steps, placing one foot next to the other, hold your     |\n|\t\t| arms out for balance.						     |",
				"► Tai Chi: 							     |\n|\t\t| This gentle practice combines movement and meditation, improving   |\n|\t\t| balance and coordination. 					     |",
				"► Standing Leg Raises: 					     |\n|\t\t| Lift one leg to the side while holding onto a stable surface for   |\n|\t\t| support.							     |",
				"► One-Leg Stand: 						     |\n|\t\t| Hold onto a chair and lift one foot off the ground, maintaining    |\n|\t\t| balance.							     |",
				"► Circular Arm Swings: 					     |\n|\t\t| Stand tall and swing both arms in circular motions to improve      |\n|\t\t| balance and coordination.					     |",
				"► Step-Ups (5-10 reps per leg): 				     |\n|\t\t| Use a stable step or platform to step up and down with one foot at |\n|\t\t| a time.						             |",
				"► Balance Ball Exercises: 					     |\n|\t\t| Engage in gentle movements while sitting on a balance ball to      |\n|\t\t| improve stability.						     |"
	        };
		
		//String array for flexibilityExercises
		String[] flexibilityExercises = {
				"► Neck Rolls (5 times each direction): 			     |\n|\t\t| Slowly roll your head in a circular motion forward and backward.   |",
				"► Arm Circles (10 times each direction): 			     |\n|\t\t| Make small circles with your arms forward and backward.            |",
				"► Hamstring Stretch: 						     |\n|\t\t| Sit on the floor with legs extended, reach for your toes           |\n|\t\t| (use straps if needed), hold.					     |",
				"► Cat-Cow Pose: 						     |\n|\t\t| Round your back on inhale, arch your back on exhale, repeat.       |",
				"► Chest Stretch: 						     |\n|\t\t| Clasp your hands behind your back and gently pull your shoulders   |\n|\t\t| backwards.							     |",
				"► Seated Forward Bend: 					     |\n|\t\t| Sit on the floor, stretch legs forward, and bend forward at the    |\n|\t\t| hips to reach your toes.					     |",
				"► Shoulder Rolls (10 times each direction): 			     |\n|\t\t| Roll your shoulders forward and backward to release tension.	     |",
				"► Seated Spinal Twist: Sit tall, 				     |\n|\t\t| twist your torso gently to one side, hold, and switch sides.	     |",
				"► Wrist and Ankle Rotations: 					     |\n|\t\t| Rotate wrists and ankles clockwise and counterclockwise to 	     |\n|\t\t| improve joint flexibility.					     |",
				"► Seated Cat-Cow Stretch: 					     |\n|\t\t| Perform the cat-cow stretch while seated in a chair for spinal     |\n|\t\t| mobility.							     |"
			};
		
		/*
	     * {Outputs}
	     */
		
		//Integer Array to store Time
		int[] updatedTime = updateTime(hour_start, minute_start, 0);
		
		//Table Header	
		System.out.println();
		outputLine('=');
		System.out.print("|     Time\t|\t\t\t\tExercises\t\t\t     |\n");
		outputLine('=');
		
		//Endurance Exercise Suggestions
		for (int var1 = 0; var1 < numberofExercises[0]; var1++) {
			if (var1==0) { //To ensure that the first iteration does not add any duration to the start
			
			//Display staring time
			System.out.print("|  "+formatTime(updatedTime[0], updatedTime[1]) + "-");
			//Add the duration of the activity
			updatedTime = updateTime(updatedTime[0], updatedTime[1], minutesPerActivity);
			//Display ending time
			System.out.print(formatTime(updatedTime[0], updatedTime[1]) + "\t| ");
			//Randomly Choose an exercise from index 0-8 of enduranceExercises Array
			System.out.println(enduranceExercises[randomizer(0,8)]);
			outputLine('-');
			
			} else if (var1>=0) { //To ensure that the 2nd iteration and so on add duration to the start
				
			updatedTime = updateTime(updatedTime[0], updatedTime[1], 30); //30 min break
			//Display staring time
			System.out.print("|  "+formatTime(updatedTime[0], updatedTime[1]) + "-");
			//Add the duration of the activity
		    updatedTime = updateTime(updatedTime[0], updatedTime[1], minutesPerActivity);
		    //Display ending time
		    System.out.print(formatTime(updatedTime[0], updatedTime[1]) + "\t| ");
		    //Randomly Choose an exercise from index 0-8 of enduranceExercises Array
		    System.out.println(enduranceExercises[randomizer(0,8)]);
		    outputLine('-');
			}
		}
		
		//Strength Exercise Suggestions
		for (int var2 = 0; var2 < numberofExercises[1]; var2++) {
			//30 min break
			updatedTime = updateTime(updatedTime[0], updatedTime[1], 30);
			//Display staring time
			System.out.print("|  "+formatTime(updatedTime[0], updatedTime[1]) + "-");
			//Add the duration of the activity
		    updatedTime = updateTime(updatedTime[0], updatedTime[1], minutesPerActivity);
		    //Display ending time
		    System.out.print(formatTime(updatedTime[0], updatedTime[1]) + "\t| ");
		    //Randomly Choose an exercise from index 0-9 of strengthExercises Array
		    System.out.println(strengthExercises[randomizer(0,9)]);
		    outputLine('-');
		}
		
		//Balance Exercise Suggestions
		for (int var3 = 0; var3 < numberofExercises[2]; var3++) {
			//30 min break
			updatedTime = updateTime(updatedTime[0], updatedTime[1], 30);
			//Display staring time
			System.out.print("|  "+formatTime(updatedTime[0], updatedTime[1]) + "-");
			//Add the duration of the activity
		    updatedTime = updateTime(updatedTime[0], updatedTime[1], minutesPerActivity);
		    //Display ending time
		    System.out.print(formatTime(updatedTime[0], updatedTime[1]) + "\t| ");
		    //Randomly Choose an exercise from index 0-9 of balanceExercises Array
		    System.out.println(balanceExercises[randomizer(0,9)]);
		    outputLine('-');
		}
		
		//Flexibility Exercise Suggestions
		for (int var4 = 0; var4 < numberofExercises[3]; var4++) {
			//30 min break
			updatedTime = updateTime(updatedTime[0], updatedTime[1], 30);
			//Display staring time
			System.out.print("|  "+formatTime(updatedTime[0], updatedTime[1]) + "-");
			//Add the duration of the activity
		    updatedTime = updateTime(updatedTime[0], updatedTime[1], minutesPerActivity);
		    //Display ending time
		    System.out.print(formatTime(updatedTime[0], updatedTime[1]) + "\t| ");
		    //Randomly Choose an exercise from index 0-9 of flexibilityExercises Array
		    System.out.println(flexibilityExercises[randomizer(0,9)]);
		    outputLine('-');
		}
		//Display disclaimer
		System.out.println("\nDISCLAIMER: Before starting, it's wise to chat with your doctor! This program is a friendly \r\n"
				+ "suggestion, not a strict regime. So listen to your body, take breaks every 10-15 minutes, \r\n"
				+ "and choose exercises that feel good. If you need a boost, consider a pro like a trainer. \r\n"
				+ "Remember, start gentle, keep things safe, and if anything feels off, talk to your doctor. \r\n"
				+ "\r\n"
				+ "Now, let's move and enjoy the journey!");
		
		outputLine('=');
	}
	
	//VALIDATE INPUT TYPE AND VALUES (INTEGER)
	public static int scannerValidationInt(int min, int max) {
       Scanner input = new Scanner(System.in);
       int validInt;
       while (true) {
           if (input.hasNextInt()) {
               validInt = input.nextInt();
               if (validInt <= max && validInt >=min) {
               break; // Break out of the loop if the input is an integer
               } else {
               	System.out.print("Invalid input. Please enter an integer in betweeen " + min +"-"+ max +": ");
               }
           } else {
               System.out.print("Invalid input. Please enter an integer: ");
           }
          }
         return validInt;
   }
	       
	//VALIDATE INPUT TYPE AND VALUES (CHARACTER)
   public static char scannerValidationChar() {
       Scanner input = new Scanner(System.in);
       char validChar;
       while (true) {
           String inputString = input.nextLine();
           if (inputString.length() == 1) {
               char inputChar = inputString.charAt(0);
               if (inputChar == 'x' || inputChar == 'g' || inputChar == 'r') {
               	validChar = inputChar;
                   break; // Break out of the loop if the input is a valid character
               } else {
                   System.out.print("Invalid input. Please enter a valid character 'x', 'g', or 'r': ");
               }
           } else {
               System.out.print("Invalid input. Please enter a single character: ");
           }
         }
           return validChar;
   }
	
	//PRINT HORIZONTAL LINES
	public static void outputLine(char type) {
       for (int i = 0; i < 86; i++) {
           System.out.print(type);
       }
       System.out.println();
   }
	
	//UPDATE TIME METHOD FOR ADDING MINUTES TO STARTING TIME
	public static int[] updateTime(int hours, int minutes, int minutesToAdd) {
	    // Calculate the total minutes by converting hours to minutes and adding the current minutes and additional minutes
	    int totalMinutes = hours * 60 + minutes + minutesToAdd;
	    // Calculate the updated hours by dividing totalMinutes by 60 (minutes in an hour)
	    int updatedHours = totalMinutes / 60;
	    // Calculate the updated minutes by taking the remainder after dividing totalMinutes by 60
	    int updatedMinutes = totalMinutes % 60;
	    // If the updated minutes exceed 60 (an hour), adjust the hours and minutes accordingly
	    if (updatedMinutes >= 60) {
	        updatedHours += updatedMinutes / 60; // Add the extra hours from the excess minutes
	        updatedMinutes %= 60; // Update minutes to stay within the range (0-59)
	    }
	    // Ensure the updated hours remain within a 24-hour format
	    updatedHours %= 24;
	    // Return an array containing the updated hours and minutes
	    return new int[]{updatedHours, updatedMinutes};
	}
  
   //METHOD TO ENSURE CORRECT TIME FORMATTING OF ZEROS (00:00)
   public static String formatTime(int hours, int minutes) {
       return String.format("%d:%02d", hours, minutes);
   }
   			
   //METHOD TO GENERATE RANDOM NUMBERS IN BETWEEN THE MIN AND MAX INPUTS
   public static int randomizer(int min, int max) {
       return (int)(Math.random() * (max - min + 1)) + min;
   }
  
}