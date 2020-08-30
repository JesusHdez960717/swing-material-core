package com.jhw.swing.material.components.passwordfield;

import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import static com.jhw.swing.material.components.textfield._MaterialTextField.LINE_OPACITY_MASK;
import com.clean.core.exceptions.ValidationException;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.FloatingLabelStandar;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.utils.security.SHA;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.validations.Validation;
import com.jhw.swing.util.validations.textfield.TextFieldValidation;
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
public class _MaterialPasswordField extends JPasswordField implements BindableComponent<char[]>, Wrong, MaterialComponent, FloatingLabelStandar {

    private FloatingLabel floatingLabel;
    private Line line;
    private String hint = "hint";
    private String label = "label";
    private Color accentColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_ACCENT);

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

    private final ArrayList<TextFieldValidation> preValidations = new ArrayList<>();
    private final ArrayList<TextFieldValidation> postValidations = new ArrayList<>();

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

        floatingLabel = new FloatingLabel(this);
        line = new Line(this);
        setAccent(accentColor);
        setText("");
    }

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is the one provided.
     *
     * @param text An starting value for this text field
     */
    public _MaterialPasswordField(String text) {
        this();
        setText(text);
    }

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

    public ArrayList<TextFieldValidation> getPostValidations() {
        return postValidations;
    }

    public void addPostValidation(TextFieldValidation val) {
        postValidations.remove(val);
        postValidations.add(val);
    }

    public ArrayList<TextFieldValidation> getPreValidations() {
        return preValidations;
    }

    public void addPreValidation(TextFieldValidation val) {
        preValidations.remove(val);
        preValidations.add(val);
    }

    /**
     * Gets the hint text. The hint text is displayed when this textfield is
     * empty.
     *
     * @return the text being used as hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * Sets the hint text. The hint text is displayed when this textfield is
     * empty.
     *
     * @param hint the text to use as hint
     */
    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    /**
     * Gets the color the label changes to when this {@code materialTextField}
     * is focused.
     *
     * @return the {@code "Color"} currently in use for accent. The default
     * value is {@link MaterialColor#CYAN_300}.
     */
    public Color getAccent() {
        return accentColor;
    }

    /**
     * Sets the color the label changes to when this {@code materialTextField}
     * is focused. The default value is {@link MaterialColor#CYAN_300}.
     *
     * @param accentColor the {@code "Color"} that should be used for accent.
     */
    public void setAccent(Color accentColor) {
        this.accentColor = accentColor;
        this.floatingLabel.setAccentColor(accentColor);
        repaint();
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

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (floatingLabel != null) {
            floatingLabel.updateForeground();
        }
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
        floatingLabel.update();
        line.update();
        clearWrong(new KeyEvent(this, 0, 0, 0, 0, '0'));
    }

    @Override
    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);
        floatingLabel.update();
        line.update();
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        floatingLabel.update();
        line.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        super.paintComponent(g2);//paint the text, caret,higligth and foreground

        g2.setColor(getBackground());//por defecto no pinta el background
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setFont(getFont());
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());

        int yMid = getSize().height / 2;

        //Paint the hint
        if (!getHint().isEmpty() && getText().isEmpty() && (getLabel().isEmpty() || isFocusOwner()) && floatingLabel.isFloatingAbove()) {
            g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            g2.drawString(getHint(), floatingLabel.getX(), yMid + metrics.getAscent() / 2);//paint the hint in the same place as the text
        }

        g2.setColor(floatingLabel.getColor());
        g2.setFont(floatingLabel.getFont());
        g2.drawString(getLabel(), floatingLabel.getX(), floatingLabel.getY());//paint the hint in the same place as the text

        int yLine = yMid + metrics.getAscent() / 2 + 5;

        //paint the back line
        g2.setColor(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, getWidth(), 1);

        //paint the front line, this is the one that change colors and size
        g2.setColor(floatingLabel.getColor());
        g2.fillRect((int) ((getWidth() - line.getWidth()) / 2), yLine, (int) line.getWidth(), 2);

        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getForeground());
            g2.setFont(floatingLabel.getFont().deriveFont(1));//1 for bold
            g2.drawString(wrongText, 0, yLine + 15);//paint the wrong text
        }

        g2.setColor(getForeground());
        g2.setFont(getFont());
        if (!extra.trim().isEmpty()) {
            g2.drawString(extra, getWidth() - metrics.stringWidth(extra), getHeight() / 2 + metrics.getHeight() / 2 - 3);//paint the coin
        }
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
        floatingLabel.setAccentColor(wrongColor);
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
            floatingLabel.setAccentColor(accentColor);
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
        runPreValidations(pass);
        runPostValidations(pass);
        return pass;
    }

    private void runPostValidations(Object ans) {
        for (Validation v : postValidations) {
            if (!v.validate(ans)) {
                setWrongText(v.getWrongText());
                throw new ValidationException(v.getDetailedText());
            }
        }
    }

    private void runPreValidations(Object ans) {
        for (Validation v : preValidations) {
            if (!v.validate(ans)) {
                setWrongText(v.getWrongText());
                throw new ValidationException(v.getDetailedText());
            }
        }
    }

    public void clearPreValidations() {
        preValidations.clear();
    }

    public void clearPostValidations() {
        postValidations.clear();
    }

    public void clearAllValidations() {
        preValidations.clear();
        postValidations.clear();
    }

    public boolean containValidation(TextFieldValidation v) {
        return preValidations.contains(v) || postValidations.contains(v);
    }

    @Override
    public Component getComponent() {
        return this;
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
