package com.jhw.swing.examples.model;

import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import java.awt.event.ActionListener;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com) 5/4/2020
 */
public class CargoICBS extends ICBSNotEmptySeleccionable<CargoModel> {

    public CargoICBS() {
        super("Cargo");
    }

    @Override
    public void actualizarComboBox() {
        setModel(CargoModel.getCargos());
        getComboBox().decorate(CargoICBS::format, CargoICBS::filter);
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

    public static String format(CargoModel cargo) {
        if (cargo == null) {
            return "";
        }
        return String.format("%s", cargo.getNombreCargo());
    }

    public static boolean filter(CargoModel emp, String textToFilter) {
        if (textToFilter.isEmpty()) {
            return true;
        }
        return CargoICBS.format(emp).toLowerCase()
                .contains(textToFilter.toLowerCase());
    }
}
