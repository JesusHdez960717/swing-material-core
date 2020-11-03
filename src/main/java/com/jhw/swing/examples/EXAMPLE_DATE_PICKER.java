/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

//import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.datepicker.MaterialDatePicker;
import com.jhw.swing.material.components.datepicker.MaterialDatePickerIcon;
import com.jhw.swing.material.components.datepicker.MaterialDatePickersFactory;
import com.jhw.swing.material.components.datepicker._Month;
import com.jhw.swing.material.components.datepicker._MonthPicker;
import com.jhw.swing.material.components.datepicker._YearMonthPicker;
import com.jhw.swing.material.components.datepicker._YearPicker;
import com.jhw.swing.material.components.datepicker._YearPickerIcon;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_DATE_PICKER extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_DATE_PICKER() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.YELLOWA_400);

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        MaterialDatePicker date1 = MaterialDatePickersFactory.build();
        vlc.add(date1, true);

        MaterialDatePickerIcon date2 = MaterialDatePickersFactory.buildIcon();
        vlc.add(date2, true);

        _MonthPicker month = _MonthPicker.from();
        month.setObject(_Month.from(9));
        vlc.add(month, true);

        _YearPicker year = _YearPicker.from();
        year.setObject(Year.of(2021));
        vlc.add(year, true);

        _YearPickerIcon yearIcon = _YearPickerIcon.from();
        yearIcon.setObject(Year.of(2021));
        vlc.add(yearIcon, true);

        _YearMonthPicker yearMonth = _YearMonthPicker.from();
        yearMonth.setObject(YearMonth.of(2025, Month.MARCH));
        vlc.add(yearMonth, true);

        vlc.add(new JButton(new AbstractAction("Wrong") {
            @Override
            public void actionPerformed(ActionEvent e) {
                date1.wrong("bu");
                date2.wrong("jijiji");
                month.wrong("aaa");
                year.wrong("123");
                yearMonth.wrong("123");
            }
        }));

        vlc.add(new JButton(new AbstractAction("Object") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, date1.getObject());
                JOptionPane.showMessageDialog(null, date2.getObject());
                JOptionPane.showMessageDialog(null, month.getObject());
                JOptionPane.showMessageDialog(null, yearIcon.getObject());
                JOptionPane.showMessageDialog(null, yearMonth.getObject());
            }
        }));

        jPanel1.add(vlc.build());

    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setSize(new Dimension(500, 500));
        //this.setExtendedState(MAXIMIZED_BOTH);

        this.setLocationRelativeTo(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EXAMPLE_DATE_PICKER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
