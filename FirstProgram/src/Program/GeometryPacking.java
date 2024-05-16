package Program;

import java.util.Scanner;

class GeometryPacking {

	public static void main(String[] args) {
		/*
		 * JAMILANO JUACALLA LIWANAG
		 */

		
		boolean hi = false;
		Scanner input = new Scanner(System.in);
		// Constant PI w/o using Math.PI
		double circlepie = 3.141592653589793238462643383279502884197;

		// Area variables
		int area_l = 0, area_m = 0, area_s = 0;

		// Area Converted into String
		String stype_l = "", stype_m = "", stype_s = "";

		// Confirmation string to exit the program
		String confirm;

		// Number of shapes able to pack inside the outer shape
		int numb_m = 0, numb_s = 0;

		// JAMILANO
		do {
			// Logo, Header, Instructions, and Selections
			System.out.println("\n================================================");
			System.out.println(" __    ____  ___   _      ____ _____  ___   _\n/ /`_ | |_  / / \\ | |\\/| | |_   | |  | |_) \\ \\_/\n\\_\\_/ |_|__ \\_\\_/ |_|  | |_|__  |_|  |_| \\  |_|\n ___    __    __    _     _   _      __\n| |_)  / /\\  / /`  | |_/ | | | |\\ | / /`_\n|_|   /_/--\\ \\_\\_, |_| \\ |_| |_| \\| \\_\\_/\\");
			System.out.println("\n======== GEOMETRY PACKING CALCULATOR ===========");
			System.out.println("\nEver wanted to know how much shapes you can fit is another shape without it overlapping? This \nprogram makes it easy for you to do so. All you have to do is input the type of shape (indicated by the \nnumber on the left-hand side) and its dimensions. This program can calculate the maximum number of \nshapes able to fit in a larger shape, and total area covered by the medium and small shapes. For sake of \nsimplicity, this program can only input up to 3 shapes.\n");
			System.out.println("[1] Square (□) \n[2] Rectangle (▭) \n[3] Circle (○)\n[4] Triangle (△)\n");

			// Loop for asking inputs & calculating the area
			// JUACALLA
			for (int i = 0; i < 3; i++) {
				int area;
				String stype;
				// Output statements
				switch (i) {
				case 0:
					System.out.print("Enter the Largest Shape: ");
					break;
				case 1:
					System.out.print("\nEnter the Medium-sized Shape: ");
					break;
				case 2:
					System.out.print("\nEnter the Small-sized Shape: ");
					break;
				}

				// Input scanner for shape type.
				int shape = input.nextInt();
				// Shape switch case
				// LIWANAG
				switch (shape) {
				case 1:
					stype = "Square";
					System.out.print("Enter the length of one side of the square: ");
					// Square - input one side to find the area
					int Side = input.nextInt();
					area = Side * Side;
					break;
				case 2:
					stype = "Rectangle";
					// Rectangle - input H&W to find the area
					System.out.print("Enter the height length of the rectangle: ");
					int Length = input.nextInt();
					System.out.print("Enter the width length of the rectangle: ");
					int Width = input.nextInt();

					area = Length * Width;
					break;
				case 3:
					stype = "Circle";
					// Circle - input Radius to find the area
					System.out.print("Enter the radius of the circle: ");
					int radius = input.nextInt();

					area = (int) circlepie * radius * radius;
					break;
				case 4:
					stype = "Triangle";
					// Triangle - input B&H to find the area
					System.out.print("Enter the base length of the triangle: ");
					int Base = input.nextInt();
					System.out.print("Enter the height length of the triangle: ");
					int Height = input.nextInt();

					area = (int) (Base * Height) / 2;
					break;
				default:
					System.out.println("Invalid shape type.");
					input.close();
					return;
				}

				// LIWANAG
				// Variable storage.
				if (i == 0) {
					area_l = area;
					stype_l = stype;
				} else if (i == 1) {
					area_m = area;
					stype_m = stype;
				} else if (i == 2) {
					area_s = area;
					stype_s = stype;
				}
			}
			// JUACALLA
			// Logic to find the number of shapes fitting in
			if (area_l != 0 && area_m != 0 && area_s != 0) {
				numb_m = area_l / area_m;
				numb_s = area_m / area_s;

				// JAMILANO
				// Grammar Corrector
				if (numb_m >= 2) {
					stype_m = stype_m + "s";
				}
				if (numb_s >= 2) {
					stype_s = stype_s + "s";
				}

				// Display the result
				// JAMILANO
				System.out.println("\n================================================");
				System.out.println("\nYou can fit " + numb_m + " medium-sized " + stype_m + " in one large " + stype_l + ", of that medium-sized " + stype_m + " you can fit " + numb_s + " small " + stype_s + ".");
				System.out.println("\nThe total number of small " + stype_s + " you can fit in the large " + stype_l + " is " + numb_s * numb_m + " relative to the medium shape.\n");
				System.out.println("The total area occupied by the medium shape " + stype_m + " is " + numb_m * area_m + ".");
				System.out.println("The total area occupied by the smaller shape " + stype_s + " is " + numb_s * area_s + ".");
				System.out.println("\n================================================");

			} else {
				// Error output if shape is invalid.
				System.out.println("Invalid size of shape, please try again");
			}

			// Ending statement
			System.out.println("\nThank you for using our program.\nDo you want to re-run the program and try something else? (y/n)");
			confirm = input.next();
			
		} while (confirm.equals("y"));
	}
}
