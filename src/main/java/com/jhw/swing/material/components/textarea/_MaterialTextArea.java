package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.effects.DefaultMaterialLineBorder;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.util.interfaces.BindableComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.TitledBorder;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.components.scrollpane.MaterialScrollPane;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;
import com.jhw.swing.util.Utils;
import javax.swing.border.Border;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextArea extends javax.swing.JPanel implements BindableComponent<String> {

    private Color accentColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_ACCENT);

    private final BorderDinamic borderEffect;

    private String label;

    public _MaterialTextArea() {
        initComponents();
        addListeners();
        borderEffect = new BorderDinamic(this);
        setLabel("label");
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
        borderEffect.update();
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

    private void setTitledBorder(String text) {
        materialScrollPaneCore.setBorder(new TitledBorder(text));
        TitledBorder titled = (TitledBorder) materialScrollPaneCore.getBorder();
        titled.setTitleColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
        titled.setBorder(DefaultMaterialLineBorder.builder().build());
        borderEffect.update();
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
    public Font getFont() {
        return super.getFont();
    }

    @Override
    public Color getForeground() {
        return super.getForeground();
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
