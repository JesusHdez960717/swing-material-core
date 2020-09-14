/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.textfield.MaterialTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextField;
import com.jhw.swing.material.components.toggle.MaterialToggleButton;
import com.jhw.swing.material.components.toggle.MaterialToggleFactory;
import com.jhw.swing.material.components.toggle.ToggleGroup;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        MaterialTextField simple = MaterialTextAreaFactory.build();
        vlc.add(simple, true);

        MaterialTextField icon = MaterialTextAreaFactory.buildIcon();
        vlc.add(icon, true);

        jPanel1.add(vlc.build());

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
