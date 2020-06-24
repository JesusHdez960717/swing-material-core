package com.jhw.swing.ui.componentsui.menubar;

import com.jhw.swing.util.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.awt.*;

public class MaterialMenuBarUI extends BasicMenuBarUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialMenuBarUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JMenuBar menuBar = (JMenuBar) c;
        menuBar.setFont(UIManager.getFont("MenuBar.font"));
        menuBar.setBackground(UIManager.getColor("MenuBar.background"));
        menuBar.setBorder(UIManager.getBorder("MenuBar.border"));
        menuBar.setForeground(UIManager.getColor("MenuBar.foreground"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
