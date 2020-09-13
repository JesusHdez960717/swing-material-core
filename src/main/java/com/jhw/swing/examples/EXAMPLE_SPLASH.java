/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

//import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.bundles.loading.LoadingProcess;
import com.jhw.swing.bundles.loading.LoadingWorker;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.container.panel.MaterialPanelBorder;
import com.jhw.swing.material.components.splashScreen.SplashScreen;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_SPLASH extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EXAMPLE_SPLASH() {
        initComponents();

        jPanel1.setLayout(new BorderLayout());
        jPanel1.setBackground(MaterialColors.WHITE);
        jPanel1.add(new JButton(new AbstractAction("Start") {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        }));
    }

    private void start() {
        new LoadingWorker<Void>(new SplashScreen() {
            @Override
            public JPanel mainSplash() {
                MaterialPanelBorder back = MaterialContainersFactory.buildPanelGradient();
                back.setIcon(MaterialIcons.CARD_GIFTCARD.deriveIcon(500));
                return back;
            }
        }, new LoadingProcess<Void>() {
            @Override
            public Void process() throws Exception {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println("Dormido " + i + " segundos");
                }
                return null;
            }

            @Override
            public void completed(Void result) throws Exception {
                System.out.println("Iniciando el sistema....");
            }

            @Override
            public void errorInProcess(Exception result) {

                System.exit(-1);
            }
        });
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        this.setContentPane(jPanel1);

        pack();

        this.setSize(new Dimension(500, 500));
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
                new EXAMPLE_SPLASH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
