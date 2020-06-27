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
public class HorizontalLayoutContainer extends _PanelGradient {

    private final int heightMax;

    private final FlowLayout layout;

    public HorizontalLayoutContainer() {
        this(70);
        layout.setHgap(5);
    }

    @Override
    public FlowLayout getLayout() {
        return layout;
    }

    public HorizontalLayoutContainer(int widthMax) {
        this.heightMax = widthMax;
        layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        this.setLayout(layout);
        this.setOpaque(false);
        this.setBackground(MaterialColors.TRANSPARENT);
    }

    public Component add(Component component, boolean adjust) {
        if (adjust || component.getPreferredSize().getHeight() > heightMax) {
            component.setPreferredSize(new Dimension((int) component.getPreferredSize().getWidth(), heightMax));
        }

        super.add(component);
        adjustSize();
        return component;
    }

    public Component add(Component component) {
        return add(component, true);
    }

    private void adjustSize() {
        int width = 0;
        for (Component component : getComponents()) {
            width += component.getPreferredSize().getWidth();
        }
        Dimension dim = new Dimension(width, heightMax);
        this.setMaximumSize(dim);
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
    }
}
