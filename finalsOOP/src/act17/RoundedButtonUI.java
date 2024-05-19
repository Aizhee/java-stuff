package act17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

// Custom Button UI

public class RoundedButtonUI extends BasicButtonUI {

    private static final int ARC_WIDTH = 15;
    private static final int ARC_HEIGHT = 15;
    private static final float LIGHTEN_FACTOR = 0.3f; 

    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorderPainted(true);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
 
    }

    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getBackground(), b.getModel().isPressed());
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c, Color bgColor, boolean isPressed) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(isPressed ? lightenColor(bgColor) : bgColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = c.getWidth();
        int height = c.getHeight();
        g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, ARC_WIDTH, ARC_HEIGHT));
        g2d.dispose();
    }

    private Color lightenColor(Color color) {
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        return Color.getHSBColor(hsb[0], hsb[1], Math.min(1.0f, hsb[2] + LIGHTEN_FACTOR));
    }
}

