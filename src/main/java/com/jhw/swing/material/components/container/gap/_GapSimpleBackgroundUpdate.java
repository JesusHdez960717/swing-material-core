package com.jhw.swing.material.components.container.gap;

import com.jhw.swing.material.components.container.panel._PanelSimpleBackground;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.utils.interfaces.Update;
import java.awt.Component;
import java.awt.Container;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T>
 */
public class _GapSimpleBackgroundUpdate<T extends Component> extends _GapContainerGeneral implements Update {

    public _GapSimpleBackgroundUpdate() {
        super(new _MaterialPanel(), null, 20);
    }

    public _GapSimpleBackgroundUpdate(Component component) {
        this(component, 30);
    }

    public _GapSimpleBackgroundUpdate(Component component, int gap) {
        this(new _PanelSimpleBackground(), component, gap);
    }

    public _GapSimpleBackgroundUpdate(Container parent, Component component, int gap) {
        super(parent, component, gap);
    }

    @Override
    public void update() {
        if (getCoreComponent() instanceof Update) {
            ((Update) getCoreComponent()).update();
        }
    }

}
