package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.components.scrollpane.MaterialScrollFactory;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.DefaultFloatingLabel;
import java.awt.*;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.effects.DefaultWrong;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.derivable_icons.DerivableIcon;
import java.awt.event.ActionEvent;
import com.jhw.swing.material.effects.Wrong;
import static com.jhw.swing.material.standards.Utils.*;
import java.util.ArrayList;

/**
 * A Material Design combo box.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html#buttons-dropdown-buttons">Dropdown
 * buttons (Google design guidelines)</a>
 */
public class _MaterialComboBox<T> extends MaterialComboBox<T> {

    public static MaterialComboBox from() {
        return new _MaterialComboBox();
    }

    private FloatingLabel floatingLabel;//no se puede iniciar aqui xq da null pionter con el foreground
    private Line line = new DefaultLine(this);
    private final Wrong wrong = new DefaultWrong(this);

    private ImageIcon iconArrow = MaterialIcons.ARROW_DROP_DOWN;

    public _MaterialComboBox() {
        floatingLabel = new DefaultFloatingLabel(this);

        this.setPreferredSize(new Dimension(145, 65));
        this.setRenderer(new FieldRenderer<>(this));
        this.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popupAct = new Popup(comboBox);
                popupAct.getAccessibleContext().setAccessibleParent(comboBox);
                return popupAct;
            }

            @Override
            protected JButton createArrowButton() {
                return null;
            }
        });

        this.addActionListener((ActionEvent e) -> {
            clearWrong();
        });

        this.setOpaque(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setHint("Select...");

        this.setModel(new ArrayList<>());
    }

    @Override
    public void setModel(java.util.List<T> aModel) {
        super.setModel(new DefaultComboBoxModel(aModel.toArray(new Object[aModel.size()])));
        this.setSelectedIndex(-1);
    }

    @Override
    public void addElement(T element) {
        ((DefaultComboBoxModel<T>) getModel()).addElement(element);
    }
//-------------------LINE-------------------------

    @Override
    public void paintLine(Graphics g2) {
        line.paintLine(g2);
    }

    @Override
    public int getYLine(Graphics g2) {
        return line.getYLine(g2);
    }
//-------------------FLOATING_LABEL-------------------------

    @Override
    public Color getAccentFloatingLabel() {
        return floatingLabel.getAccentFloatingLabel();
    }

    @Override
    public void setAccentFloatingLabel(Color accentColor) {
        floatingLabel.setAccentFloatingLabel(accentColor);
    }

    @Override
    public String getLabel() {
        return floatingLabel.getLabel();
    }

    @Override
    public void setLabel(String label) {
        floatingLabel.setLabel(label);
    }

    @Override
    public String getHint() {
        return floatingLabel.getHint();
    }

    @Override
    public void setHint(String hint) {
        floatingLabel.setHint(hint);
    }

    @Override
    public void paintLabel(Graphics g) {
        floatingLabel.paintLabel(g);
    }

    @Override
    public void paintHint(Graphics g) {
        floatingLabel.paintHint(g);
    }
//-------------------WRONG-------------------------

    @Override
    public void wrong() {
        wrong.wrong();
    }

    @Override
    public void wrong(String wrongText) {
        wrong.wrong(wrongText);
    }

    @Override
    public Color getWrongColor() {
        return wrong.getWrongColor();
    }

    @Override
    public void setWrongColor(Color wrongColor) {
        wrong.setWrongColor(wrongColor);
    }

    @Override
    public void clearWrong() {
        wrong.clearWrong();
    }

    @Override
    public void paintWrong(Graphics g2, int y) {
        wrong.paintWrong(g2, y);
    }

//-------------------WRONG-------------------------
    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        firePropertyChange("processFocusEvent", null, null);
    }

    protected ImageIcon getIconArrow() {
        return iconArrow;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int yMid = getSize().height / 2;

        paintLabel(g2);

        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        g2.setFont(getFont());
        if (getSelectedItem() == null && isFocusOwner()) {
            paintHint(g2);
        } else if (getSelectedItem() != null) {
            if (isEnabled()) {
                g2.setColor(getForeground());
            } else {
                g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            }
            g2.drawString(getSelectedItem().toString(), 0, metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }
        paintLine(g2);

        paintWrong(g2, getYLine(g2) + 15);

        //paint the arrow
        if (iconArrow != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccentFloatingLabel();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            if (iconArrow instanceof DerivableIcon) {
                iconArrow = ((DerivableIcon) iconArrow).deriveIcon(iconColor);
            }
            iconArrow.paintIcon(this, g2, (int) (this.getSize().getWidth() - iconArrow.getIconHeight()), yMid - iconArrow.getIconHeight() / 2);
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public T getObject() {
        return (T) getSelectedItem();
    }

    @Override
    public void setObject(T object) {
        setSelectedItem(object);
        firePropertyChange("text", null, null);//hacer un fire para que el floating label se entere que algo cambio y se tiene que actualizar
    }

    public static class FieldRenderer<T> extends JComponent implements ListCellRenderer<T> {

        private final MaterialComboBox comboBox;
        private String text;
        private boolean mouseOver = false;
        private boolean selected = false;

        public FieldRenderer(MaterialComboBox comboBox) {
            this.comboBox = comboBox;
        }

        @Override
        public Component getListCellRendererComponent(JList jList, Object o, int index, boolean isSelected, boolean cellHasFocus) {
            text = o != null ? o.toString() : "";
            setSize(jList.getWidth(), 56);
            setPreferredSize(new Dimension(jList.getWidth(), 32));
            setOpaque(true);
            mouseOver = isSelected;
            selected = comboBox.getSelectedIndex() == index;
            return this;
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
            super.paint(g2);

            if (mouseOver) {
                g2.setColor(Utils.isDark(comboBox.getBackground()) ? Utils.brighten(comboBox.getBackground()) : Utils.darken(comboBox.getBackground()));
            } else {
                g2.setColor(comboBox.getBackground());
            }
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setFont(comboBox.getFont());
            if (selected) {
                g2.setColor(comboBox.getAccentFloatingLabel());
            } else {
                g2.setColor(comboBox.getForeground());
            }
            FontMetrics metrics = g2.getFontMetrics(g2.getFont());
            g2.drawString(text, 24, metrics.getAscent() + (getHeight() - metrics.getHeight()) / 2);
        }
    }

    public static class Popup extends BasicComboPopup {

        public Popup(JComboBox combo) {
            super(combo);
            setBackground(combo.getBackground());
            setOpaque(true);
            setBorderPainted(true);
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroller = MaterialScrollFactory.buildPane();
            scroller.setViewportView(super.getList());
            return scroller;
        }

        @Override
        protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
            FontMetrics metrics = Utils.fontMetrics(super.comboBox.getFont());
            int yMid = super.comboBox.getSize().height / 2;
            int yLine = yMid + metrics.getAscent() / 2 + 5;
            return super.computePopupBounds(px, py - comboBox.getHeight() + yLine + 3,
                    (int) Math.max(comboBox.getPreferredSize().getWidth(), pw), ph);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(MaterialDrawingUtils.getAliasedGraphics(g));
        }
    }

}
