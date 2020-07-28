package com.jhw.swing.bundles.jop;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialColors;

/**
 *
 * @author Jessica Aidyl Garcia Albalah (jgarciaalbalah@gmail.com)
 */
public class _DialogOptionPane extends JDialog implements MaterialComponent {

    private final _OptionPanel optionPane;

    public _DialogOptionPane(OptionPanelBuilder builder) {
        super();
        this.optionPane = new _OptionPanel();
        this.setUndecorated(true);
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setUndecorated(builder.undecorated);
        optionPane.setInternalPanel(builder.panel);
        optionPane.getButtonPositive().addActionListener(builder.positiveButtonListener);
        optionPane.getButtonNegative().addActionListener(builder.negativeButtonListener);
        validates(builder);
        disposes();
        setUpDialog(optionPane);
    }

    private void validates(OptionPanelBuilder builder) {
        if (builder.backgroundColor != null) {
            optionPane.setBackground(builder.backgroundColor);
        }
        if (builder.buttonPositiveText != null) {
            optionPane.setButtonPositiveText(builder.buttonPositiveText);
        }
        if (builder.buttonNegativeText != null) {
            optionPane.setButtonNegativeText(builder.buttonNegativeText);
        }
        if (builder.buttonPositiveBackground != null) {
            optionPane.setButtonPositiveBackground(builder.buttonPositiveBackground);
        }
        if (builder.buttonNegativeBackground != null) {
            optionPane.setButtonNegativeBackground(builder.buttonNegativeBackground);
        }
        if (builder.buttonsBackground != null) {
            optionPane.setButtonsBackground(builder.buttonsBackground);
        }
        if (builder.internalPanelBackground != null) {
            optionPane.setInternalPanelBackgroun(builder.internalPanelBackground);

        }
        if (builder.setTouchOutside) {
            this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        } else {
            this.setModalityType(Dialog.ModalityType.MODELESS);
        }
        if (builder.title != null) {
            this.setTitle(builder.title);
        }
    }

    private void setUpDialog(_OptionPanel optionPane) {
        this.setLayout(new GridLayout(1, 1));
        this.add(optionPane);
        this.setSize(optionPane.getPreferredSize());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void disposes() {
        optionPane.getButtonPositive().addActionListener((ActionEvent e) -> {
            dispose();
        });

        optionPane.getButtonNegative().addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    public static class OptionPanelBuilder {

        private final JPanel panel;
        private ActionListener positiveButtonListener;
        private ActionListener negativeButtonListener;
        private Color backgroundColor;
        private Color buttonPositiveBackground;
        private Color buttonNegativeBackground;
        private Color buttonsBackground;
        private Color internalPanelBackground;
        private String buttonPositiveText;
        private String buttonNegativeText;
        private String title;
        private boolean setTouchOutside;
        private boolean undecorated;

        public OptionPanelBuilder(JPanel panel) {
            this.panel = panel;
        }

        public OptionPanelBuilder setPositiveButtonListener(ActionListener listener) {
            this.positiveButtonListener = listener;
            return this;
        }

        public OptionPanelBuilder setNegativeButtonListener(ActionListener listener) {
            this.negativeButtonListener = listener;
            return this;
        }

        public OptionPanelBuilder setBackgroundColor(Color color) {
            this.backgroundColor = color;
            return this;
        }

        public OptionPanelBuilder setButtonPositiveBackground(Color color) {
            this.buttonPositiveBackground = color;
            return this;
        }

        public OptionPanelBuilder setButtonNegativeBackground(Color color) {
            this.buttonNegativeBackground = color;
            return this;
        }

        public OptionPanelBuilder setInternalPanelBackground(Color color) {
            this.internalPanelBackground = color;
            return this;
        }

        public OptionPanelBuilder setButtonsBackground(Color color) {
            this.buttonsBackground = color;
            return this;
        }

        public OptionPanelBuilder setTouchOutside(Boolean bool) {
            this.setTouchOutside = bool;
            return this;
        }

        public OptionPanelBuilder setUndecorated(Boolean bool) {
            this.undecorated = bool;
            return this;
        }

        public OptionPanelBuilder setTitle(String text) {
            this.title = text;
            return this;
        }

        public OptionPanelBuilder setButtonPositiveText(String text) {
            this.buttonPositiveText = text;
            return this;
        }

        public OptionPanelBuilder setButtonNegativeText(String text) {
            this.buttonNegativeText = text;
            return this;
        }

        public _DialogOptionPane build() {
            return new _DialogOptionPane(this);
        }

    }

}
