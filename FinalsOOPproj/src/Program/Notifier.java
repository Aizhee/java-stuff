package Program;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

// This class is responsible for displaying notifications to the user.
public class Notifier {
	
	public ImageIcon icon = new ImageIcon("../FinalsOOPproj/Excercises/actionLogo.png");

	public static void notify(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public static void notifyError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void notifyWarning(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void notifyInfo(String message) {
		JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	//validate int and send error message if not
	public static boolean validateInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			notifyError("Please enter a valid number.");
			return false;
		}
	}
}
