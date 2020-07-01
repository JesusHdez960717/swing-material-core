package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.standars.MaterialColors;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskButton extends JButton implements MaterialComponent {

    private boolean selected = false;
    private Color selectedColor  = MaterialColors.BLUE_200;
    private Color deselectedColor  = MaterialColors.BLUE_800;

    public TaskButton(Action a, CollapseMenu parent) {
        setAction(a);

        setPreferredSize(parent.getjPanelFixed().getPreferredSize());

        setHorizontalAlignment(SwingConstants.LEADING);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.childSelected();
                select();
            }
        });
        
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
            ImageIcon icon = MaterialIcons.ARROW_DROP_RIGHT;
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
