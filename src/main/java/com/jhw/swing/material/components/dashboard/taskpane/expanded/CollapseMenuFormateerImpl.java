package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.material.standars.MaterialColors;
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
        menu.setDeselectedColor(primary);
        menu.setSelectedColor(Utils.darken(primary));
        //menu.setCollapsablePanelBackground(Color.green);
        menu.setMainPanelFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);
        menu.setMainPanelForeground(MaterialColors.WHITE);
        menu.setComponentsGap(0);
        //menu.setPanelCollapsibleGaps(5, 20, 5, 0);
        menu.setHeight(50);
    }
    
    @Override
    public void formatButton(TaskButton button) {
        button.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        button.setForeground(MaterialColors.WHITE);
        button.setSelectedColor(Utils.darken(secundary));
        button.setDeselectedColor(secundary);
    }
    
}
