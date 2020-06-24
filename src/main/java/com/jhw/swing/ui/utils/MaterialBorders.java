package com.jhw.swing.ui.utils;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import com.jhw.swing.ui.shadows.DropShadowBorder;
import com.jhw.swing.material.standars.MaterialColors;

public class MaterialBorders {

    public static final Border LIGHT_LINE_BORDER = BorderFactory.createLineBorder(MaterialColors.GREY_200, 1);
    public static final Border LIGHT_SHADOW_BORDER
            = new DropShadowBorder(Color.BLACK, 0, 4, 0.3f, 12,
                    true, true, true, true);
    public static final Border DEFAULT_SHADOW_BORDER
            = new DropShadowBorder(Color.BLACK, 5, 5, 0.3f, 12,
                    true, true, true, true);

    private MaterialBorders() {
    }

}
