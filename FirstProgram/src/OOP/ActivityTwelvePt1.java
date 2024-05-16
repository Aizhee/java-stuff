package OOP;
import javax.swing.*;

public class ActivityTwelvePt1 {
	public static void main(String[] args) {
		new Panel();
	}
}

class Panel {
	public Panel() {
		Object[] choices = { "Dog", "Cat", "Bird", "Fish" };
	    
		String petIndex = (String) JOptionPane.showInputDialog(null, "Choose your favorite pet:", "Pet", 
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		
		if (petIndex != null)
			JOptionPane.showMessageDialog(null, "Your favorite pet is a " + petIndex, "Info",JOptionPane.INFORMATION_MESSAGE);
	
	}
}