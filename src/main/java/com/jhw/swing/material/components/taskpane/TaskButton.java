/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class TaskButton extends JButton implements MaterialComponent {

    public TaskButton(Action a) {
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
    }

}
