package act17;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/*
 * Aizhar Jamilano
 * BSCpE II - GF | CPE05 - OOP
 * 
 * Activity 17: Java Event and ActionListener
 * 
 * Binary Bitwise Calculator
 * 
 * It performs bitwise operations on two binary numbers
 * It can perform AND, OR, NOT, NAND, NOR, XOR, Shift Left, Shift Right operations
 * It can also perform bit shift operations
 * 
 */
public class Act17and14 extends MainCalculator{

    private JTextArea title;
    private StringBuilder currentExpression = new StringBuilder();
    private JComboBox<String> bitShft;

    public Act17and14() {
    	
        JButton[] buttons;
        // Button labels
        String[] buttonLabels = {"AND", "OR", "NOT", ">>", "NAND", "NOR", "XOR", "<<", "1", "0", "CE", "⌫"};
        // Tool tip texts
        String[] toolTipTexts = {"And (Alt + A)", "Or (Alt + O)", "Not (Alt + N)", "Shift Left (Alt + LEFT_ARROW)", "Not And (Alt + D)", "Not Or (Alt + R)", "Exclusive Or (Alt + X)", "Shift Right (Alt + RIGHT_ARROW)", "One", "Zero", "Clear (Alt + DEL)", "Back Space (Alt + BACK_SPACE)"};
        // Button bit shift
        String[] buttonBitShft = {"Arithmetic", "Logical", "Rotate Circular Shift", "Rotate Through Carry Circular Shift"};
        
        //creating instance of JFrame
        JFrame frame = new JFrame("JFrameTitle");
        //frame size 300 width and 300 height
        frame.setSize(450, 400);
        //center the frame
        frame.setLocationRelativeTo(null);
        //exit the application on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make the frame visible
        frame.setVisible(true);
        

        frame.setIconImage(new ImageIcon("C:\\Users\\aizhar\\Downloads\\bitwise.png").getImage());
        
        // Create a JTextArea
        title = new JTextArea();
        title.setText("Enter Expression Here");
        title.setAutoscrolls(true);
        title.setFont(new Font(null, Font.BOLD, 33));
        title.setBorder(BorderFactory.createEmptyBorder(60, 0, 5, 0));
        title.setForeground(Color.GRAY);
        title.setBackground(new Color(32, 32, 32));
        title.setEditable(false);

        // Add KeyListener to JTextArea
        title.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar)) {
                	if ((keyChar == '1') || (keyChar == '0') || keyChar == ' ') 
                        currentExpression.append(keyChar);
                } else if (keyChar == '\b') { // Backspace key
                	backspace();
                } else if (keyChar == '\n') { // Enter key
                	setMainCalculator(bitShft, title, currentExpression);
                    calculateExpression();
                } else if (keyChar == 'b') { // B key
                    changeBitShift();
                }
                title.setText(currentExpression.toString());
            }

        });


        // add the scroll pane to the title text area
        JScrollPane scrollPaneTitle = new JScrollPane(title);
        scrollPaneTitle.createVerticalScrollBar();
        scrollPaneTitle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        //remove the border
        scrollPaneTitle.setBorder(null);
        scrollPaneTitle.getHorizontalScrollBar().setBackground(new Color(32, 32, 32));
        scrollPaneTitle.getHorizontalScrollBar().setForeground(new Color(32, 32, 32));
        scrollPaneTitle.getHorizontalScrollBar().setUI(new CustomRoundedScrollBarUI());
        scrollPaneTitle.getHorizontalScrollBar().setBorder(BorderFactory.createEmptyBorder());
        scrollPaneTitle.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
        scrollPaneTitle.getHorizontalScrollBar().setUnitIncrement(16);
        scrollPaneTitle.getHorizontalScrollBar().setBlockIncrement(16);
        
        JPanel menuComponent = new JPanel();
        menuComponent.setLayout(new GridLayout(1, 4, 0, 0));

        JPanel centerComponent = new JPanel();
        centerComponent.setLayout(new GridLayout(0, 4, 0, 0));

        buttons = new JButton[buttonLabels.length];

        bitShft = new JComboBox<>();
        for (int i = 0; i < buttonBitShft.length; i++) {
            bitShft.addItem(buttonBitShft[i]);
            bitShft.setForeground(Color.WHITE);
            bitShft.setFont(new Font(null, Font.BOLD, 15));
            bitShft.setBackground(new Color(50, 50, 50));
        }
        // Remove the border
        bitShft.setBorder(null);
        bitShft.setBorder(new EmptyBorder(0, 0, 0, 0));
        bitShft.setFocusable(false);
        bitShft.getEditor().getEditorComponent().setBackground(new Color(50, 50, 50));
        bitShft.setUI(new CustomComboBoxUI());

        JPanel bitShftPanel = new JPanel();
        JLabel bitShftLabel = new JLabel("Type of Bit Shift:");
        bitShftLabel.setDisplayedMnemonic('B');
        bitShftLabel.setForeground(Color.WHITE);
        bitShftLabel.setFont(new Font(null, Font.BOLD, 15));
        bitShftPanel.add(bitShftLabel);
        bitShftPanel.setBackground(new Color(40, 40, 40));
        bitShftPanel.setLayout(new GridLayout(1, 2, 0, 0));
        bitShftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        bitShftPanel.add(bitShft);
        menuComponent.add(bitShftPanel);

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setUI(new RoundedButtonUI());
            buttons[i].setToolTipText(toolTipTexts[i]);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(new Color(40, 40, 40));
            buttons[i].setFocusable(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32), 2));

            buttons[i].setFont(new Font(null, Font.BOLD, 20));
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                buttons[i].addActionListener(new OperationButtonListener());
            } else if (i == 8 || i == 9) {
                buttons[i].setBackground(new Color(50, 50, 50));
                buttons[i].addActionListener(new NumberButtonListener());
            } else {
                buttons[i].setBackground(new Color(216, 0, 50));
                buttons[i].setForeground(new Color(32, 32, 32));
                buttons[i].addActionListener(new SpecialButtonListener());
            }
            centerComponent.add(buttons[i]);
        }
        
        buttons[0].setMnemonic(KeyEvent.VK_A);
        buttons[1].setMnemonic(KeyEvent.VK_O);
        buttons[2].setMnemonic(KeyEvent.VK_N);
        buttons[3].setMnemonic(KeyEvent.VK_RIGHT);
        buttons[4].setMnemonic(KeyEvent.VK_D);
        buttons[5].setMnemonic(KeyEvent.VK_R);
        buttons[6].setMnemonic(KeyEvent.VK_X);
        buttons[7].setMnemonic(KeyEvent.VK_LEFT);
        buttons[10].setMnemonic(KeyEvent.VK_DELETE);
        buttons[11].setMnemonic(KeyEvent.VK_BACK_SPACE);

        centerComponent.setBackground(new Color(32, 32, 32));
        menuComponent.setBackground(new Color(40, 40, 40));
        menuComponent.setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32), 2));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(scrollPaneTitle, BorderLayout.NORTH);
        titlePanel.add(menuComponent, BorderLayout.SOUTH);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(centerComponent, BorderLayout.CENTER);

        JButton calculate = new JButton("=");
        calculate.setToolTipText("Calculate");
        calculate.setFont(new Font(null, Font.BOLD, 35));
        calculate.setBackground(new Color(30, 252, 30));
        calculate.setForeground(Color.BLACK);
        calculate.setHorizontalAlignment(SwingConstants.RIGHT);
        calculate.setFocusable(false);
        calculate.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 50));
        calculate.addActionListener(new CalculateButtonListener());
        frame.add(calculate, BorderLayout.SOUTH);
        calculate.setMnemonic(KeyEvent.VK_ENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Act17and14();
    }
    private class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            currentExpression.append(" ").append(source.getText()).append(" ");
            title.setText(currentExpression.toString());
        }
    }
    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            currentExpression.append(source.getText());
            title.setText(currentExpression.toString());
        }
    }
    private class SpecialButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("CE")) {
                currentExpression.setLength(0);
            } else if (source.getText().equals("⌫")) {
                backspace();
            }
            title.setText(currentExpression.toString());
        }
    }
    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	setMainCalculator(bitShft, title, currentExpression);
            calculateExpression();
        }
    }
    // Backspace method
    private void backspace() {
    String[] operators = {" AND ", " NAND ", " OR ", " NOR ", " NOT ", " XOR ", " << ", " >> ", "1", "0"};
	String expression = currentExpression.toString();
	for (int i = 0; i < operators.length; i++) {
        String operator = operators[i];
        if (expression.endsWith(operator)) {
            currentExpression.setLength(currentExpression.length() - operator.length());
            break;
        }
    }}
	private void changeBitShift() {
		//cycle through the bit shift types
		bitShft.setSelectedIndex((bitShft.getSelectedIndex() + 1) % bitShft.getItemCount());
	}
}



