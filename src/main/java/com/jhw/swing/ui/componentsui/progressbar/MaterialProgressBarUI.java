package com.jhw.swing.ui.componentsui.progressbar;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import com.jhw.swing.ui.utils.MaterialBorders;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.standards.MaterialColors;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialProgressBarUI extends BasicProgressBarUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialProgressBarUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JProgressBar progressBar = (JProgressBar) c;
        progressBar.setBorder(MaterialBorders.LIGHT_LINE_BORDER);
        progressBar.setBackground(MaterialColors.GREY_200);
        progressBar.setForeground(MaterialColors.LIGHTBLUE_400);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

}
