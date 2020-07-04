package com.jhw.swing.examples.application;

import com.jhw.swing.TEST.dash.*;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.bundles.dialog.DialogPanel;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.container.gap._GapContainerGeneral;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.SingleCollapseMenu;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.swing.util.JOP;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    public static final SwingApplicationImpl app = new SwingApplicationImpl();

    public static void main(String args[]) throws Exception {
        app.run();
        app.registerModule(new SampleSwingModule());
    }

}
