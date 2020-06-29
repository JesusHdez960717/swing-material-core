package com.jhw.swing.material.components.combobox.combobox_editable;

import com.jhw.swing.material.components.combobox._MaterialComboBox;
import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import static com.jhw.swing.material.components.textfield._MaterialTextField.LINE_OPACITY_MASK;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.icons.DerivableIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialComboBoxFiltrable<T> extends _MaterialComboBox<T> {

    public _MaterialComboBoxFiltrable(T[] items) {
        super(items);
        this.setSelectedIndex(-1);
    }

    public _MaterialComboBoxFiltrable() {
    }

    private boolean focus;

    public void processExternalFocusEvent(boolean focus, FocusEvent e) {
        this.focus = focus;
        processFocusEvent(e);
    }

    @Override
    public boolean isFocusOwner() {
        return focus;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int yMid = getSize().height / 2;

        g2.setColor(getFloatingLabel().getColor());
        g2.setFont(getFloatingLabel().getFont());
        if (!getLabel().isEmpty()) {
            g2.drawString(getLabel(), getFloatingLabel().getX(), getFloatingLabel().getY());//paint the hint in the same place as the text
        }

        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        g2.setFont(getFont());
        if (getSelectedItem() == null && isFocusOwner()) {
            g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            g2.drawString(getHint(), getFloatingLabel().getX(), metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }

        int yLine = yMid + metrics.getAscent() / 2 + 5;

        //paint the back line
        g2.setColor(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, getWidth(), 1);

        //paint the front line, this is the one that change colors and size
        g2.setColor(getAccent());
        g2.fillRect((int) ((getWidth() - getLine().getWidth()) / 2), yLine, (int) getLine().getWidth(), 2);

        //paint the wrong text if the flag is actived
        if (isWrongFlag()) {
            g2.setColor(getWrongColor());
            g2.setFont(getFloatingLabel().getFont().deriveFont(1));//1 for bold
            g2.drawString(getWrongText(), 0, yLine + 15);//paint the wrong text
        }

        //paint the arrow
        if (getIcon() != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccent();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            ImageIcon icon = getIcon();
            if (icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(iconColor);
            }
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - getIcon().getIconHeight()), yMid - icon.getIconHeight() / 2);
        }

    }

}
