package Program;

import java.util.Scanner;
public class Student {
	public static void main(String[] args)
	{
		
		Student_Records firstTerm = new Student_Records();
		Student_Records secondTerm = new Student_Records();
		Student_Records finalTerm = new Student_Records();
		
		System.out.println("First Term:");
		
		firstTerm.setScore();	
		firstTerm.computeRawScore();
		firstTerm.showGrade();
		
		System.out.println("\n-Second Term:");
		
		secondTerm.setScore();
		secondTerm.computeRawScore();
		secondTerm.showGrade();
		
		System.out.println("\n-Final Term:");
		
		finalTerm.setScore();
		finalTerm.computeRawScore();
		finalTerm.showGrade();

	}
	
}

class Student_Records {
	
	public double rawScore;
	//inputs
	public double performanceScore;
	public double performanceTotal;
	public double recitScore;
	public double recitTotal;
	public double quizzesScore;
	public double quizzesTotal;
	public double examScore;
	public double examTotal;
	
	public void setScore()
	{
		Scanner input = new Scanner(System.in);
		Boolean isValid = true;
		
		do {
			
			System.out.print("Enter your Performance task score: ");
			performanceScore = input.nextDouble();
			System.out.print("Enter the Total Items: ");
			performanceTotal = input.nextDouble();
			System.out.println();
			if (performanceScore>performanceTotal) {
				isValid = false;
				System.out.println("Invalid, Enter again");
			} else {
				isValid = true;
			}
		
		} while (!isValid);
		
		do {
			System.out.print("now, enter your Recitation/Class Participation task score: ");
			recitScore = input.nextDouble();
			System.out.print("Enter the Total Items: ");
			recitTotal = input.nextDouble();
			System.out.println();
			if (recitScore>recitTotal) {
				isValid = false;
				System.out.println("Invalid, Enter again");
			} else {
				isValid = true;
			}
		
		} while (!isValid);
		
		do {
			System.out.print("now, enter your Quizzes score: ");
			quizzesScore = input.nextDouble();
			System.out.print("Enter the Total Items: ");
			quizzesTotal = input.nextDouble();
			System.out.println();
			
			if (quizzesScore>quizzesTotal) {
				isValid = false;
				System.out.println("Invalid, Enter again");
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		
		do {
			System.out.print("now, enter your Exam score: ");
			examScore = input.nextDouble();
			System.out.print("Enter the Total Items: ");
			examTotal = input.nextDouble();
			System.out.println();
			if (examScore>examTotal) {
				isValid = false;
				System.out.println("Invalid, Enter again");
			} else {
				isValid = true;
			}
			
		} while (!isValid);
	}

	
	public double computeRawScore() {
		return rawScore = (((performanceScore / performanceTotal)*100)*.4) + (((recitScore / recitTotal)*100)*.15) + (((quizzesScore / quizzesTotal)*100)*.15)+(((examScore / examTotal)*100)*.3);
	}
	
	public double computeTermGrade() {
		return rawScore*0.625+37.5;
	}

	public void showGrade() {
		System.out.println("Your grades for this term is: "+ computeTermGrade());
		if (computeTermGrade() < 75) {
			System.out.println("you failed this term.");
		} else {
			System.out.println("you passed this term.");
		}
	}
	
}
