/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.exmaples;

import com.jhw.swing.examples.*;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextFieldIcon;
import com.jhw.swing.material.components.textfield.MaterialTextField;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.prepared.textfield.MaterialPreparedTextFactory;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.utils.formateer.CreditCardFormateer;
import com.jhw.utils.formateer.MoneyFormateer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_TEXT_FIELDS extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_TEXT_FIELDS() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.REDA_200);

        /*MaterialToggleButton btn = MaterialToggleFactory.buildButton();
        btn.addActionListener((ActionEvent e) -> {
            System.out.println(btn.isSelected());
        });
        this.add(btn);*/
        //-------------------SIMPLE-------------------------
        VerticalLayoutContainer.builder vlcSimple = VerticalLayoutContainer.builder();


        MaterialTextField textFieldDouble = MaterialPreparedTextFactory.buildDouble();
        textFieldDouble.setLabel("text field simple double");
        vlcSimple.add(textFieldDouble, true);

        MaterialTextFieldIcon textFieldDoubleIcon = MaterialPreparedTextFactory.buildDoubleIcon();
        textFieldDoubleIcon.setLabel("text field simple double icon");
        vlcSimple.add(textFieldDoubleIcon, true);

        MaterialTextField textFieldInt = MaterialPreparedTextFactory.buildInteger();
        textFieldInt.setLabel("text field simple integer");
        vlcSimple.add(textFieldInt, true);

        MaterialTextFieldIcon textFieldIntIcon = MaterialPreparedTextFactory.buildIntegerIcon();
        textFieldIntIcon.setLabel("text field simple integer icon");
        vlcSimple.add(textFieldIntIcon, true);
        //-------------------SIMPLE-------------------------

        //-------------------Formated-------------------------
        VerticalLayoutContainer.builder vlcFormated = VerticalLayoutContainer.builder();
        MaterialFormatedTextField formatedTextFieldMoney = MaterialPreparedTextFactory.buildFormatedMoney();
        formatedTextFieldMoney.setLabel("formated runtime money");
        vlcFormated.add(formatedTextFieldMoney, true);

        MaterialFormatedTextFieldIcon formatedTextFieldMoneyIcon = MaterialPreparedTextFactory.buildFormatedMoneyIcon();
        formatedTextFieldMoneyIcon.setLabel("formated runtime money icon");
        vlcFormated.add(formatedTextFieldMoneyIcon, true);
        //-------------------Formated-------------------------

        jPanel1.add(vlcSimple.build(), BorderLayout.WEST);
        jPanel1.add(vlcFormated.build(), BorderLayout.EAST);

    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setSize(new Dimension(500, 500));
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
                new EXAMPLE_TEXT_FIELDS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
