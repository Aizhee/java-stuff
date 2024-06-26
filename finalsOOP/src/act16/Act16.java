package act16;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;
/*
 * Aizhar Jamilano
 * BSCpE II - GF | CPE05 - OOP
 * 
 * Activity 16: Menu and Submenu
 * 
 */
public class Act16 {
	// New File
	private File file = new File("placeholder.txt");
	
	Act16() {
		// Create a new JFrame
		JFrame frame = new JFrame("Notepad");
		frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("src/notepad.png").getImage());
        
        // Set the size of the frame
        JTextArea textArea = new JTextArea(20, 60);
        textArea.setBackground(Colors.SECONDARY);
        textArea.setForeground(Colors.FOREGROUND);
        textArea.setBorder(null);
        textArea.setCaretColor(Colors.FOREGROUND);
        textArea.putClientProperty("caretWidth", 2);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        
        //Undo the last action using Undo Manager in javax.swing
		UndoManager undoManager = new UndoManager();
		textArea.getDocument().addUndoableEditListener(undoManager);
		
		// JScrollPane for the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPane.getVerticalScrollBar().setUI(new CustomRoundedScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomRoundedScrollBarUI());
        scrollPane.getVerticalScrollBar().setBackground(Colors.SECONDARY);
        scrollPane.getHorizontalScrollBar().setBackground(Colors.SECONDARY);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
        
