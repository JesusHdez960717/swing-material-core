/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.components.searchfield.MaterialSearchField;
import com.jhw.swing.material.components.searchfield._MaterialSearchField;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.root101.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_SEARCH_FIELD extends javax.swing.JFrame implements Update {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_SEARCH_FIELD() {
        initComponents();

        jPanel1.setBackground(MaterialColors.BLUE_50);
        jPanel1.setLayout(new BorderLayout());

        filter = MaterialContainersFactory.buildPanelGradient();
        filter.setLayout(new BorderLayout());
        jPanel1.add(filter);

        search = _MaterialSearchField.from();
        search.setSearchActionListener((ActionEvent e) -> {
            update();
        });
        jPanel1.add(search, BorderLayout.NORTH);

        Random rdm = new Random();
        for (int i = 0; i < 20; i++) {
            l.add(String.valueOf(rdm.nextLong()));
        }
        update();
    }
    MaterialSearchField search;
    List<String> l = new ArrayList<>();
    JPanel filter;

    @Override
    public void update() {
        filter.removeAll();
        System.out.println("updating");
        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        for (String s : l) {
            if (s.contains(search.getText())) {
                MaterialLabel label = MaterialLabelsFactory.build();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setText(s);
                vlc.add(label);
            }
        }

        filter.add(vlc.build());
        filter.revalidate();
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
                new EXAMPLE_SEARCH_FIELD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
