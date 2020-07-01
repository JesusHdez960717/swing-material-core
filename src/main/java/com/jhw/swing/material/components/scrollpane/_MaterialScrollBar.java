package com.jhw.swing.material.components.scrollpane;

import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import java.awt.Adjustable;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialScrollBar extends JScrollBar {

    public static int THUMB_WIDTH_FOCUSED = 10;
    public static int THUMB_WIDTH_UNFOCUSED = 5;

    private int width = 5;
    private boolean pressed = false;
    private boolean entered = false;

    private Color background = MaterialColors.WHITE;
    private Color foreground = MaterialColors.GREY_600;

    public _MaterialScrollBar(Color background, int orientation) {
        this(background, MaterialColors.GREY_600, orientation);
    }

    public _MaterialScrollBar(int orientation) {
        this(MaterialColors.WHITE, MaterialColors.GREY_600, orientation);
    }

    public Color getBackgroundThumb() {
        return background;
    }

    public void setBackgroundThumb(Color background) {
        this.background = background;
        repaint();
    }

    public Color getForegroundThumb() {
        return foreground;
    }

    public void setForegroundThumb(Color foreground) {
        this.foreground = foreground;
        repaint();
    }

    public _MaterialScrollBar(Color background, Color foreground, int orientation) {
        super(orientation);
        this.setBackgroundThumb(background);
        this.setForegroundThumb(foreground);
        
        setPreferredSize(new Dimension(width, 10));

        setUI(new BasicScrollBarUI() {
            @Override
            protected BasicScrollBarUI.ScrollListener createScrollListener() {
                setUnitIncrement(56);
                setBlockIncrement(560);
                return super.createScrollListener();
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(getBackgroundThumb());
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton dummyButton = new JButton();
                dummyButton.setPreferredSize(new Dimension(0, 0));
                return dummyButton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton dummyButton = new JButton();
                dummyButton.setPreferredSize(new Dimension(0, 0));
                return dummyButton;
            }

            @Override
            protected Dimension getMinimumThumbSize() {
                return new Dimension(5, 50);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                if (!thumbBounds.isEmpty() && this.scrollbar.isEnabled()) {
                    Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

                    boolean isVertical = _MaterialScrollBar.this.getOrientation()
                            == Adjustable.VERTICAL;
                    g2.setColor(getForegroundThumb());
                    g2.fillRoundRect(thumbBounds.x, thumbBounds.y,
                            width, thumbBounds.height,
                            isVertical ? thumbBounds.width : thumbBounds.height,
                            isVertical ? thumbBounds.width : thumbBounds.height);
                }
            }

            @Override
            public void layoutContainer(Container scrollbarContainer) {
                super.layoutContainer(scrollbarContainer);
                incrButton.setBounds(0, 0, 0, 0);
                decrButton.setBounds(0, 0, 0, 0);
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered();
                super.mouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited();
                super.mouseExited(evt);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                registerMouseReleased();
                super.mouseReleased(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                registerMousePressed();
                super.mousePressed(e);
            }

        });
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public int getThumbWidth() {
        return width;
    }

    private void registerMouseEntered() {
        entered = true;
        doAdjust();
    }

    private void registerMouseExited() {
        entered = false;
        doAdjust();
    }

    private void registerMousePressed() {
        pressed = true;
        doAdjust();
    }

    private void registerMouseReleased() {
        pressed = false;
        doAdjust();
    }

    private void doAdjust() {
        if (entered || pressed) {
            this.width = THUMB_WIDTH_FOCUSED;
        } else {
            this.width = THUMB_WIDTH_UNFOCUSED;
        }
        setPreferredSize(new Dimension(width, width));
        revalidate();
    }

    @Override
    public Component add(Component comp) {
        if (comp != null) {
            return super.add(comp);
        }
        return null;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(MaterialColors.RED_800);
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paint(g);
    }
}
