package Program;

import java.util.Scanner;

public class Jamilano_Aizhar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers:");

		int postive_number = 0, negative_number = 0, zero_number = 0;

		for (int x = 1; x <= 10; x++) {
			int number = input.nextInt();

			if (number > 0)
				postive_number++;
			if (number < 0)
				negative_number++;
			if (number == 0)
				zero_number++;

		}

		input.close();
		System.out.print("\nPositive Numbers: " + postive_number + "\n" + "Negative Numbers: " + negative_number + "\n" + "Zero Numbers: " + zero_number);

	}
}
