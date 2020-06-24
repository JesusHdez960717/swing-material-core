package com.jhw.swing.bundles.loading;

import com.jhw.swing.material.components.container.panels._MaterialPanel;
import java.awt.GridLayout;
import javax.swing.JDialog;
import com.jhw.swing.material.standars.MaterialColors;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class LoadingDialog extends JDialog {

    private final _MaterialPanel basePanel;

    public LoadingDialog() {
        super();

        this.basePanel = new LoadingPanel();

        this.setUndecorated(true);
        this.setBackground(MaterialColors.TRANSPARENT);

        this.setLayout(new GridLayout(1, 1));
        this.add(basePanel);
        this.setSize(basePanel.getPreferredSize());
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }
}
