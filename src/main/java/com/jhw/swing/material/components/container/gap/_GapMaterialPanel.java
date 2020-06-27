package com.jhw.swing.material.components.container.gap;

import com.jhw.swing.material.components.container.panel._MaterialPanel;
import java.awt.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T>
 */
public class _GapMaterialPanel<T extends Component> extends _GapContainerGeneral {

    public _GapMaterialPanel(Component component, int gap) {
        super(new _MaterialPanel(), component, gap);
    }

    public _GapMaterialPanel(Component component) {
        super(new _MaterialPanel(), component, 20);
    }

    public _GapMaterialPanel() {
        super(new _MaterialPanel(), null, 20);
    }

}
