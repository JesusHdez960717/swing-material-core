package com.root101.swing.material.components.combobox.filtrable_utils;

import com.root101.swing.util.HtmlHighlighter;
import javax.swing.*;
import java.awt.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CustomComboRenderer<T> extends DefaultListCellRenderer {

    public static final Color background = UIManager.getColor("List.background");
    private static final Color defaultBackground = UIManager.getColor("List.background");
    private static final Color defaultForeground = UIManager.getColor("List.foreground");
    private Supplier<String> highlightTextSupplier;
    private Function<T, String> comboDisplayTextMapper;

    public CustomComboRenderer(Supplier<String> highlightTextSupplier, Function<T, String> comboDisplayTextMapper) {
        this.highlightTextSupplier = highlightTextSupplier;
        this.comboDisplayTextMapper = comboDisplayTextMapper;
    }

    public static <T> CustomComboRenderer build(Supplier<String> highlightTextSupplier, Function<T, String> comboDisplayTextMapper) {
        return new CustomComboRenderer(highlightTextSupplier, comboDisplayTextMapper);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        T obj = (T) value;
        if (obj == null) {
            return this;
        }
        String text = comboDisplayTextMapper.apply(obj);
        text = HtmlHighlighter.highlightText(text, highlightTextSupplier.get());
        this.setText(text);
        if (!isSelected) {
            this.setBackground(index % 2 == 0 ? background : defaultBackground);
        }
        this.setForeground(defaultForeground);
        return this;
    }

}
