package com.root101.swing.material.components.combobox.filtrable_utils;

import com.root101.swing.material.components.combobox._MaterialComboBoxFiltrable;
import com.root101.utils.interfaces.Formateable;
import com.root101.utils.interfaces.Filtrable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ComboBoxFilterDecorator<T> {

    private JComboBox<T> comboBox;
    private BiPredicate<T, String> filter;
    private Function<T, String> format;
    private List<T> originalItems;
    private Object selectedItem;
    private FilterEditor filterEditor;

    public ComboBoxFilterDecorator(JComboBox<T> comboBox,
            BiPredicate<T, String> userFilter,
            Function<T, String> comboDisplayTextMapper) {
        this.comboBox = comboBox;
        this.filter = userFilter;
        this.format = comboDisplayTextMapper;
    }

    public static <T> ComboBoxFilterDecorator<T> decorate(JComboBox<T> comboBox) {
        BiPredicate<T, String> filter = (object, text) -> {
            if (object == null) {
                return false;
            } else if (object instanceof Filtrable) {
                return ((Filtrable) object).test(text);
            } else {
                return object.toString().toLowerCase().contains(text.toLowerCase());
            }
        };
        Function<T, String> formater = (object) -> {
            if (object == null) {
                return "";
            } else if (object instanceof Formateable) {
                return ((Formateable) object).format();
            } else {
                return object.toString();
            }
        };

        ComboBoxFilterDecorator decorator
                = new ComboBoxFilterDecorator(comboBox, filter,
                        formater);
        decorator.init();
        return decorator;
    }

    public static <T> ComboBoxFilterDecorator<T> decorate(JComboBox<T> comboBox,
            Function<T, String> comboDisplayTextMapper,
            BiPredicate<T, String> userFilter) {
        ComboBoxFilterDecorator decorator
                = new ComboBoxFilterDecorator(comboBox, userFilter,
                        comboDisplayTextMapper);
        decorator.init();
        return decorator;
    }

    private void init() {
        prepareComboFiltering();
        initComboPopupListener();
        initComboKeyListener();
    }

    public BiPredicate<T, String> getFilter() {
        return filter;
    }

    public Function<T, String> getFormat() {
        return format;
    }

    private void prepareComboFiltering() {
        DefaultComboBoxModel<T> model = (DefaultComboBoxModel<T>) comboBox.getModel();
        this.originalItems = new ArrayList<>(model.getSize());
        for (int i = 0; i < model.getSize(); i++) {
            this.originalItems.add(model.getElementAt(i));
        }
        filterEditor = new FilterEditor(format, new Consumer<Boolean>() {
            //editing mode (commit/cancel) change listener
            @Override
            public void accept(Boolean aBoolean) {
                if (aBoolean) {//commit
                    selectedItem = comboBox.getSelectedItem();
                } else {//rollback to the last one
                    comboBox.setSelectedItem(selectedItem);
                    filterEditor.setItem(selectedItem);
                }
            }
        });
        JLabel filterLabel = filterEditor.getFilterLabel();
        filterLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (comboBox instanceof _MaterialComboBoxFiltrable) {
                    ((_MaterialComboBoxFiltrable) comboBox).processExternalFocusEvent(true, e);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (comboBox instanceof _MaterialComboBoxFiltrable) {
                    ((_MaterialComboBoxFiltrable) comboBox).processExternalFocusEvent(false, e);
                }
                resetFilterComponent();
            }
        });
        comboBox.setEditor(filterEditor);
        comboBox.setEditable(true);
    }

    private void initComboKeyListener() {
        filterEditor.getFilterLabel().addKeyListener(
                new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (!Character.isDefined(keyChar)) {
                    return;
                }
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_DELETE:
                        return;
                    case KeyEvent.VK_ENTER:
                        selectedItem = comboBox.getSelectedItem();
                        resetFilterComponent();
                        return;
                    case KeyEvent.VK_ESCAPE:
                        resetFilterComponent();
                        return;
                    case KeyEvent.VK_BACK_SPACE:
                        filterEditor.removeCharAtEnd();
                        break;
                    default:
                        filterEditor.addChar(keyChar);
                }
                if (!comboBox.isPopupVisible()) {
                    comboBox.showPopup();
                }
                if (filterEditor.isEditing()
                        && filterEditor.getText().length() > 0) {
                    applyFilter();
                } else {
                    comboBox.hidePopup();
                    resetFilterComponent();
                }
            }
        }
        );
    }

    public Supplier<String> getFilterTextSupplier() {
        return () -> {
            if (filterEditor.isEditing()) {
                return filterEditor.getFilterLabel().getText();
            }
            return "";
        };
    }

    private void initComboPopupListener() {
        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                resetFilterComponent();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                resetFilterComponent();
            }
        });
    }

    private void resetFilterComponent() {
        if (!filterEditor.isEditing()) {
            return;
        }
        //restore original order
        DefaultComboBoxModel<T> model = (DefaultComboBoxModel<T>) comboBox.getModel();
        model.removeAllElements();
        for (T item : originalItems) {
            model.addElement(item);
        }
        filterEditor.reset();
    }

    private void applyFilter() {
        DefaultComboBoxModel<T> model = (DefaultComboBoxModel<T>) comboBox.getModel();
        model.removeAllElements();
        java.util.List<T> filteredItems = new ArrayList<>();
        //add matched items at top
        for (T item : originalItems) {
            if (filter.test(item,
                    filterEditor.getFilterLabel().getText())) {
                model.addElement(item);
            } else {
                filteredItems.add(item);
            }
        }
        //red color when no match
        filterEditor.getFilterLabel()
                .setForeground(model.getSize() == 0
                        ? Color.red
                        : UIManager.getColor("Label.foreground"));
        //add unmatched items
        filteredItems.forEach(model::addElement);
    }
}
