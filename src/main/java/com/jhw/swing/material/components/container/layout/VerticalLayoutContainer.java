package com.jhw.swing.material.components.container.layout;

import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standars.MaterialColors;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class VerticalLayoutContainer extends _PanelGradient {

    private final int widthMax;

    private final FlowLayout layout;

    public VerticalLayoutContainer() {
        this(350);
    }

    public VerticalLayoutContainer(int widthMax) {
        this.widthMax = widthMax;
        layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        this.setLayout(layout);
        this.setOpaque(false);
        this.setBackground(MaterialColors.TRANSPARENT);
    }

    public Component add(Component component, boolean adjust) {
        if (adjust || component.getPreferredSize().getWidth() > widthMax) {
            component.setPreferredSize(new Dimension(widthMax, (int) component.getPreferredSize().getHeight()));
        }

        super.add(component);
        adjustSize();
        return component;
    }

    public Component add(Component component) {
        return add(component, true);
    }

    private void adjustSize() {
        int height = 0;
        for (Component component : getComponents()) {
            height += component.getPreferredSize().getHeight();
        }
        Dimension dim = new Dimension(widthMax, height);
        this.setMaximumSize(dim);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
    }

    @Override
    public FlowLayout getLayout() {
        return layout;
    }
}
