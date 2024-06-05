package act15;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

//Custom Scroll Bar UI
public class CustomRoundedScrollBarUI extends BasicScrollBarUI {
	private final int ARC_WIDTH = 5;
	private final int ARC_HEIGHT = 5;
	private final Color COLOR_SECONDARY = new Color(26,32,45,255);
	private final Color COLOR_FOREGROUND = new Color(169,171,176,255);

	protected JButton createDecreaseButton(int orientation) {
		return createArrowButton();
	}

	protected JButton createIncreaseButton(int orientation) {
		return createArrowButton();
	}

	private JButton createArrowButton() {
		JButton button = new JButton();
		button.setOpaque(true);
		button.setBackground(COLOR_SECONDARY);
		button.setBorder(BorderFactory.createLineBorder(COLOR_SECONDARY, 5));
		return button;
	}

	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(COLOR_SECONDARY);
		g2d.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(COLOR_FOREGROUND);
		g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, ARC_WIDTH, ARC_HEIGHT);
		g2d.dispose();
	}
}