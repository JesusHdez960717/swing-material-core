package com.jhw.swing.models.input.panels;

import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jhw.utils.interfaces.Update;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ModelMixPanel<T> extends _PanelTransparent {

    private ModelPanel modelPanel;
    private List<Component> extras = new ArrayList<>();

    public ModelMixPanel() {
        initComponents();
    }

    public ModelMixPanel(ModelPanel model, Component[] extras) {
        this(model, Arrays.asList(extras));
    }

    public ModelMixPanel(ModelPanel model, List<Component> extras) {
        this.modelPanel = model;
        this.extras = extras;

        initComponents();
        personalize();
        addListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        panelGeneral = new com.jhw.swing.material.components.container.panel._MaterialPanel();
        panelInputView = new com.jhw.swing.material.components.container.panel._PanelComponent();
        buttonAddEdit = new com.jhw.swing.material.components.button.prepared._buttonAddEdit();
        panelExtra = new com.jhw.swing.material.components.container.panel._PanelTransparent();

        javax.swing.GroupLayout panelInputViewLayout = new javax.swing.GroupLayout(panelInputView);
        panelInputView.setLayout(panelInputViewLayout);
        panelInputViewLayout.setHorizontalGroup(
            panelInputViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        panelInputViewLayout.setVerticalGroup(
            panelInputViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        buttonAddEdit.setText("Crear");

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(buttonAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(panelInputView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelInputView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelExtra.setLayout(new java.awt.GridLayout(0, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelExtra, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.button.prepared._buttonAddEdit buttonAddEdit;
    private com.jhw.swing.material.components.container.panel._PanelTransparent panelExtra;
    private com.jhw.swing.material.components.container.panel._MaterialPanel panelGeneral;
    private com.jhw.swing.material.components.container.panel._PanelComponent panelInputView;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        this.panelInputView.setComponent(modelPanel);
        panelExtra.removeAll();
        for (Component c : extras) {
            panelExtra.add(c);
        }
        updateAll();
    }

    public void setModelPanel(ModelPanel modelPanel) {
        this.modelPanel = modelPanel;
        personalize();
    }

    public void setExtras(List<Component> extras) {
        this.extras = extras;
        personalize();
    }

    public void addExtra(Component extra) {
        this.extras.add(extra);
        personalize();
    }

    public void updateAll() {
        buttonAddEdit.isCreated(modelPanel.getOldModel() == null);
        modelPanel.update();

        for (Component component : panelExtra.getComponents()) {
            if (component instanceof Update) {
                ((Update) component).update();
            }
        }
    }

    private void addListeners() {
        buttonAddEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelPanel.onCreateAction();
            }
        });
    }

    public ModelPanel getModelPanel() {
        return modelPanel;
    }

    public _buttonAddEdit getButtonAddEdit() {
        return buttonAddEdit;
    }
}
