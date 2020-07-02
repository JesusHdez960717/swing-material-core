package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.clean.swing.app.dashboard.DashboardExtendedUp;
import com.jhw.swing.material.components.button._MaterialButtonTransparent;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.GradientEnum;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Action;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UpPanel extends _PanelGradient implements DashboardExtendedUp<Component> {

    private final int HEIGHT_FINAL = 36;

    public UpPanel() {
        initComponents();
        personalize();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.components = new _PanelTransparent();
        this.components.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.add(this.components, BorderLayout.EAST);
    }

    private JButton company;
    private _PanelTransparent components;

    @Override
    public void addUpElement(Component component) {
        addComponentGeneral(component);
    }

    @Override
    public void setCompany(Action action) {
        if (this.company != null) {
            this.remove(this.company);
        }
        this.company = new CompanyButton();
        this.company.setAction(action);
        this.company.setPreferredSize(new Dimension((int) company.getPreferredSize().getWidth(), HEIGHT_FINAL));
        this.add(this.company, BorderLayout.WEST);
    }

    public void addComponentGeneral(Component component) {
        component.setPreferredSize(new Dimension((int) component.getPreferredSize().getWidth(), HEIGHT_FINAL));
        components.add(component);
    }

    private void personalize() {
        Color sec = Utils.darken(PersonalizationMaterial.getInstance().getColorSecundary());

        this.setPrimaryColor(PersonalizationMaterial.getInstance().getColorPrincipal());
        this.setSecundaryColor(sec);
        this.setGradient(GradientEnum.VERTICAL_3_4);
    }

    private class CompanyButton extends _MaterialButtonTransparent {

        public CompanyButton() {
            super("");
            float h = HEIGHT_FINAL;
            this.setFont(MaterialFontRoboto.MEDIUM.deriveFont(h * 0.65f));
        }
    }
}
