package com.jhw.swing.ui.componentsui.radiobutton;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;
import com.jhw.swing.util.interfaces.MaterialComponent;

/**
 * Contributed by https://github.com/downToHell
 */
public class MaterialRadioButtonUI extends BasicRadioButtonUI {

    public static ComponentUI createUI(JComponent c) {
        if (c instanceof MaterialComponent) {
            return new javax.swing.plaf.basic.BasicRadioButtonUI();
        }
        return new MaterialRadioButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JRadioButton radioButton = (JRadioButton) c;
        radioButton.setFont(UIManager.getFont("RadioButton.font"));
        radioButton.setBackground(UIManager.getColor("RadioButton.background"));
        radioButton.setForeground(UIManager.getColor("RadioButton.foreground"));
        radioButton.setIcon(UIManager.getIcon("RadioButton.icon"));
        radioButton.setSelectedIcon(UIManager.getIcon("RadioButton.selectedIcon"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
