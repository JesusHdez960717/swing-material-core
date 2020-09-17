/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.prepared.button;

import com.jhw.swing.material.components.button.MaterialButton;
import com.jhw.swing.material.components.popup.MaterialPopupFactory;
import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialPreparedButtonsFactory {

    public static MaterialButton buildView() {
        return _buttonView.from();
    }

    public static MaterialButtonAddEdit buildAddEdit() {
        return _buttonAddEdit.from();
    }

    @Deprecated
    public static MaterialButton buildReport() {
        return _buttonReportes.from();
    }

    public static MaterialButton buildReport(List<Action> actions) {
        MaterialButton btn = buildReport();
        btn.setComponentPopupMenu(MaterialPopupFactory.buildCircular(actions));
        return btn;
    }
}
