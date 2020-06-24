package com.jhw.swing.bundles.dialog;

import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Dialogo vacío que muestra un panel.<br/>
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

        this.setSize(basePanel.getPreferredSize());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setVisible(true);
    }

    public JPanel getBasePanel() {
        return basePanel;
    }

}
