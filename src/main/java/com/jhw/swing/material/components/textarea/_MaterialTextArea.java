package com.jhw.swing.material.components.textarea;

import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.components.scrollpane.MaterialScrollPane;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextArea extends _PanelTransparent implements BindableComponent<String>, BorderDinamic {

    public static _MaterialTextArea from() {
        return new _MaterialTextArea();
    }

    private final DefaultBorderDinamic borderEffect;

    public _MaterialTextArea() {
        initComponents();
        addListeners();
        borderEffect = new DefaultBorderDinamic(this);
        setBorderTitle("label");
    }

    private void initComponents() {
        materialScrollPaneCore = MaterialScrollFactory.buildPane();
        materialTextAreaCore = new com.jhw.swing.material.components.textarea._MaterialTextAreaCore();

        materialTextAreaCore.setColumns(1);
        materialTextAreaCore.setRows(1);
        materialScrollPaneCore.setViewportView(materialTextAreaCore);

        this.setLayout(new BorderLayout());
        this.add(materialScrollPaneCore);
        this.setPreferredSize(new Dimension(230, 150));
    }

    private MaterialScrollPane materialScrollPaneCore;
    private com.jhw.swing.material.components.textarea._MaterialTextAreaCore materialTextAreaCore;

    @Override
    public JComponent getFocusableComponent() {
        return materialTextAreaCore;
    }

    @Override
    public JComponent getBordeableComponent() {
        return materialScrollPaneCore;
    }

    @Override
    public String getBorderTitle() {
        return borderEffect.getBorderTitle();
    }

    @Override
    public void setBorderTitle(String title) {
        borderEffect.setBorderTitle(title);
    }

    @Override
    public Color getBorderAccentColor() {
        return borderEffect.getBorderAccentColor();
    }

    @Override
    public void setBorderAccentColor(Color accentColor) {
        borderEffect.setBorderAccentColor(accentColor);
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

    public MaterialScrollPane getScrollPane() {
        return materialScrollPaneCore;
    }

    @Override
    public void setBorder(Border border) {
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
            borderEffect.update();
        }
    }

    @Override
    public void setForeground(Color fore) {
        super.setForeground(fore);
        if (materialTextAreaCore != null) {
            materialTextAreaCore.setForeground(fore);
            borderEffect.update();
        }
    }

    @Override
    public String getObject() {
        return getText();
    }

    @Override
    public void setObject(String object) {
        setText(object);
    }

    private void addListeners() {
        materialTextAreaCore.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                borderEffect.update();
            }

            @Override
            public void focusLost(FocusEvent e) {
                borderEffect.update();
            }
        });
    }
}
