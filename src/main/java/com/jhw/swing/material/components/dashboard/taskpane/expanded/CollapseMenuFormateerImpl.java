package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CollapseMenuFormateerImpl implements CollapseMenuFormateer {

    private final Color primary = PersonalizationMaterial.getInstance().getColorSecundary();
    private final Color secundary = PersonalizationMaterial.getInstance().getColorPrincipal();

    @Override
    public void formatMenu(CollapseMenu menu) {
        menu.setDeselected(primary);
        menu.setSelected(Utils.darken(primary));
        //menu.setCollapsablePanelBackground(Color.green);
        menu.setButtonNameFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);

        menu.setComponentsGap(0);
        //menu.setPanelCollapsibleGaps(5, 20, 5, 0);
        menu.setHeight(50);
    }

    @Override
    public void formatButton(TaskButton button) {
        button.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));

        button.setSelectedColor(Utils.darken(secundary));
        button.setDeselectedColor(secundary);
    }

}
