package ven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class venven {

    public static void main(String[] args) {
        new MicrosoftWord();
    }
}

class MicrosoftWord extends JFrame {
    private JLabel statusbar;

    public MicrosoftWord() {
        setTitle("Microsoft Word");  // Set the title of the window
        setBackground(Color.BLACK);
        setSize(1216, 726);  // Set the size of the window
        setLocationRelativeTo(null);  // Center the window on the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // Specify what happens when the close button is clicked

        ImageIcon mswordIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\msword.png");
        setIconImage(mswordIcon.getImage());

        
        // Set dark mode colors
        Color backgroundColor = Color.BLACK;
        Color backgroundColor1 = new Color(45, 45, 45);
        Color textColor = new Color(255, 255, 255);

        
        
        // Create a menu bar
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(backgroundColor);
        menubar.setForeground(textColor);

        // Create the "File" menu
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.setBackground(backgroundColor);
        file.setForeground(textColor);
        file.getPopupMenu().setBackground(new Color(56, 52, 52));
        file.getPopupMenu().setForeground(textColor);

        // Create the "Home" menu item with an icon
        ImageIcon homeIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\homeImage.png");
        JMenuItem FileHome = new JMenuItem("Home", homeIcon);
        FileHome.setMnemonic(KeyEvent.VK_HOME);
        FileHome.setBackground(new Color (56, 52, 52));
        FileHome.setForeground(textColor);
        file.add(FileHome);		// Add "Home" menu item to "File" menu

        // Create sub-menu items under "File"
        ImageIcon newIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\newImage.png");
        JMenuItem fileNew = new JMenuItem("New", newIcon);
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileNew.setBackground(new Color (56, 52, 52));
        fileNew.setForeground(textColor);
        file.add(fileNew);

        ImageIcon openIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\openImage.png");
        JMenuItem fileOpen = new JMenuItem("Open", openIcon);
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setBackground(new Color (56, 52, 52));
        fileOpen.setForeground(textColor);
        file.add(fileOpen);
        
        JMenuItem fileInfo = new JMenuItem("Info");
        fileInfo.setMnemonic(KeyEvent.VK_I);
        fileInfo.setBackground(new Color (56, 52, 52));
        fileInfo.setForeground(textColor);

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileSave.setBackground(new Color (56, 52, 52));
        fileSave.setForeground(textColor);

        // Create "Save As" submenu
        JMenu saveAsSubMenu = new JMenu("Save As");
        saveAsSubMenu.setMnemonic(KeyEvent.VK_A);
        saveAsSubMenu.getPopupMenu().setBackground(new Color (56, 52, 52));
        saveAsSubMenu.getPopupMenu().setForeground(textColor);
        saveAsSubMenu.setBackground(new Color (56, 52, 52));
        saveAsSubMenu.setForeground(textColor);

        // Create sub-items for "Save As" submenu
        ImageIcon pcIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\pcImage.png");
        JMenuItem saveAsThisPC = new JMenuItem("This PC", pcIcon);
        saveAsThisPC.setBackground(new Color(56, 52, 52));
        saveAsThisPC.setForeground(textColor);

        ImageIcon addIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\addImage.png");
        JMenuItem saveAsAddPlace = new JMenuItem("Add Place", addIcon);
        saveAsAddPlace.setBackground(new Color(56, 52, 52));
        saveAsAddPlace.setForeground(textColor);

        ImageIcon browseIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\browseImage.png");
        JMenuItem saveAsBrowse = new JMenuItem("Browse", browseIcon);
        saveAsBrowse.setBackground(new Color(56, 52, 52));
        saveAsBrowse.setForeground(textColor);

        // Add sub-items to "Save As" submenu
        saveAsSubMenu.add(saveAsThisPC);
        saveAsSubMenu.add(saveAsAddPlace);
        saveAsSubMenu.add(saveAsBrowse);

       
        ImageIcon printIcon = new ImageIcon("C:\\Users\\Reigven\\Downloads\\printImage.png");
        JMenuItem filePrint = new JMenuItem("Print", printIcon);
        filePrint.setMnemonic(KeyEvent.VK_P);
        filePrint.setBackground(new Color (56, 52, 52));
        filePrint.setForeground(textColor);

        JMenuItem fileShare = new JMenuItem("Share");
        fileShare.setMnemonic(KeyEvent.VK_H);
        fileShare.setBackground(new Color (56, 52, 52));
        fileShare.setForeground(textColor);

        JMenuItem fileClose = new JMenuItem("Close");
        fileClose.setMnemonic(KeyEvent.VK_C);
        fileClose.setToolTipText("Exit application");
        fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        fileClose.setBackground(new Color (56, 52, 52));
        fileClose.setForeground(textColor);
        fileClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create the "Export" sub-menu under "File"
        JMenu exp = new JMenu("Export");
        exp.setMnemonic(KeyEvent.VK_E);
        exp.setBackground(new Color (56, 52, 52));
        exp.setForeground(textColor);
        exp.getPopupMenu().setBackground(new Color (56, 52, 52));
        exp.getPopupMenu().setForeground(textColor);
        
        
        JMenuItem subExpButton = new JMenuItem("Create PDF/XPS Document");
        subExpButton.setBackground(new Color (56, 52, 52));
        subExpButton.setForeground(textColor);

        JMenuItem subExpButton1 = new JMenuItem("Change File Type");
        subExpButton1.setBackground(new Color (56, 52, 52));
        subExpButton1.setForeground(textColor);

        exp.add(subExpButton);
        exp.add(subExpButton1);

        // Add menu items to the "File" menu
        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileInfo);
        file.add(fileSave);
        file.add(saveAsSubMenu);
        file.add(filePrint);
        file.add(fileShare);
        file.addSeparator();
        file.add(exp);
        file.addSeparator();
        file.add(fileClose);

        // Add the "File" menu to the menu bar
        menubar.add(file);

        // Set the menu bar to the frame
        setJMenuBar(menubar);

        // Create a text area with a scroll pane
        JTextArea textArea = new JTextArea();
        textArea.setBackground(backgroundColor1);
        textArea.setForeground(textColor);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.getViewport().setBackground(backgroundColor);

        // Set background and foreground colors for the frame
        getContentPane().setBackground(backgroundColor1);
        getContentPane().setForeground(textColor);

        getContentPane().add(scrollPane);
        setVisible(true);
    }
}