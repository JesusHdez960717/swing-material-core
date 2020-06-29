package com.jhw.swing.material.components.combobox.icbs;

import com.clean.core.exceptions.ValidationException;
import com.jhw.swing.material.components.button._MaterialButtonSimpleIcon;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.util.validations.Validation;
import com.jhw.swing.util.validations.icbs.ICBSValidation;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandzb96@gmail.com)
 */
public abstract class InputComboBoxSelection<T> extends _PanelComponent implements Update {

    private final ArrayList<ICBSValidation> preValidations = new ArrayList<>();
    private final ArrayList<ICBSValidation> postValidations = new ArrayList<>();

    public InputComboBoxSelection(String label, String hint) {
        initComponents(label, hint);
        personalize();

        this.getComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearWrong();
            }
        });
        clearWrong();
    }

    @SuppressWarnings("unchecked")
    private void initComponents(String label, String hint) {
        comboBox = new _MaterialComboBoxFiltrable();
        comboBox.setLabel(label);
        comboBox.setHint(hint);

        int h = (int) this.comboBox.getPreferredSize().getHeight();

        buttonNuevo = new _MaterialIconButtonTranspRect();
        buttonNuevo.setIcon(
                PersonalizationMaterial.getInstance().getIconButtonAdd()
                        .deriveIcon(PersonalizationMaterial.getInstance().getColorButtonAdd())
                        .deriveIcon(h / 2));

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder(h);
        hlc.add(HorizontalLayoutComponent.builder(comboBox).width(Short.MAX_VALUE / 2).build());
        hlc.add(HorizontalLayoutComponent.builder(buttonNuevo).build());
        this.setComponent(hlc.build());
    }

    // Variables declaration - do not modify
    private _MaterialIconButtonTranspRect buttonNuevo;
    private _MaterialComboBoxFiltrable<T> comboBox;
    // End of variables declaration

    @Override
    public void update() {
        actualizarComboBox();
    }

    private void personalize() {
        setAddButtonListener();
    }

    public ArrayList<ICBSValidation> getPostValidations() {
        return postValidations;
    }

    public void addPostValidation(ICBSValidation val) {
        postValidations.remove(val);
        postValidations.add(val);
    }

    public ArrayList<ICBSValidation> getPreValidations() {
        return preValidations;
    }

    public void addPreValidation(ICBSValidation val) {
        preValidations.remove(val);
        preValidations.add(val);
    }

    public T getSelectedItem() {
        runPreValidations();
        T ans = (T) comboBox.getSelectedItem();
        runPostValidations();
        return ans;
    }

    public void wrong() {
        comboBox.wrong();
    }

    public void clearWrong() {
        comboBox.clearWrong();
    }

    @Override
    public void setEnabled(boolean enabled) {
        comboBox.setEnabled(enabled);
        buttonNuevo.setEnabled(enabled);
    }

    public abstract void actualizarComboBox();

    public abstract ActionListener buttonAddAction();

    protected void setAddButtonListener() {
        buttonNuevo.addActionListener(buttonAddAction());
    }

    public void setSelectedItem(T item) {
        comboBox.setSelectedItem(item);
    }

    public void setModel(List<T> model) {
        comboBox.setModel(model);
    }

    public void setButtonNuevoVisibility(boolean visible) {
        buttonNuevo.setVisible(visible);
    }

    public _MaterialIconButtonTranspRect getButtonNuevo() {
        return buttonNuevo;
    }

    public _MaterialComboBoxFiltrable<T> getComboBox() {
        return comboBox;
    }

    public String getHint() {
        return comboBox.getHint();
    }

    public void setHint(String hint) {
        comboBox.setHint(hint);
    }

    public String getLabel() {
        return comboBox.getLabel();
    }

    public void setLabel(String label) {
        comboBox.setLabel(label);
    }

    public void clearPreValidations() {
        preValidations.clear();
    }

    public void clearPostValidations() {
        postValidations.clear();
    }

    public void clearAllValidations() {
        preValidations.clear();
        postValidations.clear();
    }

    private void runPostValidations() {
        for (Validation v : postValidations) {
            if (!v.validate(this)) {
                comboBox.wrong(v.getWrongText());
                throw new ValidationException(v.getDetailedText());
            }
        }
    }

    private void runPreValidations() {
        for (Validation v : preValidations) {
            if (!v.validate(this)) {
                comboBox.wrong(v.getWrongText());
                throw new ValidationException(v.getDetailedText());
            }
        }
    }
}
