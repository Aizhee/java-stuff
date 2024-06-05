package cher;

import javax.swing.JOptionPane;

//Class for managing dialog input and output
class DialogManager {
// Method to display a message dialog
public static void showMessage(String message) {
   JOptionPane.showMessageDialog(null, message);
}

// Method to display an option dialog and return the selected option
public static int showOptionDialog(String message, String title, String[] options) {
   return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
}

// Method to show input dialog and return the input int value
public static double showInputDialog(String message) {
   String input = JOptionPane.showInputDialog(message);
   if (input == null) {
       return Double.NaN; // User clicked cancel
   } else {
       try {
           return Double.parseDouble(input);
       } catch (NumberFormatException e) {
           showMessage("Invalid input! Please enter a numerical value.");
           return showInputDialog(message);
       }
   }
}
// Method to show input dialog and return the input string value
public static String showInputDialogString(String message) {
   String input = JOptionPane.showInputDialog(message);
   if (input == null) {
       return null; // User clicked cancel
   } else {
       return input;
   }
}

// Method to show input dialog and return the input dropdown value
public static String showDropdown(String message, String title, String[] options, String defaultOption) {
   String input = (String) JOptionPane.showInputDialog(null,
       message, title,
       JOptionPane.QUESTION_MESSAGE, null, options, defaultOption);
   if (input == null) {
       return null; // User clicked cancel
   } else {
       return input;
   }
}

//Method to get valid angle input from the user
public static double getAngle(String message) {
   double angle = Double.NaN;
   boolean validInput = false;
   while (!validInput) {
       String input = showInputDialogString(message);
       if (input == null) {
           return Double.NaN; // User clicked cancel
       } else {
           boolean isNumeric = true;
           for (int i = 0; i < input.length(); i++) {
               if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.') {
                   isNumeric = false;
                   break;
               }
           }
           if (isNumeric) {
               angle = Double.parseDouble(input);
               validInput = true;
           } else {
               showMessage("Invalid input! Please enter a numerical value.");
           }
       }
   }
   return angle;
}


}
