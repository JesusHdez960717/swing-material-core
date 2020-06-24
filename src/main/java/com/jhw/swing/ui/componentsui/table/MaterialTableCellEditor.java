package com.jhw.swing.ui.componentsui.table;

import com.jhw.swing.ui.componentsui.textfield.MaterialTextFieldUI;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.*;

public class MaterialTableCellEditor extends DefaultCellEditor {

    public MaterialTableCellEditor() {
        super(init());
    }

    private static JTextField init() {
        JTextField textField = new JTextField();
        textField.setUI(new MaterialTextFieldUI(false));
        return textField;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
        JTextField textField = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, rowIndex, vColIndex);
        textField.setFont(super.getComponent().getFont());
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setText(value != null ? value.toString() : "");

        return textField;
    }
}
