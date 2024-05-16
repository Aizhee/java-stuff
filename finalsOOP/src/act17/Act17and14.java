package act17;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Act17and14 {

    private JTextArea title;
    private StringBuilder currentExpression = new StringBuilder();
    private JComboBox<String> bitShft;

    public Act17and14() {
        JButton[] buttons;
        // Button labels
        String[] buttonLabels = {"AND", "OR", "NOT", ">>", "NAND", "NOR", "XOR", "<<", "1", "0", "CE", "⌫"};
        // Tool tip texts
        String[] toolTipTexts = {"And (Alt + A)", "Or (Alt + O)", "Not (Alt + N)", "Shift Left (Alt + LEFT_ARROW)", "Not And (Alt + D)", "Not Or (Alt + R)", "Exclusive Or (Alt + X)", "Shift Right (Alt + RIGHT_ARROW)", "One", "Zero", "Clear", "Back Space"};
        // Button bit shift
        String[] buttonBitShft = {"Arithmetic", "Logical", "Rotate Circular Shift", "Rotate Through Carry Circular Shift"};

        JFrame frame = new JFrame("Binary Bitwise Calculator");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(490, 400));
        frame.setBackground(new Color(32, 32, 32));
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
        scrollPaneTitle.getHorizontalScrollBar().setUI(new CustomScrollBarUIS());
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
            buttons[i].setUI(new RoundedButtonUIS());
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
            calculateExpression();
        }
    }
    
    private void backspace() {
    String[] operators = {" AND ", " NAND ", " OR ", " NOR ", " NOT ", " XOR ", " << ", " >> ", "1", "0"};
	String expression = currentExpression.toString();
	for (int i = 0; i < operators.length; i++) {
        String operator = operators[i];
        if (expression.endsWith(operator)) {
            currentExpression.setLength(currentExpression.length() - operator.length());
            break;
        }
    }
	}

	private void changeBitShift() {
		//cycle through the bit shift types
		bitShft.setSelectedIndex((bitShft.getSelectedIndex() + 1) % bitShft.getItemCount());
	}

    private void calculateExpression() {
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

// CustomComboBoxUI.java
class CustomComboBoxUI extends BasicComboBoxUI {
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
			private static final long serialVersionUID = 1L;

            protected void configurePopup() {
                super.configurePopup();
                setOpaque(false);
            }
        };
    }

    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(new Color(50, 50, 50));
        button.setBorder(BorderFactory.createLineBorder(new Color(32,32,32), 2));
        return button;
    }

	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        g2.fill(new RoundRectangle2D.Double(bounds.x, bounds.y, bounds.width, bounds.height, 5, 5));
        g2.dispose();
    }
}

// Custom Rounded Button UI
class RoundedButtonUIS extends BasicButtonUI {

    private static final int ARC_WIDTH = 15;
    private static final int ARC_HEIGHT = 15;
    private static final float LIGHTEN_FACTOR = 0.3f; 

    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorderPainted(true);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
 
    }

    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getBackground(), b.getModel().isPressed());
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c, Color bgColor, boolean isPressed) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(isPressed ? lightenColor(bgColor) : bgColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = c.getWidth();
        int height = c.getHeight();
        g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT));
        g2d.dispose();
    }

    private Color lightenColor(Color color) {
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(hsb[0], hsb[1], Math.min(1.0f, hsb[2] + LIGHTEN_FACTOR));
    }
}
// Custom Scroll Bar UI
class CustomScrollBarUIS extends BasicScrollBarUI {
	private static final int ARC_WIDTH = 10;
	private static final int ARC_HEIGHT = 10;

	protected JButton createDecreaseButton(int orientation) {
		return createArrowButton();
	}

	protected JButton createIncreaseButton(int orientation) {
		return createArrowButton();
	}

	private JButton createArrowButton() {
		JButton button = new JButton();
		button.setOpaque(true);
		button.setBackground(new Color(32, 32, 32));
		button.setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32), 2));
		return button;
	}

	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(new Color(32, 32, 32));
		g2d.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(new Color(50, 50, 50));
		g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}
}