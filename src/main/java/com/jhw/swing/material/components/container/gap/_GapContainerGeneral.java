package com.jhw.swing.material.components.container.gap;

import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _GapContainerGeneral<T extends Component> extends _PanelTransparent {

    private int gap = 20;
    private T component;
    private Container parent;

    public _GapContainerGeneral(Container parent, T component, int gap) {
        this.parent = parent;
        this.gap = gap;
        initComponents();
        setComponent(component);
    }

    private void initComponents() {
        panelModelCore = new com.jhw.swing.material.components.container.panel._PanelComponent();
        
        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(this);
        this.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(0)
                                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(0)
                                .addComponent(parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0))
        );
        
        javax.swing.GroupLayout panelModelLayout = new javax.swing.GroupLayout(parent);
        parent.setLayout(panelModelLayout);
        panelModelLayout.setHorizontalGroup(
                panelModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelModelLayout.createSequentialGroup()
                                .addGap(gap)
                                .addComponent(panelModelCore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(gap))
        );
        panelModelLayout.setVerticalGroup(
                panelModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelModelLayout.createSequentialGroup()
                                .addGap(gap)
                                .addComponent(panelModelCore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(gap))
        );
    }

    private com.jhw.swing.material.components.container.panel._PanelComponent panelModelCore;

    public void setComponent(T component) {
        this.component = component;
        this.panelModelCore.setComponent(this.component);
    }

    public T getCoreComponent() {
        return component;
    }

    public int getGap() {
        return gap;
    }
}
