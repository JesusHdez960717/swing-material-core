/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.container;

import com.jhw.swing.material.components.container.frame.MaterialWindow;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.container.panel.*;
import com.jhw.swing.material.components.container.tabbed._TabbedPaneClose;
import com.jhw.swing.material.components.container.tabbed._TabbedPaneHeader;
import com.jhw.swing.material.components.container.tabbed._TabbedPaneSelector;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialContainersFactory {

    public static JFrame buildFrame() {
        return MaterialWindow.from();
    }

    public static MaterialPanelBorder buildPanel() {
        return MaterialSwingInjector.getImplementation(_MaterialPanel.class);
        //return _MaterialPanel.from();
    }

    public static MaterialPanelBorder buildPanelComponent() {
        return MaterialSwingInjector.getImplementation(_MaterialPanelComponent.class);
        //return _MaterialPanelComponent.from();
    }

    public static JPanel buildPanelComponentTransparent() {
        return _PanelComponent.from();
    }

    public static _PanelAvatarChooser buildPanelAvatar() {
        return _PanelAvatarChooser.from();
    }

    public static JPanel buildPanelCurves() {
        return _PanelCurves.from();
    }

    public static MaterialPanelBorder buildPanelGradient() {
        return MaterialSwingInjector.getImplementation(_PanelGradient.class);
        //return _PanelGradient.from();
    }

    public static MaterialPanelBorder buildPanelGradientTranslucid() {
        return MaterialSwingInjector.getImplementation(_PanelGradientTranslucid.class);
        //return _PanelGradientTranslucid.from();
    }

    public static JPanel buildPanelTransparent() {
        return _PanelTransparent.from();
    }

    public static JTabbedPane buildTabbedClose() {
        return _TabbedPaneClose.from();
    }

    public static JTabbedPane buildTabbedHeader() {
        return _TabbedPaneHeader.from();
    }

    public static JTabbedPane buildTabbedSelector() {
        return _TabbedPaneSelector.from();
    }
}
