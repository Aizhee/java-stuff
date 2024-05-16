package rootCalculatorTrial;

// Abstract class for derivatives
// This class is used to represent the derivative of a function
abstract class Derivative {
    abstract Derivative diff(String var);
    
}
// Class to represent a constant value
class Constant extends Derivative {
    double value;

    Constant(double value) {
        this.value = value;
    }

    
    Derivative diff(String var) {
        return new Constant(0); // Derivative of a constant is zero
    }

    
    public String toString() {
        return "(" + String.valueOf(value)+ ")";
    }


	public int getValue() {
		return (int) value;
	}
    
}
// Class to represent a variable
class Variable extends Derivative {
    String name;

    Variable(String name) {
        this.name = name;
    }

    
    Derivative diff(String var) {
        if (name.equals(var)) {
            return new Constant(1); // Derivative of a variable with respect to itself is 1
        } else {
            return new Constant(0); // Derivative of a variable with respect to other variables is zero
        }
    }

    
    public String toString() {
        return name;
    }
}
// Class to represent a sum formula of a derivative
class Sum extends Derivative {
    Derivative expr1, expr2;

    Sum(Derivative expr1, Derivative expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    
    Derivative diff(String var) {
        return new Sum(expr1.diff(var), expr2.diff(var)); // Sum rule: d(u+v)/dx = du/dx + dv/dx
    }

    
    public String toString() {
        return "(" + expr1 + " + " + expr2 + ")";
    }
}
// Class to represent a product formula of a derivative
class Product extends Derivative {
    Derivative expr1, expr2;

    Product(Derivative expr1, Derivative expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    Derivative diff(String var) {
        return new Sum(new Product(expr1, expr2.diff(var)), new Product(expr1.diff(var), expr2)); // Product rule: d(uv)/dx = u*dv/dx + v*du/dx
    }

    
    public String toString() {
        return "(" + expr1 + " * " + expr2 + ")";
    }
}

// Class to represent a power formula of a derivative
class Power extends Derivative {
    Derivative base;
    int exponent;

    Power(Derivative base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    Derivative diff(String var) {
        if (exponent == 0) {
            return new Constant(0); // Derivative of a constant power is zero
        } else if (exponent == 1) {
            return base.diff(var); // Derivative of x^1 is 1
        } else {
            // Apply the power rule: d(x^n)/dx = n * x^(n-1)
            Derivative derivativeOfBase = new Product(new Constant(exponent), new Power(base, exponent - 1));
            return new Product(derivativeOfBase, base.diff(var));
        }
    }
    
    public String toString() {
        if (exponent == 0) {
            return "1"; // Any constant raised to the power of 0 is 1
        } else if (exponent == 1) {
            return base.toString(); // x^1 is just x
        } else {
            return "(" + base + "^" + exponent + ")"; // For other powers, display as base^exponent
        }
    }
}







