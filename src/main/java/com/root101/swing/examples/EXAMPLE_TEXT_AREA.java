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

import com.root101.swing.material.components.textarea.MaterialTextAreaFactory;
import com.root101.swing.material.components.textarea.DefaultContentArea;
import com.root101.swing.material.components.textarea._MaterialTextArea;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class EXAMPLE_TEXT_AREA extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_TEXT_AREA() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);
        jPanel1.setBackground(Color.white);

        _MaterialTextArea text = MaterialTextAreaFactory.build();
        text.setBorderTitle("buajajajaja");
        text.setObject("\n\n\n\n\n\n\n");

        jPanel1.add(text);

        DefaultContentArea c = DefaultContentArea.from();
        c.header("header").headerFont(MaterialFontRoboto.BOLD.deriveFont(50f));
        c.text("123123123123\n12312313\ndfgdfgdfgdg\ndsfgsdfsdf");
        jPanel1.add(c, BorderLayout.NORTH);

        jPanel1.add(new Checkbox("focus"), BorderLayout.SOUTH);
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
                new EXAMPLE_TEXT_AREA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
