package OOP;

import java.util.Scanner;

import java.util.Scanner;

public class QuadraticEquationConverter {
    
    public static void main(String[] args) {
        // Step 1: Get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the quadratic equation (ay^2 + bx + cy + d = 0):");
        String userInput = scanner.nextLine().toLowerCase().replaceAll("\\s", "").replace("=0", "");
        scanner.close();
        
        // Step 2: Convert the equation to the standard form
        String standardForm = convertToStandardForm(userInput);
        
        // Display the standard form equation
        System.out.println("Standard form equation: " + standardForm);
    }
    
    public static String convertToStandardForm(String equation) {
        // Check if the equation is well-formed
        if (!equation.matches("^[\\dxy^\\-+=.() ]+$")) {
            return "Invalid input. Please provide a well-formed quadratic equation.";
        }

        // Standard form for parabola equations:
        // (x - h)^2 = 4p(y - k) or (x - h)^2 = -4p(y - k) or (y - k)^2 = 4p(x - h) or (y - k)^2 = -4p(x - h)
        
        // Parse the equation to extract coefficients
        String[] terms = equation.split("(?=\\+|\\-)");
        double a = 0, b = 0, c = 0;

        for (String term : terms) {
            term = term.replaceAll("\\s", "");
            if (term.endsWith("x^2")) {
                a = term.startsWith("-") ? -1 : (term.startsWith("+") ? 1 : Double.parseDouble(term.replace("x^2", "")));
            } else if (term.endsWith("x")) {
                b = term.startsWith("-") ? -1 : (term.startsWith("+") ? 1 : Double.parseDouble(term.replace("x", "")));
            } else if (term.endsWith("y^2")) {
                a = term.startsWith("-") ? -1 : (term.startsWith("+") ? 1 : Double.parseDouble(term.replace("y^2", "")));
            } else if (term.endsWith("y")) {
                c = term.startsWith("-") ? -1 : (term.startsWith("+") ? 1 : Double.parseDouble(term.replace("y", "")));
            } else {
                c = Double.parseDouble(term);
            }
        }

        // Standard form equation variables
        double h = -b / (2 * a);
        double k = -c / (2 * a);
        double p = Math.abs(1 / (4 * a));

        // Construct the standard form equation
        String standardForm;
        if (equation.contains("x")) {
            if (a > 0) {
                standardForm = "(x - " + h + ")^2 = " + (4 * p) + "(y - " + k + ")";
            } else {
                standardForm = "(x - " + h + ")^2 = " + (-4 * p) + "(y - " + k + ")";
            }
        } else {
            if (a > 0) {
                standardForm = "(y - " + k + ")^2 = " + (4 * p) + "(x - " + h + ")";
            } else {
                standardForm = "(y - " + k + ")^2 = " + (-4 * p) + "(x - " + h + ")";
            }
        }

        return standardForm;
    }
}



