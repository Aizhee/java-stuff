package OOP;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Act13 extends JFrame {
    // Component labels
    private final String[] componentLabels = {"User Name:" , "Name:" , "Password:",  "Confirm Password:" , "Year, Course and Section:", "Date of Birth:" , "Age:" , "Gender:", "Citizenship:", "Religion:" , "Contact Number:", "Father's Name"," Mother's Name:", "Motto: ", "Skills:" , "Seminars Attended: "};
    
    // Text fields
    private JTextField[] textFields = new JTextField[componentLabels.length];

    public Act13() throws IOException {
        setLayout(new BorderLayout(10, 30));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Student Registration Form");
        setSize(1000, 600);
        setBackground(Color.BLACK);
        
        
        JPanel mainForm = new JPanel();
        mainForm.setLayout(new GridLayout(1,2,0,0));
        mainForm.setSize(920, 360);
        JPanel actualForm = new JPanel();
        actualForm.add(new JScrollPane(mainForm));
        
        
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1, 3, 5, 5));
        
        JLabel title = new JLabel("Student Registration Form");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(null, Font.BOLD, 23));
        
        
        BufferedImage slsu = null, mis = null;
        
        slsu = ImageIO.read(new File("C:\\Users\\aizhar\\Downloads\\slsu.png")); 
        mis = ImageIO.read(new File("C:\\Users\\aizhar\\Downloads\\mis.png")); 
        JLabel slsuLogo = new JLabel(new ImageIcon(slsu));
        JLabel misLogo = new JLabel(new ImageIcon(mis));
        
        header.add(slsuLogo);
        header.add(title);
        header.add(misLogo);
        header.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(header, BorderLayout.NORTH);
        
 
        //Start Right
        JPanel startRight = new JPanel();
        startRight.setLayout(new GridLayout(8, 1, 0, 1));

        //End Right Inside
        JPanel endRight = new JPanel();
        endRight.setLayout(new GridLayout(8, 1, 0, 1));
        
        //End Right Inside 
        JPanel endRightInside = new JPanel();
        endRightInside.setLayout(new GridLayout(1, 1, 0, 0));
        endRightInside.add(endRight);
        
        // Create and add components to the frame
        for (int i = 0; i < componentLabels.length; i++) {
        	textFields[i] = new JTextField(15);
        	JLabel label = new JLabel(componentLabels[i]);
        	
			if (i==2||i==3) {
				// Password field
				JPasswordField password = new JPasswordField(15);
				JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(password);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
			} else if(i==4) {
            	//Dropdown
            	JComboBox<String> year = new JComboBox<>();
            	JComboBox<String> course = new JComboBox<>();
            	JComboBox<String> section = new JComboBox<>();
            	//year
            	year.addItem("1st Year");
            	year.addItem("2nd Year");
            	year.addItem("3rd Year");
            	year.addItem("4th Year");
            	year.addItem("Irregular");
            	//course
            	//CIT
            	course.addItem("BSIT");
            	//CoE
            	course.addItem("BSCpE");
            	course.addItem("BSCE");
            	course.addItem("BSME");
            	course.addItem("BSEE");
            	course.addItem("BSIE");
            	course.addItem("BSECE");
            	//CAS
            	course.addItem("BAComm");
            	course.addItem("BAH");
            	course.addItem("BAP");
            	course.addItem("BAB");
            	course.addItem("BAM");
            	//CTE
            	course.addItem("BEEd");
            	course.addItem("BSEd");
            	course.addItem("BCAEd");
            	course.addItem("BTLEd");
            	course.addItem("BSESS");
            	//CABHA
            	course.addItem("BPA");
            	course.addItem("BSA");
            	course.addItem("BSBA");
            	course.addItem("BSHM");
            	//CAM
            	course.addItem("BSN");
            	course.addItem("BSRT");
            	//Section
            	section.addItem("A");
            	section.addItem("B");
            	
            	JPanel panel = new JPanel();
            	panel.setLayout(new GridLayout(1, 3, 5, 5));
            	panel.add(year);
            	panel.add(course);
            	panel.add(section);
            	
            	JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(panel);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
            	
			} else if (i == 7) {
				// Radio buttons for gender
				JRadioButton radioButton = new JRadioButton("Male");
				JRadioButton radioButton1 = new JRadioButton("Female");
				JRadioButton radioButton2 = new JRadioButton("LGBTQ+");
				ButtonGroup group = new ButtonGroup();
				group.add(radioButton);
				group.add(radioButton1);
				group.add(radioButton2);
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(1, 3, 1, 1));
				panel.add(radioButton);
				panel.add(radioButton1);
				panel.add(radioButton2);
				
				JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(panel);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
				
				
			}else if(i == 13 || i == 14) {
				// Text area for motto and skills
				JTextArea textArea = new JTextArea(1,15);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);

				JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(textArea);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
				
			} else if(i == 15) {
				// Text area with scroll bar for seminars attended
				JTextArea textArea = new JTextArea(1,15);
				JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(textArea);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
				
            } else {
            	//Default text fields
            	JPanel dummy = new JPanel();
				dummy.setLayout(new FlowLayout());
				dummy.add(label);
				dummy.add(textFields[i]);
				
				if (i%2==0) {
	        		startRight.add(dummy);
	        	} else {
	        		endRight.add(dummy);
	        	}
            }
        }
        

        mainForm.add(startRight);

        mainForm.add(endRightInside);
        
        //mainForm.setBorder(BorderFactory.createEmptyBorder(10, 70, 10, 70));
        
        add(actualForm, BorderLayout.CENTER);
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3, 5, 5));
        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        JButton validate = new JButton("Validate");
        
        buttons.add(submit);
        buttons.add(reset);
        buttons.add(validate);
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 200, 15, 200));
        
        add(buttons, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    
    public static void main(String[] args) throws IOException {
        new Act13();
    }
}

