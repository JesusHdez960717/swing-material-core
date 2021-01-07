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
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
