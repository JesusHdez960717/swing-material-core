package com.jhw.swing.material.components.container.tabbed;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Componente extraido su logica de edisoncorSX.
 */
public class _TabbedPaneSelector extends JTabbedPane implements MaterialComponent {

    public static _TabbedPaneSelector from() {
        return new _TabbedPaneSelector();
    }

    private static final Insets NO_INSETS = new Insets(7, 0, 7, 7);
    private Color colorBackGround = Color.BLACK;
    protected Color colorDeBorde = new Color(173, 173, 173);
    protected Color colorDeSegundoBorde = Color.WHITE;
    private Color listColor = Color.WHITE;
    private float listOpacity = 0.05f;
    private float selectionBorderOpacity = 0.8f;
    private Color selectionColor = Color.WHITE;
    private float selectionOpacity = 0.2f;

    private class TabbedPaneUI extends BasicTabbedPaneUI {

        private int buttonHeight;
        private int leftInset;

        private TabbedPaneUI() {
            this.buttonHeight = 27;
            this.leftInset = 12;
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
            return _TabbedPaneSelector.NO_INSETS;
        }

        protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
            return this.buttonHeight;
        }

        protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
            return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + this.buttonHeight;
        }

        protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
            int tw = this.tabPane.getBounds().width;
            int th = _TabbedPaneSelector.this.getHeight();
            try {
                tw = this.rects[selectedIndex].width;
            } catch (Exception e) {
            }
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

            Composite composite = g2.getComposite();
            g2.setColor(_TabbedPaneSelector.this.colorBackGround);
            g2.fillRect(0, 0, _TabbedPaneSelector.this.getWidth(), _TabbedPaneSelector.this.getHeight());
            g2.setComposite(AlphaComposite.getInstance(3, _TabbedPaneSelector.this.listOpacity));
            g2.setColor(_TabbedPaneSelector.this.listColor);
            RoundRectangle2D background = new Double(13.0d, 3.0d, ((double) tw) - 26.0d, ((double) _TabbedPaneSelector.this.getHeight()) - 6.0d, 10.0d, 10.0d);
            g2.fill(background);
            Stroke stroke = g2.getStroke();
            g2.setStroke(new BasicStroke(3.0f));
            g2.setComposite(AlphaComposite.getInstance(3, _TabbedPaneSelector.this.selectionBorderOpacity));
            g2.setColor(_TabbedPaneSelector.this.selectionColor);
            g2.draw(background);
            g2.drawRoundRect(tw - 2, 3, (_TabbedPaneSelector.this.getWidth() - tw) - 3, _TabbedPaneSelector.this.getHeight() - 6, 10, 10);
            g2.setComposite(AlphaComposite.getInstance(3, _TabbedPaneSelector.this.selectionOpacity));
            g2.fillRoundRect(tw - 2, 3, (_TabbedPaneSelector.this.getWidth() - tw) - 3, _TabbedPaneSelector.this.getHeight() - 6, 10, 10);
            g2.setStroke(stroke);
            g2.setComposite(composite);
            super.paintTabArea(g, tabPlacement, selectedIndex);
        }

        @Override
        protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
        }

        @Override
        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int tx, int ty, int tw, int th, boolean isSelected) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            if (tabPlacement == 2) {
                g2d.translate(0, 0);
            }
            if (tabPlacement == 4) {
                g2d.translate(tx - this.buttonHeight, 0);
            }
            if (isSelected) {
                paintSelection(g2d, tabIndex, tx, ty, tw, th);
            } else {
                g.setColor(_TabbedPaneSelector.this.getBackground());
                ((Graphics2D) g.create()).setColor(_TabbedPaneSelector.this.colorDeSegundoBorde);
            }
            if (tabPlacement == 2) {
                g2d.translate(0, 0);
            }
            if (tabPlacement == 3) {
                g2d.translate(tx * -1, ty * -1);
            }
        }

        private void paintSelection(Graphics2D g, int index, int tx, int ty, int tw, int th) {
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            Composite composite = g2.getComposite();
            Stroke stroke = g2.getStroke();
            g2.setStroke(new BasicStroke(3.0f));
            g2.setColor(_TabbedPaneSelector.this.colorBackGround);
            g2.drawLine(tw - 2, ty - 3, tw - 2, (th + ty) + 3);
            g2.setComposite(AlphaComposite.getInstance(3, _TabbedPaneSelector.this.selectionOpacity));
            g2.setColor(_TabbedPaneSelector.this.selectionColor);
            g2.fill(getShape(index, tx, ty, tw + 2, th));
            g2.setComposite(AlphaComposite.getInstance(3, _TabbedPaneSelector.this.selectionBorderOpacity));
            g2.setColor(_TabbedPaneSelector.this.selectionColor);
            g2.draw(getShape(index, tx, ty, tw, th));
            g2.setStroke(stroke);
            g2.setComposite(composite);
        }

        private Shape getShape(int index, int tx, int ty, int tw, int th) {
            GeneralPath gp = new GeneralPath();
            tw -= 2;
            gp.moveTo((float) tw, (float) (ty - 3));
            gp.curveTo((float) tw, (float) (ty - 3), (float) tw, (float) ty, (float) (tw - 3), (float) ty);
            gp.lineTo(6.0f, (float) ty);
            float f = 6.0f;
            float f2 = 3.0f;
            gp.curveTo(f, (float) ty, f2, (float) ty, 3.0f, (float) (ty + 3));
            gp.lineTo(3.0f, (float) ((th + ty) - 3));
            gp.curveTo(3.0f, (float) ((th + ty) - 3), 3.0f, (float) (th + ty), 6.0f, (float) (th + ty));
            gp.lineTo((float) (tw - 3), (float) (th + ty));
            gp.curveTo((float) (tw - 3), (float) (th + ty), (float) tw, (float) (ty + th), (float) tw, (float) ((ty + th) + 3));
            return gp;
        }

        protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
            Rectangle r = this.rects[tabIndex];
            Graphics2D g2d = (Graphics2D) g;
            if (tabPlacement == 2) {
                g2d.translate(0, r.y);
            }
            if (tabPlacement == 4) {
                g2d.translate(r.width - this.buttonHeight, 0);
            }
            FontMetrics fm = getFontMetrics();
            if (isSelected) {
                g.setColor(_TabbedPaneSelector.this.getForeground());
            } else {
                g.setColor(_TabbedPaneSelector.this.getForeground().darker());
            }
            g.drawString(title, ((r.width / 2) - (fm.stringWidth(title) / 2)) + 1, ((this.buttonHeight / 2) + fm.getMaxDescent()) + 2);
            if (tabPlacement == 2) {
                g2d.translate(0, r.y * -1);
            }
            if (tabPlacement == 4) {
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

    public _TabbedPaneSelector() {
        setForeground(Color.WHITE);
        setTabPlacement(2);
        setUI(new TabbedPaneUI());
        this.setPreferredSize(new Dimension(50, 50));
    }

    public Color getColorBackGround() {
        return this.colorBackGround;
    }

    public void setColorBackGround(Color colorBackGround) {
        this.colorBackGround = colorBackGround;
    }

    public Color getListColor() {
        return this.listColor;
    }

    public void setListColor(Color listColor) {
        this.listColor = listColor;
    }

    public Color getSelectionColor() {
        return this.selectionColor;
    }

    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
    }

    public Color getColorDeBorde() {
        return this.colorDeBorde;
    }

    public void setColorDeBorde(Color colorDeBorde) {
        this.colorDeBorde = colorDeBorde;
    }

    public Color getColorDeSegundoBorde() {
        return this.colorDeSegundoBorde;
    }

    public void setColorDeSegundoBorde(Color colorDeSegundoBorde) {
        this.colorDeSegundoBorde = colorDeSegundoBorde;
    }

    public void setTabPlacement(int tabPlacement) {
        if (tabPlacement == 2) {
            super.setTabPlacement(tabPlacement);
        }
    }
}
