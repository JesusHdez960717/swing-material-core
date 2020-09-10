/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.combobox.*;
//import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_COMBO extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_COMBO() {
        initComponents();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        _MaterialComboBox<Integer> combo = (_MaterialComboBox<Integer>) MaterialComboBoxFactory.build();
        combo.setModel(new DefaultComboBoxModel(new Object[]{1, 2, 3, 4, 5, 6}));
        vlc.add(combo, true);

        _MaterialComboBoxFiltrable comboFiltrable = (_MaterialComboBoxFiltrable) MaterialComboBoxFactory.buildFiltrable();
        comboFiltrable.setModel(Arrays.asList(new Object[]{1, 2, 3, 4, 5, 6}));
        vlc.add(comboFiltrable, true);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(vlc.build());
        jPanel1.setBackground(MaterialColors.WHITE);

        JButton wrong = new JButton(new AbstractAction("wrong") {
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.wrong("RUUUN");
                comboFiltrable.wrong("bu");
            }
        });
        jPanel1.add(wrong, BorderLayout.SOUTH);

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
                new EXAMPLE_COMBO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
