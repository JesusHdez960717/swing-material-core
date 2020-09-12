package com.jhw.swing.material.components.scrollpane;

import com.jhw.swing.material.effects.DefaultBorderDinamic;
import com.jhw.swing.material.effects.DefaultMaterialLineBorder;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;
import java.awt.Adjustable;
import javax.swing.JScrollBar;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialScrollPaneCore extends MaterialScrollPane {

    public static _MaterialScrollPaneCore from() {
        return new _MaterialScrollPaneCore();
    }

    private final _MaterialScrollBar verticalScrollBar = new _MaterialScrollBar(Adjustable.VERTICAL);
    private final _MaterialScrollBar horizontalScrollBar = new _MaterialScrollBar(Adjustable.HORIZONTAL);

    //private final DefaultBorderDinamic borderEffect;
    protected _MaterialScrollPaneCore() {
        //para el border
        this.setBackground(MaterialColors.WHITE);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));

        //barras de material
        this.setVerticalScrollBar(verticalScrollBar);
        this.setHorizontalScrollBar(horizontalScrollBar);

        //smoot
        this.addMouseWheelListener(new SmoothScrollMouseWheelListener(this));

        //transparente
        this.getViewport().setOpaque(false);
        this.getViewport().setBackground(MaterialColors.TRANSPARENT);

        //le sobra el borde
        //this.setBorder(null);
        
        //borderEffect = new DefaultBorderDinamic(this);
    }

    @Override
    public MaterialScrollBar getMaterialVerticalScrollBar() {
        return verticalScrollBar;
    }

    @Override
    public MaterialScrollBar getMaterialHorizontalScrollBar() {
        return horizontalScrollBar;
    }

}
