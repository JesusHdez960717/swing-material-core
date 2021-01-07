/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.examples;

//import com.root101.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.filechooser.MaterialFileChoosersFactory;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelDoble;
import com.root101.swing.material.components.labels.MaterialLabelDobleMoney;
import com.root101.swing.material.components.labels.MaterialLabelMoney;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_LABELS extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_LABELS() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        MaterialLabel simple = MaterialLabelsFactory.build();
        simple.setText("simple");
        simple.setEnabled(false);
        vlc.add(simple, true);

        MaterialLabelMoney money = MaterialLabelsFactory.buildMoney();
        money.setMoney(new BigDecimal("123123"), "MN");
        vlc.add(money, true);

        MaterialLabelMoney moneyPos = MaterialLabelsFactory.buildMoneyPositive();
        moneyPos.setMoney(new BigDecimal("44"), "MN");
        vlc.add(moneyPos, true);

        MaterialLabelMoney moneyNeg = MaterialLabelsFactory.buildMoneyNegative();
        moneyNeg.setMoney(new BigDecimal("2222"), "MN");
        vlc.add(moneyNeg, true);

        MaterialLabelDoble doublee = MaterialLabelsFactory.buildDouble();
        vlc.add(doublee, true);

        MaterialLabelDobleMoney doubleMoney = MaterialLabelsFactory.buildDoubleMoney();
        doubleMoney.setMoney(new BigDecimal("11111"), "AAA");
        doubleMoney.setText("bum");
        vlc.add(doubleMoney, true);

        MaterialLabelDobleMoney doubleMoneyNeg = MaterialLabelsFactory.buildDoubleMoneyNegative();
        doubleMoneyNeg.setMoney(new BigDecimal("1111891"), "AAAZA");
        doubleMoneyNeg.setText("bummmmm1");
        vlc.add(doubleMoneyNeg, true);

        MaterialLabelDobleMoney doubleMoneyPos = MaterialLabelsFactory.buildDoubleMoneyPositive();
        doubleMoneyPos.setMoney(new BigDecimal("656"), "tttt");
        doubleMoneyPos.setText("bummmmm2");
        vlc.add(doubleMoneyPos, true);

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
                new EXAMPLE_LABELS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
