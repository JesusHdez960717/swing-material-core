package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.textfield._MaterialFormatedTextField;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;
import com.jhw.utils.others.SDF;
import com.jhw.swing.util.interfaces.DateSelected;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.util.interfaces.Wrong;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialDatePicker extends JXDatePicker implements DateSelected, BindableComponent<Date>, Wrong, MaterialComponent {

    private final _MaterialFormatedTextField text = new _MaterialFormatedTextField();

    public _MaterialDatePicker() {
        super();
        this.setFormats(SDF.SDF);
        this.setDate(new Date());
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(18f));

        this.setEditor(text);
        personalizeButton();

    }

    public void setLowerBound(Date lower) {
        this.getMonthView().setLowerBound(lower);
    }

    public void setUpperBound(Date lower) {
        this.getMonthView().setUpperBound(lower);
    }

    private void personalizeButton() {
        JButton button = null;
        for (Component component : this.getComponents()) {
            if (component instanceof JButton) {
                button = (JButton) component;
                break;
            }
        }
        if (button != null) {
            button.setIcon(MaterialIcons.DATE_RANGE);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setOpaque(false);
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public Date getObject() {
        return this.getDate();
    }

    @Override
    public void setObject(Date object) {
        this.setDate(object);
    }

    @Override
    public void wrong() {
        text.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        text.wrong(wrongText);
    }

}
