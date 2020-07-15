/*
 * MIT License
 *
 * Copyright (c) 2018-2019 atharva washimkar,
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.jhw.swing.ui;

import java.awt.Color;
import java.lang.reflect.Method;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.DefaultEditorKit;
import com.jhw.swing.ui.componentsui.button.MaterialButtonUI;
import com.jhw.swing.ui.componentsui.checkbox.MaterialCheckBoxUI;
import com.jhw.swing.ui.componentsui.checkboxmenuitem.MaterialCheckBoxMenuItemUI;
import com.jhw.swing.ui.componentsui.combobox.MaterialComboBoxUI;
import com.jhw.swing.ui.componentsui.filechooser.MaterialFileChooserUI;
import com.jhw.swing.ui.componentsui.formattertextfield.MaterialFormattedTextFieldUI;
import com.jhw.swing.ui.componentsui.label.MaterialLabelUI;
import com.jhw.swing.ui.componentsui.list.MaterialListUI;
import com.jhw.swing.ui.componentsui.menu.MaterialMenuUI;
import com.jhw.swing.ui.componentsui.menubar.MaterialMenuBarUI;
import com.jhw.swing.ui.componentsui.menuitem.MaterialMenuItemUI;
import com.jhw.swing.ui.componentsui.optionpane.MaterialOptionPaneUI;
import com.jhw.swing.ui.componentsui.panel.MaterialPanelUI;
import com.jhw.swing.ui.componentsui.password.MaterialPasswordFieldUI;
import com.jhw.swing.ui.componentsui.popupmenu.MaterialPopupMenuUI;
import com.jhw.swing.ui.componentsui.progressbar.MaterialProgressBarUI;
import com.jhw.swing.ui.componentsui.radiobutton.MaterialRadioButtonUI;
import com.jhw.swing.ui.componentsui.radiobuttonmenuitem.MaterialRadioButtonMenuItemUI;
import com.jhw.swing.ui.componentsui.scrollbar.MaterialScrollBarUI;
import com.jhw.swing.ui.componentsui.separator.MaterialSeparatorUI;
import com.jhw.swing.ui.componentsui.slider.MaterialSliderUI;
import com.jhw.swing.ui.componentsui.spinner.MaterialSpinnerUI;
import com.jhw.swing.ui.componentsui.tabbedpane.MaterialTabbedPaneUI;
import com.jhw.swing.ui.componentsui.table.MaterialTableHeaderUI;
import com.jhw.swing.ui.componentsui.table.MaterialTableUI;
import com.jhw.swing.ui.componentsui.textfield.MaterialTextFieldUI;
import com.jhw.swing.ui.componentsui.textpane.MaterialTextPaneUI;
import com.jhw.swing.ui.componentsui.togglebutton.MaterialToggleButtonUI;
import com.jhw.swing.ui.componentsui.toolbar.MaterialToolBarUI;
import com.jhw.swing.ui.componentsui.tooltip.MaterialToolTipUI;
import com.jhw.swing.ui.componentsui.tree.MaterialTreeUI;
import com.jhw.swing.ui.utils.MaterialBorders;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.material.standars.MaterialImages;

public class MaterialLookAndFeel extends MetalLookAndFeel {

    private static final String buttonUI = MaterialButtonUI.class.getCanonicalName();
    private static final String textfieldUI = MaterialTextFieldUI.class.getCanonicalName();
    private static final String passwordFieldUI = MaterialPasswordFieldUI.class.getCanonicalName();
    private static final String tableUI = MaterialTableUI.class.getCanonicalName();
    private static final String tableHeaderUI = MaterialTableHeaderUI.class.getCanonicalName();
    private static final String treeUI = MaterialTreeUI.class.getCanonicalName();
    private static final String spinnerUI = MaterialSpinnerUI.class.getCanonicalName();
    private static final String panelUI = MaterialPanelUI.class.getCanonicalName();
    private static final String labelUI = MaterialLabelUI.class.getCanonicalName();
    private static final String menuItemUI = MaterialMenuItemUI.class.getCanonicalName();
    private static final String menuBarUI = MaterialMenuBarUI.class.getCanonicalName();
    private static final String menuUI = MaterialMenuUI.class.getCanonicalName();
    private static final String checkBoxUI = MaterialCheckBoxUI.class.getCanonicalName();
    private static final String radioButtonUI = MaterialRadioButtonUI.class.getCanonicalName();
    private static final String tabbedPaneUI = MaterialTabbedPaneUI.class.getCanonicalName();
    private static final String toggleButtonUI = MaterialToggleButtonUI.class.getCanonicalName();
    private static final String scrollBarUI = MaterialScrollBarUI.class.getCanonicalName();
    private static final String comboBoxUI = MaterialComboBoxUI.class.getCanonicalName();
    private static final String popupMenuUI = MaterialPopupMenuUI.class.getCanonicalName();
    private static final String toolbarUI = MaterialToolBarUI.class.getCanonicalName();
    private static final String sliderUI = MaterialSliderUI.class.getCanonicalName();
    private static final String progressBarUI = MaterialProgressBarUI.class.getCanonicalName();
    private static final String radioButtonMenuItemUI = MaterialRadioButtonMenuItemUI.class.getCanonicalName();
    private static final String checkBoxMenuItemUI = MaterialCheckBoxMenuItemUI.class.getCanonicalName();
    private static final String textPaneUI = MaterialTextPaneUI.class.getCanonicalName();
    private static final String editorPane = MaterialTextPaneUI.class.getCanonicalName();
    private static final String separatorUI = MaterialSeparatorUI.class.getCanonicalName();
    private static final String fileChooserUI = MaterialFileChooserUI.class.getCanonicalName();
    private static final String toolTipUI = MaterialToolTipUI.class.getCanonicalName();
    private static final String optionPaneUI = MaterialOptionPaneUI.class.getCanonicalName();
    private static final String formattedTextFieldUI = MaterialFormattedTextFieldUI.class.getCanonicalName();
    private static final String listUI = MaterialListUI.class.getCanonicalName();

    private BasicLookAndFeel basicLookAndFeel;

    public MaterialLookAndFeel() {
        try {
            basicLookAndFeel = new MetalLookAndFeel();
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        } catch (Exception ignore) {
            //do nothing
        }
    }

    @Override
    public String getName() {
        return "Material Look And Feel";
    }

    @Override
    public String getID() {
        return "MaterialLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "A modern Material Design UI for Java Swing";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        table.put("ButtonUI", buttonUI);
        table.put("TextFieldUI", textfieldUI);
        table.put("PasswordFieldUI", passwordFieldUI);
        table.put("ToggleButtonUI", toggleButtonUI);
        table.put("CheckBoxUI", checkBoxUI);
        table.put("RadioButtonUI", radioButtonUI);
        table.put("ComboBoxUI", comboBoxUI);
        table.put("TableUI", tableUI);
        table.put("TableHeaderUI", tableHeaderUI);
        table.put("TreeUI", treeUI);
        table.put("SpinnerUI", spinnerUI);
        table.put("PanelUI", panelUI);
        table.put("LabelUI", labelUI);
        table.put("MenuItemUI", menuItemUI);
        table.put("MenuBarUI", menuBarUI);
        table.put("MenuUI", menuUI);
        table.put("TabbedPaneUI", tabbedPaneUI);
        table.put("ScrollBarUI", scrollBarUI);
        table.put("PopupMenuUI", popupMenuUI);
        table.put("ToolBarUI", toolbarUI);
        table.put("SliderUI", sliderUI);
        table.put("ProgressBarUI", progressBarUI);
        table.put("RadioButtonMenuItemUI", radioButtonMenuItemUI);
        table.put("CheckBoxMenuItemUI", checkBoxMenuItemUI);
        table.put("TextPaneUI", textPaneUI);
        table.put("EditorPaneUI", editorPane);
        table.put("SeparatorUI", separatorUI);
        table.put("FileChooserUI", fileChooserUI);
        table.put("ToolTipUI", toolTipUI);
        table.put("OptionPaneUI", optionPaneUI);
        table.put("FormattedTextFieldUI", formattedTextFieldUI);
        table.put("ListUI", listUI);
    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        table.put("Button.highlight", MaterialColors.GREY_200);
        table.put("Button.opaque", true);
        table.put("Button.border", BorderFactory.createEmptyBorder(7, 17, 7, 17));
        table.put("Button.background", MaterialColors.GREY_200);
        table.put("Button.foreground", Color.BLACK);
        table.put("Button.font", MaterialFontRoboto.MEDIUM);
        table.put("Button.mouseHoverColor", MaterialColors.GREY_400);
        table.put("Button.mouseHoverEnable", true);
        table.put("Button.focusable", false);
        table.put("Button[focus].color", MaterialColors.GREY_600);
        table.put("Button.disabledText", MaterialColors.GREY_700);

        table.put("CheckBox.font", MaterialFontRoboto.REGULAR);
        table.put("CheckBox.background", Color.WHITE);
        table.put("CheckBox.foreground", Color.BLACK);
        table.put("CheckBox.icon", MaterialIcons.CHECK_BOX_OUTLINE_BLANK);
        table.put("CheckBox.selectedIcon", MaterialIcons.CHECK_BOX);

        table.put("ComboBox.font", MaterialFontRoboto.REGULAR);
        table.put("ComboBox.background", Color.WHITE);
        table.put("ComboBox.foreground", Color.BLACK);
        table.put("ComboBox.border", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        table.put("ComboBox.buttonBackground", MaterialColors.GREY_300);
        table.put("ComboBox.selectionBackground", MaterialColors.GREY_300);
        table.put("ComboBox.disabledBackground", MaterialColors.GREY_500);
        table.put("ComboBox.disabledForeground", MaterialColors.GREY_900);
        table.put("ComboBox.selectionForeground", MaterialColors.BLACK);
        table.put("ComboBox.selectedInDropDownBackground", MaterialColors.GREY_200);
        table.put("ComboBox.mouseHoverColor", MaterialColors.GREY_400);
        table.put("ComboBox.mouseHoverEnabled", true);

        table.put("Label.font", MaterialFontRoboto.REGULAR.deriveFont(16f));
        table.put("Label.background", Color.WHITE);
        table.put("Label.foreground", Color.BLACK);
        table.put("Label.border", BorderFactory.createEmptyBorder());

        table.put("Menu.font", MaterialFontRoboto.BOLD);
        table.put("Menu.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.put("Menu.background", Color.WHITE);
        table.put("Menu.foreground", Color.BLACK);
        table.put("Menu.opaque", true);
        table.put("Menu.selectionBackground", MaterialColors.GREY_200);
        table.put("Menu.selectionForeground", Color.BLACK);
        table.put("Menu.disabledForeground", new Color(0, 0, 0, 100));
        table.put("Menu.menuPopupOffsetY", 3);
        table.put("Menu[MouseOver].enable", true); //TODO testing
        //TODO refactoinh and using the convensioni Component[Action].ohYeah

        table.put("MenuBar.font", MaterialFontRoboto.BOLD);
        table.put("MenuBar.background", Color.WHITE);
        table.put("MenuBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("MenuBar.foreground", Color.BLACK);

        table.put("MenuItem.disabledForeground", new Color(0, 0, 0, 100));
        table.put("MenuItem.selectionBackground", MaterialColors.GREY_200);
        table.put("MenuItem.selectionForeground", Color.BLACK);
        table.put("MenuItem.font", MaterialFontRoboto.MEDIUM);
        table.put("MenuItem.background", Color.WHITE);
        table.put("MenuItem.foreground", Color.BLACK);
        table.put("MenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));

        table.put("OptionPane.background", Color.WHITE);
        table.put("OptionPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("OptionPane.font", MaterialFontRoboto.REGULAR);

        table.put("Panel.font", MaterialFontRoboto.REGULAR);
        table.put("Panel.background", Color.WHITE);
        table.put("Panel.border", BorderFactory.createEmptyBorder());

        table.put("PopupMenu.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("PopupMenu.background", Color.WHITE);
        table.put("PopupMenu.foreground", Color.BLACK);

        table.put("RadioButton.font", MaterialFontRoboto.REGULAR);
        table.put("RadioButton.background", Color.WHITE);
        table.put("RadioButton.foreground", Color.BLACK);
        table.put("RadioButton.icon", MaterialIcons.RADIO_BUTTON_UNCHECKED);
        table.put("RadioButton.selectedIcon", MaterialIcons.RADIO_BUTTON_CHECKED);

        table.put("Spinner.font", MaterialFontRoboto.REGULAR);
        table.put("Spinner.background", Color.WHITE);
        table.put("Spinner.foreground", Color.BLACK);
        table.put("Spinner.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Spinner.arrowButtonBackground", MaterialColors.GREY_200);
        table.put("Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder());
        table.put("Spinner.mouseHoverEnabled", true);
        table.put("Spinner.mouseHoverColor", MaterialColors.GREY_400);

        table.put("ScrollBar.font", MaterialFontRoboto.REGULAR);
        table.put("ScrollBar.barUnitIncrement", 15);
        table.put("ScrollBar.track", MaterialColors.GREY_200);
        table.put("ScrollBar.thumb", MaterialColors.GREY_500);
        table.put("ScrollBar.thumbDarkShadow", MaterialColors.GREY_500);
        table.put("ScrollBar.thumbHighlight", MaterialColors.GREY_500);
        table.put("ScrollBar.thumbShadow", MaterialColors.GREY_500);
        table.put("ScrollBar.arrowButtonBackground", MaterialColors.GREY_200);
        table.put("ScrollBar.enableArrow", true);
        table.put("ScrollBar.arrowButtonBorder", BorderFactory.createEmptyBorder());
        table.put("ScrollBar[MouseHover].enable", true);
        table.put("ScrollBar[MouseHover].color", MaterialColors.GREY_400);
        table.put("ScrollBar[OnClick].color", MaterialColors.GREY_500);

        table.put("ScrollPane.background", MaterialColors.WHITE);
        table.put("ScrollPane.border", BorderFactory.createEmptyBorder());
        table.put("ScrollPane.font", MaterialFontRoboto.REGULAR);

        table.put("Slider.font", MaterialFontRoboto.REGULAR);
        table.put("Slider.background", Color.WHITE);
        table.put("Slider.foreground", MaterialColors.LIGHTBLUE_400);
        table.put("Slider.trackColor", Color.BLACK);
        table.put("Slider.border", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        table.put("SplitPane.border", BorderFactory.createEmptyBorder());
        table.put("SplitPane.background", Color.WHITE);
        table.put("SplitPane.dividerSize", 5);
        table.put("SplitPaneDivider.border", BorderFactory.createEmptyBorder());

        table.put("TabbedPane.font", MaterialFontRoboto.REGULAR);
        table.put("TabbedPane.background", Color.WHITE);
        table.put("TabbedPane.foreground", Color.BLACK);
        table.put("TabbedPane.border", BorderFactory.createEmptyBorder());
        table.put("TabbedPane.shadow", null);
        table.put("TabbedPane.darkShadow", null);
        table.put("TabbedPane.highlight", MaterialColors.GREY_200);
        table.put("TabbedPane.borderHighlightColor", MaterialColors.GREY_300);

        table.put("Table.selectionBackground", MaterialColors.GREY_100);
        table.put("Table.selectionForeground", MaterialColors.BLACK);
        table.put("Table.background", MaterialColors.WHITE);
        table.put("Table.font", MaterialFontRoboto.REGULAR);
        table.put("Table.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Table.gridColor", MaterialColors.GREY_400);
        table.put("TableHeader.background", MaterialColors.GREY_200);
        table.put("TableHeader.font", MaterialFontRoboto.BOLD);
        table.put("TableHeader.cellBorder", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        table.put("TextArea.background", MaterialColors.GREY_200);
        table.put("TextArea.border", BorderFactory.createEmptyBorder());
        table.put("TextArea.foreground", Color.BLACK);

        table.put("TextField.inactiveForeground", MaterialColors.GREY_800);
        table.put("TextField.inactiveBackground", MaterialColors.GREY_200);
        table.put("TextField.selectionBackground", MaterialColors.LIGHTBLUE_400);
        table.put("TextField.selectionForeground", MaterialColors.BLACK);
        table.put("TextField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));
        table.put("TextField.focusInputMap", fieldInputMap); //install shortcut
        table.put("TextField.font", MaterialFontRoboto.MEDIUM.deriveFont(12f));

        table.put("PasswordField.inactiveForeground", MaterialColors.GREY_800);
        table.put("PasswordField.inactiveBackground", MaterialColors.GREY_200);
        table.put("PasswordField.selectionBackground", MaterialColors.LIGHTBLUE_400);
        table.put("PasswordField.selectionForeground", MaterialColors.BLACK);
        table.put("PasswordField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));
        table.put("PasswordField.focusInputMap", fieldInputMap); //install shortcut

        table.put("ToggleButton.border", BorderFactory.createEmptyBorder());
        table.put("ToggleButton.font", MaterialFontRoboto.REGULAR);
        table.put("ToggleButton.background", Color.WHITE);
        table.put("ToggleButton.foreground", Color.BLACK);
        table.put("ToggleButton.icon", new ImageIcon(MaterialImages.TOGGLE_BUTTON_OFF));
        table.put("ToggleButton.selectedIcon", new ImageIcon(MaterialImages.TOGGLE_BUTTON_ON));

        table.put("ToolBar.font", MaterialFontRoboto.REGULAR);
        table.put("ToolBar.background", Color.WHITE);
        table.put("ToolBar.foreground", Color.BLACK);
        table.put("ToolBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("ToolBar.dockingBackground", MaterialColors.LIGHTGREENA_100);
        table.put("ToolBar.floatingBackground", MaterialColors.GREY_200);

        table.put("Tree.font", MaterialFontRoboto.REGULAR);
        table.put("Tree.selectionForeground", Color.BLACK);
        table.put("Tree.foreground", Color.BLACK);
        table.put("Tree.selectionBackground", MaterialColors.GREY_200);
        table.put("Tree.background", Color.WHITE);
        table.put("Tree.closedIcon", MaterialIcons.ARROW_DROP_RIGHT);
        table.put("Tree.openIcon", MaterialIcons.ARROW_DROP_DOWN.deriveIcon(18f));
        table.put("Tree.selectionBorderColor", null);

        table.put("RadioButtonMenuItem.foreground", Color.BLACK);
        table.put("RadioButtonMenuItem.selectionForeground", Color.BLACK);
        //If it changes the background of the menuitem it must change this too, irrespective of its setting
        table.put("RadioButtonMenuItem.background", UIManager.getColor("MenuItem.background"));
        table.put("RadioButtonMenuItem.selectionBackground", MaterialColors.GREY_200);
        table.put("RadioButtonMenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));
        table.put("RadioButtonMenuItem.checkIcon", MaterialIcons.RADIO_BUTTON_UNCHECKED);
        table.put("RadioButtonMenuItem.selectedCheckIcon", MaterialIcons.RADIO_BUTTON_CHECKED);

        //If it changes the background of the menuitem it must change this too, irrespective of its setting
        table.put("CheckBoxMenuItem.background", UIManager.getColor("MenuItem.background"));
        table.put("CheckBoxMenuItem.selectionBackground", MaterialColors.GREY_200);
        table.put("CheckBoxMenuItem.foreground", Color.BLACK);
        table.put("CheckBoxMenuItem.selectionForeground", Color.BLACK);
        table.put("CheckBoxMenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));
        table.put("CheckBoxMenuItem.checkIcon", MaterialIcons.CHECK_BOX_OUTLINE_BLANK);
        table.put("CheckBoxMenuItem.selectedCheckIcon", MaterialIcons.CHECK_BOX);

        table.put("TextPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("TextPane.background", MaterialColors.GREY_50);
        table.put("TextPane.selectionBackground", MaterialColors.LIGHTBLUE_200);
        table.put("TextPane.inactiveForeground", MaterialColors.GREY_500);
        table.put("TextPane.font", MaterialFontRoboto.REGULAR);

        table.put("EditorPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("EditorPane.background", MaterialColors.GREY_50);
        table.put("EditorPane.selectionBackground", MaterialColors.LIGHTBLUE_200);
        table.put("EditorPane.inactiveForeground", MaterialColors.GREY_500);
        table.put("EditorPane.font", MaterialFontRoboto.REGULAR);

        table.put("Separator.background", MaterialColors.GREY_300);
        table.put("Separator.foreground", MaterialColors.GREY_300);

        table.put("ToolTip.background", MaterialColors.GREY_500);
        table.put("ToolTip.foreground", MaterialColors.WHITE);
        table.put("ToolTip.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));

        table.put("ColorChooser.background ", MaterialColors.WHITE);
        table.put("ColorChooser.foreground ", MaterialColors.BLACK);

        table.put("TitledBorder.font", MaterialFontRoboto.REGULAR);

        table.put("TaskPane.font", MaterialFontRoboto.MEDIUM);
        table.put("TaskPane.titleBackgroundGradientStart", MaterialColors.GREY_300);
        table.put("TaskPane.titleBackgroundGradientEnd", MaterialColors.GREY_500);
        table.put("TaskPane.titleOver", MaterialColors.LIGHTBLUE_500);
        table.put("TaskPane.specialTitleOver", MaterialColors.LIGHTBLUE_500);
        table.put("TaskPane.background", MaterialColors.LIGHTBLUE_500);
        table.put("TaskPane.foreground", MaterialColors.BLACK);
        table.put("TaskPane.borderColor", MaterialColors.LIGHTBLUE_500);
        table.put("TaskPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("TaskPane.contentBackground", MaterialColors.GREY_50);
        table.put("TaskPane.yesCollassed", MaterialIcons.EXPAND_MORE);
        table.put("TaskPane.noCollassed", MaterialIcons.EXPAND_LESS);

        table.put("OptionPaneUI.warningIcon", new ImageIcon(MaterialImages.WARNING));
        table.put("OptionPaneUI.errorIcon", new ImageIcon(MaterialImages.ERROR));
        table.put("OptionPaneUI.questionIcon", new ImageIcon(MaterialImages.QUESTION));
        table.put("OptionPaneUI.informationIcon", new ImageIcon(MaterialImages.INFORMATION));

        table.put("FormattedTextField.inactiveForeground", MaterialColors.GREY_800);
        table.put("FormattedTextField.inactiveBackground", MaterialColors.GREY_200);
        table.put("FormattedTextField.selectionBackground", MaterialColors.LIGHTBLUE_400);
        table.put("FormattedTextField.selectionForeground", Color.BLACK);
        table.put("FormattedTextField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));

        table.put("List.background", MaterialColors.WHITE);
        table.put("List.foreground", MaterialColors.BLACK);
        table.put("List.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("List.font", MaterialFontRoboto.MEDIUM);
        table.put("List.selectionBackground", MaterialColors.GREY_400);
        table.put("List.selectionForeground", MaterialColors.BLACK);
        table.put("List.focusable", true);
    }

    @Override
    public UIDefaults getDefaults() {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod("getDefaults");
            superMethod.setAccessible(true);
            final UIDefaults defaults = (UIDefaults) superMethod.invoke(basicLookAndFeel);
            initClassDefaults(defaults);
            initComponentDefaults(defaults);
            defaults.put("OptionPane.warningIcon", new ImageIcon(MaterialImages.WARNING));
            defaults.put("OptionPane.errorIcon", new ImageIcon(MaterialImages.ERROR));
            defaults.put("OptionPane.questionIcon", new ImageIcon(MaterialImages.QUESTION));
            defaults.put("OptionPane.informationIcon", new ImageIcon(MaterialImages.INFORMATION));
            return defaults;
        } catch (Exception ignore) {
        }
        return super.getDefaults();
    }

    /*Shortcut for filed input*/
    Object fieldInputMap = new UIDefaults.LazyInputMap(new Object[]{
        "ctrl C", DefaultEditorKit.copyAction,
        "ctrl V", DefaultEditorKit.pasteAction,
        "ctrl X", DefaultEditorKit.cutAction,
        "COPY", DefaultEditorKit.copyAction,
        "PASTE", DefaultEditorKit.pasteAction,
        "CUT", DefaultEditorKit.cutAction,
        "control INSERT", DefaultEditorKit.copyAction,
        "shift INSERT", DefaultEditorKit.pasteAction,
        "shift DELETE", DefaultEditorKit.cutAction,
        "shift LEFT", DefaultEditorKit.selectionBackwardAction,
        "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
        "shift RIGHT", DefaultEditorKit.selectionForwardAction,
        "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
        "ctrl LEFT", DefaultEditorKit.previousWordAction,
        "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
        "ctrl RIGHT", DefaultEditorKit.nextWordAction,
        "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
        "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
        "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
        "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
        "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
        "ctrl A", DefaultEditorKit.selectAllAction,
        "HOME", DefaultEditorKit.beginLineAction,
        "END", DefaultEditorKit.endLineAction,
        "shift HOME", DefaultEditorKit.selectionBeginLineAction,
        "shift END", DefaultEditorKit.selectionEndLineAction,
        "BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
        "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
        "ctrl H", DefaultEditorKit.deletePrevCharAction,
        "DELETE", DefaultEditorKit.deleteNextCharAction,
        "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
        "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction,
        "RIGHT", DefaultEditorKit.forwardAction,
        "LEFT", DefaultEditorKit.backwardAction,
        "KP_RIGHT", DefaultEditorKit.forwardAction,
        "KP_LEFT", DefaultEditorKit.backwardAction,
        "ENTER", JTextField.notifyAction,
        "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
        "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/});


    /*Shortcut for multiline input*/
    Object multilineInputMap = new UIDefaults.LazyInputMap(new Object[]{
        "ctrl C", DefaultEditorKit.copyAction,
        "ctrl V", DefaultEditorKit.pasteAction,
        "ctrl X", DefaultEditorKit.cutAction,
        "COPY", DefaultEditorKit.copyAction,
        "PASTE", DefaultEditorKit.pasteAction,
        "CUT", DefaultEditorKit.cutAction,
        "control INSERT", DefaultEditorKit.copyAction,
        "shift INSERT", DefaultEditorKit.pasteAction,
        "shift DELETE", DefaultEditorKit.cutAction,
        "shift LEFT", DefaultEditorKit.selectionBackwardAction,
        "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
        "shift RIGHT", DefaultEditorKit.selectionForwardAction,
        "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
        "ctrl LEFT", DefaultEditorKit.previousWordAction,
        "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
        "ctrl RIGHT", DefaultEditorKit.nextWordAction,
        "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
        "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
        "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
        "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
        "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
        "ctrl A", DefaultEditorKit.selectAllAction,
        "HOME", DefaultEditorKit.beginLineAction,
        "END", DefaultEditorKit.endLineAction,
        "shift HOME", DefaultEditorKit.selectionBeginLineAction,
        "shift END", DefaultEditorKit.selectionEndLineAction,
        "UP", DefaultEditorKit.upAction,
        "KP_UP", DefaultEditorKit.upAction,
        "DOWN", DefaultEditorKit.downAction,
        "KP_DOWN", DefaultEditorKit.downAction,
        "PAGE_UP", DefaultEditorKit.pageUpAction,
        "PAGE_DOWN", DefaultEditorKit.pageDownAction,
        "shift PAGE_UP", "selection-page-up",
        "shift PAGE_DOWN", "selection-page-down",
        "ctrl shift PAGE_UP", "selection-page-left",
        "ctrl shift PAGE_DOWN", "selection-page-right",
        "shift UP", DefaultEditorKit.selectionUpAction,
        "shift KP_UP", DefaultEditorKit.selectionUpAction,
        "shift DOWN", DefaultEditorKit.selectionDownAction,
        "shift KP_DOWN", DefaultEditorKit.selectionDownAction,
        "ENTER", DefaultEditorKit.insertBreakAction,
        "BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
        "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
        "ctrl H", DefaultEditorKit.deletePrevCharAction,
        "DELETE", DefaultEditorKit.deleteNextCharAction,
        "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
        "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction,
        "RIGHT", DefaultEditorKit.forwardAction,
        "LEFT", DefaultEditorKit.backwardAction,
        "KP_RIGHT", DefaultEditorKit.forwardAction,
        "KP_LEFT", DefaultEditorKit.backwardAction,
        "TAB", DefaultEditorKit.insertTabAction,
        "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
        "ctrl HOME", DefaultEditorKit.beginAction,
        "ctrl END", DefaultEditorKit.endAction,
        "ctrl shift HOME", DefaultEditorKit.selectionBeginAction,
        "ctrl shift END", DefaultEditorKit.selectionEndAction,
        "ctrl T", "next-link-action",
        "ctrl shift T", "previous-link-action",
        "ctrl SPACE", "activate-link-action",
        "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/});
}
