package act15;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;


/*
 * Aizhar Jamilano
 * BSCpE II - GF | CPE05 - OOP
 * 
 * Activity 15: Images (Image Icon and Buffer Image)
 * 
 */
public class act15 extends Designer{
	
	// Custom colors constants
	
	act15() {
		JFrame frame = new JFrame("Untitled Document - Word 2021");
  
        JPanel paper = new JPanel();
        paper.setBackground(Colors.COLOR_SECONDARY);
        paper.setBorder(BorderFactory.createEmptyBorder(50, 70, 50, 70));
        paper.setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea(30, 20);
       
        textArea.setBackground(Colors.COLOR_PAPER);
        textArea.setForeground(Colors.COLOR_TEXT);
        textArea.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        textArea.setCaretColor(Colors.COLOR_FOREGROUND);
        textArea.putClientProperty("caretWidth", 2);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        paper.add(textArea, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(paper);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("src/word.png").getImage());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPane.getVerticalScrollBar().setUI(new CustomRoundedScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomRoundedScrollBarUI());
        scrollPane.getVerticalScrollBar().setBackground(Colors.COLOR_SECONDARY);
        scrollPane.getHorizontalScrollBar().setBackground(Colors.COLOR_SECONDARY);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        //show vertical scrollbar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Colors.COLOR_SECONDARY);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        JLabel status = new JLabel("Page 1 of 1      0  words       ◘ English (Philippines)          ◙ Display Settings   □ Focus             - ----█-+------ + 72%");
        
		textArea.addCaretListener(new CaretListener() {
		public void caretUpdate(CaretEvent e){
			int caretPos = textArea.getCaretPosition();
			for (int offset = caretPos; offset > 0;) {
				try {
					offset = javax.swing.text.Utilities.getRowStart(textArea, offset) - 1;
				} catch (javax.swing.text.BadLocationException e1) {
					e1.printStackTrace();
				}
			}
			status.setText("Page 1 of 1      " + textArea.getText().split("\\s+").length
					+ " words       ◘ English (Philippines)          ◙ Display Settings   □ Focus             - ----█-+------ + 72%");
		}});
        
        status.setBorder(null);
        status.setFont(new Font("Consolas", Font.PLAIN, 15));
        statusPanel.add(status);
        statusPanel.setBackground(Colors.COLOR_PRIMARY);
        status.setForeground(Colors.COLOR_FOREGROUND);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(statusPanel, BorderLayout.SOUTH);

        // File Menu Items and Icons and Mnemonics
        String[] fileMenuItemsStr = {
        	    " ","Home",null,null,"Get Add-ins","Page Setup","Info","Save",null,"Save as Adobe PDF","History",
        	    null,null,null,"Transform","Close","Account","Feedback","Options"};
       
       String[] fileMenuicons = {"src/back.png","src/home.png",null,null,"src/addin.png", null, null, "src/save.png",null,"src/pdf.png", null, null, null, null, null, "src/close.png", "src/account.png", "src/feedback.png", "src/options.png"};
       char[] fileMenuMnemonics = {'.','M','N','O','G','G','I','S','A','U','8','R','H','E','T','C','T','F','I'};

       //Submenu declaration
       JMenu[] submenu = { new JMenu("New"), new JMenu("Open"), new JMenu("Save As"), new JMenu("Print"), new JMenu("Share"), new JMenu("Export") };
       String[] submenuIcons = { "src/new.png", "src/open.png", "src/saveas.png", "src/print.png", "src/share.png", "src/export.png" };
       char[] submenuMnemonics = { 'N', 'O', 'A', 'P', 'H', 'E' };
		for (int x = 0; x < submenu.length; x++) {
			submenu[x].setIcon(new ImageIcon(new ImageIcon(submenuIcons[x]).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
			submenu[x].setMnemonic(submenuMnemonics[x]);
			design(submenu[x]);
		}

       
       //NewSubMenu title and icons
       JMenuItem [] NewSubMenu = { new JMenuItem("Blank Document"), new JMenuItem("Template"), new JMenuItem("Existing Document") };
       String [] NewSubMenuIcons ={ "src/file.png", "src/template.png", "src/existing.png" };
       
       //add submenu to new menu
       addItemsToSubMenu(NewSubMenu, NewSubMenuIcons, submenu[0], "src/file.png");
       
       //OpenSubMenu title and icons
       JMenuItem [] OpenSubMenu = { new JMenuItem("OneDrive"), new JMenuItem("Browse"), new JMenuItem("Recent") };
       String [] OpenSubMenuIcons ={ "src/onedrive.png", "src/folder.png", "src/recent.png" };
       
       //add submenu to open menu
	   addItemsToSubMenu(OpenSubMenu, OpenSubMenuIcons, submenu[1], "src/folder.png");
       
       //SaveAsSubMenu title and icons .docx .docm .xps .pdf 
       JMenuItem [] SaveAsSubMenu = { new JMenuItem("Word Document"), new JMenuItem("Word Macro-Enabled Document"), new JMenuItem("XPS Document"), new JMenuItem("PDF Document") };
       String [] SaveAsSubMenuIcons = { "src/word.png", "src/wordmacro.png", "src/xps.png", "src/pdf.png" };
       
       //add submenu to save as menu
       addItemsToSubMenu(SaveAsSubMenu, SaveAsSubMenuIcons, submenu[2], "src/saveas.png");
       
       //PrintSubMenu title and icons
       JMenuItem [] PrintSubMenu = { new JMenuItem("Print"), new JMenuItem("Quick Print"), new JMenuItem("Print Preview"), new JMenuItem("Print Setup") };
       String [] PrintSubMenuIcons ={ "src/print.png", "src/quickprint.png", "src/preview.png", "src/setup.png" };
       
       //add submenu to print menu
       addItemsToSubMenu(PrintSubMenu, PrintSubMenuIcons, submenu[3], "src/print.png");
            
       
       //ShareSubMenu title and icons
       JMenuItem [] ShareSubMenu = { new JMenuItem("People"), new JMenuItem("Email"), new JMenuItem("Present Online"), new JMenuItem("Blog") };
       String [] ShareSubMenuIcons = {"src/people.png","src/email.png","src/present.png","src/blog.png" };
       
       //add submenu to share menu
	   addItemsToSubMenu(ShareSubMenu, ShareSubMenuIcons, submenu[4], "src/share.png");
       
       //ExportSubMenu title and icons
       JMenuItem [] ExportSubMenu = { new JMenuItem("Create PDF/XPS"), new JMenuItem("Create Video"), new JMenuItem("Create Handouts"), new JMenuItem("Create Blog Post") };
       String [] ExportSubMenuIcons = {"src/pdf.png","src/video.png","src/handouts.png","src/blog.png"};

       //add submenu to export menu
       addItemsToSubMenu(ExportSubMenu, ExportSubMenuIcons, submenu[5], "src/export.png");
               
       JMenu fileMenu = new JMenu("File");
       fileMenu.setIcon(new ImageIcon(new ImageIcon("src/word.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
       fileMenu.setMnemonic('F');
       //submenu index counter
       int sub = 0;
       
       for (int x=0; x < fileMenuItemsStr.length;x++) {
    		if(x == 4||x==16 ) {
				JSeparator separator = new JSeparator();
				separator.setBackground(Colors.COLOR_PRIMARY);
				separator.setForeground(Colors.COLOR_PRIMARY);
				separator.setBorder(BorderFactory.createLineBorder(Colors.COLOR_PRIMARY, 1));
				fileMenu.add(separator);
			} 
    		
    		// Menu item with submenu
    		if (fileMenuItemsStr[x] == null) {
    			design(submenu[sub]);
				fileMenu.add(submenu[sub]);
				sub++;
				
    		} else {
    		// Maka a menu item
    		JMenuItem menuItem = new JMenuItem(fileMenuItemsStr[x]);

			if (x == 10 || x == 14) 
				menuItem.setEnabled(false);
			if (fileMenuicons[x]!=null) 
				menuItem.setIcon(new ImageIcon(new ImageIcon(fileMenuicons[x]).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
			if (x != 0)
				menuItem.setMnemonic(fileMenuMnemonics[x]);
			if (x == 15) {
				menuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
			}
			design(menuItem);
			
			fileMenu.add(menuItem);
			}
        }
        
    	fileMenu.getPopupMenu().setSize(200, 200);
		 	
    	JMenuBar menuBar = new JMenuBar();
    	fileMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    	menuBar.add(fileMenu);
    	
    	ImageIcon ribbon = new ImageIcon(new ImageIcon("src/ribbon.png").getImage().getScaledInstance(1040, 100, Image.SCALE_SMOOTH));
    	JLabel ribbonLabel = new JLabel(ribbon);
    	ribbonLabel.setBackground(Colors.COLOR_PRIMARY);
    	frame.add(ribbonLabel, BorderLayout.NORTH);
        	
        menuBar.setBackground(Colors.COLOR_PRIMARY);
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        
        fileMenu.setForeground(Colors.COLOR_FOREGROUND);
        fileMenu.setBackground(Colors.COLOR_SECONDARY);
        fileMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Colors.COLOR_PRIMARY, 2));
        fileMenu.getPopupMenu().setBackground(Colors.COLOR_SECONDARY);
        
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1040, 650);
        frame.setResizable(false);
 
        frame.setVisible(true);
    }
	
    public static void main(String[] args) throws IOException {
        new act15();
    }
}

