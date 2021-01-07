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

import com.root101.swing.material.components.button.MaterialButton;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.ui.MaterialLookAndFeel;
import com.root101.swing.util.AbstractActionUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class EXAMPLE_POPUP extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_POPUP() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);

        List<Action> actions = new ArrayList<>();
        actions.add(new AbstractAction("", MaterialIcons.EXCEL.deriveIcon(30)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de excel.");
            }
        });
        actions.add(new AbstractAction("NB", MaterialIcons.TEC_NB.deriveIcon(24)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de NB.");
            }
        });
        actions.add(new AbstractAction("ADOBE", MaterialIcons.TEC_ADOBE.deriveIcon(24)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de adobe.");
            }
        });
        actions.add(new AbstractAction("FLAT", MaterialIcons.TEC_FLATICON.deriveIcon(24)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de flaticon.");
            }
        });
        actions.add(new AbstractAction("GIT", MaterialIcons.TEC_GIT.deriveIcon(24)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de git.");
            }
        });
        Action ac = new AbstractAction("JAVA", MaterialIcons.TEC_JAVA.deriveIcon(24)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Click en el boton de java.");
            }
        };
        ac.putValue(AbstractActionUtils.KEY_BACKGROUND, MaterialColors.YELLOW_600);
        actions.add(ac);

        MaterialButton btn = MaterialButtonsFactory.buildPopup(actions);
        btn.setText("Exportar");
        btn.setIcon(MaterialIcons.EXPORT);

        jPanel1.add(btn);
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
                new EXAMPLE_POPUP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
