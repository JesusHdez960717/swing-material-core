/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.splashScreen;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
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
        this.setPreferredSize(new Dimension(500, 500));
        labelProgress = new _MaterialLabel();
        labelProgress.setPreferredSize(new Dimension(0, 25));
        labelProgress.setText(text);
        labelProgress.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(MaterialColors.GREY_600);

        this.setLayout(new BorderLayout());
        this.add(mainSplash(), BorderLayout.CENTER);
        this.add(labelProgress, BorderLayout.SOUTH);
    }

    private _MaterialLabel labelProgress;

    public _PanelGradient mainSplash() {
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
        System.setErr(ps);
        System.setOut(ps);
    }
}
