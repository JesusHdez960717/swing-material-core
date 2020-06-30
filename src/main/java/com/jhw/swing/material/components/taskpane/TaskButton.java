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

/**
 * 
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskButton extends JButton implements MaterialComponent {

    private boolean selected = false;
    private final CollapseMenu parent;

    public TaskButton(Action a, CollapseMenu parent) {
        this.parent = parent;
        setAction(a);
        //setIcon((Icon) a.getValue(Action.SMALL_ICON));
        //setText(a.getValue(Action.NAME).toString());
        setFont(getFont().deriveFont(24f));

        this.setBackground(Color.red);

        setHorizontalAlignment(SwingConstants.LEADING);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //setBorderPainted(false);
        //setContentAreaFilled(false);
        setFocusPainted(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.childSelected();
                select();
            }
        });
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
        repaint();
    }

    public void deselect() {
        selected = false;
        repaint();
    }
}
