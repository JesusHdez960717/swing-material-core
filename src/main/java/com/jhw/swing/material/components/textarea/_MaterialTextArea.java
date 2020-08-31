package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextArea extends javax.swing.JPanel implements BindableComponent<String> {

    public _MaterialTextArea() {
        initComponents();
    }

    private void initComponents() {

        materialScrollPaneCore = new com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore();
        materialTextAreaCore = new com.jhw.swing.material.components.textarea._MaterialTextAreaCore();

        materialTextAreaCore.setColumns(1);
        materialTextAreaCore.setRows(1);
        materialScrollPaneCore.setViewportView(materialTextAreaCore);

        this.setLayout(new BorderLayout());
        this.add(materialScrollPaneCore);
    }// </editor-fold>                        

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore materialScrollPaneCore;
    private com.jhw.swing.material.components.textarea._MaterialTextAreaCore materialTextAreaCore;
    // End of variables declaration                   

    public void setTitledBorder(String text) {
        materialScrollPaneCore.setTitledBorder(text);
    }

    public String getText() {
        return materialTextAreaCore.getText();
    }

    public void setText(String text) {
        materialTextAreaCore.setText(text);
    }

    public _MaterialTextAreaCore getTextArea() {
        return materialTextAreaCore;
    }

    public _MaterialScrollPaneCore getScrollPane() {
        return materialScrollPaneCore;
    }

    public void setBorderCustom(Border b) {
        materialScrollPaneCore.setBorder(b);
    }

    public void setBorderText(String text) {
        materialScrollPaneCore.setBorder(new TitledBorder(text));
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
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setFont(font);
        }
        super.setFont(font);
    }

    @Override
    public Font getFont() {
        if (materialTextAreaCore != null) {
            return materialTextAreaCore.getFont();
        }
        return super.getFont();
    }

    @Override
    public Color getForeground() {
        if (materialTextAreaCore != null) {
            materialTextAreaCore.getForeground();
        }
        return super.getForeground();
    }

    @Override
    public void setForeground(Color fore) {
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setForeground(fore);
        }
        super.setForeground(fore);
    }

    @Override
    public String getObject() {
        return getText();
    }

    @Override
    public void setObject(String object) {
        setText(object);
    }
}
