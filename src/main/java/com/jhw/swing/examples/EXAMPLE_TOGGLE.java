/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
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
public class EXAMPLE_TOGGLE extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_TOGGLE() {
        initComponents();

        jPanel1.setBackground(MaterialColors.BLUE_50);
        jPanel1.setLayout(new BorderLayout());

        /*MaterialToggleButton btn = MaterialToggleFactory.buildButton();
        btn.addActionListener((ActionEvent e) -> {
            System.out.println(btn.isSelected());
        });
        this.add(btn);*/
        
        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(MaterialToggleFactory.buildButton());
        vlc.add(MaterialToggleFactory.buildCheckBox());
        vlc.add(MaterialToggleFactory.buildRadioButton());

        HorizontalLayoutContainer.builder hlcGroup = HorizontalLayoutContainer.builder();
        ToggleGroup g = MaterialToggleFactory.buildGroup();
        MaterialToggleButton t1 = MaterialToggleFactory.buildCheckBox();
        g.add(t1);
        hlcGroup.add(t1);

        MaterialToggleButton t2 = MaterialToggleFactory.buildCheckBox();
        g.add(t2);
        hlcGroup.add(t2);

        MaterialToggleButton t3 = MaterialToggleFactory.buildCheckBox();
        g.add(t3);
        hlcGroup.add(t3);

        vlc.add(hlcGroup.build());
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
                new EXAMPLE_TOGGLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
