package com.root101.swing.ui.componentsui.filechooser;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.material.standards.MaterialImages;

public class MaterialFileChooserUI extends MetalFileChooserUI {

    public MaterialFileChooserUI(JFileChooser fileChooser) {
        super(fileChooser);
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialFileChooserUI((JFileChooser) c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JFileChooser fileChooser = (JFileChooser) c;
        MaterialFileChooserUI ui = (MaterialFileChooserUI) fileChooser.getUI();

        ui.uninstallIcons(fileChooser);
        ui.uninstallComponents(fileChooser);
        ui.clearIconCache();

        ui.computerIcon = MaterialIcons.COMPUTER.deriveIcon(18f);
        ui.directoryIcon = MaterialIcons.FOLDER.deriveIcon(18f);
        ui.fileIcon = MaterialIcons.INSERT_DRIVE_FILE.deriveIcon(18f);
        ui.floppyDriveIcon = MaterialIcons.SAVE.deriveIcon(18f);
        ui.hardDriveIcon = MaterialIcons.STORAGE.deriveIcon(18f);

        ui.homeFolderIcon = MaterialIcons.HOME.deriveIcon(18f);
        ui.listViewIcon = MaterialIcons.LIST.deriveIcon(18f);
        ui.detailsViewIcon = MaterialIcons.VIEW_MODULE.deriveIcon(18f);
        ui.newFolderIcon = MaterialIcons.CREATE_NEW_FOLDER.deriveIcon(18f);
        ui.upFolderIcon = MaterialIcons.ARROW_BACK.deriveIcon(18f);

        ui.openButtonText = "ABRIR";
        ui.cancelButtonText = "CANCELAR";
        ui.helpButtonText = "AYUDA";
        ui.saveButtonText = "SALVAR";
        ui.directoryOpenButtonText = "ABRIR";
        ui.updateButtonText = "EDITAR";

        ui.installComponents(fileChooser);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
