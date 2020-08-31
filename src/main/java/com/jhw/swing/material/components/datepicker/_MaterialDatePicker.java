package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.textfield._MaterialFormatedTextField;
import com.jhw.swing.material.standards.MaterialColors;
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
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatterFactory;
import org.jdesktop.swingx.calendar.DatePickerFormatter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialDatePicker extends JXDatePicker implements DateSelected, BindableComponent<Date>, Wrong, MaterialComponent {

    static {
        UIManager.put("JXMonthView.monthDownFileName", MaterialIcons.KEYBOARD_ARROW_LEFT);
        UIManager.put("JXMonthView.monthUpFileName", MaterialIcons.KEYBOARD_ARROW_RIGHT);
        UIManager.put("JXMonthView.monthStringBackground", MaterialColors.PURPLE_200);
        UIManager.put("JXMonthView.monthStringForeground", MaterialColors.BLACK);
    }

    private final _MaterialFormatedTextField text = new _MaterialFormatedTextField();

    public _MaterialDatePicker() {
        super();
        this.setFormats(SDF.SDF);
        this.setDate(new Date());
        this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(18f));

        //set up the formatter
        this.text.setFormatterFactory(new DefaultFormatterFactory(new DatePickerFormatter(getFormats(), getLocale())));

        this.setEditor(text);
        
        personalizeButton();
    }

    public _MaterialFormatedTextField getFormatedTextField() {
        return text;
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
            //para que cuando se de un click no pinte por el material ui
            button.setBackground(MaterialColors.TRANSPARENT);
            button.setForeground(MaterialColors.TRANSPARENT);

            //icono
            button.setIcon(MaterialIcons.ARROW_DROP_DOWN.deriveIcon(getFont().getSize2D() * 2));
            //button.setIcon(MaterialIcons.DATE_RANGE);

            //borrar todo lo demas
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setOpaque(false);

            //cursor
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

/*

        defaults.add(JXMonthView.uiClassID, "org.jdesktop.swingx.plaf.basic.BasicMonthViewUI");
        defaults.add("JXMonthView.background", new ColorUIResource(Color.WHITE));
        defaults.add("JXMonthView.monthStringBackground", new ColorUIResource(138, 173, 209));//color moradito de arriba, no funciona directo
        defaults.add("JXMonthView.monthStringForeground", new ColorUIResource(68, 68, 68));
        defaults.add("JXMonthView.daysOfTheWeekForeground", new ColorUIResource(68, 68, 68));
        defaults.add("JXMonthView.weekOfTheYearForeground", new ColorUIResource(68, 68, 68));
        defaults.add("JXMonthView.unselectableDayForeground", new ColorUIResource(Color.RED));
        defaults.add("JXMonthView.selectedBackground", new ColorUIResource(197, 220, 240));
        defaults.add("JXMonthView.flaggedDayForeground", new ColorUIResource(Color.RED));
        defaults.add("JXMonthView.leadingDayForeground", new ColorUIResource(Color.LIGHT_GRAY));
        defaults.add("JXMonthView.trailingDayForeground", new ColorUIResource(Color.LIGHT_GRAY));
        defaults.add("JXMonthView.font", UIManagerExt.getSafeFont("Button.font", new FontUIResource("Dialog", 0, 12)));
        defaults.add("JXMonthView.monthDownFileName", LookAndFeel.makeIcon(MonthViewAddon.class, "basic/resources/month-down.png"));
        defaults.add("JXMonthView.monthUpFileName", LookAndFeel.makeIcon(MonthViewAddon.class, "basic/resources/month-up.png"));
        defaults.add("JXMonthView.boxPaddingX", Integer.valueOf(3));
        defaults.add("JXMonthView.boxPaddingY", Integer.valueOf(3));



 */
