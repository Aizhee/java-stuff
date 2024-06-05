package cher;

import javax.swing.JOptionPane;
import java.lang.Math;

// Helper class for TrigCalculatorApp extending TrigonometryFunction to calculate trigonometric identities
public class TrigCalculatorAppHelper extends TrigonometryFunction {

    // Method to calculate Identity option 1
    public static void calculateIdentity1() {
        askFunctionAndCalculate(true);
    }

    // Method to calculate Identity option 2
    public static void calculateIdentity2() {
        // Get user input for the functions and operation for both equations
        String function1 = showDropdown(
                "Choose a trigonometric function for equation 1:", "Trigonometric Function",
                 new String[]{"Sine", "Cosine"}, "Sine");
        if (function1 == null) {
            return; // User clicked cancel, so terminates the program
        }
        String operation1 = askOperation();
        if (operation1 == null) {
            return; // User clicked cancel, so terminates the program
        }
        String function2 = showDropdown(
                "Choose a trigonometric function for equation 2:", "Trigonometric Function",
                 new String[]{"Sine", "Cosine"}, "Sine");
        if (function2 == null) {
            return; // User clicked cancel, so terminates the program
        }
        String operation2 = askOperation();
        if (operation2 == null) {
            return; // User clicked cancel, so terminates the program
        }

        // Get user input for angles in degrees for both equations
        double angle1_1 = getAngle("Enter the first angle for equation 1 in degrees:");
        if (Double.isNaN(angle1_1)) {
            return; // User clicked cancel, so terminates the program
        }
        double angle1_2 = getAngle("Enter the second angle for equation 1 in degrees:");
        if (Double.isNaN(angle1_2)) {
            return; // User clicked cancel, so terminates the program
        }
        double angle2_1 = getAngle("Enter the first angle for equation 2 in degrees:");
        if (Double.isNaN(angle2_1)) {
            return; // User clicked cancel, so terminates the program
        }
        double angle2_2 = getAngle("Enter the second angle for equation 2 in degrees:");
        if (Double.isNaN(angle2_2)) {
            return; // User clicked cancel, so terminates the program
        }

        // Convert degrees to radians for trigonometric functions
        angle1_1 = Math.toRadians(angle1_1);
        angle1_2 = Math.toRadians(angle1_2);
        angle2_1 = Math.toRadians(angle2_1);
        angle2_2 = Math.toRadians(angle2_2);

        // Calculate results for both equations
        double result1, result2;
        // No need to call the trigonometric functions directly it is already inherited
        if (function1.equals("Sine")) {
            result1 = (operation1.equals("Sum")) ? sineSum(angle1_1, angle1_2) : sineDifference(angle1_1, angle1_2);
        } else { // Cosine
            result1 = (operation1.equals("Sum")) ? cosineSum(angle1_1, angle1_2) : cosineDifference(angle1_1, angle1_2);
        }

        if (function2.equals("Sine")) {
            result2 = (operation2.equals("Sum")) ? sineSum(angle2_1, angle2_2) : sineDifference(angle2_1, angle2_2);
        } else { // Cosine
            result2 = (operation2.equals("Sum")) ? cosineSum(angle2_1, angle2_2) : cosineDifference(angle2_1, angle2_2);
        }

        // Check if results are equal or not
        String equalityMessage = areAlmostEqual(result1, result2) ? "The results are equal." : "The results are not equal.";

        // Construct the message with the results
        String resultMessage = "Result for equation 1: " + result1 + "\n"
                + "Result for equation 2: " + result2 + "\n"
                + equalityMessage;

        // Display the message
        showMessage(resultMessage);
    }

    // Method to ask the user to choose between Sine and Cosine and calculate
    private static void askFunctionAndCalculate(boolean isSine) {
        // Get user input for angles in degrees and function choice
        String[] options = {"Sine", "Cosine", "Product"};
        String functionChoice = null;
        while (functionChoice == null) {
            functionChoice = showDropdown(
                    "Choose a trigonometric function:", "Trigonometric Function",
                     options, options[0]);
            if (functionChoice == null) {
                return; // User clicked cancel, so return to previous pane
            }
        }

        if (functionChoice.equals("Product")) {
            calculateProduct(isSine);
        } else {
            String operationChoice = askOperation();
            calculateResultAngles(functionChoice.equals("Sine"), operationChoice);
        }
    }

    // Method to ask the user to choose an operation (sum, difference)
    private static String askOperation() {
        String[] operationOptions = {"Sum", "Difference"};
        String operationChoice = null;
        while (operationChoice == null) {
            operationChoice = showDropdown(
                    "Get the:", "Choose an operation",
                     operationOptions, operationOptions[0]);
            if (operationChoice == null) {
                return null; // User clicked cancel, so terminates the program
            }
        }
        return operationChoice;
    }

    // Method to calculate and display the results
    private static void calculateResultAngles(boolean isSine, String operationChoice) {
        double angle1 = getAngle("Enter the first angle in degrees:");
        if (Double.isNaN(angle1)) {
            return; // User clicked cancel, so terminates the program
        }
        double angle2 = getAngle("Enter the second angle in degrees:");
        if (Double.isNaN(angle2)) {
            return; // User clicked cancel, so terminates the program
        }

        // Convert degrees to radians for trigonometric functions
        angle1 = Math.toRadians(angle1);
        angle2 = Math.toRadians(angle2);

        double result;
        if (operationChoice.trim().equalsIgnoreCase("Sum")) {
            result = isSine ? sineSum(angle1, angle2) : cosineSum(angle1, angle2);
        } else { // Cosine
            result = isSine ? sineDifference(angle1, angle2) : cosineDifference(angle1, angle2);
        }

        // Display the result
        JOptionPane.showMessageDialog(null, "Result: " + result);
    }

    // Method to calculate the product of angles expressed as a sum or difference
    private static void calculateProduct(boolean isSine) {
        String function1 = null;
        String function2 = null;
        while (function1 == null) {
            function1 = showDropdown(
                    "Choose a trigonometric function for angle 1:", "Trigonometric Function",
                    new String[]{"Sine", "Cosine"}, "Sine");
            if (function1 == null) {
                return; // User clicked cancel, so return to previous pane
            }
        }
        while (function2 == null) {
            function2 = showDropdown("Choose a trigonometric function for angle 2:", "Trigonometric Function",
                     new String[]{"Sine", "Cosine"}, "Sine");
            if (function2 == null) {
                return; // User clicked cancel, so return to previous pane
            }
        }

        // Get user input for angles in degrees
        double angle1 = getAngle("Enter the angle 1 in degrees:");
        if (Double.isNaN(angle1)) {
            return; // User clicked cancel, so return to previous pane
        }
        double angle2 = getAngle("Enter the angle 2 in degrees:");
        if (Double.isNaN(angle2)) {
            return; // User clicked cancel, so return to previous pane
        }

        // Convert degrees to radians for trigonometric functions
        angle1 = Math.toRadians(angle1);
        angle2 = Math.toRadians(angle2);

        // Calculate product using the new method
        double product = trigProduct(function1, function2, angle1, angle2);

        // Display the product
        JOptionPane.showMessageDialog(null, "Product: " + product);
    }

    

    // The results of both equation are rounded off to the nearest 11th decimal
    public static boolean areAlmostEqual(double a, double b) {
        long roundedA = Math.round(a * 1e11);
        long roundedB = Math.round(b * 1e11);
        return roundedA == roundedB;
    }
}