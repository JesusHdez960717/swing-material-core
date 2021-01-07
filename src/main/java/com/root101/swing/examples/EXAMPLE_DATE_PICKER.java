/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.examples;

//import com.root101.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.datepicker.MaterialDatePicker;
import com.root101.swing.material.components.datepicker.MaterialDatePickerIcon;
import com.root101.swing.material.components.datepicker.MaterialDatePickersFactory;
import com.root101.swing.material.components.datepicker.MaterialMonthPicker;
import com.root101.swing.material.components.datepicker.MaterialMonthPickerIcon;
import com.root101.swing.material.components.datepicker.MaterialYearMonthPicker;
import com.root101.swing.material.components.datepicker.MaterialYearMonthPickerIcon;
import com.root101.swing.material.components.datepicker.MaterialYearPicker;
import com.root101.swing.material.components.datepicker.MaterialYearPickerIcon;
import com.root101.swing.material.components.datepicker._Month;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.ui.MaterialLookAndFeel;
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
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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

        MaterialMonthPicker month = MaterialDatePickersFactory.buildMonthPicker();
        month.setObject(_Month.from(9));
        vlc.add(month, true);

        MaterialMonthPickerIcon monthIcon = MaterialDatePickersFactory.buildMonthPickerIcon();
        monthIcon.setObject(_Month.from(9));
        vlc.add(monthIcon, true);

        MaterialYearPicker year = MaterialDatePickersFactory.buildYearPicker();
        year.setObject(Year.of(2021));
        vlc.add(year, true);

        MaterialYearPickerIcon yearIcon = MaterialDatePickersFactory.buildYearPickerIcon();
        yearIcon.setObject(Year.of(2021));
        vlc.add(yearIcon, true);

        MaterialYearMonthPicker yearMonth = MaterialDatePickersFactory.buildYearMonthPicker();
        yearMonth.setObject(YearMonth.of(2025, Month.MARCH));
        vlc.add(yearMonth, true);

        MaterialYearMonthPickerIcon yearMonthIcon = MaterialDatePickersFactory.buildYearMonthPickerIcon();
        yearMonthIcon.setObject(YearMonth.of(2025, Month.DECEMBER));
        vlc.add(yearMonthIcon, true);

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
