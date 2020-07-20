package com.jhw.swing.models.index;

import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.button.prepared._buttonView;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.textarea._ContentArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import com.jhw.swing.util.icons.DerivableIcon;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialIcons;

/**
 * Panel base para crear index de modelos. <\br>
 * Como se usa
 * <pre>
 *  public class TipoOpDet extends _MaterialPanelIndex {
 *
 *      public TipoOpDet() {
 *          this.setMainText("Tipo de OP");
 *
 *          this.addDetailedText("Administra las diferentes operaciones");
 *          this.addDetailedText("Ejemplo.: ENTRADA, SALIDA");
 *
 *          this.addButtonAddListener(new java.awt.event.ActionListener() {
 *              public void actionPerformed(java.awt.event.ActionEvent evt) {
 *                  new _NotificationDialogInfo("Button ADD activado");
 *              }
 *          });
 *
 *          this.addButtonViewListener(new java.awt.event.ActionListener() {
 *              public void actionPerformed(java.awt.event.ActionEvent evt) {
 *                  new _NotificationDialogInfo("Button VIEW activado");
 *              }
 *          });
 *      }
 *
 *  }
 * <\pre>
 * @author Yo
 */
public class _MaterialPanelIndex extends JPanel implements Update {

    private Font mainFont = MaterialFontRoboto.BOLD.deriveFont(24f);
    private Font detailFont = MaterialFontRoboto.MEDIUM.deriveFont(18f);

    public _MaterialPanelIndex() {
        initComponents();
        personalize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        panelBackground = new com.jhw.swing.material.components.container.panel._MaterialPanel();
        panelIcon = new com.jhw.swing.material.components.container.panel._PanelGradient();
        labelMain = new com.jhw.swing.material.components.labels._MaterialLabel();
        contentAreaDetail = new com.jhw.swing.material.components.textarea._ContentArea();
        buttonView = new com.jhw.swing.material.components.button.prepared._buttonView();
        buttonAdd = new com.jhw.swing.material.components.button.prepared._buttonAddEdit();

        panelBackground.setPreferredSize(new java.awt.Dimension(775, 165));

        panelIcon.setPreferredSize(new java.awt.Dimension(50, 50));
        panelIcon.setPrimaryColor(new java.awt.Color(255, 255, 255));
        panelIcon.setSecundaryColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelIconLayout = new javax.swing.GroupLayout(panelIcon);
        panelIcon.setLayout(panelIconLayout);
        panelIconLayout.setHorizontalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        panelIconLayout.setVerticalGroup(
            panelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        labelMain.setText("Main TEXT");
        labelMain.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N

        buttonView.setText("Ver");

        buttonAdd.setText("Nuevo");

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addContainerGap(157, Short.MAX_VALUE)
                        .addComponent(buttonView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                        .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(contentAreaDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(panelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(labelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(7, 7, 7)))
                .addGap(12, 12, 12))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(labelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(contentAreaDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.button.prepared._buttonAddEdit buttonAdd;
    private com.jhw.swing.material.components.button.prepared._buttonView buttonView;
    private com.jhw.swing.material.components.textarea._ContentArea contentAreaDetail;
    private com.jhw.swing.material.components.labels._MaterialLabel labelMain;
    private com.jhw.swing.material.components.container.panel._MaterialPanel panelBackground;
    private com.jhw.swing.material.components.container.panel._PanelGradient panelIcon;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
    }

    private void personalize() {
        labelMain.setBackground(panelBackground.getBackground());
        labelMain.setFont(mainFont);

        contentAreaDetail.setBackColor(panelBackground.getBackground());
        contentAreaDetail.setTextFont(detailFont);

        panelIcon.setPrimaryColor(MaterialColors.TRANSPARENT);
        panelIcon.setSecundaryColor(MaterialColors.TRANSPARENT);
        panelIcon.setIcon(MaterialIcons.ADD);
    }

    public void addButtonViewListener(ActionListener action) {
        buttonView.addActionListener(action);
    }

    public void addButtonAddListener(ActionListener action) {
        buttonAdd.addActionListener(action);
    }

    public void addDetailedText(String text) {
        contentAreaDetail.addText(text);
    }

    public void setDetailedText(String text) {
        contentAreaDetail.setText(text);
    }

    public void setMainText(String text) {
        labelMain.setText(text);
    }

    public void setIcon(ImageIcon icon) {
        if (icon instanceof DerivableIcon) {
            float w = (float) panelIcon.getPreferredSize().getWidth();
            float h = (float) panelIcon.getPreferredSize().getWidth();
            float s = Math.min(w, h);
            panelIcon.setIcon(((DerivableIcon) icon).deriveIcon(s));//duplicado para no sobreescribir el mismo icono y que no afecto a otras entidades que lo usen
        } else {
            panelIcon.setIcon(icon);
        }
    }

    public Font getMainFont() {
        return mainFont;
    }

    public Font getDetailFont() {
        return detailFont;
    }

    public _buttonAddEdit getButtonAdd() {
        return buttonAdd;
    }

    public _buttonView getButtonView() {
        return buttonView;
    }

    public _ContentArea getContentAreaDetail() {
        return contentAreaDetail;
    }

    public _MaterialLabel getLabelMain() {
        return labelMain;
    }

    public _MaterialPanel getPanelBackground() {
        return panelBackground;
    }

    public _PanelGradient getPanelIcon() {
        return panelIcon;
    }
}
