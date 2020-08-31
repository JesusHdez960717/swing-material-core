/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.standards.MaterialIcons;
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CopyPastePopup extends JPopupMenu {

    public static CopyPastePopup INSTANCE = new CopyPastePopup();

    private final Map<String, Action> map = new HashMap<>();

    private CopyPastePopup() {
        createActionMap();
        initComponents();
    }

    private void initComponents() {
        Action cut = new AbstractAction("Cortar", MaterialIcons.EDIT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.cutAction).actionPerformed(e);
            }
        };
        cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        this.add(cut);

        Action copy = new AbstractAction("Copiar", MaterialIcons.EDIT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.copyAction).actionPerformed(e);
            }
        };
        copy.putValue(Action.SMALL_ICON, MaterialIcons.COPYRIGHT);
        this.add(copy);

        Action pegar = new AbstractAction("Pegar", MaterialIcons.EDIT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.get(DefaultEditorKit.pasteAction).actionPerformed(e);
            }
        };
        pegar.putValue(Action.SMALL_ICON, MaterialIcons.PAYMENT);
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
