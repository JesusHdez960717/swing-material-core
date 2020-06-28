package com.jhw.swing.material.components.combobox;

import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.effects.Line;
import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import static com.jhw.swing.material.components.textfield._MaterialTextField.LINE_OPACITY_MASK;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.FloatingLabelStandar;
import java.awt.*;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.icons.DerivableIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * A Material Design combo box.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html#buttons-dropdown-buttons">Dropdown
 * buttons (Google design guidelines)</a>
 */
public class _MaterialComboBox<T> extends JComboBox<T> implements MaterialComponent, FloatingLabelStandar {

    private FloatingLabel floatingLabel;
    private Line line = new Line(this);
    private String label = "label";
    private String hint = "hint";
    private Color accentColor = MaterialColors.BLUEA_400;

    //default
    private Color foreground = MaterialColors.BLACK;

    private Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

    private ImageIcon icon = MaterialIcons.ARROW_DROP_DOWN;

    //flags for wrong
    private Color wrongColor = PersonalizationMaterial.getInstance().getColorWrong();
    private String wrongText = "Error en este campo";
    private boolean wrongFlag = false;

    public _MaterialComboBox() {
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

        this.floatingLabel = new FloatingLabel(this);
        this.setAccent(accentColor);
        this.setOpaque(false);
        this.setCursor(cursor);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setHint("Select...");
        this.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3"}));
        this.setSelectedIndex(-1);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                floatingLabel.update();

            }
        });

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearWrong();
            }
        });
    }

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

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Gets the color the label changes to when this {@code materialTextField}
     * is focused.
     *
     * @return the {@code "Color"} currently in use for accent. The default
     * value is {@link MaterialColor#BLUEA_400}.
     */
    public Color getAccent() {
        return accentColor;
    }

    /**
     * Sets the color the label changes to when this {@code materialTextField}
     * is focused. The default value is {@link MaterialColor#PINK_500}.
     *
     * @param accentColor the {@code "Color"} that should be used for accent.
     */
    public void setAccent(Color accentColor) {
        this.accentColor = accentColor;
        this.floatingLabel.setAccentColor(accentColor);
        repaint();
    }

    /**
     * Gets the label text. The label will float above any contents input into
     * this text field.
     *
     * @return the text being used in the floating label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the label text. The label will float above any contents input into
     * this text field.
     *
     * @param label the text to use in the floating label
     */
    public void setLabel(String label) {
        this.label = label;
        floatingLabel.update();
        repaint();
    }

    /**
     * Gets the hint text. The hint text is displayed when the list inside this
     * combo box is empty or no element has been selected yet.
     *
     * @return hint text
     */
    public String getHint() {
        return hint;
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (floatingLabel != null) {
            floatingLabel.updateForeground();
        }
    }

    /**
     * Sets the hint text. The hint text is displayed when the list inside this
     * combo box is empty or no element has been selected yet.
     *
     * @param hint hint text
     */
    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    public void wrong() {
        floatingLabel.setAccentColor(wrongColor);
        this.wrongFlag = true;
    }

    public void wrong(String wrongText) {
        this.wrongText = wrongText;
        wrong();
    }

    private void clearWrong() {
        if (wrongFlag) {
            this.wrongFlag = false;
            this.setForeground(foreground);
            floatingLabel.setAccentColor(accentColor);
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
        floatingLabel.update();
        line.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int yMid = getSize().height / 2;

        g2.setColor(floatingLabel.getColor());
        g2.setFont(floatingLabel.getFont());
        if (!getLabel().isEmpty()) {
            g2.drawString(getLabel(), floatingLabel.getX(), floatingLabel.getY());//paint the hint in the same place as the text
        }

        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        g2.setFont(getFont());
        if (getSelectedItem() == null && isFocusOwner()) {
            g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            g2.drawString(hint, floatingLabel.getX(), metrics.getAscent() + yMid - metrics.getAscent() / 2);
        } else if (getSelectedItem() != null) {
            g2.setColor(getForeground());
            g2.drawString(getSelectedItem().toString(), floatingLabel.getX(), metrics.getAscent() + yMid - metrics.getAscent() / 2);
        }

        int yLine = yMid + metrics.getAscent() / 2 + 5;

        //paint the back line
        g2.setColor(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, getWidth(), 1);

        //paint the front line, this is the one that change colors and size
        g2.setColor(accentColor);
        g2.fillRect((int) ((getWidth() - line.getWidth()) / 2), yLine, (int) line.getWidth(), 2);

        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getWrongColor());
            g2.setFont(floatingLabel.getFont().deriveFont(1));//1 for bold
            g2.drawString(getWrongText(), 0, yLine + 15);//paint the wrong text
        }

        //paint the arrow
        if (icon != null) {
            Color iconColor;
            if (isFocusOwner()) {
                iconColor = accentColor;
            } else {
                iconColor = Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK);
            }
            if (icon instanceof DerivableIcon) {
                icon = ((DerivableIcon) icon).deriveIcon(iconColor);
            }
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - icon.getIconHeight()), yMid - icon.getIconHeight() / 2);
        }

    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public String getText() {
        return getSelectedItem() == null ? "" : getSelectedItem().toString();
    }

    @Override
    public Component getComponent() {
        return this;
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

            g.setFont(MaterialFontRoboto.REGULAR.deriveFont(15f));
            if (selected) {
                g2.setColor(comboBox.accentColor);
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
            JScrollPane scroller = super.createScroller();
            scroller.setVerticalScrollBar(new ScrollBar(comboBox, Adjustable.VERTICAL));
            scroller.setBorder(new MatteBorder(16, 0, 16, 0, MaterialColors.WHITE));
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

    public static class ScrollBar extends JScrollBar {

        public ScrollBar(final JComboBox comboBox, int orientation) {
            super(orientation);
            setPreferredSize(new Dimension(5, 100));

            setUI(new BasicScrollBarUI() {
                @Override
                protected ScrollListener createScrollListener() {
                    setUnitIncrement(56);
                    setBlockIncrement(560);
                    return super.createScrollListener();
                }

                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                    g.setColor(comboBox.getBackground());
                    g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    JButton dummyButton = new JButton();
                    dummyButton.setPreferredSize(new Dimension(0, 0));
                    return dummyButton;
                }

                @Override
                protected JButton createIncreaseButton(int orientation) {
                    JButton dummyButton = new JButton();
                    dummyButton.setPreferredSize(new Dimension(0, 0));
                    return dummyButton;
                }

                @Override
                protected Dimension getMinimumThumbSize() {
                    return new Dimension(5, 50);
                }

                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    if (!thumbBounds.isEmpty() && this.scrollbar.isEnabled()) {
                        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                        boolean isVertical = ScrollBar.this.getOrientation()
                                == Adjustable.VERTICAL;
                        g.setColor(MaterialColors.GREY_500);
                        g.fillRoundRect(thumbBounds.x, thumbBounds.y,
                                thumbBounds.width, thumbBounds.height,
                                isVertical ? thumbBounds.width : thumbBounds.height,
                                isVertical ? thumbBounds.width : thumbBounds.height);
                    }
                }

                @Override
                public void layoutContainer(Container scrollbarContainer) {
                    super.layoutContainer(scrollbarContainer);
                    incrButton.setBounds(0, 0, 0, 0);
                    decrButton.setBounds(0, 0, 0, 0);
                }
            });
        }

        @Override
        public Component add(Component comp) {
            if (comp != null) {
                return super.add(comp);
            }
            return null;
        }

        @Override
        public void paint(Graphics g) {
            g.setColor(MaterialColors.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paint(g);
        }
    }

}
