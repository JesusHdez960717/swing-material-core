package com.jhw.swing.material.components.dashboard.taskpane.expanded;

import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.MaterialComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DownPanel extends _PanelGradient {

    private final int HEIGHT = 16;

    public DownPanel() {
        initComponents();

        addTecnology(MaterialIcons.TEC_JAVA.deriveIcon(16));
        addTecnology(MaterialIcons.TEC_NB.deriveIcon(16));
        addTecnology(MaterialIcons.TEC_GITKRAKEN.deriveIcon(16));
        addTecnology(MaterialIcons.TEC_GITHUB.deriveIcon(16));

        AbstractAction action = new AbstractAction("Vence en X Dias", MaterialIcons.SECURITY.deriveIcon(16)) {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
            }
        };
        setLicence(action);
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
        this.licence.setPreferredSize(new Dimension((int) licence.getPreferredSize().getWidth(), HEIGHT));
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
        _MaterialIconButtonTranspRect btn_Tec = new _MaterialIconButtonTranspRect();
        btn_Tec.setAction(action);
        String name = ((String) action.getValue(Action.NAME)).trim();
        if (!name.isEmpty()) {
            btn_Tec.setToolTipText(name);
        }
        btn_Tec.setPreferredSize(new Dimension(HEIGHT, HEIGHT));
        tec.add(btn_Tec);
    }

    private class LicenceButton extends JButton implements MaterialComponent {

        public LicenceButton() {
            this(MaterialColors.ORANGEA_200);
        }

        public LicenceButton(Color back) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            this.setFocusPainted(false);
            this.setBackground(back);
            this.setBorder(new LineBorder(Utils.darken(Utils.darken(back)), 2));
        }

    }
}
