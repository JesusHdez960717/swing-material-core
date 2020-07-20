package com.jhw.swing.material.components.scrollpane;

import static com.jhw.swing.material.components.textfield._MaterialTextField.LINE_OPACITY_MASK;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import java.awt.Adjustable;
import javax.swing.JScrollBar;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialScrollPaneCore extends JScrollPane {

    private _MaterialScrollBar verticalScrollBar = new _MaterialScrollBar(Adjustable.VERTICAL);
    private _MaterialScrollBar horizontalScrollBar = new _MaterialScrollBar(Adjustable.HORIZONTAL);

    public _MaterialScrollPaneCore() {
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
    }

    public _MaterialScrollBar getMaterialVerticalScrollBar() {
        return verticalScrollBar;
    }

    public JScrollBar getMaterialHorizontalScrollBar() {
        return horizontalScrollBar;
    }

    public void setTitledBorder(String text) {
        this.setBorder(new TitledBorder(text));
    }

    @Override
    public void setBorder(Border b) {
        if (b instanceof TitledBorder) {
            TitledBorder bor = (TitledBorder) b;
            bor.setTitleFont(getFont());

            LineBorder lb = new LineBorder(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
            bor.setBorder(lb);

            super.setBorder(bor);
        } else {
            super.setBorder(b);
        }
    }
}
