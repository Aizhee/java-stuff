package act16;


import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Act16 {
	
	private static Color colorprimary = new Color(0,10,37,255);
	private static Color colorsecondary = new Color(26,32,45,255);
	private static Color foreground = new Color(169,171,176,255);
	
	private static File file = new File("placeholder.txt");
	
	Act16() {
		JFrame frame = new JFrame("Notepad");
        JTextArea textArea = new JTextArea(20, 60);
        textArea.setBackground(colorsecondary);
        textArea.setForeground(foreground);
        textArea.setBorder(null);
        textArea.setCaretColor(foreground);
        textArea.putClientProperty("caretWidth", 2);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("src/notepad.png").getImage());
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

        // File Menus Title
        String[] fileMenuItemsStr = {
        	    "New File",
        	    "New Window",
        	    "Open",
        	    "Save",
        	    "Save As",
        	    "Save All",
        	    "Print",
        	    "Close",
        	    "Close Window",
        	    "Exit"
        };
        
        // File Menus Key Stroke
		KeyStroke[] fileMenuItemsKey = { 
					KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.ALT_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK),
					KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK) 
		};
		
		// File Menus Action Listener
		ActionListener[] fileMenuItemsListener = {
				// New File
					new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            textArea.setText("");
                        }
                    },// New Window
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                              // Create a new window
                        	  new Act16();
                              
                            }
                        },
                    // Open
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Open");
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						fileChooser.setAcceptAllFileFilterUsed(false);
						fileChooser.setMultiSelectionEnabled(false);
						fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text files", "txt"));
						fileChooser.setApproveButtonText("Open");
						fileChooser.setApproveButtonToolTipText("Open selected file");
						
						if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							file = fileChooser.getSelectedFile();
							textArea.setText("");
							try {
								Scanner scanner = new Scanner(fileChooser.getSelectedFile());
								while (scanner.hasNextLine()) {
									textArea.append(scanner.nextLine() + "\n");
								}
								scanner.close();
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}
						}
					}
				},// Save
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Save the text in the text area to the file
						PrintWriter printWriter;
						try {
							printWriter = new PrintWriter(file);
							printWriter.print(textArea.getText());
							printWriter.close();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						}
					}
				},
				// Save As
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
						if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							// Save the text in the text area to the selected file
							file = fileChooser.getSelectedFile();
							PrintWriter printWriter;
							try {
                                printWriter = new PrintWriter(file);
                                printWriter.print(textArea.getText());
                                printWriter.close();
                            } catch (FileNotFoundException ex) {
                                ex.printStackTrace();
                            }
						}
					}
				},// Save All
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Save all the text in the text areas to their respective files
						PrintWriter printWriter;
						try {
                            printWriter = new PrintWriter(file);
                            printWriter.print(textArea.getText());
                            printWriter.close();
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
					}
				},// Print
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Print the text in the text area
						File file = new File("print.txt");
	                    PrintWriter printWriter;
						try {
							printWriter = new PrintWriter(file);
							printWriter.print(textArea.getText());
							printWriter.close();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						}
	
						
						try {
							Desktop.getDesktop().print(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				},// Close 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				},// Close Window
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Close this specific window
						frame.dispose();
					}
				},// Exit
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
					
		};


        String[] editMenuItemsStr = {
        	    "Undo",
        	    "Cut",
        	    "Copy",
        	    "Paste",
        	    "Delete",
        	    "Find",
        	    "Find Next",
        	    "Find Previous",
        	    "Replace",
        	    "Go To",
        	    "Select All",
        	    "Time/Date",
        	    "Font"
        	};
        
        // Edit Menus Key Stroke
        KeyStroke[] editMenuItemsKey = {
        		KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0),
        		KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0),
        		KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.SHIFT_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK),
        		KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),
        		null
        };
        
        // Edit Menus Action Listener
        ActionListener[] editMenuItemsListener = {
        		// Undo
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//textArea.undo();
        			}
        		},
        		// Cut
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//textArea.cut();
        			}
        		},
        		// Copy
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//textArea.copy();
        			}
        		},
        		// Paste
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//textArea.paste();
        			}
        		},
        		// Delete
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				textArea.replaceSelection("");
        			}
        		},
        		// Find
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        				JFrame findFrame = new JFrame("Find");
        				findFrame.setSize(300, 100);
        				findFrame.setLayout(new FlowLayout());
        				findFrame.setLocationRelativeTo(frame);
        				findFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				findFrame.setResizable(false);
        				
        				JTextField findTextField = new JTextField(20);
        				JButton findButton = new JButton("Find");
						findButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String text = textArea.getText();
								String find = findTextField.getText();
								int index = text.indexOf(find);
								if (index != -1) {
									textArea.setCaretPosition(index);
									textArea.moveCaretPosition(index + find.length());
								}
							}
						});

						findFrame.add(findTextField);
						findFrame.add(findButton);
						findFrame.setVisible(true);
						
        			}
        		},
        		// Find Next
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        			}
        		},
        		// Find Previous
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        			}
        		},
        		// Replace
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        				
        			}
        		},
        		// Go To
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        				int line = Integer.parseInt(JOptionPane.showInputDialog("Enter Line Number: "));
        				try {
        					int start = textArea.getLineStartOffset(line - 1);
        					int end = textArea.getLineEndOffset(line - 1);
        					textArea.setCaretPosition(start);
        					textArea.moveCaretPosition(end);
        				} catch (BadLocationException ex) {
        					JOptionPane.showMessageDialog(null, "Invalid Line Number", "Error", JOptionPane.ERROR_MESSAGE);
        				
        			};
        			}
        		},
        		// Select All
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				textArea.selectAll();
        			}
        		},
        		// Time/Date
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        			    textArea.append(" " + new java.text.SimpleDateFormat("HH:mm MM/dd/yyyy").format(new Date()));
        			}
        		},
        		// Font
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//TODO
        			}
        		}
        };

        	String[] viewMenuItemsStr = {
        	    "Zoom In",
        	    "Zoom Out",
        	    "Restore Default Zoom",
        	    "Status Bar",
        	    "Word Wrap"
        	};

        	JMenu zoomMenu = new JMenu("Zoom");
        	JMenuItem zoomIn = new JMenuItem(viewMenuItemsStr[0]);
        	JMenuItem zoomOut = new JMenuItem(viewMenuItemsStr[1]);
        	JMenuItem restoreZoom = new JMenuItem(viewMenuItemsStr[2]);
        	
        	zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
        	zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
        	restoreZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
        	
        	
			zoomIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textArea.getFont().getSize() < 72) {
						textArea.setFont(new Font("Consolas", Font.PLAIN, textArea.getFont().getSize() + 2));
					}
				}
			});
			
			zoomOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textArea.getFont().getSize() > 8) {
						textArea.setFont(new Font("Consolas", Font.PLAIN, textArea.getFont().getSize() - 2));
					}
				}
			});
			
			restoreZoom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
				}
			});

			
        	
        	zoomMenu.add(zoomIn);
        	zoomMenu.add(zoomOut);
        	zoomMenu.add(restoreZoom);
        	
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
				
				menuItem.setAccelerator(fileMenuItemsKey[x]);
				menuItem.addActionListener(fileMenuItemsListener[x]);
				
				
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
				menuItem.addActionListener(editMenuItemsListener[x]);
				menuItem.setAccelerator(editMenuItemsKey[x]);
				editMenu.add(menuItem);
				
			}
			
			
            JMenu viewMenu = new JMenu("View");
			for (int x = 0; x < viewMenuItemsStr.length; x++) {
				if(x==0) {
					viewMenu.add(zoomMenu);
				} else if(x == 3 || x==4) {
				JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(viewMenuItemsStr[x]);
				menuItem.setState(true);
				menuItem.setForeground(foreground);
				menuItem.setBackground(colorsecondary);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				if (x == 3) {
					menuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						statusPanel.setVisible(!statusPanel.isVisible());
					}});
				} else {
					menuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textArea.setLineWrap(!textArea.getLineWrap());
						}
					});
				}
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
	
    public static void main(String[] args) {
        new Act16();
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

