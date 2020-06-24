package com.jhw.swing.ui.componentsui.checkbox;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.awt.*;
import com.jhw.swing.util.interfaces.MaterialComponent;

public class MaterialCheckBoxUI extends BasicCheckBoxUI {

    public static ComponentUI createUI(JComponent c) {
        if (c instanceof MaterialComponent) {
            return new javax.swing.plaf.basic.BasicCheckBoxUI();
        }
        return new MaterialCheckBoxUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JCheckBox checkBox = (JCheckBox) c;
        checkBox.setFont(UIManager.getFont("CheckBox.font"));
        checkBox.setBackground(UIManager.getColor("CheckBox.background"));
        checkBox.setForeground(UIManager.getColor("CheckBox.foreground"));
        checkBox.setIcon(UIManager.getIcon("CheckBox.icon"));
        checkBox.setSelectedIcon(UIManager.getIcon("CheckBox.selectedIcon"));
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
