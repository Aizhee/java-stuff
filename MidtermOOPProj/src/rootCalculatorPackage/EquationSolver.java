package rootCalculatorPackage;

//Class to evaluate the expression that has been substituted with a value
public class EquationSolver extends RootCalculator {
	
    // Evaluate the expression
	public float evaluateExpression(String expression) {
	    return new Object() {
	        int pos = -1, ch;
	        //Method to get the next character
	        public void nextChar() {
	            if (++pos < expression.length()) {
	                ch = expression.charAt(pos);
	            } else {
	                ch = -1;
	            }
	        }
	        //Method to check if the next character is a specific character
	        //If it is, then get the next character
	        public boolean eat(int charToEat) {
	            while (ch == ' ') 
	            	nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }
	        //Method to parse the expression by calling the parseExpression method it returns a float
	        public float parse() {
	            nextChar();
	            float x = parseExpression();
	            if (pos < expression.length()) 
	            	//If the position is less than the length of the expression, then it is an error
	            	error("Unexpected: " + (char) ch);
	            return (float) x;
	        }
	        //Method to parse the expression
	        public float parseExpression() {
	        	float x = parseTerm();
	            while (true) {
	                if (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else return x;
	            }
	        }
	        //Method to parse the term
	        public float parseTerm() {
	        	float x = parseFactor();
	            while (true) {
	                if (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else return x;
	            }
	        }
	        
	        // Method to parse the factor
	        public float parseFactor() {
	            if (eat('+')) return parseFactor(); // unary plus operation
	            if (eat('-')) return -parseFactor(); // unary minus operation

	            float x = 1;
	            int startPos = this.pos;

	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                if (!eat(')')) 
	                    error("Missing closing parenthesis");
	                
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Float.parseFloat(expression.substring(startPos, this.pos));
	                //If the next character is a 'x' then parse the factor
	            } else if (eat('x')) { // variable x
	                x = parseFactor();
	                //If the next character is a '^' then parse the factor
	            } else if (eat('^')) {
	                x = (float) Math.pow(x, parseFactor()); // exponentiation
	            	
	            } else {
	                error("Unexpected: " + (char) ch);
	            }
	            //If the next character is a '^' then parse the factor
	            if (eat('^')) x = (float) Math.pow(x, parseFactor()); // exponentiation

	            return x;
	        }

	    }.parse(); //End of the Object then parse the expression
	}

}



