package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.components.combobox.filtrable_utils.ComboBoxFilterDecorator;
import com.jhw.swing.material.components.combobox.filtrable_utils.CustomComboRenderer;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.util.function.BiPredicate;
import java.util.function.Function;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialComboBoxFiltrable<T> extends _MaterialComboBox<T> {

    public static MaterialComboBox from() {
        return new _MaterialComboBoxFiltrable();
    }

    private boolean focus;
    private ComboBoxFilterDecorator<T> decorator;

    public _MaterialComboBoxFiltrable() {
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

    @Override
    public MaterialComboBox getComboBox() {
        return this;
    }

    @Override
    public void setModel(ComboBoxModel<T> aModel) {
        super.setModel(aModel);
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

        paintLine(g2);

        paintWrong(g2, getYLine(g2) + 15);

        //paint the arrow
        if (getIconArrow()!= null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccentFloatingLabel();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            ImageIcon icon = getIconArrow();
            if (icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(iconColor);
            }
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - icon.getIconHeight()), yMid - icon.getIconHeight() / 2);
        }
    }

}
