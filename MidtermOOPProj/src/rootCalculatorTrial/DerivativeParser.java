package rootCalculatorTrial;

public class DerivativeParser extends RootCalculator {

	//method to parse expression to Derivative object using the variable x
	public static Derivative parseExpression(String expression, Variable x) {
	    expression = expression.replaceAll(" ", "").toLowerCase();
	    StringBuilder numBuilder = new StringBuilder();
	    StringBuilder operatorBuilder = new StringBuilder();
	    Derivative result = null;
	    boolean numStarted = false;

	    for (int i = 0; i < expression.length(); i++) {
	        char c = expression.charAt(i);
	        //check if the character is a digit or a decimal point
	        if (Character.isDigit(c) || c == '.') {
	            numBuilder.append(c);
	            numStarted = true;
	        } else if (c == '-' && i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                // Concatenate the '-' sign with the next digits to form a negative number
                numBuilder.append(c);   
	            //check if the character is a letter
	        } else if (Character.isLetter(c)) {
	            if (c == 'x') {
	            	//check if the number builder is empty
	                if (result == null) {
	                	//parse the number builder to a double
	                    result = x;
	                } else {
	                	//apply the operator to the result and the variable x
	                    result = applyOperator(result, x, operatorBuilder.toString());
	                }
	            } else {
	            	//error message if the variable is not x
	            	error("Unsupported variable found in the expression: " + c);
	            	run();
	            }
	            //reset the operator builder
	            operatorBuilder.setLength(0);
	            
	        } else if (c == '(') {
	            //check if the number has started
	            if (numStarted) {
	            	error("Unexpected opening parenthesis after number: " + c);
	            	run();
	            }
	            //find the matching closing parenthesis
	            int subExpressionStart = i + 1;
	            int subExpressionEnd = findMatchingClosingParen(expression, subExpressionStart);
	            String subExpression = expression.substring(subExpressionStart, subExpressionEnd);
	            //parse the subExpression to a Derivative object
	            Derivative subExpressionResult = parseExpression(subExpression, x);
	            if (result == null) {
	            	//set the result to the subExpressionResult
	                result = subExpressionResult;
	            } else {
	            	//apply the operator to the result and the subExpressionResult
	                result = applyOperator(result, subExpressionResult, operatorBuilder.toString());
	            }
	            //reset the operator builder
	            operatorBuilder.setLength(0);
	            i = subExpressionEnd; // Skip the sub-expression, including the closing parenthesis
	        //Check if the character is an operator
	        } else if (c == '+' || c == '-' || c == '*' || c == '^') {
	        	//check if the number has started
	            if (numStarted) {
	            	//parse the number builder to a double
	                double value = Double.parseDouble(numBuilder.toString());
	                //create a constant object with the value
	                Derivative constant = new Constant(value);
	                //check if the result is null
	                if (result == null) {
	                	//set the result to the constant
	                    result = constant;
	                } else {
	                	//apply the operator to the result and the constant
	                    result = applyOperator(result, constant, operatorBuilder.toString());
	                }  
	                //reset the number builder
	                numBuilder.setLength(0);
	                numStarted = false;
	            }
	            
	            //append the operator to the operator builder
	            operatorBuilder.append(c);
	            
	        } else {
	        	//error message if the character is not a digit, letter, parenthesis, or operator
	        	error("Unsupported character found in the expression: " + c);
	        }
	    }
	    //check if the number has started
	    if (numStarted) {
	    	//parse the number builder to a double
	        double value = Double.parseDouble(numBuilder.toString());
	        //create a constant object with the value
	        Derivative constant = new Constant(value);
	        //check if the result is null
	        if (result == null) {
	            result = constant;
	        } else {
	            result = applyOperator(result, constant, operatorBuilder.toString());
	        }
	    }
	    

	    return result;
	}
	//method to find the matching closing parenthesis
	public static int findMatchingClosingParen(String expression, int startIndex) {
	    int count = 0;
	    for (int i = startIndex; i < expression.length(); i++) {
	        char c = expression.charAt(i);
	        if (c == '(') {
	            count++;
	        } else if (c == ')') {
	            if (count == 0) {
	                return i;
	            }
	            count--;
	        }
	    }
	    //error message if no matching closing parenthesis is found
	    error("No matching closing parenthesis found");
	    return -1;
	}


	public static Derivative applyOperator(Derivative expr1, Derivative expr2, String operator) {
	    switch (operator) {
	        case "+":
	            return new Sum(expr1, expr2);
	        case "-":
	        	if (expr2 instanceof Constant) {
	                // If the second expression is a constant, subtract its value directly
	                double value = -((Constant) expr2).getValue();
	                return new Sum(expr1, new Constant(value));
	            } else {
	                // If not a constant, subtract the entire expression
	                return new Sum(expr1, new Product(new Constant(-1), expr2));
	            }

	        case "*":
	            return new Product(expr1, expr2);
	        case "^":
	            if (!(expr1 instanceof Variable) && !(expr1 instanceof Constant)) {
	                error("Exponentiation can only be applied to a variable or constant");
	                run();
	            }
	            if (!(expr2 instanceof Constant)) {
	                error("Exponent must be a constant");
	                run();
	            }

	        	int exponent = (int) ((Constant) expr2).getValue();
	            return new Power(expr1, exponent);

	        default:
	            error("Invalid operator: " + operator);
	            run();
	            return null;
	    }
	}


}
