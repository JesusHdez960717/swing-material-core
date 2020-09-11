/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.container.MaterialContainersFactory;
//import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelAvatarChooser;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.swing.util.AvatarPanelAvatarChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_CONTAINERS extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_CONTAINERS() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.RED_800);

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(MaterialContainersFactory.buildPanel(), true);

        _PanelAvatarChooser avatars = MaterialContainersFactory.buildPanelAvatar();
        List<AvatarPanelAvatarChooser> avatares = new ArrayList<>();
        avatares.add(new AvatarPanelAvatarChooser("1", "bu", MaterialIcons.ADD_ALERT.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("2", "buu", MaterialIcons.POLL.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("3", "buuu", MaterialIcons.LABEL.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("4", "buuuu", MaterialIcons.FEEDBACK.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("5", "buuuuu", MaterialIcons.ASSISTANT.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("6", "buuuuuu", MaterialIcons.TEC_NB.getImage()));
        avatars.setAvatars(avatares);
        vlc.add(avatars, true);

        JPanel comp = MaterialContainersFactory.buildPanelComponent();
        comp.add(new JButton("Component"));
        vlc.add(comp, true);

        JPanel comp2 = MaterialContainersFactory.buildPanelComponentTransparent();
        comp2.add(new JButton("Component 2"));
        vlc.add(comp2, true);

        vlc.add(MaterialContainersFactory.buildPanelCurves(), true);

        vlc.add(MaterialContainersFactory.buildPanelGradient(), true);
        vlc.add(MaterialContainersFactory.buildPanelGradientTranslucid(), true);
        vlc.add(MaterialContainersFactory.buildPanelTransparent(), true);

        jPanel1.add(vlc.build(), BorderLayout.WEST);

        VerticalLayoutContainer.builder vlc2 = VerticalLayoutContainer.builder();

        JTabbedPane close = MaterialContainersFactory.buildTabbedClose();
        close.add("1", new JPanel());
        close.add("2", new JPanel());
        close.add("3", new JPanel());
        vlc2.add(close, true);

        JTabbedPane header = MaterialContainersFactory.buildTabbedHeader();
        header.add("1", new JPanel());
        header.add("2", new JPanel());
        header.add("3", new JPanel());
        vlc2.add(header, true);
        
        
        JTabbedPane selector = MaterialContainersFactory.buildTabbedSelector();
        selector.add("1", new JPanel());
        selector.add("2", new JPanel());
        selector.add("3", new JPanel());
        vlc2.add(selector, true);
        jPanel1.add(vlc2.build(), BorderLayout.EAST);
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
                new EXAMPLE_CONTAINERS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
