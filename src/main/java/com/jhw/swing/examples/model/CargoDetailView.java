package com.jhw.swing.examples.model;

import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.notification.toast.TOAST;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellRender;
import com.jhw.swing.examples.standars.MATERIAL_COLORS_EXAMPLE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import com.jhw.swing.util.JOP;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CargoDetailView extends _MaterialPanelDetail<CargoModel> {

    public CargoDetailView() {
        setColumns(new Column[]{
            Column.builder().name("Color").build(),
            Column.builder().name("nombre").editable(true).build(),
            Column.builder().name("Descripcion").editable(true).build()
        });

        this.setHeaderText("Modelo de cargo");
        getTable().getTable().getColumn("Color").setCellRenderer(new ComponentCellRender(false));

        //this.setActionColumnVisivility(true);
        this.setActionColumnButtonsVisivility(true, false, false);
        addActionsExtra();

        this.getTable().setPageVisibility(false);

        this.update();
        //addOptionsElements();
        //this.setOptionPanelVisibility(false);
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput<CargoModel>(this, new CargoInputView(null)).setResizable(true);
    }

    @Override
    public Object[] getRowObject(CargoModel object) {
        return new Object[]{getColorPanel(), object.getNombreCargo(), object.getDescripcion()};
    }

    private JPanel getColorPanel() {
        _PanelGradient panel = new _PanelGradient();
        java.awt.Color c = MATERIAL_COLORS_EXAMPLE.getRandomColor();
        panel.setBackground(c);
        return panel;
    }

    @Override
    public void update() {
        ArrayList<CargoModel> c = new ArrayList<>();
        c.addAll(CargoModel.getCargos());
        c.addAll(CargoModel.getCargos());
        c.addAll(CargoModel.getCargos());
        c.addAll(CargoModel.getCargos());

        setCollection(c);
    }

    @Override
    protected CargoModel deleteAction(CargoModel obj) {
        CargoModel.deleteCargo(obj);
        return obj;
    }

    @Override
    protected void editAction(CargoModel obj) {
        new DialogModelInput(this, new CargoInputView(obj));
    }

    @Override
    protected void viewAction(CargoModel obj) {
        JOP.error("VIEW no implementado");
    }

    private void addOptionsElements() {
        _MaterialIconButtonTranspRect btn1 = new _MaterialIconButtonTranspRect();
        btn1.setIcon(MaterialIcons.ADD_CIRCLE);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TOAST.makeNotificationInfo("hihihihihihihihihihihi.");
            }
        });
        this.addOptionElement(btn1);

        _MaterialIconButtonTranspRect btn2 = new _MaterialIconButtonTranspRect();
        btn2.setIcon(MaterialIcons.ADD_CIRCLE);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TOAST.makeNotificationInfo("hihihihihihihihihihihi.");
            }
        });
        this.addOptionElement(btn2);

        _MaterialIconButtonTranspRect btn3 = new _MaterialIconButtonTranspRect();
        btn3.setIcon(MaterialIcons.ADD_CIRCLE);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TOAST.makeNotificationInfo("hihihihihihihihihihihi.");
            }
        });
        this.addOptionElement(btn3);

    }

    private void addActionsExtra() {
        _MaterialIconButtonTranspRect btn1 = new _MaterialIconButtonTranspRect();
        btn1.setIcon(MaterialIcons.ADD);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TOAST.makeNotificationInfo("action hihihihihi.");
            }
        });
        this.addActionExtra(btn1);
        this.addActionExtra(btn1);
        this.addActionExtra(btn1);
        this.addActionExtra(btn1);

    }

}
