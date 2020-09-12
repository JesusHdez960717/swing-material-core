package com.jhw.swing.material.components.textarea;

import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import javax.swing.JComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextArea extends _MaterialScrollPaneCore implements BindableComponent<String> {

    public static _MaterialTextArea from() {
        return new _MaterialTextArea();
    }

    public _MaterialTextArea() {
        initComponents();
        setBorderTitle("title");
    }

    private void initComponents() {
        materialTextAreaCore = new com.jhw.swing.material.components.textarea._MaterialTextAreaCore();

        materialTextAreaCore.setColumns(1);
        materialTextAreaCore.setRows(1);
        this.setViewportView(materialTextAreaCore);

        this.setPreferredSize(new Dimension(230, 150));
    }

    private com.jhw.swing.material.components.textarea._MaterialTextAreaCore materialTextAreaCore;

    @Override
    public JComponent getFocusableComponent() {
        return materialTextAreaCore;
    }

    @Override
    public void setBackground(Color bk) {
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setBackground(bk);
        }
        super.setBackground(bk);
    }

    @Override
    public Color getBackground() {
        if (materialTextAreaCore != null) {
            return materialTextAreaCore.getBackground();
        }
        return super.getBackground();
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setFont(font);
        }
    }

    @Override
    public void setForeground(Color fore) {
        super.setForeground(fore);
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setForeground(fore);
        }
    }

    @Override
    public String getObject() {
        return materialTextAreaCore.getText();
    }

    @Override
    public void setObject(String object) {
        materialTextAreaCore.setText(object);
    }

}
