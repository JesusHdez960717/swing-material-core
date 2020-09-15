/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.table.MaterialTable;
import com.jhw.swing.material.components.table.MaterialTableByPage;
import com.jhw.swing.material.components.table.MaterialTableFactory;
import com.jhw.swing.material.components.table._MaterialTableByPage;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_TABLE extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_TABLE() {
        initComponents();

        jPanel1.setBackground(MaterialColors.RED_200);
        jPanel1.setLayout(new BorderLayout());

        MaterialTable simple = MaterialTableFactory.build();
        simple.clear();
        simple.addRow(new Object[]{"1", "2", "3", "4"});
        simple.addRow(new Object[]{"1", "2", "3", "4"});
        simple.addRow(new Object[]{"1", "2", "3", "4"});
        simple.addRow(new Object[]{"1", "2", "3", "4"});
        simple.addRow(new Object[]{"1", "2", "3", "4"});
        jPanel1.add(simple, BorderLayout.NORTH);

        MaterialTableByPage page = MaterialTableFactory.buildByPage();
        page.setPageVisibility(true);
        page.clear();
        for (int i = 0; i < 150; i++) {
            page.addRow(new Object[]{i, i, i, i});
        }
        jPanel1.add(page);

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
                new EXAMPLE_TABLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
