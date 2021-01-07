package com.root101.swing.material.components.glasspane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import com.root101.swing.util.MaterialDrawingUtils;

/**
 *
 * @author Filthy Rich Clients Book
 */
public class CustomGlassPane extends JComponent {

    public CustomGlassPane() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        Rectangle clip = g.getClipBounds();
        Color alphaWhite = new Color(1.0f, 1.0f, 1.0f, 0.65f);
        g2.setColor(alphaWhite);
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }

    /**
     * Hide the Glass Pane. Set up it's visibility to false.
     */
    public void hideMe() {
        this.setVisible(false);
    }

    /**
     * Show the Glass Pane. Set up it's visibility to true.
     */
    public void showMe() {
        this.setVisible(true);
    }
}
