package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.jhw.swing.material.components.button.*;//_MaterialButtonFlat
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.util.icons.DerivableIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskButton extends JButton implements MaterialComponent {

    private boolean selected = false;
    private Color selectedColor = MaterialColors.BLUE_200;
    private Color deselectedColor = MaterialColors.BLUE_800;
    private Color mauseOverColor = MaterialColors.BLUE_800;

    public TaskButton(Action a, CollapseMenu parent) {
        setAction(a);

        setPreferredSize(parent.getjPanelFixed().getPreferredSize());
        setHorizontalAlignment(SwingConstants.LEADING);
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setIconTextGap(20);
        //selecciona y avisa
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.childSelected();
                select();
            }
        });

        //color cuando el mouse pasa por arriba
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected) {
                    setBackground(mauseOverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected) {
                    setBackground(deselectedColor);
                }
            }
        });
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        setIcon(getIcon());
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon instanceof DerivableIcon) {
            icon = ((DerivableIcon) icon).deriveIcon(getForeground());
        }
        super.setIcon(icon);
    }

    public Color getMauseOverColor() {
        return mauseOverColor;
    }

    public void setMauseOverColor(Color mauseOverColor) {
        this.mauseOverColor = mauseOverColor;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Color getDeselectedColor() {
        return deselectedColor;
    }

    public void setDeselectedColor(Color deselectedColor) {
        this.deselectedColor = deselectedColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        super.paintComponent(g2);
        if (selected) {
            int yMid = getSize().height / 2;
            ImageIcon icon = MaterialIcons.ARROW_DROP_RIGHT.deriveIcon(getForeground());
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - getIcon().getIconHeight()), yMid - icon.getIconHeight() / 2);
        }
    }

    public void select() {
        selected = true;
        setBackground(selectedColor);
        repaint();
    }

    public void deselect() {
        selected = false;
        setBackground(deselectedColor);
        repaint();
    }
}
