package Program;


public class A {
    public static void main(String[] args) {

        final int MIN=10, MAX=20;
		int num = 15;
		//1
		System.out.println("--------------1----------------");
		while (num<MAX)
		{
			System.out.println(num);
			num = num + 1;
		}
		//2
		num = 15;
		System.out.println("--------------2----------------");
		while (num<MAX)
		{
			num = num + 1;
			System.out.println(num);
		}
		//3
		num = 15;
		System.out.println("--------------3----------------");
		do
		{
			num = num+1;
			System.out.println(num);
		}
		while (num<=MAX);
		//4
		System.out.println("--------------4----------------");
		while (num<MAX)
		{
			System.out.println(num);
			num = num-1;
		}
		System.out.println("Error, Boolean Expression will never meet, will loop infinitely & lessen num");
		//5
		num = 15;
		System.out.println("--------------5----------------");
		while (num > MIN)
		{
			System.out.println(num);
			num = num-1;
		}
		//6
		num = 15;
		System.out.println("--------------6----------------");
		while (num < MAX)
		{
			System.out.println(num);
			num += 2;
		}
		//7
		num = 15;
		System.out.println("--------------7----------------");
		while (num < MAX)
		{
			if (num%2==0)
				System.out.println(num);
			num ++;
		}
		//8
		num = 15;
		System.out.println("--------------8---------------");
		do
		{
		  num=num+1;
		  if (num*2>MAX+num)
			System.out.println(num);
		} while (num <= MAX);
						
		//9
		num = 15;
		System.out.println("--------------9----------------");

		for(int value = 0;value>=7;value++) 
			System.out.println(value);
		System.out.println("Skipped bcuz boolean expression never met, 0 is not >= 7");
		//10
		num = 15;
		System.out.println("--------------10---------------");
		for(int value = 7;value<0;value--) 
			System.out.println(value);		
		System.out.println("Skipped bcuz boolean expression never met, 7 is not < 0");
		//11
		num = 15;
		System.out.println("--------------11---------------");
		for(int value = 1;value<=20;value+=4) 
			System.out.println(value);	
		
		//12
		num = 15;
		System.out.println("--------------12---------------");
		for(int value = num;value<=MAX;value++) 
			System.out.println(value);	
		
		//13
		num = 15;
		System.out.println("--------------13---------------");
		
		for(int value = num;value<=MAX;value++) 
			if (value%4 !=0)
				System.out.println(value);			
		//14
		num = 15;
		System.out.println("--------------14---------------");

		for(int count1 = 1;count1<=7;count1++) 
		{
			for (int count2=1;count2<=5;count2++)
				System.out.print('#');	
			System.out.println();
		}
		//15
		num = 15;
		System.out.println("--------------15---------------");

		for(int count1 = 1;count1<=5;count1++) 
		{
			for (int count2=1;count2<=5;count2++)
				System.out.print(count1*count2 + " ");	
			System.out.println();
		
		}
		System.out.println("-------------------------------");
    }
}

