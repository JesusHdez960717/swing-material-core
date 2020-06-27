package com.jhw.swing.bundles.dialog;

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
    }

    public DialogPanel(String title, JPanel modelPanel) {
        super();
        this.basePanel = modelPanel;
        this.setUndecorated(false);
        this.setTitle(title);

        setUpDialog();
    }

    private void setUpDialog() {
        this.setLayout(new GridLayout(1, 1));
        this.add(basePanel);
        int w = basePanel.getPreferredSize().width + 15;
        int h = basePanel.getPreferredSize().height + (isUndecorated() ? 0 : 40);
        this.setSize(new Dimension(w, h));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setVisible(true);
    }

    public JPanel getBasePanel() {
        return basePanel;
    }

}
