package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CollapseMenuFormateerImpl implements CollapseMenuFormateer {

    @Override
    public void format(CollapseMenu menu) {
        Color primary = PersonalizationMaterial.getInstance().getColorSecundary();
        menu.setDeselected(primary);
        menu.setSelected(Utils.darken(primary));
        //menu.setCollapsablePanelBackground(Color.green);
        menu.setButtonNameFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);

        menu.setComponentsGap(0);
        //menu.setPanelCollapsibleGaps(5, 20, 5, 0);
        menu.setHeight(40);
    }

}
