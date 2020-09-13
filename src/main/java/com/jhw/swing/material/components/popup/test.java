/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button._MaterialButtonSqrt;
import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.clock._ClockFace1123123;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class test extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public test() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);

        List<Action> actions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actions.add(new AbstractAction("EXCEL", MaterialIcons.ADD_A_PHOTO.deriveIcon(35f)) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Click en el boton.");
                }
            });
        }
        MaterialButton btn = MaterialButtonsFactory.buildPopup(new Popup(actions) {
            /*@Override
            protected JComponent buildComponent(Action act) {
                MaterialButton b = MaterialButtonsFactory.buildRound();
                b.setAction(act);
                return b;
            }*/
        });
        btn.setBackground(MaterialColors.GREEN_600);

        jPanel1.add(btn);
        jPanel1.add(_ClockFace1123123.from(), BorderLayout.NORTH);

        _MaterialButtonSqrt b = _MaterialButtonSqrt.from();
        b.setAction(new AbstractAction("123", MaterialIcons.ACCOUNT_CIRCLE) {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        jPanel1.add(b, BorderLayout.SOUTH);
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
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
