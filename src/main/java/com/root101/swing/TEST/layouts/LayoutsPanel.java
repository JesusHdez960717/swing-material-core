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
package com.root101.swing.TEST.layouts;

import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.container.panel._PanelGradient;
import com.root101.swing.material.standards.MaterialColors;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 */
public class LayoutsPanel extends _PanelGradient {

    public LayoutsPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(MaterialColors.BLACK);

        curves = MaterialContainersFactory.buildPanelCurves();
        this.add(curves, BorderLayout.CENTER);

        curves.setLayout(new BorderLayout());
        curves.setBorder(BorderFactory.createEmptyBorder(30, 0, 40, 0));

        tab = MaterialContainersFactory.buildTabbedSelector();
        curves.add(tab, BorderLayout.CENTER);
        
        tab.addTab("tab 1", new JPanel());
        tab.addTab("tab buajajaja", MaterialContainersFactory.buildPanel());
    }

    private JPanel curves;
    private JTabbedPane tab;
}
