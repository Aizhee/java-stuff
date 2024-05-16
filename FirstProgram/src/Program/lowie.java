package Program;
import java .util.Scanner;

public class lowie {

		public static void main(String[]args ) {
			
			Scanner input=new Scanner(System.in);
			
			for(int line=0;line<=100;line++)
				System.out.print("__");
			
			System.out.println();
			System.out.println("                              Physical Activity Burns Calories");
			
			for(int line=0;line<=50;line++)
				System.out.print("---");
				System.out.println();
				System.out.println("                                 ------               ------");
				System.out.println("                                |A. YES|             |B. NO |");
				System.out.println("                                 ------               ------");
			    System.out.print("Do you wish to be fit and healthy???");
			    String choices=input.next();
			    
			    if(choices.equals("A")) {
			    	for(int line=0;line<=100;line++)
			    	System.out.print("--");
			    	System.out.println();
			    	System.out.println(" \t\t\t\t  LET'S GO EXERCISE!!!");
			    
			    for(int line=0;line<=100;line++)
				System.out.print("__");
			    
				System.out.println();
				System.out.println("\t\t  To proceed in calculating the Calories that you will burned\n\t\t\t\t From the activity below.\n\t\t\t\tSome question will be ask.");
						for(int line=0;line<=100;line++)
						System.out.print("--");
						System.out.println();
						System.out.print("What is your recent weight in pound?? ");
						double weight=input.nextDouble();
						for(int line=0;line<=87;line++)
						System.out.print("-");
						System.out.println();
								
						System.out.println("|                   ACTIVITIES            |         CALORIES PER HOUR PER POUND        |");
						System.out.println("|  1.              JUMPING ROPE           |                      3.80                  |");
						System.out.println("|  2.                WALKING              |                      2.40                  |");
						System.out.println("|  3.             HOUSE CLEANING          |                      1.60                  |");
						System.out.println("|  4.                RUNNING              |                      2.50                  |");
						System.out.println("|  5.                SWIMMING             |                      3.80                  |");
						for(int line=0;line<=87;line++)
						    System.out.print("-");
						System.out.println();
						
						System.out.print("How many hour/s do you want to perform this activity/s?? ");	
						double hours=input.nextInt();
						
						System.out.print("Please state the number/s of activity that you want to do: ");	
						int number_act=input.nextInt();
						switch(number_act)
						{
						case 1:
							System.out.println("Take it easy.");
							break;
						case 2:
							System.out.println("Let`s go and be fitted.");
							break;
						case 3:
							System.out.println("You are so determined.");
							break;

						case 4:
							System.out.println("WOW!! You are great.");
							break;

						case 5:
							System.out.println("OH MY GOD!! I feel your aura of being Physically fit.");
							break;
							default:
								System.out.println("OOOWWWW You dont need to rush everything.");

								
						}
						
						for(int line=0;line<=87;line++)
						System.out.print("-");
						
						System.out.println();
	                    
						System.out.println("YEHEY!!!!");
						System.out.println("With the proper diet and maintaining your healthy body\nIn this activity/s you will burned a total of "+actvalue(number_act, weight, hours)+"calories.");
						System.out.println("In the activity/s within a "+hours+"hour/s.");
						System.out.println("CONGRATULATIONS!!!!!!");
						System.out.println("Do you wish to calculate and burned more calories(1.YES / 2.NO)??");
			            int wish=input.nextInt();
	                    }}


			    	public static double actvalue(int number_act, double weight, double hours)
			    	{
			    		Scanner input=new Scanner(System.in);
			    		double sum = 0;
			    		System.out.println("In the above activity/s what activity do you want to perform/s??");
	                    for(int act=1;act<=number_act;act++)
	                    {
	                       	System.out.print("Activity "+(act)+":");
	                    	int choice=input.nextInt();
	                    	
	                    if(choice==1)
	                    {
	                    	sum += (weight*hours*3.8);
	                    }
	                    if(choice==2)
	                    {
	                    	sum += (weight*hours*3.8);
	                    }
	                    if(choice==3)
	                    {
	                    	sum += (weight*hours*3.8);
	                    }
			    	
	                    if(choice==4)
	                    {
	                    	sum += (weight*hours*3.8);
	                    }
	                    if(choice==5)
	                    {
	                    	sum += (weight*hours*3.8);
	                    }
	                    }
	                    return(sum);
			    	}
			    
}
