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
package com.root101.swing.material.components.textfield;

import com.root101.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class CopyPastePopup extends JPopupMenu {

    public static CopyPastePopup INSTANCE = new CopyPastePopup();

    private final Map<String, Action> map = new HashMap<>();

    private CopyPastePopup() {
        createActionMap();
        initComponents();
    }

    private void initComponents() {
        Action cut = new AbstractAction("Cortar", MaterialIcons.CONTENT_CUT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.cutAction).actionPerformed(e);
            }
        };
        cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        this.add(cut);

        Action copy = new AbstractAction("Copiar", MaterialIcons.CONTENT_COPY) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.copyAction).actionPerformed(e);
            }
        };
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        this.add(copy);

        Action pegar = new AbstractAction("Pegar", MaterialIcons.CONTENT_PASTE) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.pasteAction).actionPerformed(e);
            }
        };
        pegar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
        this.add(pegar);

        this.add(SelectAll.INSTANCE);
    }

    private void createActionMap() {
        for (Action action : new DefaultEditorKit().getActions()) {
            map.put((String) action.getValue(Action.NAME), action);
        }
    }

    private static class SelectAll extends TextAction {

        public static final SelectAll INSTANCE = new SelectAll();

        public SelectAll() {
            super("Seleccionar todo");
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E"));
            this.putValue(Action.SMALL_ICON, MaterialIcons.SELECT_ALL);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextComponent component = getFocusedComponent();
            component.selectAll();
            component.requestFocusInWindow();
        }

    }
}
