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

import com.root101.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.toggle.MaterialToggleButton;
import com.root101.swing.material.components.toggle.MaterialToggleFactory;
import com.root101.swing.material.components.toggle.ToggleGroup;
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
