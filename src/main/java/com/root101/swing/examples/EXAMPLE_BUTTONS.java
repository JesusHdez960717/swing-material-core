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
import com.root101.swing.material.components.button.MaterialButtonIcon;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.button._MaterialButtonIconTranspRotate;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class EXAMPLE_BUTTONS extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_BUTTONS() {
        initComponents();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        MaterialButton btnSimple = MaterialButtonsFactory.buildButton();
        btnSimple.setToolTipText("hi\nbuajajaja\n123\n");
        btnSimple.setText("material button simple");
        btnSimple.setIcon(MaterialIcons.ACCESSIBILITY);
        btnSimple.setBackground(Color.yellow);
        btnSimple.setRippleColor(Color.pink);
        vlc.add(btnSimple);

        vlc.add(MaterialButtonsFactory.buildDouble());

        MaterialButton flat = MaterialButtonsFactory.buildFlat();
        flat.setToolTipText("<html>hi<br>buajajaja<br>123<br></html>");
        flat.setText("flat simple");
        vlc.add(flat);

        JButton link = MaterialButtonsFactory.buildHyperlink();
        link.setText("hyperlink");
        vlc.add(link);

        MaterialButtonIcon rot = MaterialButtonsFactory.buildIconTranspRotate();
        rot.addActionListener(new ActionListener() {
            boolean a = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                ((_MaterialButtonIconTranspRotate) rot).setIconRotate(a ? MaterialIcons.ARROW_DROP_LEFT : MaterialIcons.ARROW_DROP_RIGHT);
                a = !a;
            }
        });
        rot.doClick();

        vlc.add(rot);

        MaterialButtonIcon transp = MaterialButtonsFactory.buildIconTransparent();
        transp.setEnabled(false);
        vlc.add(transp);

        MaterialButton popup = MaterialButtonsFactory.buildPopup();
        JPopupMenu menu = new JPopupMenu();
        menu.add(new JMenuItem("1"));
        menu.add(new JMenuItem("2"));
        menu.add(new JMenuItem("3"));
        popup.setComponentPopupMenu(menu);
        vlc.add(popup);

        vlc.add(MaterialButtonsFactory.buildPopup(Arrays.asList(new AbstractAction("123") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "BU");
            }
        })));

        MaterialButton round = MaterialButtonsFactory.buildRound();
        round.setRippleColor(Color.yellow);
        vlc.add(round);

        jPanel1.setBackground(MaterialColors.BLUE_50);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(vlc.build());
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setExtendedState(MAXIMIZED_BOTH);
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
                new EXAMPLE_BUTTONS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
