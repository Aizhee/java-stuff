package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiffEq extends JFrame {
    private JTextField initialYField, rateConstantField, stepSizeField, numIterationsField;
    private JTextArea resultArea;

    public DiffEq() {
        setTitle("Differential Equations Solver");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Initial Value (y0):"));
        initialYField = new JTextField();
        inputPanel.add(initialYField);
        inputPanel.add(new JLabel("Rate Constant (k):"));
        rateConstantField = new JTextField();
        inputPanel.add(rateConstantField);
        inputPanel.add(new JLabel("Step Size (h):"));
        stepSizeField = new JTextField();
        inputPanel.add(stepSizeField);
        inputPanel.add(new JLabel("Number of Iterations:"));
        numIterationsField = new JTextField();
        inputPanel.add(numIterationsField);

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveDifferentialEquations();
            }
        });

        inputPanel.add(solveButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void solveDifferentialEquations() {
        try {
            double y0 = Double.parseDouble(initialYField.getText());
            double k = Double.parseDouble(rateConstantField.getText());
            double h = Double.parseDouble(stepSizeField.getText());
            int numIterations = Integer.parseInt(numIterationsField.getText());

            StringBuilder result = new StringBuilder();

            // Solve growth equation
            result.append("Solving Growth Equation dy/dx = k * y\n");
            result.append("========================================\n");
            result.append("Step\tValue of y\n");
            double y = y0;
            for (int i = 0; i <= numIterations; i++) {
                result.append(i).append("\t\t").append(y).append("\n");
                y = y + h * k * y;
            }

            result.append("\n");

            // Solve decay equation
            result.append("Solving Decay Equation dy/dx = -k * y\n");
            result.append("========================================\n");
            result.append("Step\tValue of y\n");
            y = y0;
            for (int i = 0; i <= numIterations; i++) {
                result.append(i).append("\t\t").append(y).append("\n");
                y = y - h * k * y;
            }

            resultArea.setText(result.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input! Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DiffEq().setVisible(true);
            }
        });
    }
}
