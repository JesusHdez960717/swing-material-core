package com.jhw.swing.material.components.dashboard.elements;

import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.effects.DefaultRippleEffect;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultColorFadeInto;
import com.jhw.swing.utils.icons.DerivableIcon;

/**
 * Material Button para los elementos de la pagina principal. No contienen
 * elevacion pero conservan su ripple, icono que lo identifica y se le agrego un
 * icono de seleccioado.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonMainPage extends _MaterialButton implements MaterialComponent {

    private DefaultColorFadeInto fadeinto;
    private DefaultRippleEffect ripple = DefaultRippleEffect.applyTo(this);
    private boolean isMouseOver = false;
    private boolean isSelected = false;
    private Color rippleColor = Color.WHITE;
    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    private ImageIcon icon = null;
    private final DerivableIcon iconSelected = MaterialIcons.ARROW_DROP_RIGHT;

    private boolean in;

    public _MaterialButtonMainPage() {
        this(null, " ");
    }

    public _MaterialButtonMainPage(ImageIcon icon) {
        this(icon, " ");
    }

    public _MaterialButtonMainPage(String text) {
        this(null, text);
    }

    /**
     * Creates a new button.
     */
    public _MaterialButtonMainPage(ImageIcon icon, String text) {
        in = false;
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_MAIN));
        this.setText(text);
        this.icon = icon;
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        this.setCursor(cursor);
        this.setPreferredSize(new Dimension(145, 65));
        this.setFocusable(false);

        this.setOpaque(false);
        fadeinto = new DefaultColorFadeInto(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isSelected = true;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });

        this.setUI(new BasicButtonUI());

    }

    public ImageIcon getIconID() {
        return icon;
    }

    public void setIn(boolean in) {
        this.in = in;
        this.repaint();
    }

    /**
     * Sets the Background color of this button.
     * <p>
     * Keep on mind that setting a background color in a Material component like
     * this will also set the foreground color to either white or black and the
     * ripple color to white or darker shade of the color, depending of how
     * bright or dark is the chosen backgroundReal color. If you want to use a
     * custom foreground color and ripple color, ensure the background color has
     * been set first.
     * <p>
     * <b>NOTE:</b> It is up to the look and feel to honor this property, some
     * may choose to ignore it. To avoid any conflicts, using the
     * <a
     * href="https://docs.oracle.com/javase/7/docs/api/javax/swing/plaf/metal/package-summary.html">
     * Metal Look and Feel</a> is recommended.
     */
    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        Color bkAux = Utils.brighten(Utils.brighten(bg));
        setForeground(Utils.getForegroundAccording(bkAux));
        setRippleColor(Utils.getForegroundAccording(bkAux));
        fadeinto = new DefaultColorFadeInto(this);
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
    }

    /**
     * Flag to the property when the mouse is over the element.
     *
     * @return true if mouse is over, false otherwise.
     */
    @Override
    public boolean isMouseOver() {
        return isMouseOver;
    }

    public void deselect() {
        this.isSelected = false;
    }

    public void select() {
        this.isSelected = true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        Color bg = getBackground();
        if (isEnabled()) {
            if (this.isSelected) {
                bg = Utils.darken(Utils.darken(bg));
            } else {
                bg = fadeinto.getColorFadeInto();
            }
            g2.setColor(bg);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));

            g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));
            g2.setColor(rippleColor);
            ripple.paintRipple(g2);
        } else {
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 0, 0));
        }

        if (!in) {
            FontMetrics metrics = g2.getFontMetrics(getFont());
            int x = (getWidth() - metrics.stringWidth(getText())) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.setFont(getFont());
            if (this.isEnabled()) {
                g2.setColor(this.getForeground());
            } else {
                Color fg = this.getForeground();
                g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
            }
            g2.drawString(this.getText(), x, y);//getText().toUpperCase()

        }

        if (isSelected) {
            this.setIcon(iconSelected);
            this.getIcon().paintIcon(this, g2, this.getSize().width - getIcon().getIconWidth() - getIcon().getIconWidth() / 2, (this.getSize().height) / 2 - getIcon().getIconHeight() / 2);
        }
        if (icon != null) {
            this.setIcon(icon);
            this.getIcon().paintIcon(this, g2, 10, (this.getSize().height) / 2 - getIcon().getIconHeight() / 2);
        }

    }
}
