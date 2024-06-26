package act18;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Aizhar Jamilano
 * BSCpE II - GF | CPE05 - OOP
 * 
 * Activity 18: JToggleButton
 * 
 */

public class Activity18 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;//to remove the warning
	private JToggleButton redButton, blueButton, greenButton;
    private JPanel display;

    public Activity18() {
        setTitle("JToggleButton");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));
        setLayout(new GridLayout(1, 2));
       
        // Display panel
        display = new JPanel();
        display.setBackground(new Color(0, 0, 0));
        
        JPanel displayOuter = new JPanel();
        displayOuter.setLayout(new GridLayout(1, 1));
        displayOuter.add(display);
        displayOuter.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));


        // Add red button to the panel
        redButton = new JToggleButton("   red    ");
        redButton.addActionListener(this);
        redButton.setFont(new Font(null, Font.BOLD, 15));
        buttonPanel.add(redButton);
        // Add green button to the panel
        greenButton = new JToggleButton(" green ");
        greenButton.addActionListener(this);
        greenButton.setFont(new Font(null, Font.BOLD, 15));
        buttonPanel.add(greenButton);
        // Add blue button to the panel
        blueButton = new JToggleButton("  blue   ");
        blueButton.addActionListener(this);
        blueButton.setFont(new Font(null, Font.BOLD, 15));
        buttonPanel.add(blueButton);

        // Preserve the size of the buttons
        redButton.setMaximumSize(greenButton.getMaximumSize());
        blueButton.setMaximumSize(greenButton.getMaximumSize());

        // Add button panel to the frame
        add(buttonPanel);
        add(displayOuter);
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Get the current background color of the display panel
        Color color = display.getBackground();
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        // Determine which button was toggled and update the corresponding color value
        if (e.getActionCommand() == "   red    ") {
            if (redButton.isSelected()) {
                red = 255;
            } else {
                red = 0;
            }
        } else if (e.getActionCommand() == " green ") {
            if (greenButton.isSelected()) {
                green = 255;
            } else {
                green = 0;
            }
        } else if (e.getActionCommand() == "  blue   ") {
            if (blueButton.isSelected()) {
                blue = 255;
            } else {
                blue = 0;
            }
        }

        // Set the new background color for the display panel
        Color setCol = new Color(red, green, blue);
        display.setBackground(setCol);
    }
    // Main method
    public static void main(String[] args) {
            Activity18 frame = new Activity18();
            frame.setVisible(true);
    }
}
