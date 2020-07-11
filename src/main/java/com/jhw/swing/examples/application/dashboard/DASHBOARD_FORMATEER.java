package com.jhw.swing.examples.application.dashboard;

import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DownPanel;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.UpPanel;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.GradientEnum;
import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Consumer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DASHBOARD_FORMATEER {
    
    private static final Color PRIMARY = PersonalizationMaterial.getInstance().getColorSecundary();
    private static final Color SECUNDARY = PersonalizationMaterial.getInstance().getColorPrincipal();
    
    public static Consumer<TaskButton> buttonFormatter = (TaskButton btn) -> {
        btn.setFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        btn.setForeground(MaterialColors.BLACK);
        btn.setDeselectedColor(SECUNDARY);
        btn.setMauseOverColor(Utils.darken(SECUNDARY));
        btn.setSelectedColor(Utils.darken(Utils.darken(SECUNDARY)));
        btn.setPreferredSize(new Dimension(btn.getPreferredSize().width, 40));
        btn.deselect();//marcar el deselect para que pinte
    };
    
    public static Consumer<CollapseMenu> collapseMenuFormatter = (CollapseMenu menu) -> {
        menu.setDeselectedColor(PRIMARY);
        menu.setSelectedColor(Utils.darken(PRIMARY));
        menu.setMainPanelForeground(Utils.getForegroundAccording(Utils.darken(PRIMARY)));

        //menu.setCollapsablePanelBackground(Color.green);
        menu.setMainPanelFont(MaterialFontRoboto.MEDIUM.deriveFont(24f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);
        
        menu.setComponentsGap(0);
        //menu.setPanelCollapsibleGaps(0, 20, 0, 0);
        menu.setHeight(50);
        menu.setWidth(250);
    };
    
    public static Consumer<DashBoardExtends> dashBoardFormatter = (DashBoardExtends dash) -> {
        dash.setPanelSideMenuColor(SECUNDARY);
        dash.getDashboardCore().removeDownButton();
        //dash.getDashboardCore().removeUpButton();
    };
    
    public static Consumer<UpPanel> upPanelFormatter = (UpPanel up) -> {
        up.getBackgroundPanel().setSecundaryColor(PRIMARY);
        up.getBackgroundPanel().setPrimaryColor(SECUNDARY);
        up.getBackgroundPanel().setGradient(GradientEnum.VERTICAL_3_4);
    };
    
    public static Consumer<DownPanel> downPanelFormatter = (DownPanel down) -> {
        down.getBackgroundPanel().setBackground(MaterialColors.GREY_200);
        down.getBackgroundPanel().setBorder(new LineBorder(MaterialColors.GREY_500, 1));
    };
}
