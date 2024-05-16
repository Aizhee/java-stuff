package OOP;
import java.util.Scanner;

//NEW TOPIC: ABSTRACTION - Using other previous techniques with added abstract methods and classes to "hide certain details"
//Just like sa overloading/overriding na example pero dinagdagan lang, feel ko ganun din inyo 
//TIP: since tulad lang ng names ung class mo sa previous activity, maganda na idelete or dun ka na mismo sa lumang file mo ikaw mag code para di mag error at minsan na cacall na class ay ung lumang code
public class mainShape {
	public static void main(String[] args) {
		//Title
		System.out.println("==Area & Perimeter Finder==\n");
		
		//Declaration of object from the child through the parent
		//Example: Parent_class myChild_class_object = new Child_class();
		
		//since nag ganto ako i-cacall nito si default constructor "Circle()" , dun mo na ilagay inputs mo  
		Shape myCircle = new Circle();
		//dito na sa println mo mismo i call ung method mo sa output since may return ka naman na values pagka compute
		System.out.println("┖ Area: "+ myCircle.calculateArea());
		System.out.println("┖ Perimeter: "+ myCircle.calculatePerimeter());
		//make sure na di magkasunod ung declarations mo ng object if gumamit ka ng constructor otherwise i-skip nya ung output ng println mo   
		Shape myTriangle = new Triangle();
		System.out.println("┖ Area: "+ myTriangle.calculateArea());
		System.out.println("┖ Perimeter: "+ myTriangle.calculatePerimeter());
	
	}
}

//Abstract Parent (non-accessible ang parent class na abstract, so tatawagin mo lang ay child nya )
abstract class Shape {	
	//Abstract Methods NOTE: Walang laman ang abstract methods just declaration sa parent class a.k.a walang curly brace "{}"
	//Methods to ah, mukha lang variable declaration 
	abstract double calculateArea();
	abstract double calculatePerimeter();
}

//Regular Child class for Circle
class Circle extends Shape {
	
	//Naka private so secured 
	private double radius;
	
	//Default Constructor for Circle Class (dito mo ilagay inputs mo)
	Circle() {
	Scanner input = new Scanner(System.in);		
	System.out.println("⃝-==Circle==-⃝");
	System.out.print("Enter Radius: ");
	radius = input.nextDouble();	
	}
	
	//Dito mo ilagay methods mo (like last activity dito lang nakalagay ung operations, dapat may return, and dapat tulad lang sila ng type sa parent class mo na method)
	//In this case ung calculateArea() and calculatePerimeter() method ko sa parent class "Shapes" ay return method na double so dapat same same lang din as said sa overloading/overriding rules.
	public double calculateArea() {
		return Math.PI*(radius*radius);
	}
	
	//Dito mo ilagay methods mo (like last activity dito lang nakalagay ung operations, dapat may return, and dapat tulad lang sila ng type sa parent class mo na method)
	public double calculatePerimeter() {
		return 2*Math.PI*radius;
	}
}

//Regular Child class for Triangle
class Triangle extends Shape {
	
	//Naka private so secured 
	private double S;
	private double[] side = new double[3];
	
	//Default Constructor (dito mo ilagay inputs mo)
	Triangle() {
		
	Scanner input = new Scanner(System.in);		
	System.out.println("\n∆-==Triangle==-∆");
	System.out.print("Enter the 3 sides of the Triangle consecutively:");

	for (int x=0; x<3;x++) 
		side[x]= input.nextDouble();
	
	}
	
	public double calculateArea() {
		S = (side[0]+side[1]+side[2])/2;
		return S*(S-side[0])*(S-side[1])*(S-side[2]);
	}
	
	public double calculatePerimeter() {
		return side[0]+side[1]+side[2];
	}
}