package com.jhw.swing.material.components.container.tabbed;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su logica de edisoncorSX.
 */
public class _TabbedPaneHeader extends JTabbedPane implements MaterialComponent {

    public static _TabbedPaneHeader from() {
        return new _TabbedPaneHeader();
    }
    
    private static final Insets NO_INSETS = new Insets(0, 0, 0, 0);
    protected BufferedImage background = loadImage("/imgs/header_gradient.png");
    protected BufferedImage buttonHighlight = loadImage("/imgs/header_halo.png");
    protected Color colorDeSombra = new Color(173, 173, 173);
    protected BufferedImage left = loadImage("/imgs/header_slash_left.png");
    protected BufferedImage right = loadImage("/imgs/header_slash_right.png");

    private class TabbedPaneUI extends BasicTabbedPaneUI {

        private int buttonHeight;
        private int leftInset;

        private TabbedPaneUI() {
            this.buttonHeight = _TabbedPaneHeader.this.background.getHeight();
            this.leftInset = 0;
        }

        protected void installComponents() {
            super.installComponents();
        }

        protected void installDefaults() {
            super.installDefaults();
            this.tabAreaInsets.left = this.leftInset;
            this.selectedTabPadInsets = new Insets(0, 0, 0, 0);
        }

        public int getTabRunCount(JTabbedPane pane) {
            return super.getTabRunCount(pane);
        }

        protected Insets getContentBorderInsets(int tabPlacement) {
            return _TabbedPaneHeader.NO_INSETS;
        }

        protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
            if (tabPlacement == tabIndex) {
                return this.buttonHeight;
            }
            return this.buttonHeight;
        }

        protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
            return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + this.buttonHeight;
        }

        protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            int y = 0;
            int tw = this.tabPane.getBounds().width;
            int th = this.buttonHeight;
            try {
                th = this.rects[selectedIndex].height;
            } catch (Exception e) {
            }
            if (tabPlacement == 3) {
                y = _TabbedPaneHeader.this.getHeight() - th;
            }
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            g2.setPaint(gradiente(0, y, th));
            g2.drawImage(_TabbedPaneHeader.this.background, 0, y, tw, th, null);
            super.paintTabArea(g, tabPlacement, selectedIndex);
        }

        private Paint gradiente(int x, int y, int th) {
            return new LinearGradientPaint((float) x, (float) y, (float) x, (float) (y + th), new float[]{0.0f, 0.5f, 1.0f}, new Color[]{Color.white, _TabbedPaneHeader.this.getBackground().brighter(), _TabbedPaneHeader.this.getBackground()});
        }

        @Override
        protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            super.paintTab(g2, tabPlacement, rects, tabIndex, iconRect, textRect);
        }

        @Override
        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int tx, int ty, int tw, int th, boolean isSelected) {
            int count = _TabbedPaneHeader.this.getTabCount();
            Graphics2D g2d = MaterialDrawingUtils.getAliasedGraphics(g);
            if (tabPlacement == 1) {
                g2d.translate(tx, 0);
            }
            if (tabPlacement == 3) {
                g2d.translate(tx, ty);
            }

            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics((Graphics2D) g.create());
            g2.drawImage(_TabbedPaneHeader.this.background, 0, 0, tw, th, null);
            if (tabIndex != count - 1) {
                g2.drawImage(_TabbedPaneHeader.this.left, tw - _TabbedPaneHeader.this.left.getWidth(), 0, null);
            }
            if (tabIndex != 0) {
                g2.drawImage(_TabbedPaneHeader.this.right, 0, 0, null);
            }
            if (isSelected) {
                g2.drawImage(_TabbedPaneHeader.this.buttonHighlight, 0, 0, tw, th, null);
            }
            if (tabPlacement == 1) {
                g2d.translate(tx * -1, 0);
            }
            if (tabPlacement == 3) {
                g2d.translate(tx * -1, ty * -1);
            }
        }

        @Override
        protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
            Rectangle r = this.rects[tabIndex];
            Graphics2D g2d = MaterialDrawingUtils.getAliasedGraphics(g);
            if (tabPlacement == 1) {
                g2d.translate(r.x, 0);
            }
            if (tabPlacement == 3) {
                g2d.translate(r.x, r.y);
            }
            FontMetrics fm = getFontMetrics();
            TextLayout layout = new TextLayout(title, _TabbedPaneHeader.this.getFont(), g2d.getFontRenderContext());
            Rectangle2D bounds = layout.getBounds();
            g2d.setColor(_TabbedPaneHeader.this.colorDeSombra);
            int x = ((int) (((double) r.width) - bounds.getWidth())) / 2;
            int y = (((r.height - fm.getMaxAscent()) - fm.getMaxDescent()) / 2) + (fm.getAscent() - 1);
            layout.draw(g2d, (float) x, (float) y);
            if (isSelected) {
                g2d.setColor(_TabbedPaneHeader.this.getForeground());
            } else {
                g2d.setColor(_TabbedPaneHeader.this.getForeground().darker());
            }
            layout.draw(g2d, (float) x, (float) y);
            if (tabPlacement == 1) {
                g2d.translate(r.x * -1, 0);
            }
            if (tabPlacement == 3) {
                g2d.translate(r.x * -1, r.y * -1);
            }
        }

        @Override
        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        }

        @Override
        protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        }

        @Override
        protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        }
    }

    public _TabbedPaneHeader() {
        setFont(new Font("Arial", 1, 14));
        setForeground(Color.WHITE);
        setUI(new TabbedPaneUI());
    }

    private static BufferedImage loadImage(String fileName) {
        try (InputStream inputStream = _TabbedPaneHeader.class.getResourceAsStream(fileName)) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Image " + fileName + " wasn't loaded");
        }
    }

    public Color getColorDeBorde() {
        return this.colorDeSombra;
    }

    public void setColorDeBorde(Color colorDeBorde) {
        this.colorDeSombra = colorDeBorde;
    }

    public void setTabPlacement(int tabPlacement) {
        int i;
        int i2 = 1;
        if (tabPlacement == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (tabPlacement != 3) {
            i2 = 0;
        }
        if ((i2 | i) != 0) {
            super.setTabPlacement(tabPlacement);
        }
    }
}
