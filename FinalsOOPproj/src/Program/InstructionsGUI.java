package Program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

// This class is responsible for displaying the instructions to the user.
public class InstructionsGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	InstructionsGUI frame = new InstructionsGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InstructionsGUI() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("Exercises/actionLogo.png"));
        setTitle("Exercisio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(null);

        setContentPane(contentPane);
        setUndecorated(true);

        JPanel backgroundPanel = new JPanel() {
            private static final long serialVersionUID = 12L;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon startImage = new ImageIcon("../FinalsOOPproj/Exercises/8722687.jpg");
                Image img = startImage.getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        backgroundPanel.setBackground(new Color(64, 128, 128));
        backgroundPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        contentPane.add(backgroundPanel, BorderLayout.CENTER);

        backgroundPanel.setLayout(new GridBagLayout());
        
        PanelRound panelRound = new PanelRound();
        panelRound.setBackground(UIManager.getColor("Slider.focus"));
        panelRound.setRoundTopLeft(15);
        panelRound.setRoundTopRight(15);
        panelRound.setRoundBottomLeft(15);
        panelRound.setRoundBottomRight(15);
        panelRound.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelRound.setPreferredSize(new Dimension(1000, 800));  // Set preferred size
        panelRound.setMaximumSize(new Dimension(500, 500));    // Set maximum size
        panelRound.setMinimumSize(new Dimension(400, 300));    // Set minimum size
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        
        backgroundPanel.add(panelRound, gbc);
        panelRound.setLayout(new BorderLayout(0, 0));
        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(getInstructions());
        editorPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setUI(new CustomRoundedScrollBarUI());
        //set dimensions of the scrollbar 
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
        scrollPane.setBackground(new Color(64, 128, 128));
        scrollPane.setBorder(new EmptyBorder(10, 0, 10, 0));
        JButton back_btn = new JButton("Back");
        back_btn.addActionListener(e -> {
            IntroGUI intro = new IntroGUI();
            intro.setVisible(true);

            dispose();
        });
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panelRound.add(back_btn, BorderLayout.SOUTH);	
        panelRound.add(panel, BorderLayout.CENTER);
        
        CustomUIs.setColorsGlobally(contentPane, new Color(64, 128, 128), Color.WHITE, Color.BLACK);
    }
    
    private String getInstructions() {
        return "<html>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; font-size: 20pt; }"
                + "</style>"
                + "<h1>Exercisio Instructions</h1>"
                + "<h2>Getting Started</h2>"
                + "<p><b>1. Tap on Start</b><br>"
                + "   - Tap the 'Start' button to open the main schedule viewer and generator.</p>"  
                + "<h2>Initial Setup (First-Time Users)</h2>"
                + "<p><b>2. Create Your Profile</b><br>"
                + "   - If this is your first time setting up, you will be prompted to create your profile.</p>"
                + "<p><b>3. Add Your Username</b><br>"
                + "   - Enter your desired username in the provided field.</p>"
                + "<p><b>4. Change Your Picture (Optional)</b><br>"
                + "   - Tap on the picture icon to upload or change your profile picture. This step is optional.</p>"
                + "<p><b>5. Set Schedule Start Time</b><br>"
                + "   - Set the time you want to begin your generated schedule by selecting the appropriate time from the time picker.</p>"
                + "<h2>Rate Your Abilities</h2>"
                + "<p><b>6. Endurance</b><br>"
                + "   - Move the slider to rate your endurance level from 1 (lowest) to 10 (highest).</p>"
                + "<p><b>7. Strength</b><br>"
                + "   - Move the slider to rate your strength level from 1 (lowest) to 10 (highest).</p>"
                + "<p><b>8. Balance</b><br>"
                + "   - Move the slider to rate your balance level from 1 (lowest) to 10 (highest).</p>"
                + "<p><b>9. Flexibility</b><br>"
                + "   - Move the slider to rate your flexibility level from 1 (lowest) to 10 (highest).</p>"
                + "<h2>Customize Your Settings</h2>"
                + "<p><b>10. Notification Settings</b><br>"
                + "    - Choose your preferences for receiving notifications. You can toggle notifications on or off and select how you wish to be notified.</p>"
                + "<p><b>11. Randomization</b><br>"
                + "    - Enable or disable randomization for your schedule. This setting will determine whether activities are randomized.</p>"                
                + "<p><b>12. Hide Past Activities</b><br>"
                + "    - Select whether you want to hide past activities from your schedule view. Toggle this setting on or off based on your preference.</p>"
                + "<p><b>13. Incrementation of Ratings</b><br>"
                + "    - Set the number of cycles after which your ratings will automatically increment. Define the amount and frequency of this incrementation.</p>"
                + "<p>These steps should guide you through the setup and customization of your Exercisio program. Enjoy your workout planning!</p>"
                + "</html>";
}}