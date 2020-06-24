package com.jhw.swing.material.components.table.editors_renders.money.simple;

import javax.swing.DefaultCellEditor;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MoneySimpleCellEditor extends DefaultCellEditor {

    public MoneySimpleCellEditor() {
        super(new MoneyTextField());
    }

}
