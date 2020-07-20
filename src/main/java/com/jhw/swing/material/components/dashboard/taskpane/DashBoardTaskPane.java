/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.dashboard.taskpane;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.material.components.taskpane.TaskPaneMainContainer;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.enums.GradientEnum;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Jorge
 */
public class DashBoardTaskPane extends DashBoardSimple implements PropertyChangeListener {

    private Consumer<TaskButton> buttonFormatter = (TaskButton btn) -> {
    };

    private Consumer<CollapseMenu> collapseMenuFormatter = (CollapseMenu menu) -> {
    };

    private final CardLayout cards = new CardLayout();

    private boolean shrinked;

    private final TaskPaneMainContainer task = new TaskPaneMainContainer();

    private final ArrayList<CollapseMenu> menus = new ArrayList<>();

    private Consumer<CollapseMenu> menuFormatter = (CollapseMenu menu) -> {
    };

    private ImageIcon iconShrink = MaterialIcons.ARROW_FORWARD.deriveIcon(30);
    private ImageIcon iconUnShrink = MaterialIcons.ARROW_BACK.deriveIcon(30);

    /**
     * Creates new form RootView
     */
    public DashBoardTaskPane() {
        initComponents();
        personalize();
        panelContent.setLayout(cards);
        jPanelMenu.add(task, BorderLayout.CENTER);
    }

    private void initComponents() {
        panelContent = new javax.swing.JPanel();
        panelSideMenu = new _PanelGradient();
        panelUp = new javax.swing.JPanel();
        jButtonUp = new com.jhw.swing.material.components.button._MaterialButtonIconTransparent(MaterialIcons.ARROW_BACK.deriveIcon(30));
        jPanelDown = new javax.swing.JPanel();
        jButtonDown = new com.jhw.swing.material.components.button._MaterialButtonIconTransparent(MaterialIcons.ARROW_BACK.deriveIcon(30));
        jPanelMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelContent, java.awt.BorderLayout.CENTER);

        panelSideMenu.setBackground(new java.awt.Color(102, 102, 102));
        panelSideMenu.setLayout(new java.awt.BorderLayout());

        panelUp.setOpaque(false);
        panelUp.setLayout(new java.awt.BorderLayout());

        jButtonUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButtonUp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUp.setMaximumSize(null);
        jButtonUp.setMinimumSize(new java.awt.Dimension(0, 40));
        jButtonUp.setPreferredSize(new java.awt.Dimension(0, 40));
        jButtonUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpActionPerformed(evt);
            }
        });
        panelUp.add(jButtonUp, java.awt.BorderLayout.CENTER);

        panelSideMenu.add(panelUp, java.awt.BorderLayout.PAGE_START);

        jPanelDown.setOpaque(false);
        jPanelDown.setLayout(new java.awt.BorderLayout());

        jButtonDown.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButtonDown.setMaximumSize(null);
        jButtonDown.setMinimumSize(new java.awt.Dimension(40, 40));
        jButtonDown.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDownActionPerformed(evt);
            }
        });
        jPanelDown.add(jButtonDown, java.awt.BorderLayout.CENTER);

        panelSideMenu.add(jPanelDown, java.awt.BorderLayout.PAGE_END);

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setOpaque(false);
        jPanelMenu.setLayout(new java.awt.BorderLayout());
        panelSideMenu.add(jPanelMenu, java.awt.BorderLayout.CENTER);

        add(panelSideMenu, java.awt.BorderLayout.WEST);
    }// </editor-fold>                        

    private void jButtonDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDownActionPerformed
        setShrinked(!shrinked);
        jButtonDown.setIcon(shrinked ? iconShrink : iconUnShrink);
    }//GEN-LAST:event_jButtonDownActionPerformed

    private void jButtonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpActionPerformed
        setShrinked(!shrinked);
        jButtonUp.setIcon(shrinked ? iconShrink : iconUnShrink);
    }//GEN-LAST:event_jButtonUpActionPerformed

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonDown;
    private javax.swing.JButton jButtonUp;
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel panelUp;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSideMenu;
    // End of variables declaration                   

    @Override
    public void update(HashMap<String, Object> hm) {
        menus.clear();
        this.task.clear();
        for (String key : hm.keySet()) {
            Object component = hm.get(key);
            switch (key) {
                case DashboardConstants.MAIN_ELEMENT:
                    add(component);
                    break;
            }
        }
        //this.revalidate();
    }

    @Override
    public void deselectAll() {
        for (CollapseMenu menu : menus) {
            menu.deselectAll();
        }
    }

    public ImageIcon getIconShrink() {
        return iconShrink;
    }

    public void setIconShrink(ImageIcon iconShrink) {
        this.iconShrink = iconShrink;
    }

    public ImageIcon getIconUnShrink() {
        return iconUnShrink;
    }

    public void setIconUnShrink(ImageIcon iconUnShrink) {
        this.iconUnShrink = iconUnShrink;
    }

    public Consumer<CollapseMenu> getMenuFormatter() {
        return menuFormatter;
    }

    public void setMenuFormatter(Consumer<CollapseMenu> menuFormatter) {
        this.menuFormatter = menuFormatter;
        for (CollapseMenu menu : menus) {
            menuFormatter.accept(menu);
        }
    }

    private void add(Object component) {
        if (component instanceof CollapseMenu) {
            addMainElement((CollapseMenu) component);
        } else if (component instanceof List) {
            for (Object single : (List) component) {
                if (single instanceof CollapseMenu) {
                    addMainElement((CollapseMenu) single);
                }
            }
        } else {
            String logMSG = "Component " + component + " not supperted by actual DashBoard";
            Logger.getLogger(DashBoardTaskPane.class.getName()).log(Level.WARNING, logMSG);
        }
    }

    @Override
    public void addView(String name, Component compoment) {
        panelContent.add(name, compoment);
    }

    @Override
    public void showView(String name) {
        cards.show(panelContent, name);
    }

    @Override
    public Component getView(String string) {
        for (Component c : panelContent.getComponents()) {
            if (c.isVisible()) {
                return c;
            }
        }
        return panelContent;
    }

    private void personalize() {
        panelSideMenu.setBackground(PersonalizationMaterial.getInstance().getColorPrincipal());
    }

    public void removeUpButton() {
        panelUp.setVisible(false);
    }

    public void removeDownButton() {
        jPanelDown.setVisible(false);
    }

    public void setPanelSideMenuColor(Color background) {
        panelSideMenu.setBackground(background);
        task.setTaskPaneBackground(background);
    }

    public void setShrinked(boolean shrink) {
        this.shrinked = shrink;
        this.task.setCollapsed(this.shrinked);
    }

    public void addMainElement(CollapseMenu menu) {
        //add listener
        menu.addPropertyChangeListener(this);
        
        //formatear
        menuFormatter.accept(menu);
        menu.selected(false);//por defecto deseleccionado
        
        //add to the list
        menus.add(menu);
        //add to the taskPane
        this.task.addItem(menu);
        
        //set minimun size of shrink
        setMinimunShrink(menu.getComponentsHight());

    }

    /**
     * Usar directamente el {@code addMainElement}
     *
     * @param menu
     * @deprecated
     */
    @Deprecated
    public void addComponent(CollapseMenu menu) {
        menus.add(menu);
        this.task.addItem(menu);
    }

    public void setMinimunShrink(int min) {
        jButtonDown.setMinimumSize(new Dimension(min, min));
        jButtonDown.setPreferredSize(new Dimension(min, min));

        jButtonUp.setMinimumSize(new Dimension(min, min));
        jButtonUp.setPreferredSize(new Dimension(min, min));
    }

    public void setButtonFormatter(Consumer<TaskButton> buttonFormatter) {
        this.buttonFormatter = buttonFormatter;
    }

    public void setCollapseMenuFormatter(Consumer<CollapseMenu> collapseMenuFormatter) {
        this.collapseMenuFormatter = collapseMenuFormatter;
    }

    @Override
    public void format() {
        for (CollapseMenu menu : menus) {
            collapseMenuFormatter.accept(menu);
            for (TaskButton button : menu.getButtons()) {
                buttonFormatter.accept(button);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case DashboardConstants.FIRE_CHILD_SELECTED:
                deselectAll();
                break;
            default:
                return;
        }
    }

}
