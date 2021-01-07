/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.splashScreen;

import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.util.Utils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SplashScreen extends JPanel {

    public static SplashScreen from(JPanel panel) {
        return new SplashScreen() {
            @Override
            public JPanel mainSplash() {
                return panel;
            }
        };
    }

    private String text = "Cargando...\n";

    /**
     * Usar SplashScreen.from(panel). Si se va a usar este constructor
     * asegurarse de reimplementar mainSplash(), asi:
     * <pre>
     *  new SplashScreen() {
     *      @Override
     *      public JPanel mainSplash() {
     *          return panel;//el panel que se quiere mostrar
     *      }
     *  };
     * </pre>
     *
     * @deprecated
     */
    @Deprecated
    public SplashScreen() {
        initComponents();
        redirectOut();
    }

    private void initComponents() {
        Rectangle screen = Utils.getScreenSize();
        this.setPreferredSize(new Dimension((int) (screen.getWidth() / 3), (int) (screen.getHeight() / 3)));
        labelProgress = new JLabel();
        labelProgress.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        labelProgress.setPreferredSize(new Dimension(0, 20));
        labelProgress.setText(text);
        //labelProgress.setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(MaterialColors.GREY_200);

        this.setLayout(new BorderLayout());
        this.add(mainSplash(), BorderLayout.CENTER);
        this.add(labelProgress, BorderLayout.SOUTH);
    }

    private JLabel labelProgress;

    /**
     * Method to Override for personalized image display
     *
     * @return
     * @deprecated
     */
    @Deprecated
    public JPanel mainSplash() {
        return MaterialContainersFactory.buildPanelGradient();
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
