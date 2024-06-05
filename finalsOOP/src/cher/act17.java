package cher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class act17 extends JFrame implements ActionListener {
    private JTextField display1;
    private JTextField display2;
    private boolean radiansMode = false; // Default mode is readians
    
    public act17() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(180, 230, 180)); // Set pastel green background color

        // Title label
        JLabel titleLabel = new JLabel("Trigonometric Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);



        // Split the display into two sections
        JPanel displayPanel = new JPanel(new GridLayout(2, 1)); // GridLayout with 2 rows and 1 column
        display1 = new JTextField(20);
        display1.setEditable(false);
        display1.setPreferredSize(new Dimension(display1.getPreferredSize().width, 25)); // Reduce height of display1
        displayPanel.add(display1);
        
        display2 = new JTextField(20);
        display2.setEditable(false);
        display2.setPreferredSize(new Dimension(display2.getPreferredSize().width, 25)); // Reduce height of display2
        displayPanel.add(display2);
        
        panel.add(displayPanel, BorderLayout.CENTER);

        // Load clock image and resize it
        ImageIcon clockIcon = new ImageIcon("C:\\Users\\CHEWIIE\\Downloads\\clock.png");
        Image scaledClockImage = clockIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledClockIcon = new ImageIcon(scaledClockImage);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 5, 5)); // Adding horizontal and vertical gaps of 5 pixels
        String[] buttonLabels = {
            "deg", "rad",  "←", "C", 
            "sin", "cos", "tan", "+",
             "7", "8", "9", "-",
             "4", "5", "6", "x",
             "1", "2", "3", ",",
            "(", ")", "0",  "="
        };

        ButtonGroup radioGroup = new ButtonGroup(); // ButtonGroup for radio buttons
        
        for (String label : buttonLabels) {
            JButton button;
            if (label.isEmpty()) {
                // Create clock button with scaled icon
                button = new JButton(scaledClockIcon);
            } else if (label.equals("deg") || label.equals("rad")) {
                // Create radio button
                JRadioButton radioButton = new JRadioButton(label);
                radioButton.setActionCommand(label);
                radioButton.addActionListener(this); // Add action listener to handle mode change
                radioGroup.add(radioButton); // Add radio button to group
                radioButton.setSelected(!radiansMode && label.equals("deg")); // Set default selection for degrees
                buttonPanel.add(radioButton);
                continue; // Skip to next iteration, as we've already added the radio button to the panel
            } else {
                // Create regular button
                button = new JButton(label);
                button.addActionListener(this); // Add action listener to handle button clicks
            }
            // Set background color for buttons in the last column
            if (!label.isEmpty() && (buttonPanel.getComponentCount() + 1) % 4 == 0) {
                button.setBackground(new Color(180, 230, 180)); // Set pastel green background color for buttons
            }
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(panel);
        setSize(400, 500); // Set the preferred size of the frame
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("deg")) {
            radiansMode = false;
        } else if (command.equals("rad")) {
            radiansMode = true;
        } else if (command.equals("=")) {
            evaluateExpression();
        } else if (command.equals("C")) {
            clearDisplay();
        } else if (command.equals("←")) {
            deleteLastCharacter();
        } else if (command.equals("sin") || command.equals("cos") || command.equals("tan")) {
            appendToDisplay(command + " (");
        } else if (command.equals("x")|| command.equals(",") || command.equals("+") || command.equals("-")) {
            appendToDisplay(" " + command + " ");
        } else {
            appendToDisplay(command);
        }
    }

    private void evaluateExpression() {
        String expression = display1.getText();
        try {
            double result = evaluate(expression);
            display2.setText(Double.toString(result));
        } catch (Exception ex) {
            display2.setText("Error");
        }
    }

    private double evaluate(String expression) {
        // Basic implementation of evaluating trigonometric expressions.
        // For simplicity, assuming the input is in the form of "sin(30)" or "cos(60)"

    	try {
    	    double result = 0.0;
    	    System.out.println("Expression: " + expression);
    	    System.out.println("Radians mode: " + radiansMode);
    	    // Regex to find individual trigonometric function calls like "sin(x)", "cos(y)", etc.
    	    Pattern pattern = Pattern.compile("(sin|cos|tan)\\s*\\((-?\\d+(\\.\\d+)?)(\\s*[+-]\\s*(-?\\d+(\\.\\d+)?))?\\)");
    	    Matcher matcher = pattern.matcher(expression);
    	    System.out.println("Matcher: " + matcher.find());

    	    // Reset matcher position to the start of the input string
    	    matcher.reset();
    	    
    	    while (matcher.find()) {
    	        System.out.println("Matcher: " + matcher.group());
    	        String function = matcher.group(1);
    	        double angle = Double.parseDouble(matcher.group(2));
    	        
    	        if (!radiansMode) {
    	            angle = Math.toRadians(angle);
    	        }

    	        switch (function) {
    	            case "sin":
    	                result = TrigonometryFunction.sineSum(angle, 0);
    	                break;
    	            case "cos":
    	                result = TrigonometryFunction.cosineSum(angle, 0);
    	                break;
    	            case "tan":
    	                result = TrigonometryFunction.round(Math.tan(angle));
    	                break;
    	        }
    	    }

    	    return result;
    	} catch (Exception ex) {
    	    ex.printStackTrace();
    	}
    	return 0;
    }

    private void clearDisplay() {
        display1.setText("");
        display2.setText("");
    }

    private void deleteLastCharacter() {
        String text = display1.getText();
        if (!text.isEmpty()) {
            display1.setText(text.substring(0, text.length() - 1));
        }
    }

    private void appendToDisplay(String text) {
        display1.setText(display1.getText() + text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new act17().setVisible(true);
        });
    }
}
