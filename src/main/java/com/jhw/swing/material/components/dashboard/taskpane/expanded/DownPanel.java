package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashboardConstants;
import com.clean.swing.app.dashboard.MapeableContainer;
import com.jhw.swing.material.components.button._MaterialButtonFlat;
import com.jhw.swing.material.components.button._MaterialButtonIconTranspRect;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DownPanel extends MapeableContainer {

    private final int HEIGHT_FINAL = 16;

    public DownPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.background = new _PanelGradient();
        this.add(background, BorderLayout.CENTER);
        this.background.setLayout(new BorderLayout());

        this.components = new _PanelTransparent();
        this.components.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 3));

        this.background.add(this.components, BorderLayout.EAST);
    }

    private _PanelGradient background;
    private JButton licence;
    private _PanelTransparent components;

    @Override
    public void update(HashMap<String, Object> hm) {
        components.removeAll();
        for (String key : hm.keySet()) {
            Object component = hm.get(key);
            switch (key) {
                case DashboardConstants.DOWN_LICENCE:
                    setLicence(component);
                    break;
                case DashboardConstants.DOWN_ELEMENT:
                    addElement(component);
                    break;
            }
        }
        this.revalidate();
    }

    private void addElement(Object component) {
        if (component instanceof Action) {
            addDownElement((Action) component);
        } else if (component instanceof List) {
            for (Object single : (List) component) {
                if (single instanceof Action) {
                    addDownElement((Action) single);
                }
            }
        } else {
            String logMSG = "Component " + component + " not supperted for down panel.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    private void setLicence(Object component) {
        if (component instanceof Action) {
            setLicence((Action) component);
        } else {
            String logMSG = "Component " + component + " not supperted for licence.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    public void addDownElement(Action tecnology) {
        addTecnology(tecnology);
    }

    public void setLicence(Action licence) {
        doSetLicence(licence);
    }

    public _PanelGradient getBackgroundPanel() {
        return background;
    }

    public void format(Consumer<DownPanel> formatter) {
        formatter.accept(this);
    }

    private void doSetLicence(Action action) {
        if (this.licence != null) {
            this.background.remove(this.licence);
        }
        JButton licenceButton = new LicenceButton();
        this.licence = licenceButton;
        this.licence.setAction(action);
        this.licence.setPreferredSize(new Dimension((int) licence.getPreferredSize().getWidth(), HEIGHT_FINAL));
        this.background.add(this.licence, BorderLayout.WEST);
    }

    public void addTecnology(Action action) {
        _MaterialButtonIconTranspRect btn_Tec = new _MaterialButtonIconTranspRect();
        btn_Tec.setAction(action);
        String name = ((String) action.getValue(Action.NAME)).trim();
        if (!name.isEmpty()) {
            btn_Tec.setToolTipText(name);
        }
        btn_Tec.setPreferredSize(new Dimension(HEIGHT_FINAL, HEIGHT_FINAL));
        components.add(btn_Tec);
    }

    private class LicenceButton extends _MaterialButtonFlat implements MaterialComponent {

        public LicenceButton() {
            this(MaterialColors.AMBERA_400);
        }

        public LicenceButton(Color back) {
            this.setBackground(back);
            this.setBorderColor(Utils.darken(Utils.darken(back)));
            this.setBorderThickness(5);
        }

    }
}
