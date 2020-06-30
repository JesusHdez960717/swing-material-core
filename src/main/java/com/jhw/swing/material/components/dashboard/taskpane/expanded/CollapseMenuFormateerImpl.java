package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CollapseMenuFormateerImpl implements CollapseMenuFormateer {

    @Override
    public void format(CollapseMenu menu) {
        menu.setSelected(MaterialColors.RED_900);
        menu.setDeselected(MaterialColors.RED_500);//activa el color, deselected siempre de ultimo
        menu.setCollapsablePanelBackground(Color.green);
        menu.setButtonNameFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);
        menu.setPanelCollapsibleGaps(5, 20, 5, 0);
        menu.setHeight(40);
    }

}
