package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.clean.swing.app.dashboard.MapeableContainer;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.components.container.MaterialContainersFactory;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
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

        this.background = MaterialContainersFactory.buildPanelGradient();
        this.add(background, BorderLayout.CENTER);
        this.background.setLayout(new BorderLayout());

        this.components = MaterialContainersFactory.buildPanelTransparent();
        this.components.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 3));

        this.background.add(this.components, BorderLayout.EAST);
    }

    private JPanel background;
    private JButton licence;
    private JPanel components;

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
                } else if (single instanceof Component) {
                    components.add((Component) single);
                }
            }
        } else {
            System.out.println("Component " + component + " not supported for down panel.");
        }
    }

    private void setLicence(Object component) {
        if (component instanceof Action) {
            setLicence((Action) component);
        } else {
            System.out.println("Component " + component + " not supperted for licence.");
        }
    }

    public void addDownElement(Action tecnology) {
        addTecnology(tecnology);
    }

    public void setLicence(Action licence) {
        doSetLicence(licence);
    }

    public JPanel getBackgroundPanel() {
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
        JButton btn_Tec = MaterialButtonsFactory.buildIconTransparent();
        btn_Tec.setAction(action);
        String name = ((String) action.getValue(Action.NAME)).trim();
        if (!name.isEmpty()) {
            btn_Tec.setToolTipText(name);
        }
        btn_Tec.setPreferredSize(new Dimension(HEIGHT_FINAL, HEIGHT_FINAL));
        components.add(btn_Tec);
    }

    private class LicenceButton extends JButton implements MaterialComponent {

        public LicenceButton() {
            this(MaterialColors.AMBERA_400);
        }

        public LicenceButton(Color back) {
            this.setBackground(back);
            this.setBorder(new LineBorder(Utils.darken(Utils.darken(back)), 2));
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }
}
