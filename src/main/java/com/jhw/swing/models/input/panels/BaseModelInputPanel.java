package com.jhw.swing.models.input.panels;

import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.container.panels._MaterialPanel;
import com.jhw.swing.material.components.container.panels._PanelComponent;
import com.jhw.swing.material.components.container.panels._PanelGradient;
import java.awt.Color;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.util.interfaces.ModelablePanel;

import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T> Tipo de modelos que se va a trabajar.
 */
public class BaseModelInputPanel<T> extends _PanelGradient implements Update, ModelablePanel<T> {

    private final ModelPanel modelPanel;

    public BaseModelInputPanel(ModelPanel modelPanel) {
        initComponents();
        this.modelPanel = modelPanel;
        this.panelModelCore.setComponent(this.modelPanel);
        personalize();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new com.jhw.swing.material.components.container.panels._PanelGradient();
        panelModel = new com.jhw.swing.material.components.container.panels._MaterialPanel();
        panelModelCore = new com.jhw.swing.material.components.container.panels._PanelComponent();
        panelButtons = new com.jhw.swing.material.components.container.panels._PanelGradient();
        buttonAddEdit = new com.jhw.swing.material.components.button.prepared._buttonAddEdit();
        buttonCancel = new com.jhw.swing.material.components.button._MaterialButton();
        buttonDelete = new com.jhw.swing.material.components.button._MaterialIconButtonTranspRect();

        setPrimaryColor(new java.awt.Color(255, 255, 255));
        setSecundaryColor(new java.awt.Color(255, 255, 255));

        panelBackground.setPrimaryColor(new java.awt.Color(255, 255, 255));
        panelBackground.setSecundaryColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelModelCoreLayout = new javax.swing.GroupLayout(panelModelCore);
        panelModelCore.setLayout(panelModelCoreLayout);
        panelModelCoreLayout.setHorizontalGroup(
            panelModelCoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelModelCoreLayout.setVerticalGroup(
            panelModelCoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelModelLayout = new javax.swing.GroupLayout(panelModel);
        panelModel.setLayout(panelModelLayout);
        panelModelLayout.setHorizontalGroup(
            panelModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelModelCore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        panelModelLayout.setVerticalGroup(
            panelModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelModelCore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        panelButtons.setPrimaryColor(new java.awt.Color(255, 255, 255));
        panelButtons.setSecundaryColor(new java.awt.Color(255, 255, 255));

        buttonAddEdit.setText("Crear");

        buttonCancel.setText("Cancelar");
        buttonCancel.setPreferredSize(new java.awt.Dimension(125, 50));

        buttonDelete.setText("_MaterialIconButtonTranspRect1");

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(panelModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.button.prepared._buttonAddEdit buttonAddEdit;
    private com.jhw.swing.material.components.button._MaterialButton buttonCancel;
    private com.jhw.swing.material.components.button._MaterialIconButtonTranspRect buttonDelete;
    private com.jhw.swing.material.components.container.panels._PanelGradient panelBackground;
    private com.jhw.swing.material.components.container.panels._PanelGradient panelButtons;
    private com.jhw.swing.material.components.container.panels._MaterialPanel panelModel;
    private com.jhw.swing.material.components.container.panels._PanelComponent panelModelCore;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        buttonAddEdit.isCreated(modelPanel.getOldModel() == null);
        buttonDelete.setIcon(MaterialIcons.DELETE_FOREVER);

        buttonDelete.setVisible(modelPanel.getOldModel() != null);
        buttonDelete.setEnabled(modelPanel.getOldModel() != null);

        this.setPrimaryColor(MaterialColors.WHITE);
        this.setSecundaryColor(MaterialColors.WHITE);
        buttonCancel.setBackground(PersonalizationMaterial.getInstance().getColorButtonCancel());

        this.panelBackground.setBackground(PersonalizationMaterial.getInstance().getColorBackgroundPanel());
    }

    @Override
    public void update() {
        modelPanel.update();
    }

    @Override
    public T getNewModel() {
        return (T) modelPanel.getNewModel();
    }

    @Override
    public T getOldModel() {
        return (T) modelPanel.getOldModel();
    }

    @Override
    public void setOldModel(T model) {
        modelPanel.setOldModel(model);
    }

    @Override
    public T onDeleteAction() {
        return (T) modelPanel.onDeleteAction();
    }

    @Override
    public T onCreateAction() {
        return (T) modelPanel.onCreateAction();
    }

    @Override
    public T onPostCreateAction(T obj) {
        return (T) modelPanel.onPostCreateAction(obj);
    }

    @Override
    public T onPostDeleteAction(T obj) {
        return (T) modelPanel.onPostDeleteAction(obj);
    }

    @Override
    public boolean onCancelAction() {
        return modelPanel.onCancelAction();
    }

    public void setOkColor(Color okColor) {
        buttonAddEdit.setBackground(okColor);
        personalize();
    }

    public void setCancelColor(Color cancelColor) {
        buttonCancel.setBackground(cancelColor);
        personalize();
    }

    public Color getOkColor() {
        return buttonAddEdit.getBackground();
    }

    public Color getCancelColor() {
        return buttonCancel.getBackground();
    }

    public ModelPanel getModelPanel() {
        return modelPanel;
    }

    public _MaterialButton getMaterialButtonCancel() {
        return buttonCancel;
    }

    public _MaterialButton getMaterialButtonOK() {
        return buttonAddEdit;
    }

    public _PanelGradient getPanelGradientBackground() {
        return panelBackground;
    }

    public _PanelGradient getPanelGradientButtons() {
        return panelButtons;
    }

    public _buttonAddEdit getButtonAddEdit() {
        return buttonAddEdit;
    }

    public _MaterialButton getButtonCancel() {
        return buttonCancel;
    }

    public _MaterialIconButtonTranspRect getButtonDelete() {
        return buttonDelete;
    }

    public _PanelGradient getPanelBackground() {
        return panelBackground;
    }

    public _PanelGradient getPanelButtons() {
        return panelButtons;
    }

    public _MaterialPanel getPanelModel() {
        return panelModel;
    }

    public _PanelComponent getPanelModelCore() {
        return panelModelCore;
    }

    public _MaterialIconButtonTranspRect getMaterialButtonDelete() {
        return buttonDelete;
    }

}
