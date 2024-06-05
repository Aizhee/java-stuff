package act17;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.*;

// CustomComboBoxUI.java
public class CustomComboBoxUI extends BasicComboBoxUI {
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
			private static final long serialVersionUID = 1L;

            protected void configurePopup() {
                super.configurePopup();
                setOpaque(false);
            }
        };
    }

    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(new Color(50, 50, 50));
        button.setBorder(BorderFactory.createLineBorder(new Color(32,32,32), 2));
        return button;
    }

	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        g2.fill(new RoundRectangle2D.Double(bounds.x, bounds.y, bounds.width, bounds.height, 5, 5));
        g2.dispose();
    }
}