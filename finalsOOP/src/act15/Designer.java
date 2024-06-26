package act15;

import java.awt.*;
import javax.swing.*;

public class Designer extends Colors {
	// overriding design method
	
	public void design(JMenu menu) {
		menu.setBackground(COLOR_SECONDARY);
		menu.setForeground(COLOR_FOREGROUND);
		menu.getPopupMenu().setBorder(null);
		menu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
	}
	
	public void design(JMenuItem menuItem) {
		menuItem.setBackground(COLOR_SECONDARY);
		menuItem.setForeground(COLOR_FOREGROUND);
		menuItem.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 4));
		menuItem.setUI(new StyledMenuItemUI());
    }
	
	
	public void addItemsToSubMenu(JMenuItem[] items, String[] icons, JMenu submenu, String menuicon) {
	    for (int i = 0; i < items.length; i++) {
	        JMenuItem menuItem = items[i];
	        menuItem.setIcon(new ImageIcon(new ImageIcon(icons[i]).getImage().getScaledInstance(20,
				20, Image.SCALE_SMOOTH)));
	        design(menuItem);
	        submenu.add(menuItem);
	    }
	    submenu.setIcon(new ImageIcon(new ImageIcon(menuicon).getImage().getScaledInstance(20,
	    		                20, Image.SCALE_SMOOTH)));
	}
	
	
	//style for menu items to change disabled color
	private class StyledMenuItemUI extends javax.swing.plaf.basic.BasicMenuItemUI {
		protected void paintText(java.awt.Graphics g, JMenuItem c, java.awt.Rectangle textRect,
				String text) {
			if (c.isEnabled()) {
				super.paintText(g, c, textRect, text);
			} else {
				java.awt.Color oldColor = g.getColor();
				g.setColor(COLOR_DISABLED);
				g.drawString(text, textRect.x, textRect.y + g.getFontMetrics().getAscent());
				g.setColor(oldColor);
			}
		}
	}
	

}
