package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.DefaultFloatingLabel;
import java.awt.*;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.utils.icons.DerivableIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.jhw.swing.util.interfaces.Wrong;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;

/**
 * A Material Design combo box.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html#buttons-dropdown-buttons">Dropdown
 * buttons (Google design guidelines)</a>
 */
public class _MaterialComboBox<T> extends JComboBox<T> implements Line, FloatingLabel, BindableComponent<T>, Wrong, MaterialComponent {

    public static _MaterialComboBox from() {
        return new _MaterialComboBox();
    }

    private FloatingLabel floatingLabel;
    private Line line = new DefaultLine(this);

    //default
    private Color foreground = MaterialColors.BLACK;

    private ImageIcon icon = MaterialIcons.ARROW_DROP_DOWN;

    //flags for wrong
    private Color wrongColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_WRONG);
    private String wrongText = "Error en este campo";
    private boolean wrongFlag = false;

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

        this.setOpaque(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setHint("Select...");
        this.setModel(new javax.swing.DefaultComboBoxModel(new String[]{}));
        this.setSelectedIndex(-1);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearWrong();
            }
        });
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
//-------------------FLOATING_LABEL-------------------------

    /**
     * Get the wrong color. The worng color is the color of the component when
     * is wrong.
     *
     * @return the wrong color
     */
    public Color getWrongColor() {
        return wrongColor;
    }

    /**
     * Set the wrong color. The worng color is the color of the component when
     * is wrong.
     *
     * @param wrongColor the wrong color
     */
    public void setWrongColor(Color wrongColor) {
        this.wrongColor = wrongColor;
    }

    /**
     * Get the wrong text. The worng text is the text to display with the
     * explanaition of the error.
     *
     * @return the wrong color
     */
    public String getWrongText() {
        return wrongText;
    }

    /**
     * Set the wrong text. The worng text is the text to display with the
     * explanaition of the error.
     *
     * @param wrongText the wrong text
     */
    public void setWrongText(String wrongText) {
        this.wrongText = wrongText;
    }

    @Override
    public void wrong() {
        setAccentFloatingLabel(wrongColor);
        this.wrongFlag = true;
    }

    @Override
    public void wrong(String wrongText) {
        this.wrongText = wrongText;
        wrong();
    }

    public void clearWrong() {
        if (wrongFlag) {
            this.wrongFlag = false;
            this.setForeground(foreground);
            //setAccentFloatingLabel(accentColor);
        }
    }

    /**
     * Set the real color of the foreground. The color of the foreground when
     * the text field it's not wrong.
     *
     * @param fg the {@code "Color"} that should be used for the real color of
     * the foreground.
     */
    public void setRealForeground(Color fg) {
        this.foreground = fg;
        setForeground(foreground);
    }

    /**
     * get the real color of the foreground. The color of the foreground when
     * the text field it's not wrong.
     *
     * @return the {@code "Color"} that should be used for the real color of the
     * foreground.
     */
    public Color getRealForeground() {
        return this.foreground;
    }

    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        firePropertyChange("processFocusEvent", null, null);
    }

    protected ImageIcon getIcon() {
        return icon;
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
            g2.setColor(getForeground());
            g2.drawString(getSelectedItem().toString(), 0, metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }
        paintLine(g2);
        
        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getWrongColor());
            g2.setFont(getFont().deriveFont(getFont().getSize2D() * 0.8f).deriveFont(Font.BOLD));//1 for bold
            g2.drawString(getWrongText(), 0, getYLine(g2) + 15);//paint the wrong text
        }

        //paint the arrow
        if (icon != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = getAccentFloatingLabel();
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            if (icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(iconColor);
            }
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - icon.getIconHeight()), yMid - icon.getIconHeight() / 2);
        }

    }

    public boolean isWrongFlag() {
        return wrongFlag;
    }

    @Override
    public Color getForeground() {
        return foreground;
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
    }

    public static class FieldRenderer<T> extends JComponent implements ListCellRenderer<T> {

        private final _MaterialComboBox comboBox;
        private String text;
        private boolean mouseOver = false;
        private boolean selected = false;

        public FieldRenderer(_MaterialComboBox comboBox) {
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
            super.paint(g);
            Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

            if (mouseOver) {
                g.setColor(Utils.isDark(comboBox.getBackground()) ? Utils.brighten(comboBox.getBackground()) : Utils.darken(comboBox.getBackground()));
            } else {
                g.setColor(comboBox.getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setFont(comboBox.getFont());
            if (selected) {
                g2.setColor(comboBox.getAccentFloatingLabel());
            } else {
                g2.setColor(comboBox.getForeground());
            }
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            g.drawString(text, 24, metrics.getAscent() + (getHeight() - metrics.getHeight()) / 2);
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
            JScrollPane scroller = new _MaterialScrollPaneCore();
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
