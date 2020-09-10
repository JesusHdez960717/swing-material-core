package com.jhw.swing.material.components.scrollpane;

import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import java.awt.Adjustable;
import javax.swing.JScrollBar;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialScrollPaneCore extends JScrollPane {

    private final _MaterialScrollBar verticalScrollBar = new _MaterialScrollBar(Adjustable.VERTICAL);
    private final _MaterialScrollBar horizontalScrollBar = new _MaterialScrollBar(Adjustable.HORIZONTAL);

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
