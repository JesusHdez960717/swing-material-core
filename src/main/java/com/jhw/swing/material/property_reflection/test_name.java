/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.property_reflection;

import com.jhw.swing.material.components.button.*;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class test_name extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public test_name() {
        initComponents();

        MaterialButton btn = MaterialButtonsFactory.buildButton();

        btn.setIcon(MaterialIcons.ACCESSIBILITY);
        btn.setText("button name");
        //btn.setRippleColor(Color.yellow);
        //btn.setPaintRipple(true);
        btn.setBackground(MaterialColors.BLACK);
        btn.setName("buajaja{icon: icon-static(com.jhw.swing.material.standards.MaterialIcons.ACCOUNT_BOX); ripple-color: color-static(com.jhw.swing.material.standards.MaterialColors.RED_500)}");

        System.out.println(btn.getName());

        jPanel1.setBackground(MaterialColors.BLUE_200);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(btn);
    }

    private class testA implements testB {

        @Override
        public String value() {
            return "123";
        }

    }

    private interface testB {

        public String value();

    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setExtendedState(MAXIMIZED_BOTH);
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
                new test_name().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
