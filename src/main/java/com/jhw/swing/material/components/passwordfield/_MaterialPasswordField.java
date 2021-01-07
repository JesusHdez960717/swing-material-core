package com.jhw.swing.material.components.passwordfield;

import com.jhw.swing.material.effects.DefaultFloatingLabel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import com.jhw.swing.material.effects.FloatingLabel;
import  com.root101.security.SHA;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.DefaultWrong;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.effects.Wrong;

/**
 * A Material Design single-line text field is the basic way of getting user
 * input. It includes a descriptive label that appears as a placeholder and then
 * floats above the text field as content is written. You can also set a hint
 * for it to appear below the label when the text field is empty.
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/text-fields.html">Text
 * fields (Google design guidelines)</a>
 */
public class _MaterialPasswordField extends MaterialPasswordField {

    public static MaterialPasswordField from() {
        return new _MaterialPasswordField();
    }

    private final FloatingLabel floatingLabel = new DefaultFloatingLabel(this) {
        @Override
        protected int getTargetYPosition() {
            return _MaterialPasswordField.this.isFocusOwner() || !_MaterialPasswordField.this.getText().isEmpty() ? this.getYPositionUP() : this.getYPositionDOWN();
        }

        @Override
        protected float getTargetFontSize() {
            return (_MaterialPasswordField.this.isFocusOwner() || !_MaterialPasswordField.this.getText().isEmpty()) ? _MaterialPasswordField.this.getFont().getSize2D() * 0.8f : _MaterialPasswordField.this.getFont().getSize2D();
        }
    };
    private final Line line = new DefaultLine(this);
    private final Wrong wrong = new DefaultWrong(this);

    private int maxLength = 100;

    //extra
    private String extra = "";

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is empty.
     */
    public _MaterialPasswordField() {
        super();
        this.setPreferredSize(new Dimension(145, 65));
        this.setBorder(null);//inicialemnte tiene un border empty que hay que quitarle

        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));

        this.setOpaque(false);
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setForeground(MaterialColors.BLACK);

        this.getCaret().setBlinkRate(500);

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validateSize(evt);
                clearWrong();
            }
        });
        setText("");
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

    private void validateSize(KeyEvent evt) {
        if (getText().length() + 1 > getMaxLength()) {
            Utils.beep();
            evt.consume();
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
    public String getExtra() {
        return extra;
    }

    @Override
    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        this.setCaretPosition(s.length());
        firePropertyChange("text", null, null);
    }

    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        firePropertyChange("processFocusEvent", null, null);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        firePropertyChange("processKeyEvent", null, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        super.paintComponent(g2);//paint the text, caret,higligth and foreground

        g2.setColor(getBackground());//por defecto no pinta el background
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setFont(getFont());
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());

        //Paint the hint
        if (!getHint().isEmpty() && getText().isEmpty() && (getLabel().isEmpty() || isFocusOwner())) {
            paintHint(g2);
        }

        paintLabel(g2);

        paintLine(g2);

        paintWrong(g2, getYLine(g2) + 15);

        g2.setFont(getFont());
        g2.setColor(getForeground());

        g2.drawString(getExtra(), getWidth() - metrics.stringWidth(getExtra()), getHeight() / 2 + metrics.getHeight() / 2 - 3);//paint the extra
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public String getObject() {
        return new String(getPassword());
    }

    @Override
    public void setObject(String object) {
        setText(object);
    }

}