        //show vertical scrollbar
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Colors.SECONDARY);
        
        // Status Bar
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
		
        // Status Bar Label
        JLabel status = new JLabel("Ln 1 , Col 1      | 0 characters                             | 100%    | Windows (CRLF)             | UTF-8");
        
        // Add a caret listener to the text area to update the status bar
        textArea.addCaretListener(new CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent e) {
                try {
                    // Get the caret position
                    int caretPos = textArea.getCaretPosition();
                    // Get the font size
                    int fontSize = textArea.getFont().getSize();
                    // Get the line number
                    int line = textArea.getLineOfOffset(caretPos) + 1;  // +1 to make it 1-based index
                    // Get the column number
                    int col = caretPos - textArea.getLineStartOffset(line - 1) + 1;  // +1 to make it 1-based index
                    // Get the character count
                    int charCount = textArea.getText().length();
                    // Calculate the font size percentage
                    int fontSizePercentage = (int) ((fontSize / 20.0) * 100);
        			// Update the status bar
        			status.setText("Ln " + line + " , Col " + col + "      | " + charCount
        					+ " characters                             | " + fontSizePercentage
        					+ "%    | Windows (CRLF)             | UTF-8");
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        //Listener for changes in fontsizes of textArea
		textArea.addPropertyChangeListener("font", e -> {
			int line = 1;
			int col = 1;
			int charCount = textArea.getText().length();
			int fontSize = textArea.getFont().getSize();
			//make 20 the 100% 
			int fontSizePercentage = (int) ((fontSize / 20.0) * 100);
			// Update the status bar
			status.setText("Ln " + line + " , Col " + col + "      | " + charCount
					+ " characters                             | " + fontSizePercentage
					+ "%    | Windows (CRLF)             | UTF-8");
		});

        
        // Set the font of the status bar label
        status.setBorder(null);
        statusPanel.add(status);
        statusPanel.setBackground(Colors.PRIMARY);
        status.setForeground(Colors.FOREGROUND);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(statusPanel, BorderLayout.SOUTH);

        // File Menus Title
        String[] fileMenuItemsStr = {"New File", "New Window", "Open", "Save", "Save As", "Save All", "Print", "Close", "Close Window", "Exit" };
        
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
                        	// Check if the text area is empty
                        	if (!textArea.getText().isEmpty()) {
                        		// Ask the user if they want to save the changes
                        	int choice = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
	                        
                        	if (choice == JOptionPane.YES_OPTION) {
		                        	PrintWriter printWriter;
		                        	try {
		                        		printWriter = new PrintWriter(file);
		                        		printWriter.print(textArea.getText());
		                        		printWriter.close();
		                        	} catch (FileNotFoundException ex) {
		                        		ex.printStackTrace();
		                        	}
		                    } else if (choice == JOptionPane.NO_OPTION) {
		                        	    textArea.setText("");
                        	} 
                        }
                    }},// New Window
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
	                    // Save the text in the text area to a temporary file
						try {
							printWriter = new PrintWriter(file);
							printWriter.print(textArea.getText());
							printWriter.close();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						}
						
						// Print the temporary file
						try {
							Desktop.getDesktop().print(file);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
				},// Close 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Close the current file
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
		// Edit Menus Title
        String[] editMenuItemsStr = {"Undo","Cut","Copy","Paste","Delete","Find","Find Next","Find Previous","Replace","Go To","Select All","Time/Date","Font"};
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
        				if (undoManager.canUndo()) 
        					undoManager.undo();
        			}
        		},
        		// Cut
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				textArea.cut();
        			}
        		},
        		// Copy
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				textArea.copy();
        			}
        		},
        		// Paste
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				textArea.paste();
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
        				
        				JFrame findFrame = new JFrame("Find");
        				findFrame.setSize(300, 100);
        				findFrame.setLayout(new FlowLayout());
        				findFrame.setLocationRelativeTo(frame);
        				findFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				findFrame.setResizable(false);
        				
        				findFrame.setIconImage(new ImageIcon("src/notepad.png").getImage());
        				
        				JTextField findTextField = new JTextField(20);

        				//get highlighted text
        				String selectedText = textArea.getSelectedText();
        				  if (selectedText != null) 
        				       findTextField.setText(selectedText);
        				                        
        				JButton findButton = new JButton("Find");
						findButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String text = textArea.getText();
								String find = findTextField.getText();
								int index = text.indexOf(find, textArea.getCaretPosition());
								// Cycle to the beginning of the text if the end of the text is reached
								if (index == -1) {
									index = text.indexOf(find);
								}
								// Highlight the found text
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
        				
        				//get highlighted text
        				String selectedText = textArea.getSelectedText();
						if (selectedText != null) {
							String text = textArea.getText();
							int index = text.indexOf(selectedText, textArea.getCaretPosition());
							//Cycle to the beginning of the text if the end of the text is reached
							if (index == -1) {
								index = text.indexOf(selectedText);
							}
							//Highlight the found text
							if (index != -1) {
								textArea.setCaretPosition(index);
								textArea.moveCaretPosition(index + selectedText.length());
							}
						}
        			}
        		},
        		// Find Previous
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				//get highlighted text
        				String selectedText = textArea.getSelectedText();
                        if (selectedText != null) {
							String text = textArea.getText();
							int index = text.lastIndexOf(selectedText, textArea.getCaretPosition());
							// Cycle to the end of the text if the beginning of the text is reached
							if (index == -1) {
								index = text.lastIndexOf(selectedText);
							}
							// Highlight the found text
							if (index != -1) {
								textArea.setCaretPosition(index);
								textArea.moveCaretPosition(index + selectedText.length());
							}
        				    }
        			}
        		},
        		// Replace
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				JFrame replaceFrame = new JFrame("Replace");
        				replaceFrame.setSize(300, 150);
        				replaceFrame.setLayout(new FlowLayout());
        				replaceFrame.setLocationRelativeTo(frame);
        				replaceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				replaceFrame.setResizable(false);
        				
        				JTextField findTextField = new JTextField(20);
        				JTextField replaceTextField = new JTextField(20);
        				
        				//get highlighted text
						String selectedText = textArea.getSelectedText();
						if (selectedText != null)
							findTextField.setText(selectedText);

						JButton replaceButton = new JButton("Replace");
						replaceButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
                                String text = textArea.getText();
                                String find = findTextField.getText();
                                String replace = replaceTextField.getText();
                                int index = text.indexOf(find);
                                if (index != -1) {
                                    textArea.replaceRange(replace, index, index + find.length());
                                }
                            }
                        });
						
						replaceFrame.add(findTextField);
						replaceFrame.add(replaceTextField);
						replaceFrame.add(replaceButton);
						
						replaceFrame.setVisible(true);
        				
        			}
        		},
        		// Go To
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				JFrame gotoFrame = new JFrame("Go To");
        				gotoFrame.setSize(300, 100);
        				gotoFrame.setLayout(new FlowLayout());
        				gotoFrame.setLocationRelativeTo(frame);
        				gotoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				gotoFrame.setResizable(false);
        				
        				JTextField gotoTextField = new JTextField(20);
        				
        				JButton gotoButton = new JButton("Go To");
        				
        	            gotoButton.addActionListener(new ActionListener() {
        					public void actionPerformed(ActionEvent e) {
        						int lineNumber = Integer.parseInt(gotoTextField.getText());
        						try {
        							textArea.setCaretPosition(textArea.getLineStartOffset(lineNumber - 1));
        						} catch (BadLocationException ex) {
        							ex.printStackTrace();
        						}
        					}
        				});
        				
        	           gotoFrame.add(gotoTextField);
        	           gotoFrame.add(gotoButton);
        	           gotoFrame.setVisible(true);
        	                    				        				
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
        			    textArea.append(new java.text.SimpleDateFormat("HH:mm MM/dd/yyyy").format(new Date()));
        			}
        		},
        		// Font
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        				JFrame fontFrame = new JFrame("Font");
        				fontFrame.setSize(300, 100);
        				fontFrame.setLayout(new FlowLayout());
        				fontFrame.setLocationRelativeTo(frame);
        				fontFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				fontFrame.setResizable(false);
        				
        				JTextField fontTextField = new JTextField(20);
        				fontTextField.setText(textArea.getFont().getFontName());
        				
        				JButton fontButton = new JButton("Change Font");
        				    fontButton.addActionListener(new ActionListener() {
        				     public void actionPerformed(ActionEvent e) {
        				    	 textArea.setFont(new Font(fontTextField.getText(), Font.PLAIN, textArea.getFont().getSize()));
        				     }
        				});
        				    
        				    fontFrame.add(fontTextField);
        				    fontFrame.add(fontButton);
        				    fontFrame.setVisible(true);
        				
        			}
        		}
        	};
        	// View Menus Title
        	String[] viewMenuItemsStr = {"Zoom In","Zoom Out","Restore Default Zoom","Status Bar","Word Wrap"};
        	// Zoom In
        	JMenu zoomMenu = new JMenu("Zoom");
        	JMenuItem zoomIn = new JMenuItem(viewMenuItemsStr[0]);
        	JMenuItem zoomOut = new JMenuItem(viewMenuItemsStr[1]);
        	JMenuItem restoreZoom = new JMenuItem(viewMenuItemsStr[2]);
        	// Set key bindings for the zoom menu items
        	zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
        	zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        	restoreZoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, ActionEvent.CTRL_MASK));
        	
			import javax.swing.*;
			import java.awt.event.ActionEvent;
			import java.awt.event.ActionListener;
			
			public class AnonymousClassExample {
			
				public static void main(String[] args) {
					JFrame frame = new JFrame("Anonymous Class Example");
					JButton button = new JButton("Click Me");
			
					// Registering the ActionListener using an anonymous class
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("Button was clicked!");
						}
					});
			
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(300, 200);
					frame.setLayout(new java.awt.FlowLayout());
					frame.add(button);
					frame.setVisible(true);
				}
			}
			

        	// Zoom In
			zoomIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textArea.getFont().getSize() < 72) {
						textArea.setFont(new Font("Consolas", Font.PLAIN, textArea.getFont().getSize() + 2));
					}
				}
			});
			// Zoom Out
			zoomOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textArea.getFont().getSize() > 8) {
						textArea.setFont(new Font("Consolas", Font.PLAIN, textArea.getFont().getSize() - 2));
					}
				}
			});
			// Restore Default Zoom
			restoreZoom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setFont(new Font("Consolas", Font.PLAIN, 20));
				}
			});

			
        	
        	zoomMenu.add(zoomIn);
        	zoomMenu.add(zoomOut);
        	zoomMenu.add(restoreZoom);
        	
        	zoomMenu.setForeground(Colors.FOREGROUND);
        	zoomMenu.setBackground(Colors.SECONDARY);
        	zoomMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
        	
        	zoomMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 2));
        	zoomMenu.getPopupMenu().setBackground(Colors.SECONDARY);
        	
        	for(int x=0;x<3;x++) {
        		zoomMenu.getPopupMenu().getComponent(x).setForeground(Colors.FOREGROUND);
        		zoomMenu.getPopupMenu().getComponent(x).setBackground(Colors.SECONDARY);
        		((JComponent) zoomMenu.getPopupMenu().getComponent(x)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        	}
    

        	JMenu fileMenu = new JMenu("File");
        	fileMenu.setMnemonic(KeyEvent.VK_F);
        	for (int x=0; x < fileMenuItemsStr.length;x++) {
        		if(x == 5 || x==7 ) {
					JSeparator separator = new JSeparator();
					separator.setBackground(Colors.PRIMARY);
					separator.setForeground(Colors.PRIMARY);
					separator.setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 1));
					fileMenu.add(separator);
				} 
        		
				JMenuItem menuItem = new JMenuItem(fileMenuItemsStr[x]);
				menuItem.setForeground(Colors.FOREGROUND);
				menuItem.setBackground(Colors.SECONDARY);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
				
				menuItem.setAccelerator(fileMenuItemsKey[x]);
				menuItem.addActionListener(fileMenuItemsListener[x]);
				
				
        	    fileMenu.add(menuItem);
				
        	}
        	

        	JMenu editMenu = new JMenu("Edit");
        	editMenu.setMnemonic(KeyEvent.VK_E);
			for (int x = 0; x < editMenuItemsStr.length; x++) {
				if(x == 1 || x==6 || x==8 || x==9 || x==14||x==17) {
					JSeparator separator = new JSeparator();
					separator.setBackground(Colors.PRIMARY);
					separator.setForeground(Colors.PRIMARY);
					separator.setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 2));
					editMenu.add(separator);
				} 
        		
				JMenuItem menuItem = new JMenuItem(editMenuItemsStr[x]);
				menuItem.setForeground(Colors.FOREGROUND);
				menuItem.setBackground(Colors.SECONDARY);
				menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				menuItem.addActionListener(editMenuItemsListener[x]);
				menuItem.setAccelerator(editMenuItemsKey[x]);
				editMenu.add(menuItem);
				
			}
			
			
            JMenu viewMenu = new JMenu("View");
            viewMenu.setMnemonic(KeyEvent.VK_V);
			for (int x = 0; x < viewMenuItemsStr.length; x++) {
				if(x==0) {
					viewMenu.add(zoomMenu);
				} else if(x == 3 || x==4) {
				JCheckBoxMenuItem menuItem = new JCheckBoxMenuItem(viewMenuItemsStr[x]);
				menuItem.setState(true);
				menuItem.setForeground(Colors.FOREGROUND);
				menuItem.setBackground(Colors.SECONDARY);
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
        	
        menuBar.setBackground(Colors.PRIMARY);
        menuBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        viewMenu.setForeground(Colors.FOREGROUND);
        viewMenu.setBackground(Colors.PRIMARY);
        viewMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 2));
        viewMenu.getPopupMenu().setBackground(Colors.SECONDARY);
        
        editMenu.setForeground(Colors.FOREGROUND);
        editMenu.setBackground(Colors.PRIMARY);
        editMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 2));
        editMenu.getPopupMenu().setBackground(Colors.SECONDARY);
        
        fileMenu.setForeground(Colors.FOREGROUND);
        fileMenu.setBackground(Colors.PRIMARY);
        fileMenu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Colors.PRIMARY, 2));
        fileMenu.getPopupMenu().setBackground(Colors.SECONDARY);
        
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
