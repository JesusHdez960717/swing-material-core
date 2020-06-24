package com.jhw.swing.ui.componentsui.combobox;

import com.jhw.swing.ui.animation.MaterialUIMovement;
import com.jhw.swing.ui.utils.MaterialBorders;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.ui.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialComboBoxUI extends BasicComboBoxUI {

    public static ComponentUI createUI(JComponent c) {
        //if (c instanceof MaterialComponent) {
        return new javax.swing.plaf.basic.BasicComboBoxUI();
        //}
        //return new MaterialComboBoxUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JComboBox<?> comboBoxAct = (JComboBox<?>) c;
        comboBoxAct.setFont(UIManager.getFont("ComboBox.font"));
        comboBoxAct.setBackground(UIManager.getColor("ComboBox.background"));
        comboBoxAct.setForeground(UIManager.getColor("ComboBox.foreground"));
        comboBoxAct.setBorder(UIManager.getBorder("ComboBox.border"));
        comboBoxAct.setLightWeightPopupEnabled(true);
        comboBoxAct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected JButton createArrowButton() {
        Icon icon = UIManager.getIcon("ComboBox.buttonIcon");
        JButton button;
        if (icon != null) {
            button = new JButton(icon);
        } else {
            button = new BasicArrowButton(SwingConstants.SOUTH);
        }
        MaterialManagerListener.removeAllMouseListener(button);
        button.setOpaque(true);
        button.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
        if (UIManager.getBoolean("ComboBox.mouseHoverEnabled")) {
            button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("ComboBox.mouseHoverColor")));
        }
        button.setBorder(MaterialBorders.LIGHT_LINE_BORDER);
        return button;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new MaterialComboBoxRenderer();
    }
}
