/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.splashScreen;

import com.root101.swing.material.components.container.MaterialContainersFactory;
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

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
