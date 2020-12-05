package com.jhw.swing.material.components.searchfield;

import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import org.jdesktop.swingx.JXTextField;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialSearchField extends MaterialSearchField {

    public static int SEARCH_ACTION_AFTER = 2 * 1000;

    private final Timer timer = new Timer(SEARCH_ACTION_AFTER, (ActionEvent e) -> {
        doAction();
    });

    public static MaterialSearchField from() {
        return new _MaterialSearchField();
    }

    private ActionListener searchAction = (java.awt.event.ActionEvent evt) -> {
        System.out.println("Accion buscar no implementada.");
    };

    private int maxLength = 50;

    public _MaterialSearchField() {
        initComponents();
        addListeners();
        personalize();
    }

    private void initComponents() {
        buttonSearch = MaterialButtonsFactory.buildIconTransparent();
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
    private MaterialButtonIcon buttonSearch;
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

        buttonSearch.addActionListener((java.awt.event.ActionEvent evt) -> {
            searchAction.actionPerformed(evt);
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

    @Override
    public void setHint(String hint) {
        searchField.setPrompt(hint);
    }

    @Override
    public String getHint() {
        return searchField.getPrompt();
    }

    @Override
    public void clear(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            searchField.setText("");
            doAction();
        } else if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            doAction();
        } else {//espera SEARCH_ACTION_AFTER(2sec) para actualizar
            doDelayAction();
        }
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void setSearchActionListener(ActionListener searchAction) {
        this.searchAction = searchAction;
        doAction();
    }

    @Override
    public String getText() {
        return searchField.getText();
    }

    @Override
    public ActionListener getSearchAction() {
        return searchAction;
    }

    @Override
    public MaterialButtonIcon getButtonSearch() {
        return buttonSearch;
    }

    @Override
    public JXTextField getSearchField() {
        return searchField;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.searchField.setEnabled(enabled);
        this.buttonSearch.setEnabled(enabled);
        super.setEnabled(enabled);
    }

    private void doAction() {
        this.searchAction.actionPerformed(null);
        searchField.requestFocusInWindow();
        stopDelayAction();
    }

    private void doDelayAction() {
        timer.restart();
        timer.start();
    }

    private void stopDelayAction() {
        timer.stop();
    }
}
