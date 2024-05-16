package rootCalculatorPackage;

public class NewtonRaphsonSolver extends RootCalculator {
    // solveRegularRoot method to solve the root of a function using Newton-Raphson method
	// It calculates the approximate relative error (Et) for each iteration
	// The method returns a table showing the iteration number, the value of xi, and the approximate relative error (Et)
	// The method takes the expression, initial guess (x0), and tolerance as parameters
	public String solveRegularRoot(String expression, float x0, double tolerance) {
	    // Set the maximum number of iterations
		int maxIterations = 20;
	    // Create a StringBuilder to store the table
		
	    StringBuilder table = new StringBuilder();
	    table.append("Root Table for: ").append(expression).append("\n\n");

	    // Create an instance of the EquationSolver class
	    EquationSolver solve = new EquationSolver();
	    Variable x = new Variable("x");
	    
	    // Parse the expression to get the first derivative
	    Derivative fPrime = DerivativeParser.parseExpression(expression, x).diff("x");
	    // Append the first derivative to the table
	    table.append("1st Derivative:\n").append(fPrime).append("\n=====================\n\n");
	    table.append("i        xi             Et (%) \n");
	    
	    float xn= x0, xn2 = x0;
	    int iterations = 0;

	    float xi = 0; // Set xi to 0 for the first iteration
	    do {
	    	
	    	if (iterations == 0) {
	            xi = x0; // Set xi to 0 for the first iteration
	        } else {
	            xi = xn; // Set xi to xn for subsequent iterations
	        }
	    	
	        // Calculate xn using the Newton-Raphson method
	        xn = xn - solve.evaluateExpression(expression.replaceAll("x", String.valueOf(xi))) / solve.evaluateExpression(fPrime.toString().replaceAll("x", String.valueOf(xi)));
	        xn2 = xn - solve.evaluateExpression(expression.replaceAll("x", String.valueOf(xn))) / solve.evaluateExpression(fPrime.toString().replaceAll("x", String.valueOf(xn)));
	        
	        // Calculate Et using the previous xi and the current xn values
	        float Et;
	        if (iterations > 0) {
	            Et = Math.abs((xn2 - xn) / xn2) * 100;
	        } else {
	            xn = x0; // Set xi to xn for the first iteration
	            Et = Math.abs((xn2 - xn) / xn2) * 100;
	        }
	        
	        // Append iteration information to the table
	        table.append(iterations).append("  ").append(String.format("%.7f", xn)).append("   ").append(String.format("%.1f", Et)).append("\n");
	        iterations++;
	    }
	    // Continue the loop while the number of iterations is less than the maximum iterations and the absolute value of the function evaluated at xn is greater than the tolerance
	    while (iterations < maxIterations && Math.abs(solve.evaluateExpression(expression.replaceAll("x", String.valueOf(xn)))) > tolerance);
	    // Append the found root to the table    
	    table.append("\n=====================\n\n").append("\nFound Root: ").append(xn).append("\n=====================\n\n");
	    // If the root is not found within the maximum number of iterations, display an error message and run the program again
	    if (iterations == maxIterations) {
			error("Root not found within the maximum number of iterations. Try a different initial guess or tolerance.");
			run();
	    }
	    return table.toString();
	}
	


	// solveModifiedRoot method to solve the root of a function using modified Newton-Raphson method
	// This method uses the second derivative of the function in the calculation
	// It calculates the approximate relative error (Et) for each iteration
	// The method returns a table showing the iteration number, the value of xi, and the approximate relative error (Et)
	// The method takes the expression, initial guess (x0), and tolerance as parameters
	public String solveModifiedRoot(String expression, double x0, double tolerance) {
	    int maxIterations = 20;
	    StringBuilder table = new StringBuilder();
	    table.append("Root Table for: ").append(expression).append("\n\n");

	    EquationSolver solve = new EquationSolver();
	    Variable x = new Variable("x");
	    Derivative fPrime = DerivativeParser.parseExpression(expression, x).diff("x");// First derivative
	    Derivative fDoublePrime = DerivativeParser.parseExpression(fPrime.toString(), x).diff("x"); // Second derivative
	    table.append("1st Derivative:\n").append(fPrime).append("\n");
	    table.append("i        xi             Et (%) \n");
	    table.append("2nd Derivative:\n").append(fDoublePrime).append("\n=====================\n\n");
	    table.append("i        xi             Et (%) \n");
	    double xn = x0;
	    int iterations = 0;

	    while (iterations < maxIterations && Math.abs(solve.evaluateExpression(expression.replaceAll("x", String.valueOf(xn)))) > tolerance) {
	        double xi = xn;
	        double fPrimeValue = solve.evaluateExpression(fPrime.toString().replaceAll("x", String.valueOf(xn)));
	        double fDoublePrimeValue = solve.evaluateExpression(fDoublePrime.toString().replaceAll("x", String.valueOf(xn)));

	        if (fDoublePrimeValue == 0) {
	            return "Second derivative became zero. Cannot continue the iteration.";
	        }

	        xn = xn - (fPrimeValue / fDoublePrimeValue); // Modified formula with second derivative
	        double Et;
	        if (iterations > 0) {
	            Et = Math.abs(1 - ((xi - xn) / xi)) * 100; // Calculate approximate relative error (Et)
	        } else {
	            Et = 100; // Set Et to 100% for the first iteration
	        }

	        // Append iteration information to the table
	        table.append(iterations).append("  ").append(String.format("%.7f", xn)).append("   ").append(String.format("%.1f", Et)).append("\n");

	        iterations++;
	    }

	    table.append("\n=====================\n\n").append("\nFound Root: ").append(xn).append("\n=====================\n\n");
	    // If the maximum number of iterations is reached, display an error message
	    if (iterations == maxIterations) {
			error("Root not found within the maximum number of iterations. Try a different initial guess or tolerance.");
			run();
	    }
	    return table.toString();
	}

}

