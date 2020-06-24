package com.jhw.swing.examples.components.login_and_dashboard;

import com.jhw.swing.notification.fade.NOTIF;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.dashboard.smoot._DashboardSmoot;
import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class DashboardView extends _DashboardSmoot {

    public DashboardView() {
        super();
        initializeDashBoard();
    }

    private void initializeDashBoard() {
        //logo empresa
        _MaterialLabel label = new _MaterialLabel();
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setIcon(MaterialIcons.FACE);
        label.setText("Company name");
        this.setUpElementLeftCorner(label);

        addUpRigthCorner();
        agregarMainElements();

        //licencia
        _MaterialLabel lic = new _MaterialLabel();
        lic.setText("X días para activar");
        this.setDownElementLeftCorner(lic);

        addDownRigthPanel();
        this.setSelected(0);
    }

    /**
     * Tecnologias
     */
    private void addDownRigthPanel() {

        Dimension dim = new Dimension((int) this.getPanelDownCornerRight().getPreferredSize().getHeight() + 6, (int) this.getPanelDownCornerRight().getPreferredSize().getHeight());

        _MaterialIconButtonTranspRect tecnJava = new _MaterialIconButtonTranspRect();
        tecnJava.setToolTipText("JAVA 1.8.60(Lenguaje de programación)");
        tecnJava.setIcon(MaterialIcons.TEC_JAVA);
        tecnJava.setMinimumSize(dim);
        tecnJava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnJava);

        _MaterialIconButtonTranspRect tecnNB = new _MaterialIconButtonTranspRect();
        tecnNB.setToolTipText("NetBeans 8.0(IDE)");
        tecnNB.setIcon(MaterialIcons.TEC_NB);
        tecnNB.setMinimumSize(dim);
        tecnNB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnNB);

        _MaterialIconButtonTranspRect tecnMySql = new _MaterialIconButtonTranspRect();
        tecnMySql.setToolTipText("MySql 10.4.8 (BD)");
        tecnMySql.setIcon(MaterialIcons.TEC_MYSQL);
        tecnMySql.setMinimumSize(dim);
        tecnMySql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnMySql);

        _MaterialIconButtonTranspRect tecnXampp = new _MaterialIconButtonTranspRect();
        tecnXampp.setToolTipText("XAMPP 3.2.4 (Cliente Servicios)");
        tecnXampp.setIcon(MaterialIcons.TEC_XAMPP);
        tecnXampp.setMinimumSize(dim);
        tecnXampp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnXampp);

        _MaterialIconButtonTranspRect tecnGit = new _MaterialIconButtonTranspRect();
        tecnGit.setToolTipText("Git 2.20.1 (Control de versiones)");
        tecnGit.setIcon(MaterialIcons.TEC_GIT);
        tecnGit.setMinimumSize(dim);
        tecnGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnGit);

        _MaterialIconButtonTranspRect tecnGitKraken = new _MaterialIconButtonTranspRect();
        tecnGitKraken.setToolTipText("GitKraken 6.4.0 (Cliente Git)");
        tecnGitKraken.setIcon(MaterialIcons.TEC_GITKRAKEN);
        tecnGitKraken.setMinimumSize(dim);
        tecnGitKraken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnGitKraken);

        _MaterialIconButtonTranspRect tecnGitHub = new _MaterialIconButtonTranspRect();
        tecnGitHub.setToolTipText("GitHub (Servidor Git)");
        tecnGitHub.setIcon(MaterialIcons.TEC_GITHUB);
        tecnGitHub.setMinimumSize(dim);
        tecnGitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnGitHub);

        _MaterialIconButtonTranspRect tecnFlaticon = new _MaterialIconButtonTranspRect();
        tecnFlaticon.setToolTipText("Flaticon (Iconos)");
        tecnFlaticon.setIcon(MaterialIcons.TEC_FLATICON);
        tecnFlaticon.setMinimumSize(dim);
        tecnFlaticon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnFlaticon);

        _MaterialIconButtonTranspRect tecnFreepick = new _MaterialIconButtonTranspRect();
        tecnFreepick.setToolTipText("Freepick (Diseños)");
        tecnFreepick.setIcon(MaterialIcons.TEC_FREEPICK);
        tecnFreepick.setMinimumSize(dim);
        tecnFreepick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnFreepick);

        _MaterialIconButtonTranspRect tecnAdobe = new _MaterialIconButtonTranspRect();
        tecnAdobe.setToolTipText("Adobe (Ai y Ps para el diseño de imágenes)");
        tecnAdobe.setIcon(MaterialIcons.TEC_ADOBE);
        tecnAdobe.setMinimumSize(dim);
        tecnAdobe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnAdobe);

        _MaterialIconButtonTranspRect tecnGoogle = new _MaterialIconButtonTranspRect();
        tecnGoogle.setToolTipText("Google (Material Design)");
        tecnGoogle.setIcon(MaterialIcons.TEC_GOOGLE);
        tecnGoogle.setMinimumSize(dim);
        tecnGoogle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnGoogle);

        _MaterialIconButtonTranspRect tecnJSON = new _MaterialIconButtonTranspRect();
        tecnJSON.setToolTipText("JSON (Ficheros)");
        tecnJSON.setIcon(MaterialIcons.TEC_JSON);
        tecnJSON.setMinimumSize(dim);
        tecnJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnJSON);

        _MaterialIconButtonTranspRect tecnWhatsapp = new _MaterialIconButtonTranspRect();
        tecnWhatsapp.setToolTipText("WhatsApp (Contacto: +53 5 4268660)");
        tecnWhatsapp.setIcon(MaterialIcons.TEC_WHATSAPP);
        tecnWhatsapp.setMinimumSize(dim);
        tecnWhatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        this.addDownElementRightCorner(tecnWhatsapp);
    }

    private void agregarMainElements() {
        this.addMainElement("Pagos Pendientes", MaterialIcons.TAG_FACES, new PanelInterno());

        this.addMainElement("Empresas", MaterialIcons.SENTIMENT_VERY_DISSATISFIED, new PanelInterno());

        this.addMainElement("Cuentas", MaterialIcons.TEC_GITKRAKEN, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
        //this.addMainElement("Cuentas", MaterialIcons.SENTIMENT_NEUTRAL, new PanelInterno());
    }

    private void addUpRigthCorner() {
        Color fore = Utils.isDark(this.getPanelUp().getSecundaryColor()) ? MaterialColors.WHITE : MaterialColors.BLACK;
        _MaterialIconButtonTranspRect calc = new _MaterialIconButtonTranspRect();
        calc.setIcon(MaterialIcons.ONDEMAND_VIDEO.deriveIcon(fore));
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Runtime.getRuntime().exec("calc");
                } catch (IOException ex) {
                    System.out.println("Exception " + ex.getMessage());
                }
            }
        });
        this.addUpElementRightCorner(calc);

        _MaterialIconButtonTranspRect bug = new _MaterialIconButtonTranspRect();
        bug.setIcon(MaterialIcons.CLOUD_CIRCLE.deriveIcon(fore));
        bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOTIF.makeNotificationFAIL("BBBBBUUUUUUGGGGGGGG. Run and Run as fast as you can.");
            }
        });
        this.addUpElementRightCorner(bug);
    }
}
