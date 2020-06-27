package com.jhw.swing.material.components.container.gap;

import com.jhw.swing.material.components.container.panel._MaterialPanel;
import java.awt.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialPanelComponent<T extends Component> extends _MaterialPanel {

    private int gap = 20;
    private T component;

    public _MaterialPanelComponent() {
        initComponents();
    }

    public _MaterialPanelComponent(T component) {
        this(component, 20);
    }

    public _MaterialPanelComponent(T component, int gap) {
        this.gap = gap;
        initComponents();
        setComponent(component);
    }

    private void initComponents() {
        panelModelCore = new com.jhw.swing.material.components.container.panel._PanelComponent();

        javax.swing.GroupLayout panelModelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(panelModelLayout);
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

    public T getComponent() {
        return component;
    }

    public int getGap() {
        return gap;
    }
}
