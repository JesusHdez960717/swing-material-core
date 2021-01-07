package com.root101.swing.TEST.search;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import com.root101.swing.material.components.searchfield._MaterialSearchField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import org.jdesktop.swingx.JXCollapsiblePane;
import com.root101.swing.material.standards.MaterialColors;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralSearch extends _PanelTransparent {

    private boolean shrinked = true;
    private final JXCollapsiblePane collapse = new JXCollapsiblePane();

    public GeneralSearch() {
        initComponents();
        personalize();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(collapse, BorderLayout.CENTER);

        this.collapse.setLayout(new BorderLayout());
        this.searchField = new _MaterialSearchField();
        this.collapse.add(searchField, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(20, 20));
        this.setMaximumSize(new Dimension(300, 100));
    }
    private _MaterialSearchField searchField;

    private final FocusListener focusListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            setShrinked(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
            setShrinked(true);
        }
    };

    private void personalize() {
        this.collapse.setDirection(JXCollapsiblePane.Direction.LEFT);
        this.collapse.getContentPane().setBackground(MaterialColors.TRANSPARENT);
        searchField.getSearchField().addFocusListener(focusListener);
        searchField.getButtonSearch().addFocusListener(focusListener);
    }

    public void setShrinked(boolean shrink) {
        this.shrinked = shrink;
        this.collapse.setCollapsed(this.shrinked);
    }

}
