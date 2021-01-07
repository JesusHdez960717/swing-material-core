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
package com.root101.swing.TEST.search;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.components.searchfield._MaterialSearchField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.jdesktop.swingx.JXCollapsiblePane;
import com.root101.swing.material.standards.MaterialColors;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class GeneralSearch extends _PanelTransparent {

    private boolean shrinked = true;
    private final JXCollapsiblePane collapse = new JXCollapsiblePane();

    public GeneralSearch() {
        initComponents();
        personalize();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(collapse, BorderLayout.CENTER);

        this.collapse.setLayout(new BorderLayout());
        this.searchField = new _MaterialSearchField();
        this.collapse.add(searchField, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(20, 20));
        this.setMaximumSize(new Dimension(300, 100));
    }
    private _MaterialSearchField searchField;

    private final FocusListener focusListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            setShrinked(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            setShrinked(true);
        }
    };

    private void personalize() {
        this.collapse.setDirection(JXCollapsiblePane.Direction.LEFT);
        this.collapse.getContentPane().setBackground(MaterialColors.TRANSPARENT);
        searchField.getSearchField().addFocusListener(focusListener);
        searchField.getButtonSearch().addFocusListener(focusListener);
    }

    public void setShrinked(boolean shrink) {
        this.shrinked = shrink;
        this.collapse.setCollapsed(this.shrinked);
    }

}
