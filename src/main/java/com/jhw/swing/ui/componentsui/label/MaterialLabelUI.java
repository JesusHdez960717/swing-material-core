package com.jhw.swing.ui.componentsui.label;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.Graphics;
import com.jhw.swing.material.standars.MaterialFontRoboto;

public class MaterialLabelUI extends BasicLabelUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialLabelUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JLabel label = (JLabel) c;
        label.setOpaque(false);
        label.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        label.setBackground(UIManager.getColor("Label.background"));
        label.setForeground(UIManager.getColor("Label.foreground"));
        label.setBorder(UIManager.getBorder("Label.border"));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
