package com.jhw.swing.material.components.filechooser;

import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._PanelComponent;
import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.event.ActionListener;
import java.io.File;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFileChooserPanel extends _PanelComponent implements Update {

    private _MaterialFileChooser fc;
    private static File lastFile = new File("");

    public _MaterialFileChooserPanel() {
        initComponents();
        addListeners();
        personalize();
        update();
    }

    private void initComponents() {

        labelSeleccionados = new com.jhw.swing.material.components.labels._MaterialLabel();
        buttonAbrir = new com.jhw.swing.material.components.button._MaterialButton();
        buttonOpenFolder = new com.jhw.swing.material.components.button._MaterialButtonIconTransparent();

        labelSeleccionados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSeleccionados.setText("Nada seleccionado");

        buttonAbrir.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BUTTON_VIEW));
        buttonAbrir.setText("Buscar");
        buttonAbrir.setPreferredSize(new java.awt.Dimension(120, 45));

        buttonOpenFolder.setRippleColor(new java.awt.Color(102, 102, 102));

        HorizontalLayoutContainer.builder hlc = HorizontalLayoutContainer.builder((int) buttonAbrir.getPreferredSize().getHeight());
        hlc.add(labelSeleccionados);
        hlc.add(buttonAbrir, false);
        hlc.add(buttonOpenFolder, false);

        setComponent(hlc.build());
    }

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.button._MaterialButton buttonAbrir;
    private com.jhw.swing.material.components.button._MaterialButtonIconTransparent buttonOpenFolder;
    private com.jhw.swing.material.components.labels._MaterialLabel labelSeleccionados;
    // End of variables declaration                   

    @Override
    public void update() {
        updateLabel();
    }

    public void isCreate(boolean create) {
        buttonOpenFolder.setVisible(!create);
    }

    public void addButtonOpenFolderAction(ActionListener action) {
        buttonOpenFolder.addActionListener(action);
    }

    private void personalize() {
        buttonOpenFolder.setIcon(MaterialIcons.FOLDER);

        buttonAbrir.setBackground(MaterialColors.GREY_700);
        buttonAbrir.setIcon(MaterialIcons.FIND_IN_PAGE);
    }

    public _MaterialButton getButtonAbrir() {
        return buttonAbrir;
    }

    public void setButtonAbrir(_MaterialButton buttonAbrir) {
        this.buttonAbrir = buttonAbrir;
    }

    public _MaterialLabel getLabelSeleccionados() {
        return labelSeleccionados;
    }

    public void setLabelSeleccionados(_MaterialLabel labelSeleccionados) {
        this.labelSeleccionados = labelSeleccionados;
    }

    public _MaterialFileChooser getFc() {
        return fc;
    }

    private void addListeners() {
        buttonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAbrirActionPerformed();
            }
        });
    }

    private void onButtonAbrirActionPerformed() {
        fc = new _MaterialFileChooser(lastFile);
        fc.addConfirmListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLabel();
            }
        });
    }

    public void clear() {
        if (fc != null) {
            fc.setSelectedFiles(null);
            updateLabel();
        }
    }

    public File[] getSelectedFiles() {
        if (fc == null) {
            return new File[0];
        } else {
            return fc.getSelectedFiles();
        }
    }

    private void updateLabel() {
        if (fc == null || fc.getSelectedFiles().length == 0) {
            labelSeleccionados.setText("Nada seleccionado");
            return;
        } else if (fc.getSelectedFiles().length == 1) {
            labelSeleccionados.setText("1: Seleccionado");
        } else {
            labelSeleccionados.setText("Seleccionados: " + fc.getSelectedFiles().length);
        }
        lastFile = fc.getSelectedFiles()[0].getParentFile();
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.buttonAbrir.setEnabled(enabled);
        this.labelSeleccionados.setEnabled(enabled);
        this.buttonOpenFolder.setEnabled(enabled);
        super.setEnabled(enabled);
    }
}
