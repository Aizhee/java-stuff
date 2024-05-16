package act15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicScrollBarUI;


public class act15 {

	private static Color colorprimary = new Color(0,10,37,255);
	private static Color colorsecondary = new Color(26,32,45,255);
	private static Color foreground = new Color(169,171,176,255);
	private static Color papercolor = new Color(255,255,255,255);
	private static Color textcolor = new Color(0,0,0,255);
	
	act15() {
		JFrame frame = new JFrame("Microsoft Word");
  
        JPanel paper = new JPanel();
        paper.setBackground(colorsecondary);
        paper.setBorder(BorderFactory.createEmptyBorder(50, 70, 50, 70));
        paper.setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea(30, 20);
       
        textArea.setBackground(papercolor);
        textArea.setForeground(textcolor);
        textArea.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        textArea.setCaretColor(foreground);
        textArea.putClientProperty("caretWidth", 2);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
        
        paper.add(textArea, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(paper);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("src/word.png").getImage());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI1());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI1());
        scrollPane.getVerticalScrollBar().setBackground(colorsecondary);
        scrollPane.getHorizontalScrollBar().setBackground(colorsecondary);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        //show vertical scrollbar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(colorsecondary);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        JLabel status = new JLabel("Page 1 of 1      32 words       ◘ English (Philippines)          ◙ Display Settings   □ Focus             - ----█-+------ + 72%");
        status.setBorder(null);
        status.setFont(new Font("Consolas", Font.PLAIN, 15));
        statusPanel.add(status);
        statusPanel.setBackground(colorprimary);
        status.setForeground(foreground);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(statusPanel, BorderLayout.SOUTH);

        
        String[] fileMenuItemsStr = {
        	    " ",
        	    "Home",
        	    "New",
        	    "Open",
        	    "Get Add-ins",
        	    "Page Setup",
        	    "Info",
        	    "Save",
        	    "Save As",
        	    "Save as Adobe PDF",
        	    "History",
        	    "Print",
        	    "Share",
        	    "Export",
        	    "Transform",
        	    "Close",
        	    "Account",
        	    "Feedback",
        	    "Options",
        	};
        
        String[] icons = {
        		"src/back.png",
        		"src/home.png",
        		"src/file.png",
        		"src/folder.png",
        		"src/addin.png",
        		
        	};

        	JMenu fileMenu = new JMenu("File");
        	for (int x=0; x < fileMenuItemsStr.length;x++) {
        		if(x == 4||x==16 ) {
					JSeparator separator = new JSeparator();
					separator.setBackground(colorprimary);
					separator.setForeground(colorprimary);
					separator.setBorder(BorderFactory.createLineBorder(colorprimary, 1));
					fileMenu.add(separator);
				} 
        		
        	
				JMenuItem menuItem = new JMenuItem(fileMenuItemsStr[x]);
				if (x == 10 || x == 14) {
					menuItem.setEnabled(false);
				} 
				
				if (x==0||x==1||x==2||x==3||x==4) {
					menuItem.setIcon(new ImageIcon(new ImageIcon(icons[x]).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
				}
				
				menuItem.setForeground(foreground);
				
				menuItem.setBackground(colorsecondary);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
        	    fileMenu.add(menuItem);
				
        	}
        	
        	fileMenu.getPopupMenu().setSize(200, 200);
			 	
        	JMenuBar menuBar = new JMenuBar();
        	fileMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	menuBar.add(fileMenu);
        	
        	ImageIcon ribbon = new ImageIcon(new ImageIcon("src/ribbon.png").getImage().getScaledInstance(1040, 100, Image.SCALE_SMOOTH));
        	JLabel ribbonLabel = new JLabel(ribbon);
        	ribbonLabel.setBackground(colorprimary);
        	frame.add(ribbonLabel, BorderLayout.NORTH);
        	
        menuBar.setBackground(colorprimary);
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        
        fileMenu.setForeground(foreground);
        fileMenu.setBackground(colorsecondary);
        fileMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(colorprimary, 2));
        fileMenu.getPopupMenu().setBackground(colorsecondary);
        
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1040, 650);
        frame.setResizable(false);
 
        frame.setVisible(true);
        System.out.println(frame.getSize());
    }
	
    public static void main(String[] args) throws IOException {
        new act15();
    }
}

//Custom Scroll Bar UI
class CustomScrollBarUI1 extends BasicScrollBarUI {
	private static final int ARC_WIDTH = 5;
	private static final int ARC_HEIGHT = 5;

	private static Color colorsecondary = new Color(26,32,45,255);
	private static Color foreground = new Color(169,171,176,255);

	protected JButton createDecreaseButton(int orientation) {
		return createArrowButton();
	}

	protected JButton createIncreaseButton(int orientation) {
		return createArrowButton();
	}

	private JButton createArrowButton() {
		JButton button = new JButton();
		button.setOpaque(true);
		button.setBackground(colorsecondary);
		button.setBorder(BorderFactory.createLineBorder(colorsecondary, 5));
		return button;
	}

	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(colorsecondary);
		g2d.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(foreground);
		g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}
}