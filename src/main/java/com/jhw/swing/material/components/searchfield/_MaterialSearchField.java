package com.jhw.swing.material.components.searchfield;

import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.container.panel.prepared._MaterialPanelComponent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import org.jdesktop.swingx.JXTextField;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialSearchField extends _MaterialPanel {

    private ActionListener searchAction = new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            System.out.println("Accion buscar no implementada.");
        }
    };

    private int maxLength = 50;

    public _MaterialSearchField() {
        initComponents();
        addListeners();
        personalize();
    }

    private void initComponents() {
        buttonSearch = new com.jhw.swing.material.components.button._MaterialButtonIconTransparent();
        searchField = new org.jdesktop.swingx.JXTextField();

        this.setLayout(new BorderLayout());

        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP,
                MaterialShadow.OFFSET_LEFT + 10,
                MaterialShadow.OFFSET_BOTTOM,
                MaterialShadow.OFFSET_RIGHT + 3));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorderRadius(12);

        buttonSearch.setPreferredSize(new Dimension(26, 26));
        searchField.setPrompt("Buscar...");
        this.add(searchField);
        this.add(buttonSearch, BorderLayout.EAST);
    }

    // Variables declaration - do not modify//
    private com.jhw.swing.material.components.button._MaterialButtonIconTransparent buttonSearch;
    private org.jdesktop.swingx.JXTextField searchField;
    // End of variables declaration                   

    private void personalize() {
        buttonSearch.setIcon(MaterialIcons.SEARCH.deriveIcon(getForeground()).deriveIcon(20f));
        searchField.setBorder(null);
        searchField.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        searchField.setForeground(getForeground());
    }

    private void addListeners() {
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                onSearchFieldKeyTyped(e);
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onSearchFieldKeyReleased(evt);
            }
        });

        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAction.actionPerformed(null);
            }
        });
    }

    private void onSearchFieldKeyTyped(KeyEvent e) {
        validateLength(e);
    }

    private void onSearchFieldKeyReleased(KeyEvent evt) {
        clear(evt);
    }

    private void validateLength(KeyEvent evt) {
        if (getText().length() + 1 > maxLength) {
            Utils.beep();
            evt.consume();
        }
    }

    public void setHint(String hint) {
        searchField.setPrompt(hint);
    }

    public String getHint() {
        return searchField.getPrompt();
    }

    public void clear(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            searchField.setText("");
        }
        searchAction.actionPerformed(null);
        searchField.requestFocusInWindow();
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setSearchActionListener(ActionListener searchAction) {
        this.searchAction = searchAction;
        this.searchAction.actionPerformed(null);//activa la accion de busqueda
    }

    public String getText() {
        return searchField.getText();
    }

    public ActionListener getSearchAction() {
        return searchAction;
    }

    public _MaterialButtonIconTransparent getButtonSearch() {
        return buttonSearch;
    }

    public JXTextField getSearchField() {
        return searchField;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.searchField.setEnabled(enabled);
        this.buttonSearch.setEnabled(enabled);
        super.setEnabled(enabled);
    }
}
