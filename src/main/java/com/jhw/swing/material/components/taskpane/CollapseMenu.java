/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.components.button._MaterialButtonSimple;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.personalization.PersonalizationMaterial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPaneContainer;

/**
 *
 * @author Jorge
 */
//TODO: fondo personalizable
//TODO: 
public class CollapseMenu extends JPanel {

    public static final String PROP_COLLAPSE = "Collapse";

    private Icon iconoCategoria;
    private String nombreCategoria;

    private ArrayList<TaskButton> buttons = new ArrayList<>();

    public CollapseMenu(Icon iconoCategoria, String nombreCategoria) {
        initComponents();
        this.iconoCategoria = iconoCategoria;
        this.nombreCategoria = nombreCategoria;
        configurateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSubActions = new org.jdesktop.swingx.JXTaskPaneContainer();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanelFixed = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonIcono = new _MaterialIconButtonTranspRect();
        jButtonNombre = new _MaterialButtonSimple("");
        jPanelCollapsible = new org.jdesktop.swingx.JXCollapsiblePane();

        jPanelSubActions.setBackground(new java.awt.Color(204, 0, 204));
        jPanelSubActions.setOpaque(false);
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jPanelSubActions.setLayout(verticalLayout1);

        setBackground(new java.awt.Color(255, 255, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.BorderLayout());

        jPanelFixed.setBackground(new java.awt.Color(0, 153, 153));
        jPanelFixed.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        jPanelFixed.setMinimumSize(new java.awt.Dimension(327, 60));
        jPanelFixed.setPreferredSize(new java.awt.Dimension(294, 40));
        jPanelFixed.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("#");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelFixed.add(jLabel1, java.awt.BorderLayout.LINE_END);

        jButtonIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIcono.setMaximumSize(new java.awt.Dimension(80, 80));
        jButtonIcono.setMinimumSize(new java.awt.Dimension(60, 60));
        jButtonIcono.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelFixed.add(jButtonIcono, java.awt.BorderLayout.LINE_START);

        jButtonNombre.setFont(new java.awt.Font(".SF NS Text", 0, 18)); // NOI18N
        jButtonNombre.setText("<Nombre>");
        jButtonNombre.setBorderPainted(false);
        jPanelFixed.add(jButtonNombre, java.awt.BorderLayout.CENTER);

        add(jPanelFixed, java.awt.BorderLayout.PAGE_START);

        jPanelCollapsible.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCollapsible.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.DOWN);
        add(jPanelCollapsible, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void shrink() {
        onMouseCLicked(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIcono;
    private javax.swing.JButton jButtonNombre;
    private javax.swing.JLabel jLabel1;
    private org.jdesktop.swingx.JXCollapsiblePane jPanelCollapsible;
    private javax.swing.JPanel jPanelFixed;
    private org.jdesktop.swingx.JXTaskPaneContainer jPanelSubActions;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    public void addMenuItem(Action action) {
        TaskButton button = new TaskButton(action);
        buttons.add(button);
        jPanelSubActions.add(button);
        jLabel1.setText("" + jPanelSubActions.getComponentCount());
        jPopupMenu1.add(action);
    }

    public void setMainButtonBackground(Color color) {
        jPanelFixed.setBackground(color);
    }

    public void setCollapsablePanelBackground(Color color) {
        jPanelCollapsible.getContentPane().setBackground(color);
    }

    public void setButtonNameFont(Font font) {
        jButtonNombre.setFont(font);
        Font internal = font.deriveFont(Font.PLAIN).deriveFont(font.getSize2D() * 0.8f);
        setButtonsInternalFont(internal);
        jLabel1.setFont(internal);

    }

    public void setButtonsInternalFont(Font font) {
        for (TaskButton button : buttons) {
            button.setFont(font);
        }
    }

    public void setButtonNameHorizontalAlignment(int align) {
        jButtonNombre.setHorizontalAlignment(align);
    }

    public void setPanelCollapsibleGaps(int top, int left, int bottom, int right) {
        jPanelCollapsible.setBorder(javax.swing.BorderFactory.createEmptyBorder(top, left, bottom, right));
    }

    public void setHeight(int h) {
        jPanelFixed.setPreferredSize(new java.awt.Dimension(300, h));
        jButtonIcono.setPreferredSize(new java.awt.Dimension(h, h));
        //this.setMinimumSize(new java.awt.Dimension(h, h));
    }

    public int getComponentsHight() {
        return (int) jButtonIcono.getPreferredSize().getHeight();
    }

    protected void configurateUI() {
        jPanelCollapsible.setLayout(new BorderLayout());
        jPanelCollapsible.add(jPanelSubActions, BorderLayout.CENTER);

        jButtonIcono.setIcon(iconoCategoria);

        jButtonNombre.setText(nombreCategoria);

        jPanelCollapsible.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            if (evt.getPropertyName().equals("collapse")) {
                setOpaque(!jPanelCollapsible.isCollapsed());
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (isShinked()) {
                    jPanelCollapsible.setCollapsed(true);
                    jButtonIcono.setToolTipText(nombreCategoria);
                } else {
                    jButtonIcono.setToolTipText(null);
                }

            }

        });
        addListeners();
    }

    private boolean isShinked() {
        return getSize().width < 85;//TODO: personalizar tamanno del menu
    }

    private void createPopupPanel() {
        jPopupMenu1.show(this, jButtonIcono.getBounds().x + jButtonIcono.getWidth(), jButtonIcono.getBounds().y);
        //  Logger.getLogger(getClass().getName()).log(Level.WARNING, "En desarrollo");
    }

    private void onMouseCLicked(ActionEvent e) {
        if (isShinked()) {
            createPopupPanel();
        } else {
            jPanelCollapsible.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION).actionPerformed(null);
        }

    }

    public JButton getjButtonIcono() {
        return jButtonIcono;
    }

    public JButton getjButtonNombre() {
        return jButtonNombre;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JXCollapsiblePane getjPanelCollapsible() {
        return jPanelCollapsible;
    }

    protected void addListeners() {
        jButtonIcono.addActionListener((ActionEvent e) -> {
            onMouseCLicked(e);
        });
        jButtonNombre.addActionListener((ActionEvent e) -> {
            onMouseCLicked(e);
        });
    }

}
