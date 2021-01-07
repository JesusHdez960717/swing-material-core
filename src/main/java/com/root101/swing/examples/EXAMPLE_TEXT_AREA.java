/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.examples;

//import com.root101.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.filechooser.MaterialFileChoosersFactory;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelDoble;
import com.root101.swing.material.components.labels.MaterialLabelDobleMoney;
import com.root101.swing.material.components.labels.MaterialLabelMoney;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.components.passwordfield.MaterialPasswordField;
import com.root101.swing.material.components.passwordfield.MaterialPasswordFieldFactory;
import com.root101.swing.material.components.progress._MaterialProgressSpinner;
import com.root101.swing.material.components.scrollpane.MaterialScrollFactory;
import com.root101.swing.material.components.scrollpane.MaterialScrollPane;
import com.root101.swing.material.components.scrollpane._MaterialScrollPaneCore;
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
import java.math.BigDecimal;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
