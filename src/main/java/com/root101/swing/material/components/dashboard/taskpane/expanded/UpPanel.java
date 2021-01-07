/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.dashboard.taskpane.expanded;

import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.clean.swing.app.dashboard.MapeableContainer;
import com.root101.swing.material.components.button.MaterialButtonsFactory;
import com.root101.swing.material.components.button._MaterialButtonHiperlink;
import com.root101.swing.material.components.container.MaterialContainersFactory;
import com.root101.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.derivable_icons.DerivableIcon;
import java.awt.BorderLayout;
import java.awt.Component;
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

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UpPanel extends MapeableContainer {

    private final int HEIGHT_FINAL = 36;

    public UpPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.background = MaterialContainersFactory.buildPanelGradient();
        this.add(background, BorderLayout.CENTER);

        this.background.setLayout(new BorderLayout());

        this.components = MaterialContainersFactory.buildPanelTransparent();
        this.components.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.background.add(this.components, BorderLayout.EAST);
    }

    private JPanel background;
    private JButton company;
    private JPanel components;

    @Override
    public void update(HashMap<String, Object> hm) {
        components.removeAll();
        for (String key : hm.keySet()) {
            Object component = hm.get(key);
            switch (key) {
                case DashboardConstants.UP_COMPANY:
                    setCompany(component);
                    break;
                case DashboardConstants.UP_ELEMENT:
                    addElement(component);
                    break;
            }
        }
        this.revalidate();
    }

    public void format(Consumer<UpPanel> formatter) {
        formatter.accept(this);
    }

    private void addElement(Object component) {
        if (component instanceof Component) {
            addComponentGeneral((Component) component);
        } else if (component instanceof Action) {
            addComponentGeneral((Action) component);
        } else if (component instanceof List) {
            for (Object single : (List) component) {
                if (single instanceof Component) {
                    addComponentGeneral((Component) single);
                } else if (single instanceof Action) {
                    addComponentGeneral((Action) single);
                }
            }
        } else {
            String logMSG = "Component " + component + " not supperted for up element.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    private void setCompany(Object component) {
        if (component instanceof Action) {
            setCompany((Action) component);
        } else {
            String logMSG = "Component " + component + " not supperted for company.";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    public void setCompany(Action action) {
        if (this.company != null) {
            this.background.remove(this.company);
        }
        this.company = new CompanyButton();
        this.company.setAction(action);
        this.company.setPreferredSize(new Dimension((int) company.getPreferredSize().getWidth(), HEIGHT_FINAL));
        this.background.add(this.company, BorderLayout.WEST);
    }

    public void addComponentGeneral(Action action) {
        JButton component = MaterialButtonsFactory.buildIconTransparent();
        component.setAction(action);

        if (action.getValue(Action.SMALL_ICON) instanceof DerivableIcon) {
            component.setForeground(((DerivableIcon) action.getValue(Action.SMALL_ICON)).getColor());
        }

        component.setPreferredSize(new Dimension(HEIGHT_FINAL, HEIGHT_FINAL));
        components.add(component);
    }

    public void addComponentGeneral(Component component) {
        component.setPreferredSize(new Dimension((int) component.getPreferredSize().getWidth(), HEIGHT_FINAL));
        components.add(component);
    }

    public JPanel getBackgroundPanel() {
        return background;
    }

    private class CompanyButton extends _MaterialButtonHiperlink {

        public CompanyButton() {
            setText("");
            float h = HEIGHT_FINAL;
            this.setMouseEnteredColor(MaterialColors.BLACK);
            this.setMouseExitedColor(MaterialColors.BLACK);
            this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(h * 0.65f));
            this.setIconTextGap(8);
            this.repaint();
        }
    }
}
