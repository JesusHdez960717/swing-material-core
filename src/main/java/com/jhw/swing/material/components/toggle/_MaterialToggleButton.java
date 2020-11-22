package com.jhw.swing.material.components.toggle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialImages;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;
import com.jhw.swing.util.Utils;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialToggleButton extends MaterialToggleButton {

    public static MaterialToggleButton from() {
        return new _MaterialToggleButton();
    }

    private ImageIcon unselectedIcon;
    private ImageIcon selectedIcon;

    private boolean isMousePressed = false;

    public _MaterialToggleButton() {
        this(_MaterialToggleButton.Type.DEFAULT);
    }

    public _MaterialToggleButton(Type type) {
        //this.setText("Toggle");
        setCorrespondingIcons(type);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setOpaque(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(unselectedIcon);
        this.setSelectedIcon(selectedIcon);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                isMousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                isMousePressed = false;
                repaint();
            }
        });
    }

    @Override
    public ImageIcon getUnselectedIcon() {
        return unselectedIcon;
    }

    @Override
    public void setUnselectedIcon(ImageIcon unselectedIcon) {
        this.unselectedIcon = unselectedIcon;
    }

    @Override
    public ImageIcon getSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public void setSelectedIcon(ImageIcon selectedIcon) {
        this.selectedIcon = selectedIcon;
    }

    private void setCorrespondingIcons(Type type) {
        if (type == Type.CHECK_BOX) {
            unselectedIcon = MaterialIcons.CHECK_BOX_OUTLINE_BLANK;
            selectedIcon = MaterialIcons.CHECK_BOX;
        } else if (type == Type.RADIO_BUTTON) {
            unselectedIcon = MaterialIcons.RADIO_BUTTON_UNCHECKED;
            selectedIcon = MaterialIcons.RADIO_BUTTON_CHECKED;
        } else {
            unselectedIcon = new ImageIcon(MaterialImages.TOGGLE_BUTTON_OFF);
            selectedIcon = new ImageIcon(MaterialImages.TOGGLE_BUTTON_ON);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(MaterialDrawingUtils.getAliasedGraphics(g));
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        if (getText().trim().isEmpty() && getIcon() != null) {//solo pinto icono en el medio
            if ((isMousePressed && !this.isSelected()) || (!isMousePressed && this.isSelected()) || (isMousePressed && this.isSelected())) {
                this.setIcon(selectedIcon);
            } else {
                this.setIcon(unselectedIcon);
            }
            this.getIcon().paintIcon(this, g2, (this.getSize().width - getIcon().getIconWidth()) / 2, (this.getSize().height - getIcon().getIconHeight()) / 2);
        } else {
            if ((isMousePressed && !this.isSelected()) || (!isMousePressed && this.isSelected()) || (isMousePressed && this.isSelected())) {
                this.setIcon(selectedIcon);
            } else {
                this.setIcon(unselectedIcon);
            }
            g2.setFont(getFont());
            if (this.isEnabled()) {
                g2.setColor(this.getForeground());
            } else {
                Color fg = this.getForeground();
                g2.setColor(Utils.applyAlphaMask(fg, HINT_OPACITY_MASK));
                //g2.setColor(new Color(fg.getRed() / 255f, fg.getGreen() / 255f, fg.getBlue() / 255f, 0.6f));
            }

            int iconWidth = 0;
            int distReal = getIconTextGap();
            if (getIcon() != null) {
                iconWidth = getIcon().getIconWidth();
            } else {
                distReal = 0;
            }

            FontMetrics metrics = g.getFontMetrics(getFont());
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

            int xText = 0;
            int xIcon = 0;

            int strWidth = metrics.stringWidth(getText());
            int align = getHorizontalAlignment();

            if (align == SwingConstants.TRAILING || align == SwingConstants.RIGHT) {
                xText = getWidth() - strWidth;
                xIcon = xText - iconWidth - 2 * distReal;
            } else if (align == SwingConstants.LEADING || align == SwingConstants.LEFT) {
                xIcon = 0;
                xText = iconWidth + distReal;
            } else {
                xText = (getWidth() - strWidth) / 2 + distReal / 2 + iconWidth / 2;
                xIcon = xText - iconWidth - distReal;
            }
            g2.drawString(this.getText(), xText, y);//getText().toUpperCase()

            this.getIcon().paintIcon(this, g2, xIcon, (this.getSize().height - getIcon().getIconHeight()) / 2);

        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public Boolean getObject() {
        return isSelected();
    }

    @Override
    public void setObject(Boolean object) {
        setSelected(object);
    }

    public enum Type {

        CHECK_BOX, RADIO_BUTTON, DEFAULT
    }
}
