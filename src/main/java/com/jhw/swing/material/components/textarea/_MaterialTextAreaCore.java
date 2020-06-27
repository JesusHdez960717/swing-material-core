package com.jhw.swing.material.components.textarea;

import java.awt.Color;
import javax.swing.JTextArea;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextAreaCore extends JTextArea {

    public _MaterialTextAreaCore() {
        this.setBackground(MaterialColors.WHITE);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setLineWrap(true);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.setForeground(Utils.getForegroundAccording(bg));
    }
}
