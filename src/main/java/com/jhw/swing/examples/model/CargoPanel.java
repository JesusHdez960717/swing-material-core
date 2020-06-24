package com.jhw.swing.examples.model;

import com.jhw.swing.models.detail._MaterialPanelDetailMini;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.notification.toast.TOAST;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.jhw.swing.util.JOP;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CargoPanel extends _MaterialPanelDetailMini<CargoModel> {

    public CargoPanel() {
        super(new Column[]{
            Column.builder().name("nombre").editable(true).build(),
            Column.builder().name("money").editable(true).build(),
            Column.builder().name("Descripcion").editable(true).build()
        });

        this.setHeaderText("Modelo de cargo");

        getTable().getTable().getColumn("money").setCellRenderer(new MoneyCellRender());

        this.setActionColumnVisivility(false);
        //this.setActionColumnButtonsVisivility(true, false, false);

        this.update();
        this.update();
        this.update();
        this.update();
        this.update();

        //addOptionsElements();
        this.setOptionPanelVisibility(false);
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput<CargoModel>(this, new CargoInputView(null));
    }

    @Override
    public Object[] getRowObject(CargoModel object) {
        return new Object[]{object.getNombreCargo(),
            new MoneyTableComponent(new Random().nextInt(1000000), "MN"),
            object.getDescripcion()};
    }

    @Override
    public void update() {
        setCollection(CargoModel.getCargos());
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

}
