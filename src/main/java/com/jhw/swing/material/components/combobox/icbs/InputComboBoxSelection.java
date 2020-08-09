package com.jhw.swing.material.components.combobox.icbs;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.exceptions.ValidationException;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.combobox.combobox_editable._MaterialComboBoxFiltrable;
import com.jhw.swing.material.components.container.panel._PanelComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.util.validations.Validation;
import com.jhw.swing.util.validations.icbs.ICBSValidation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import com.jhw.swing.util.interfaces.Wrong;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandzb96@gmail.com)
 */
public abstract class InputComboBoxSelection<T> extends _PanelComponent implements Update, Wrong {

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

        buttonNuevo = new _MaterialButtonIconTransparent();
        buttonNuevo.setForeground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD));
        buttonNuevo.setRippleColor(Color.black);
        buttonNuevo.setIcon(
                PersonalizationHandler.getDerivableIcon(Personalization.KEY_ICON_BUTTON_ADD)
                        .deriveIcon(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_ADD))
                        .deriveIcon(h * .6f));

        this.setLayout(new BorderLayout());
        this.add(comboBox, BorderLayout.CENTER);
        this.add(buttonNuevo, BorderLayout.EAST);
    }

    // Variables declaration - do not modify
    private _MaterialButtonIconTransparent buttonNuevo;
    private _MaterialComboBoxFiltrable<T> comboBox;
    // End of variables declaration

    @Override
    public void update() {
        try {
            updateComboBox();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
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

    @Override
    public void wrong() {
        comboBox.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        comboBox.wrong(wrongText);
    }

    public void clearWrong() {
        comboBox.clearWrong();
    }

    @Override
    public void setEnabled(boolean enabled) {
        comboBox.setEnabled(enabled);
        buttonNuevo.setEnabled(enabled);
    }

    protected abstract void updateComboBox() throws Exception;

    public abstract ActionListener buttonAddAction();

    protected void setAddButtonListener() {
        buttonNuevo.addActionListener(buttonAddAction());
    }

    public void setSelectedItem(T item) {
        comboBox.setSelectedItem(item);
    }

    public void setModel(List<T> model) {
        comboBox.setModel(model);
        //comboBox.decorate();
    }

    public void setButtonNuevoVisibility(boolean visible) {
        buttonNuevo.setVisible(visible);
    }

    public _MaterialButtonIconTransparent getButtonNuevo() {
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
