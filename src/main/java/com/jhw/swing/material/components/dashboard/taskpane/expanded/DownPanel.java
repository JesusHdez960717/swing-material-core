package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.button._MaterialButtonFlat;
import com.jhw.swing.material.components.button._MaterialButtonIconTranspRect;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DownPanel extends _PanelGradient {

    private final int HEIGHT_FINAL = 16;

    public DownPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBackground(MaterialColors.GREY_200);
        this.setBorder(new LineBorder(MaterialColors.GREY_500, 1));

        this.tec = new _PanelTransparent();
        this.tec.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 3));

        this.add(this.tec, BorderLayout.EAST);
    }

    private JButton licence;
    private _PanelTransparent tec;

    public void setLicence(Action action) {
        if (this.licence != null) {
            this.remove(this.licence);
        }
        JButton licenceButton = new LicenceButton();
        this.licence = licenceButton;
        this.licence.setAction(action);
        this.licence.setPreferredSize(new Dimension((int) licence.getPreferredSize().getWidth(), HEIGHT_FINAL));
        this.add(this.licence, BorderLayout.WEST);
    }

    public void addTecnology(ImageIcon icon) {
        addTecnology(new AbstractAction("", icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
    }

    public void addTecnology(ImageIcon icon, String name) {
        addTecnology(new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
    }

    public void addTecnology(Action action) {
        _MaterialButtonIconTranspRect btn_Tec = new _MaterialButtonIconTranspRect();
        btn_Tec.setAction(action);
        String name = ((String) action.getValue(Action.NAME)).trim();
        if (!name.isEmpty()) {
            btn_Tec.setToolTipText(name);
        }
        btn_Tec.setPreferredSize(new Dimension(HEIGHT_FINAL, HEIGHT_FINAL));
        tec.add(btn_Tec);
    }

    private class LicenceButton extends _MaterialButtonFlat implements MaterialComponent {

        public LicenceButton() {
            this(MaterialColors.ORANGEA_200);
        }

        public LicenceButton(Color back) {
            this.setBackground(back);
            this.setBorder(new LineBorder(Utils.darken(Utils.darken(back)), 2));
        }

    }
}
