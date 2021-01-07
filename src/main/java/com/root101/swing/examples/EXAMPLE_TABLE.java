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

import com.root101.swing.material.components.table.MaterialTable;
import com.root101.swing.material.components.table.MaterialTableByPage;
import com.root101.swing.material.components.table.MaterialTableFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
