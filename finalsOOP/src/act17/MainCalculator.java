package act17;

import javax.swing.*;

public class MainCalculator {
	private StringBuilder currentExpression = new StringBuilder();
	private JComboBox<String> bitShft;
	private JTextArea title;

	public void setMainCalculator(JComboBox<String> bitShft, JTextArea title, StringBuilder currentExpression) {
		this.bitShft = bitShft;
		this.title = title;
		this.currentExpression = currentExpression;
	}

	public void appendExpression(String text) {
		currentExpression.append(text);
		title.setText(currentExpression.toString());
	}

	public void clearExpression() {
		currentExpression.setLength(0);
		title.setText("");
	}

	public void calculate() {
		calculateExpression();
	}
	
	void calculateExpression() {
        String type = String.valueOf(bitShft.getSelectedItem());
        String[] tokens = currentExpression.toString().split(" ");
        if (tokens.length < 3) {
            title.setText("Error: Invalid Expression");
            return;
        }

        try {
            int operand1 = Integer.parseInt(tokens[0], 2);
            String operator = tokens[1];
            int operand2 = Integer.parseInt(tokens[2], 2);
            int result = 0;

            switch (operator) {
                case "AND":
                    result = operand1 & operand2;
                    break;
                case "OR":
                    result = operand1 | operand2;
                    break;
                case "NOT":
                    result = ~operand1;
                    break;
                case "NAND":
                    result = ~(operand1 & operand2);
                    break;
                case "NOR":
                    result = ~(operand1 | operand2);
                    break;
                case "XOR":
                    result = operand1 ^ operand2;
                    break;
                case ">>":
                    result = bitShiftOperation(type, operand1, operand2, "Right");
                    break;
                case "<<":
                    result = bitShiftOperation(type, operand1, operand2, "Left");
                    break;
            }

            currentExpression.setLength(0);
            currentExpression.append(Integer.toBinaryString(result));
            title.setText(currentExpression.toString());

        } catch (NumberFormatException ex) {
            title.setText("Error: Invalid Number Format");
        }
    }
    
    private int bitShiftOperation(String type, int op1, int op2, String leftorRight) {
        switch (type) {
            case "Logical":
                if (leftorRight.equals("Left")) {
                    return op1 << op2;
                } else {
                    return op1 >>> op2;
                }
            case "Arithmetic":
                if (leftorRight.equals("Left")) {
                    return op1 << op2;
                } else {
                    return op1 >> op2;
                }
            case "Rotate Circular Shift":
                if (leftorRight.equals("Left")) {
                    return (op1 << op2) | (op1 >>> (32 - op2));
                } else {
                    return (op1 >>> op2) | (op1 << (32 - op2));
                }
            case "Rotate Through Carry Circular Shift":
                if (leftorRight.equals("Left")) {
                    return ((op1 << op2) | (op1 >>> (32 - op2))) ^ (op1 >>> 31);
                } else {
                    return ((op1 >>> op2) | (op1 << (32 - op2))) ^ (op1 << 31);
                }
            default:
                title.setText("Invalid operation");
                return -1;
        }
    }
}
