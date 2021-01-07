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
package com.root101.swing.bundles.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Dialogo vacio que muestra un panel.<br/>
 * Si NO tiene titulo se undecora.
 *
 * Ejemplo: new DialogPanel("123", new EmptyPanel());
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
