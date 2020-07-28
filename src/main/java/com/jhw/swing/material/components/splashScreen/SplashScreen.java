/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.splashScreen;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SplashScreen extends _PanelGradient {

    private String text = "Cargando...\n";

    public SplashScreen() {
        initComponents();
        redirectOut();
    }

    private void initComponents() {
        Rectangle screen = Utils.getScreenSize();
        this.setPreferredSize(new Dimension((int) (screen.getWidth() / 3), (int) (screen.getHeight() / 3)));
        labelProgress = new _MaterialLabel();
        labelProgress.setPreferredSize(new Dimension(0, 20));
        labelProgress.setText(text);
        labelProgress.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(MaterialColors.GREY_200);

        this.setLayout(new BorderLayout());
        this.add(mainSplash(), BorderLayout.CENTER);
        this.add(labelProgress, BorderLayout.SOUTH);
    }

    private _MaterialLabel labelProgress;

    /**
     * Method to Override for personalized image display
     *
     * @return
     * @deprecated
     */
    @Deprecated
    public JPanel mainSplash() {
        return new _PanelGradient(MaterialColors.AMBER_600);
    }

    private void redirectOut() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                char ch = (char) b;
                text += ch;
                String[] spl = text.split("\n");
                labelProgress.setText(spl[spl.length - 1]);
            }
        };
        PrintStream ps = new PrintStream(out);
        System.setOut(ps);
    }
}
