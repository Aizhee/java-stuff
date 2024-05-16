package rootCalculatorTrial;

import javax.swing.JOptionPane;

/* RACN-R: A Root Approximation Calculator 
* using The Newton-Raphson Method for Simple 
* Polynomials with Single or Multiple Roots.
*/

public class RootCalculator {
	// Aizhar Jamilano
	// BSCpE - GF
	
	// Main method	
	public static void main(String[] args) {
	// start the program
       run();
    }

    // Run method to handle the main logic
    public static void run() {
    	showTitlePage();
    	NewtonRaphsonSolver newtonRaphsonSolver = new NewtonRaphsonSolver();
        String expression = input("Enter the equation (e.g., x*x - 4):");
        if (expression == null) {
            // User clicked Cancel
        	System.exit(0);
            return;
        }
        // Parse the expression to see if the user entered a valid expression
        Derivative expr = DerivativeParser.parseExpression(expression, new Variable("x"));
		if (expr == null) {
			error("Invalid expression.");
			return;
		}
		
        boolean proceed = confirm("You Entered: " + expr + "\nProceed?");
        // If the user confirms, ask for the initial guess and tolerance
        if (proceed) {
        	// Check if the expression contains '^ and a digit'
    		if (expr.toString().contains("^")) {
    		    // If the expression contains '^ and a digit', it is not a simple polynomial
    			String multipleRoots = inputWithButtons("Your Expression contains multiple roots! \nYou can choose to use the modified Newton-Raphson Method for better accuracy.", new String[] {"Use Regular", "Use Modified"});
				if (multipleRoots == null) {
					// User clicked Cancel
					System.exit(0);
					return;
				} else if (multipleRoots.equals("Use Modified")) {
					useModified(newtonRaphsonSolver, expression);
				} else {
					useRegular(newtonRaphsonSolver, expression);
				}
    		} else {
        	useRegular(newtonRaphsonSolver, expression);
    		}
		} else {
			// If the user does not confirm, try again
			run();
		}
    }

    //RegularRoot method to solve the root of a function using Newton-Raphson method
	public static void useRegular(Object newtonRaphsonSolver, String expression) {
		String intialGuess = input("Enter initial guess (e.g. 4, 6 ,3):");
		if (intialGuess == null) {
			// User clicked Cancel
			System.exit(0);
			return;
		}
		
		try {
		    Integer.parseInt(intialGuess);
		} catch (NumberFormatException e) {
		    // User input cannot be parsed as an integer
		    error("Initial guess must be a number.");
		    useRegular(newtonRaphsonSolver,expression);
		    return;
		}

		Float x0 = Float.parseFloat(intialGuess);
		double tolerance;
		
		while (true) {
		    try {
		        tolerance = Double.parseDouble(input("Enter the tolerance (e.g. 0.0001):"));
		        if (tolerance == 0) {
		            error("Tolerance cannot be zero.");
		            // Continue the loop to prompt the user again
		            continue;
		        }
		        // Break the loop if a valid tolerance is provided
		        break;
		    } catch (NumberFormatException e) {
		        // User input cannot be parsed as a double
		        error("Tolerance must be a number.");
		        continue;
		       
		    } 
		  
		}


		if (tolerance == 0) {
		        error("Tolerance cannot be zero.");
		        return;
		}
	    
		String table = ((NewtonRaphsonSolver) newtonRaphsonSolver).solveRegularRoot(expression, x0, tolerance);
		message(table);
	}
	
	//ModifiedRoot method to solve the root of a function using modified Newton-Raphson method
	public static void useModified(Object newtonRaphsonSolver, String expression) {
		String intialGuess = input("Enter initial guess (e.g. 4, 6 ,3):");
		if (intialGuess == null) {
			// User clicked Cancel
			System.exit(0);
			return;
		}
		try {
		    Integer.parseInt(intialGuess);
		} catch (NumberFormatException e) {
		    // User input cannot be parsed as an integer
		    error("Initial guess must be a number.");
		    useModified(newtonRaphsonSolver,expression);
		    return;
		}

		Float x0 = Float.parseFloat(intialGuess);
		double tolerance;
		try {
		    tolerance = Double.parseDouble(input("Enter the tolerance (e.g. 0.0001):"));
		    
		} catch (NumberFormatException e) {
		    // User input cannot be parsed as a double
		    error("Tolerance must be a number.");
		    useModified(newtonRaphsonSolver, expression);
		    return;
		}

		if (tolerance == 0) {
		        error("Tolerance cannot be zero.");
		        return;
		}
		
		String table = ((NewtonRaphsonSolver) newtonRaphsonSolver).solveModifiedRoot(expression, x0, tolerance);
		message(table);
	}
	// UI methods
	public static void showTitlePage() {
        String title = "A Root Approximation Calculator\nusing The Newton-Raphson Method for Simple\nPolynomials with Single or Multiple Roots.";
        JOptionPane.showMessageDialog(null, title, "Welcome to RACN-R!", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void message(String message) {
		 String[] options = {"Use Again", "Close"};
	        int choice = JOptionPane.showOptionDialog(null, message, "RACN-R | Results", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        if (choice == 0) {
	            run();
	        } else if (choice == 1) {
	            System.exit(0);
	        }
    }

	public static void error(String message) {
		JOptionPane.showMessageDialog(null, "Error: " + message, "RACN-R | Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean confirm(String message) {
        int choice = JOptionPane.showConfirmDialog(null, message, "RACN-R | Confirmation", JOptionPane.OK_CANCEL_OPTION);
        return (choice == JOptionPane.OK_OPTION);
    }
	
	public static String input(String message) {
		String input = JOptionPane.showInputDialog(null,  message,"RACN-R | Input", JOptionPane.QUESTION_MESSAGE);
		if (input == null) {
			// User clicked Cancel
			System.exit(0);
		} else if (input.isEmpty()) {
			error("Input cannot be empty.");
			return input(message);
		}
	    return input;
	}
	
	public static String inputWithButtons(String message, String[] options) {
        return (String) JOptionPane.showInputDialog(null, message, "RACN-R | Input", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
	

}
