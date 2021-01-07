package com.root101.swing.material.components.container.tabbed.prepared;

import com.root101.swing.material.components.container.tabbed._TabbedPaneHeader;
import java.awt.Component;
import com.root101.utils.interfaces.Update;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _TabbedPaneActualizable extends _TabbedPaneHeader implements Update {

    public _TabbedPaneActualizable() {
        addListeners();
    }

    private void addListeners() {
        this.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                onTabbedPaneStateChange();
            }
        });
    }

    private void onTabbedPaneStateChange() {
        Component c = this.getSelectedComponent();
        if (c != null && c instanceof Update) {
            ((Update) this.getSelectedComponent()).update();
        }
    }

    @Override
    public void update() {
        onTabbedPaneStateChange();
    }

    public void actualizarAll() {
        for (Component c : this.getComponents()) {
            if (c != null && c instanceof Update) {
                ((Update) this.getSelectedComponent()).update();
            }
        }
    }

}
