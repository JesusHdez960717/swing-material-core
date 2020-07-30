package com.jhw.swing.material.components.datepicker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;
import com.jhw.utils.others.SDF;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.DateSelected;
import com.jhw.swing.material.standards.MaterialFontRoboto;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _JXDatePicker extends JXDatePicker implements DateSelected {

    public _JXDatePicker() {
        super();
        this.setFormats(SDF.SDF);
        this.setDate(new Date());
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(18f));

    }

    @Override
    public Date getDateValidated() {
        return this.getDate();
    }

    @Override
    protected void printComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        super.printComponent(g2);
    }
}
