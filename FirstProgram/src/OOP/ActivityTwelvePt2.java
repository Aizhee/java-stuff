package OOP;

import javax.swing.*;

public class ActivityTwelvePt2 {
	public static void main(String[] args) {
		new policeRadar(); //Call the constructor of policeRadar
	}
}

class policeRadar {
	
	policeRadar(){
		//Declare and initialize variable
        int penalty = 0;
		
        //Prompt user for speed input
		String speedTest = JOptionPane.showInputDialog(null, "Enter the speed: ", "Speed", JOptionPane.QUESTION_MESSAGE);
		
		//Prevent error if user clicks cancel and no input
		if (speedTest != null && !speedTest.equals("")) {
			penalty = penaltyCalculator(Integer.parseInt(speedTest)) ;
			showInfoPanel(penalty);
		}
	}
	
	//Method to show the info panel
	public void showInfoPanel(int penalty) {
		if (penalty == 0) {
			JOptionPane.showMessageDialog(null, "You are driving within the speed limit.", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			//If speed is within the limit, show info message
		} else if (penalty == -1) {
			//If speed is too fast, show error message
			JOptionPane.showMessageDialog(null, "You are driving too fast, you are under arrest.", "Arrest",
					JOptionPane.ERROR_MESSAGE);
		} else {
			//If speed is over the limit, show warning message with the penalty
		JOptionPane.showMessageDialog(null, "Speeding...\nYour penalty is: $" + penalty, "Penalty", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//Method to calculate the penalty based on the speed
	public int penaltyCalculator(int speed) {
		//if speed is within the range, return the corresponding penalty
	    if (speed >= 55 && speed <= 60) {
	        return 200;
	    } else if (speed >= 61 && speed <= 70) {
	        return 250;
	    } else if (speed >= 71 && speed <= 80) {
	        return 300;
		} else if (speed > 80) {
			return -1; //if speed is too fast
	    } else {
	        return 0; //if speed is within the limit
	    }
	}

}