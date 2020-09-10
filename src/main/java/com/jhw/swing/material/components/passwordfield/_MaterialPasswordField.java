package com.jhw.swing.material.components.passwordfield;

import com.jhw.swing.material.effects.DefaultFloatingLabel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.utils.security.SHA;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.Wrong;

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
public class _MaterialPasswordField extends JPasswordField implements Line, BindableComponent<char[]>, Wrong, MaterialComponent, FloatingLabel {

    private FloatingLabel floatingLabel = new DefaultFloatingLabel(this);

    private Line line = new DefaultLine(this);

    //default
    private Color foreground = MaterialColors.BLACK;

    //flags for wrong
    private Color wrongColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_WRONG);
    private String wrongText = "Error en este campo";
    private boolean wrongFlag = false;

    private int maxLength = Integer.MAX_VALUE;

    private boolean doValidate = true;

    //coin
    private String extra = "";

    private String hashAlgorithm = "SHA-256";

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is empty.
     */
    public _MaterialPasswordField() {
        super();
        this.setPreferredSize(new Dimension(145, 65));
        this.setBorder(null);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));

        this.setOpaque(false);
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setForeground(MaterialColors.BLACK);

        this.setCaret(new DefaultCaret() {
            @Override
            protected synchronized void damage(Rectangle r) {
                this.repaint(); //fix caret not being removed completely
            }
        });
        this.getCaret().setBlinkRate(500);

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validateText(evt);
                clearWrong(evt);
                repaint();
            }
        });
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                repaint();
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {

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

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
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

    /**
     * Get the max length of the text.
     *
     * @return the max length of the text
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Set the max length of the text.
     *
     * @param maxLength the max length of the text
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public boolean isDoValidate() {
        return doValidate;
    }

    public void setDoValidate(boolean doValidate) {
        this.doValidate = doValidate;
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        this.setCaretPosition(super.getPassword().length);
        firePropertyChange("text", null, null);
        clearWrong(new KeyEvent(this, 0, 0, 0, 0, '0'));
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

        int yMid = getSize().height / 2;

        g2.setFont(getFont());
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());

        //Paint the hint
        if (!getHint().isEmpty() && getText().isEmpty() && (getLabel().isEmpty() || isFocusOwner())) {
            paintHint(g2);
        }

        paintLabel(g2);
        paintLine(g2);

        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getWrongColor());
            g2.setFont(getFont().deriveFont(getFont().getSize2D() * 0.8f).deriveFont(1));//1 for bold
            g2.drawString(wrongText, 0, getYLine(g2) + 15);//paint the wrong text
        }

        g2.setFont(getFont());
        g2.setColor(getForeground());

        g2.drawString(getExtra(), getWidth() - metrics.stringWidth(getExtra()), getHeight() / 2 + metrics.getHeight() / 2 - 3);//paint the extra
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    private Object validateText(KeyEvent evt) {
        Object ans = null;
        if (!doValidate) {//no tengo que validar, asumo todo ok
            return true;
        }

        if (getPassword().length + 1 > maxLength) {
            Utils.beep();
            if (evt != null) {
                evt.consume();
            }
            return false;
        }
        try {
            ans = getPassword();
        } catch (Exception e) {
        }
        if (ans == null) {
            Utils.beep();
            if (evt != null) {
                evt.consume();
            }
        }

        return ans;
    }

    @Override
    public void wrong() {
        setForeground(wrongColor);
//        floatingLabel.setAccentColor(wrongColor);
        this.wrongFlag = true;
    }

    @Override
    public void wrong(String wrongText) {
        this.wrongText = wrongText;
        wrong();
    }

    private void clearWrong(KeyEvent evt) {
        if (wrongFlag && !evt.isConsumed()) {
            this.wrongFlag = false;
            setForeground(foreground);
//            floatingLabel.setAccentColor(accentColor);
        }
    }

    /**
     * Get the password in this text field.<\br>
     * By default, it hash via SHA-256.
     *
     * @return
     */
    @Override
    public char[] getPassword() {
        char[] pass = super.getPassword();
        if (hashAlgorithm != null && !hashAlgorithm.trim().isEmpty()) {
            pass = SHA.hash(new String(pass), hashAlgorithm).toCharArray();
        }
        return pass;
    }

    @Override
    public char[] getObject() {
        return getPassword();
    }

    @Override
    public void setObject(char[] object) {
        setText(new String(object));
    }

}
