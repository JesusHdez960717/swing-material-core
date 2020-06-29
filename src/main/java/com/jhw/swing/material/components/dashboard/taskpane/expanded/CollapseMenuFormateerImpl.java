package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CollapseMenuFormateerImpl implements CollapseMenuFormateer {

    @Override
    public void format(CollapseMenu menu) {
        menu.setMainButtonBackground(Color.RED);
        menu.setCollapsablePanelBackground(Color.RED);
        menu.setButtonNameFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);
        menu.setPanelCollapsibleGaps(10, 60, 10, 1);
    }

}
