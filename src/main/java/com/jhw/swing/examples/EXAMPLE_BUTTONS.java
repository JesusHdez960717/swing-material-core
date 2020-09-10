/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.material.components.button.*;
import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.button.prepared._buttonView;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_BUTTONS extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_BUTTONS() {
        initComponents();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        _MaterialButton btnSimple = (_MaterialButton) MaterialButtonsFactory.buildButton();
        btnSimple.setText("material button simple");
        btnSimple.setIcon(MaterialIcons.ACCESSIBILITY);
        btnSimple.setBackground(Color.yellow);
        btnSimple.setRippleColor(Color.pink);
        vlc.add(btnSimple);

        _buttonAddEdit addEdit = (_buttonAddEdit) MaterialButtonsFactory.buildAddEdit();
        addEdit.isCreated(true);
        vlc.add(addEdit);

        _buttonAddEdit addEdit2 = (_buttonAddEdit) MaterialButtonsFactory.buildAddEdit();
        addEdit2.isCreated(false);
        vlc.add(addEdit2);

        vlc.add(MaterialButtonsFactory.buildDouble());

        _MaterialButton flat = (_MaterialButton) MaterialButtonsFactory.buildFlat();
        flat.setText("flat simple");
        vlc.add(flat);

        JButton link = MaterialButtonsFactory.buildHyperlink();
        link.setText("hyperlink");
        vlc.add(link);

        _MaterialButtonIconTranspRotate rot = (_MaterialButtonIconTranspRotate) MaterialButtonsFactory.buildIconTranspRotate();
        rot.addActionListener(new ActionListener() {
            boolean a = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                rot.setIconRotate(a ? MaterialIcons.ARROW_DROP_LEFT : MaterialIcons.ARROW_DROP_RIGHT);
                a = !a;
            }
        });
        rot.doClick();

        vlc.add(rot);
        vlc.add(MaterialButtonsFactory.buildIconTransparent());

        _MaterialButtonPopup popup = (_MaterialButtonPopup) MaterialButtonsFactory.buildPopup();
        JPopupMenu menu = new JPopupMenu();
        menu.add(new JMenuItem("1"));
        menu.add(new JMenuItem("2"));
        menu.add(new JMenuItem("3"));
        popup.setComponentPopupMenu(menu);
        vlc.add(popup);

        _MaterialIconButtonRound round = (_MaterialIconButtonRound) MaterialButtonsFactory.buildRound();
        round.setRippleColor(Color.yellow);
        vlc.add(round);

        _buttonView view = (_buttonView) MaterialButtonsFactory.buildView();
        vlc.add(view);

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
