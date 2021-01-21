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

import com.root101.swing.material.components.combobox.MaterialComboBox;
import com.root101.swing.material.components.combobox.MaterialComboBoxFactory;
import com.root101.swing.material.components.combobox.MaterialComboBoxIcon;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.ui.MaterialLookAndFeel;
import com.root101.utils.refraction.FiltrableRefraction;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class EXAMPLE_COMBO extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_COMBO() {
        initComponents();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        MaterialComboBox<Integer> combo = MaterialComboBoxFactory.build();
        combo.setLabel("simple");
        combo.setModel(new DefaultComboBoxModel(new Object[]{4, 4, 5, 45, 456789999, 2, 3, 4, 5, 6}));
        vlc.add(combo, true);

        MaterialComboBoxIcon<Integer> comboIcon = MaterialComboBoxFactory.buildIcon();
        comboIcon.setLabel("simple icon");
        comboIcon.setModel(new DefaultComboBoxModel(new Object[]{1, 2, 3, 4, 5, 6}));
        comboIcon.setEnabled(false);
        vlc.add(comboIcon, true);

        MaterialComboBox comboFiltrable = MaterialComboBoxFactory.buildFiltrable();
        comboFiltrable.setLabel("filtrable");
        comboFiltrable.setModel(Arrays.asList(new Object[]{1, 2, 3, 4, 5, 6}));
        vlc.add(comboFiltrable, true);

        MaterialComboBoxIcon comboFiltrableIcon = MaterialComboBoxFactory.buildFiltrableIcon();
        comboFiltrableIcon.setLabel("filtrable icon");
        comboFiltrableIcon.setModel(new DefaultComboBoxModel(new Object[]{1, 2, 3, 4, 5, 6}));
        vlc.add(comboFiltrableIcon, true);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(vlc.build());
        jPanel1.setBackground(MaterialColors.WHITE);

        JButton wrong = new JButton(new AbstractAction("wrong") {
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.wrong("RUUUN");
                comboFiltrable.wrong("bu");
                comboIcon.wrong("RUUUN");
                comboFiltrableIcon.wrong("bu");
            }
        });
        jPanel1.add(wrong, BorderLayout.SOUTH);
        JButton clear = new JButton(new AbstractAction("wrong") {
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.clear();
                comboFiltrable.clear();
                comboIcon.clear();
                comboFiltrableIcon.clear();
            }
        });
        jPanel1.add(clear, BorderLayout.NORTH);
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
