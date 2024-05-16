package act16;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;

public class Act16 {
	
	private static Color colorprimary = new Color(0,10,37,255);
	private static Color colorsecondary = new Color(26,32,45,255);
	private static Color foreground = new Color(169,171,176,255);
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad");
        JTextArea textArea = new JTextArea(20, 60);
        textArea.setBackground(colorsecondary);
        textArea.setForeground(foreground);
        textArea.setBorder(null);
        textArea.setCaretColor(foreground);
        textArea.putClientProperty("caretWidth", 2);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("C:\\Users\\aizhar\\Downloads\\notepad.png").getImage());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI1());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI1());
        scrollPane.getVerticalScrollBar().setBackground(colorsecondary);
        scrollPane.getHorizontalScrollBar().setBackground(colorsecondary);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        
        //show vertical scrollbar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(colorsecondary);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        JLabel status = new JLabel("Ln 1, Col 1      | 5 characters                             | 100%    | Windows (CRLF)             | UTF-8");
        status.setBorder(null);
        statusPanel.add(status);
        statusPanel.setBackground(colorprimary);
        status.setForeground(foreground);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(statusPanel, BorderLayout.SOUTH);

        
        String[] fileMenuItemsStr = {
        	    "New Tab                Ctrl+N",
        	    "New Window         Ctrl+Shift+N",
        	    "Open                      Ctrl+O",
        	    "Save As                 Ctrl+Shift+S",
        	    "Save All                 Ctrl+Alt+S",
        	    "Page Setup",
        	    "Print                       Ctrl+P",
        	    "Close Tab             Ctrl+W",
        	    "Close Window      Ctrl+Shift+W",
        	    "Exit"
        	};

        	String[] editMenuItemsStr = {
        	    "Undo                                 Ctrl+Z",
        	    "Cut                                    Ctrl+X",
        	    "Copy                                 Ctrl+C",
        	    "Paste 	                               Ctrl+V",
        	    "Delete                              Del",
        	    "Explain with Copilot      Ctrl+E",
        	    "Find                                 Ctrl+F",
        	    "Find Next                        F3",
        	    "Find Previous                Shift+F3",
        	    "Replace                          Ctrl+H",
        	    "Go To                             Ctrl+G",
        	    "Select All                        Ctrl+A",
        	    "Time/Date                       F5",
        	    "Font"
        	};

        	String[] viewMenuItemsStr = {
        	    "Zoom In                                Ctrl+Plus",
        	    "Zoom Out                             Ctrl+Minus",
        	    "Restore Default Zoom        Ctrl+0",
        	    "✔ Status Bar",
        	    "✔ Word Wrap"
        	};

        	JMenu zoomMenu = new JMenu("Zoom");
        	zoomMenu.add(new JMenuItem(viewMenuItemsStr[0]));
        	zoomMenu.add(new JMenuItem(viewMenuItemsStr[1]));
        	zoomMenu.add(new JMenuItem(viewMenuItemsStr[2]));
        	
        	zoomMenu.setForeground(foreground);
        	zoomMenu.setBackground(colorsecondary);
        	zoomMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
        	
        	zoomMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(colorprimary, 2));
        	zoomMenu.getPopupMenu().setBackground(colorsecondary);
        	
        	for(int x=0;x<3;x++) {
        		zoomMenu.getPopupMenu().getComponent(x).setForeground(foreground);
        		zoomMenu.getPopupMenu().getComponent(x).setBackground(colorsecondary);
        		((JComponent) zoomMenu.getPopupMenu().getComponent(x)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	}
    

        	JMenu fileMenu = new JMenu("File");
        	for (int x=0; x < fileMenuItemsStr.length;x++) {
        		if(x == 5 || x==7 ) {
					JSeparator separator = new JSeparator();
					separator.setBackground(colorprimary);
					separator.setForeground(colorprimary);
					separator.setBorder(BorderFactory.createLineBorder(colorprimary, 1));
					fileMenu.add(separator);
				} 
        		
				JMenuItem menuItem = new JMenuItem(fileMenuItemsStr[x]);
				menuItem.setForeground(foreground);
				menuItem.setBackground(colorsecondary);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
        	    fileMenu.add(menuItem);
				
        	}
        	

        	JMenu editMenu = new JMenu("Edit");
			for (int x = 0; x < editMenuItemsStr.length; x++) {
				if(x == 1 || x==6 || x==8 || x==9 || x==14||x==17) {
					JSeparator separator = new JSeparator();
					separator.setBackground(colorprimary);
					separator.setForeground(colorprimary);
					separator.setBorder(BorderFactory.createLineBorder(colorprimary, 2));
					editMenu.add(separator);
				} 
        		
				JMenuItem menuItem = new JMenuItem(editMenuItemsStr[x]);
				menuItem.setForeground(foreground);
				menuItem.setBackground(colorsecondary);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				editMenu.add(menuItem);
				
			}
			
			
            JMenu viewMenu = new JMenu("View");
			for (int x = 0; x < viewMenuItemsStr.length; x++) {
				if(x==0) {
					viewMenu.add(zoomMenu);
				} else if(x == 3 || x==4) {
				JMenuItem menuItem = new JMenuItem(viewMenuItemsStr[x]);
				menuItem.setForeground(foreground);
				menuItem.setBackground(colorsecondary);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				viewMenu.add(menuItem);
				}
			}

            	
        	JMenuBar menuBar = new JMenuBar();
        	fileMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	editMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	viewMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	menuBar.add(fileMenu);
        	menuBar.add(editMenu);
        	menuBar.add(viewMenu);
        	
        menuBar.setBackground(colorprimary);
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        viewMenu.setForeground(foreground);
        viewMenu.setBackground(colorprimary);
        viewMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(colorprimary, 2));
        viewMenu.getPopupMenu().setBackground(colorsecondary);
        
        editMenu.setForeground(foreground);
        editMenu.setBackground(colorprimary);
        editMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(colorprimary, 2));
        editMenu.getPopupMenu().setBackground(colorsecondary);
        
        fileMenu.setForeground(foreground);
        fileMenu.setBackground(colorsecondary);
        fileMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(colorprimary, 2));
        fileMenu.getPopupMenu().setBackground(colorsecondary);
        
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
