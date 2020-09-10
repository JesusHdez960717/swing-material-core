package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.components.combobox._MaterialComboBox;
import com.jhw.swing.material.components.combobox.filtrable_utils.ComboBoxFilterDecorator;
import com.jhw.swing.material.components.combobox.filtrable_utils.CustomComboRenderer;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;
import static com.jhw.swing.material.standards.Utils.HINT_OPACITY_MASK;
import java.awt.Font;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialComboBoxFiltrable<T> extends _MaterialComboBox<T> {

    private boolean focus;
    private ComboBoxFilterDecorator<T> decorator;

    public _MaterialComboBoxFiltrable() {
        initComponent();
    }

    public void setModel(List<T> aModel) {
        super.setModel(new DefaultComboBoxModel(aModel.toArray(new Object[aModel.size()])));
        decorateInner();
        this.setSelectedIndex(-1);
    }

    @Override
    public T getSelectedItem() {
        return (T) super.getSelectedItem();
    }

    public void addItemAndDecorate(T item) {
        super.addItem(item);
        decorateInner();
    }

    public void decorate(Function<T, String> comboDisplayTextMapper,
            BiPredicate<T, String> userFilter) {
        this.decorator = ComboBoxFilterDecorator.decorate(this,
                comboDisplayTextMapper,
                userFilter);
        this.setRenderer(
                CustomComboRenderer.build(decorator.getFilterTextSupplier(),
                        comboDisplayTextMapper));
    }

    public void decorate() {
        this.decorator = ComboBoxFilterDecorator.decorate(this);
        this.setRenderer(
                CustomComboRenderer.build(decorator.getFilterTextSupplier(),
                        decorator.getFormat()));
    }

    private void decorateInner() {
        if (decorator != null) {
            decorate(decorator.getFormat(), decorator.getFilter());
        } else {
            decorate();
        }
    }

    private void initComponent() {
        this.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popupAct = new Popup(comboBox);
                popupAct.getAccessibleContext().setAccessibleParent(comboBox);
                return popupAct;
            }

            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });
    }

    public void processExternalFocusEvent(boolean focus, FocusEvent e) {
        this.focus = focus;
        processFocusEvent(e);
    }

    @Override
    public boolean isFocusOwner() {
        return focus;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int yMid = getSize().height / 2;

        if (getSelectedItem() == null && isFocusOwner()) {
            paintHint(g2);
        }
        paintLabel(g2);

        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        int yLine = yMid + metrics.getAscent() / 2 + 5;

        //paint the back line
        g2.setColor(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, getWidth(), 1);

        //paint the front line, this is the one that change colors and size
        g2.setColor(getAccentFloatingLabel());
        g2.fillRect((int) ((getWidth() - getLine().getWidth()) / 2), yLine, (int) getLine().getWidth(), 2);

        //paint the wrong text if the flag is actived
        if (isWrongFlag()) {
            g2.setColor(getWrongColor());
            g2.setFont(getFont().deriveFont(getFont().getSize2D() * 0.8f).deriveFont(Font.BOLD));//1 for bold
            g2.drawString(getWrongText(), 0, yLine + 15);//paint the wrong text
        }

        //paint the arrow
        if (getIcon() != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccentFloatingLabel();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            ImageIcon icon = getIcon();
            if (icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(iconColor);
            }
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - getIcon().getIconHeight()), yMid - icon.getIconHeight() / 2);
        }

    }
}
