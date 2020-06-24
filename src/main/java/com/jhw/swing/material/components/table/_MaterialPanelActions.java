package com.jhw.swing.material.components.table;

import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.container.panels._PanelGradient;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialPanelActions extends _PanelGradient {

    private final _MaterialIconButtonTranspRect buttonDelete = new com.jhw.swing.material.components.button._MaterialIconButtonTranspRect();
    private final _MaterialIconButtonTranspRect buttonEdit = new com.jhw.swing.material.components.button._MaterialIconButtonTranspRect();
    private final _MaterialIconButtonTranspRect buttonView = new com.jhw.swing.material.components.button._MaterialIconButtonTranspRect();

    private final ArrayList<_MaterialIconButtonTranspRect> extras = new ArrayList<>();

    public _MaterialPanelActions() {
        this.setLayout(new GridLayout(1, 0));
        personalize();
    }

    public void addButtonDeleteActionListener(ActionListener action) {
        buttonDelete.addActionListener(action);
    }

    public void addButtonViewActionListener(ActionListener action) {
        buttonView.addActionListener(action);
    }

    public void addButtonEditActionListener(ActionListener action) {
        buttonEdit.addActionListener(action);
    }

    public void setButtonsVisibility(boolean delete, boolean edit, boolean view) {
        buttonDelete.setVisible(delete);
        buttonView.setVisible(view);
        buttonEdit.setVisible(edit);
    }

    public void addExtras(ArrayList<_MaterialIconButtonTranspRect> ex) {
        this.extras.clear();
        this.extras.addAll(ex);
    }

    private void personalize() {
        this.removeAll();
        this.buttonDelete.setIcon(MaterialIcons.DELETE_FOREVER.deriveIcon(18));
        this.buttonView.setIcon(MaterialIcons.VISIBILITY.deriveIcon(18));
        this.buttonEdit.setIcon(MaterialIcons.EDIT.deriveIcon(18));

        for (_MaterialIconButtonTranspRect c : extras) {
            _MaterialIconButtonTranspRect act = c.clone();
            if (act.isVisible()) {
                this.add(act);
            }
        }
        if (buttonView.isVisible()) {
            this.add(buttonView);
        }
        if (buttonEdit.isVisible()) {
            this.add(buttonEdit);
        }
        if (buttonDelete.isVisible()) {
            this.add(buttonDelete);
        }

    }

    public static class builder {

        private ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        private ActionListener editListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        private ActionListener viewListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        private boolean deleteVisibility = true;
        private boolean editVisibility = true;
        private boolean viewVisibility = true;

        private final ArrayList<_MaterialIconButtonTranspRect> extras = new ArrayList<>();

        public builder extra(_MaterialIconButtonTranspRect c) {
            this.extras.add(c);
            return this;
        }

        public builder deleteListener(ActionListener lis) {
            this.deleteListener = lis;
            return this;
        }

        public builder editListener(ActionListener lis) {
            this.editListener = lis;
            return this;
        }

        public builder viewListener(ActionListener lis) {
            this.viewListener = lis;
            return this;
        }

        public builder deleteVisibility(boolean vis) {
            this.deleteVisibility = vis;
            return this;
        }

        public builder editVisibility(boolean vis) {
            this.editVisibility = vis;
            return this;
        }

        public builder viewVisibility(boolean vis) {
            this.viewVisibility = vis;
            return this;
        }

        public builder buttonsVisibility(boolean delete, boolean edit, boolean view) {
            this.deleteVisibility = delete;
            this.editVisibility = edit;
            this.viewVisibility = view;
            return this;
        }

        public int getComponents() {
            int count = extras.size();
            count += deleteVisibility ? 1 : 0;
            count += editVisibility ? 1 : 0;
            count += viewVisibility ? 1 : 0;
            return count;
        }

        public _MaterialPanelActions build() {
            _MaterialPanelActions action = new _MaterialPanelActions();
            action.addButtonDeleteActionListener(deleteListener);
            action.addButtonEditActionListener(editListener);
            action.addButtonViewActionListener(viewListener);
            action.setButtonsVisibility(deleteVisibility, editVisibility, viewVisibility);
            action.addExtras(extras);
            action.personalize();
            return action;
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
