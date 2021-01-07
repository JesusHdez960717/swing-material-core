package com.root101.swing.bundles.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Dialogo vacio que muestra un panel.<br/>
 * Si NO tiene titulo se undecora.
 *
 * Ejemplo: new DialogPanel("123", new EmptyPanel());
 *
 * @author Jesús Hernandez Barrios (jhernandezb96@gmail.com) 26/02/2020 00:08
 */
public class DialogPanel extends JDialog {

    private final JPanel basePanel;

    public DialogPanel(JPanel modelPanel) {
        super();
        this.basePanel = modelPanel;
        this.setUndecorated(true);

        setUpDialog();
        
        this.setVisible(true);
    }

    public DialogPanel(String title, JPanel modelPanel) {
        super();
        this.basePanel = modelPanel;
        this.setUndecorated(false);
        this.setTitle(title);

        setUpDialog();
        
        this.setVisible(true);
    }

    public DialogPanel(String title, JPanel modelPanel, boolean visible) {
        super();
        this.basePanel = modelPanel;
        this.setUndecorated(false);
        this.setTitle(title);

        setUpDialog();
        
        this.setVisible(visible);
    }

    private void setUpDialog() {
        this.setLayout(new BorderLayout());
        this.add(basePanel);
        int w = basePanel.getPreferredSize().width + 15;
        int h = basePanel.getPreferredSize().height + (isUndecorated() ? 0 : 40);
        this.setSize(new Dimension(w, h));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public JPanel getBasePanel() {
        return basePanel;
    }

}
