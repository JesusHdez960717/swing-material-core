package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.Utils;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import static javax.swing.border.TitledBorder.LEADING;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextArea extends javax.swing.JPanel implements BindableComponent<String> {

    private Color accentColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_ACCENT);

    private String label;

    public _MaterialTextArea() {
        initComponents();
        addListeners();
    }

    private void initComponents() {
        materialScrollPaneCore = new com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore();
        materialTextAreaCore = new com.jhw.swing.material.components.textarea._MaterialTextAreaCore();

        materialTextAreaCore.setColumns(1);
        materialTextAreaCore.setRows(1);
        materialScrollPaneCore.setViewportView(materialTextAreaCore);

        this.setLayout(new BorderLayout());
        this.add(materialScrollPaneCore);
        this.setPreferredSize(new Dimension(230, 150));
    }

    private com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore materialScrollPaneCore;
    private com.jhw.swing.material.components.textarea._MaterialTextAreaCore materialTextAreaCore;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        this.setTitledBorder(label);
    }

    public Color getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(Color accentColor) {
        this.accentColor = accentColor;
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

    public void setTitledBorder(String text) {
        materialScrollPaneCore.setBorder(new TitledBorder(text));
        updateBorder();
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
        return super.getFont();
    }

    @Override
    public Color getForeground() {
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

    private void updateBorder() {
        Color accent = materialTextAreaCore.isFocusOwner() ? accentColor : Utils.applyAlphaMask(materialTextAreaCore.getForeground(), _MaterialTextField.HINT_OPACITY_MASK);
        Color accentText = materialTextAreaCore.isFocusOwner() ? accentColor : materialTextAreaCore.getForeground();
        int thickness = materialTextAreaCore.isFocusOwner() ? 2 : 1;
        try {
            TitledBorder titled = (TitledBorder) materialScrollPaneCore.getBorder();
            titled.setTitleColor(accentText);
            titled.setBorder(BorderFactory.createLineBorder(accent, thickness, false));
            materialScrollPaneCore.repaint();
        } catch (Exception e) {
        }
    }

    private void addListeners() {
        materialTextAreaCore.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                updateBorder();
            }

            @Override
            public void focusLost(FocusEvent e) {
                updateBorder();
            }
        });
    }
}
