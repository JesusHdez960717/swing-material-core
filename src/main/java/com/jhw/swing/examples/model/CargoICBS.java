package com.jhw.swing.examples.model;

import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import java.awt.event.ActionListener;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com) 5/4/2020
 */
public class CargoICBS extends ICBSNotEmptySeleccionable<CargoModel> {

    public CargoICBS() {
        super("Cargo");
    }

    @Override
    public void actualizarComboBox() {
        getComboBox().removeAllItems();
        getComboBox().addItem("Seleccione...");

        for (CargoModel c : CargoModel.getCargos()) {
            getComboBox().addItem(c);
        }
    }

    @Override
    public ActionListener buttonAddAction() {
        return new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddActionPerformed();
            }
        };
    }

    private void onButtonAddActionPerformed() {
        new DialogInputCBS(this, new CargoInputView(null));
    }

}
