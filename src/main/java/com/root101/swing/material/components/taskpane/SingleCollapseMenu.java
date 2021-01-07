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
package com.root101.swing.material.components.taskpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXCollapsiblePane;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class SingleCollapseMenu extends CollapseMenu {

    private final Action action;

    public SingleCollapseMenu(Action action) {
        this(action, true);
    }

    public SingleCollapseMenu(Action action, boolean seleccionable) {
        super((ImageIcon) action.getValue(Action.SMALL_ICON), action.getValue(Action.NAME).toString());
        this.action = action;

        if (seleccionable) {
            getjButtonIcono().addActionListener(childSelectedListener);
            getjButtonNombre().addActionListener(childSelectedListener);
        }
    }

    @Override
    protected void configurateUI() {
        super.configurateUI();
        this.getjLabel1().setVisible(false);
        getjPanelCollapsible().getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION).actionPerformed(null);
    }

    @Override
    protected void addListeners() {
        this.getjButtonNombre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
        this.getjButtonIcono().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(e);
            }
        });
    }
}
