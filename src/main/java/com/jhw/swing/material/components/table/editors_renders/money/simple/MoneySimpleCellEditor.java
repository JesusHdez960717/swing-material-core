package com.jhw.swing.material.components.table.editors_renders.money.simple;

import javax.swing.DefaultCellEditor;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MoneySimpleCellEditor extends DefaultCellEditor {

    public MoneySimpleCellEditor() {
        super(new MoneyTextField());
    }

}
