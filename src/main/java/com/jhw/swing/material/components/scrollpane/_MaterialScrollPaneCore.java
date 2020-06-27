package com.jhw.swing.material.components.scrollpane;

import static com.jhw.swing.material.components.textfield._MaterialTextField.LINE_OPACITY_MASK;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialScrollPaneCore extends JScrollPane {

    public _MaterialScrollPaneCore() {
        this.setBackground(MaterialColors.WHITE);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.addMouseWheelListener(new SmoothScrollMouseWheelListener(this));
        this.getViewport().setOpaque(false);
        this.getViewport().setBackground(MaterialColors.TRANSPARENT);
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
