/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.components.container;

import com.root101.swing.material.components.container.frame.MaterialWindow;
import com.root101.swing.material.components.container.panel.MaterialPanelBorder;
import com.root101.swing.material.components.container.panel._MaterialPanel;
import com.root101.swing.material.components.container.panel._MaterialPanelComponent;
import com.root101.swing.material.components.container.panel._PanelAvatarChooser;
import com.root101.swing.material.components.container.panel._PanelComponent;
import com.root101.swing.material.components.container.panel._PanelCurves;
import com.root101.swing.material.components.container.panel._PanelGradient;
import com.root101.swing.material.components.container.panel._PanelGradientTranslucid;
import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.components.container.tabbed._TabbedPaneClose;
import com.root101.swing.material.components.container.tabbed._TabbedPaneHeader;
import com.root101.swing.material.components.container.tabbed._TabbedPaneSelector;
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
        return _MaterialPanel.from();
    }

    public static MaterialPanelBorder buildPanelComponent() {
        return _MaterialPanelComponent.from();
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
        return _PanelGradient.from();
    }

    public static MaterialPanelBorder buildPanelGradientTranslucid() {
        return _PanelGradientTranslucid.from();
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
