package com.jhw.swing.material.components.textfield;

import com.clean.core.exceptions.ValidationException;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import com.jhw.utils.others.Misc;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.FloatingLabelStandar;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.TextTypeEnum;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.Wrong;
import com.jhw.swing.util.validations.Validation;
import com.jhw.swing.util.validations.textfield.GreaterThatCeroValidation;
import com.jhw.swing.util.validations.textfield.TextFieldValidation;
import com.jhw.utils.interfaces.Formateable;

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
public class _MaterialTextField extends JTextField implements BindableComponent, Wrong, MaterialComponent, FloatingLabelStandar {

    public static final int HINT_OPACITY_MASK = 0x99000000;
    public static final int LINE_OPACITY_MASK = 0x66000000;

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

    private TextTypeEnum type = TextTypeEnum.NORMAL;
    private int maxLength = Integer.MAX_VALUE;

    private String frontText = "";
    private String extra = "";

    private int distanceFrontText = 5;

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is empty.
     */
    public _MaterialTextField() {
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

    @Override
    public Component getComponent() {
        return this;
    }

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is the one provided.
     *
     * @param text An starting value for this text field
     */
    public _MaterialTextField(String text) {
        this();
        setText(text);
    }

    /**
     * Get the type of the text to display.
     *
     * @return the type of the text
     */
    public TextTypeEnum getType() {
        return type;
    }

    /**
     * Set the type of the text to display.
     *
     * @param type the type of the text
     */
    public void setType(TextTypeEnum type) {
        this.type = type;
        setText(getText());
    }

    public int getDistanceFrontText() {
        return distanceFrontText;
    }

    public void setDistanceFrontText(int distanceFrontText) {
        this.distanceFrontText = distanceFrontText;
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

    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
        this.repaint();
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
        this.repaint();
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (floatingLabel != null) {
            floatingLabel.updateForeground();
        }
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        this.setCaretPosition(getText().length());
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

        g2.setFont(getFont());
        FontMetrics metrics = g2.getFontMetrics(g2.getFont());
        int traslation = 0;
        if (!frontText.isEmpty()) {
            traslation = metrics.stringWidth(frontText) + getDistanceFrontText();
        }

        g2.translate(traslation, 0);
        super.paintComponent(g2);//paint the text, caret,higligth and foreground
        g2.translate(-traslation, 0);

        g2.setColor(getBackground());//por defecto no pinta el background
        g2.fillRect(0, 0, getWidth(), getHeight());

        int yMid = getSize().height / 2;

        //Paint the hint
        if (!getHint().isEmpty() && getText().isEmpty() && (getLabel().isEmpty() || isFocusOwner()) && floatingLabel.isFloatingAbove()) {
            g2.setColor(Utils.applyAlphaMask(getForeground(), HINT_OPACITY_MASK));
            g2.drawString(getHint(), traslation, yMid + metrics.getAscent() / 2);//paint the hint in the same place as the text
        }


        g2.setColor(floatingLabel.getColor());
        g2.setFont(floatingLabel.getFont());
        if (!getLabel().isEmpty()) {
            g2.drawString(getLabel(), floatingLabel.getX(), floatingLabel.getY());//paint the label in the same place as the texti
        }

        int yLine = yMid + metrics.getAscent() / 2 + 5;

        //paint the under-line 
        g2.setColor(Utils.applyAlphaMask(getForeground(), LINE_OPACITY_MASK));
        g2.fillRect(0, yLine, getWidth(), 1);

        //paint the real-line, this is the one that change colors and size
        g2.setColor(floatingLabel.getColor());
        g2.fillRect((int) ((getWidth() - line.getWidth()) / 2), yLine, (int) line.getWidth(), 2);

        //paint the wrong text if the flag is actived
        if (wrongFlag) {
            g2.setColor(getWrongColor());
            g2.setFont(floatingLabel.getFont().deriveFont(1));//1 for bold
            g2.drawString(wrongText, 0, yLine + 15);//paint the wrong text
        }

        g2.setFont(getFont());
        g2.setColor(getForeground());
        g2.drawString(getFrontText(), 0, getHeight() / 2 + metrics.getHeight() / 2 - 3);//paint the frontText

        g2.drawString(getExtra(), getWidth() - metrics.stringWidth(getExtra()), getHeight() / 2 + metrics.getHeight() / 2 - 3);//paint the extra
    }

    @Override
    protected void paintBorder(Graphics g) {
        //intentionally left blank
    }

    @Override
    public void wrong() {
        floatingLabel.setAccentColor(wrongColor);
        this.wrongFlag = true;
    }

    @Override
    public void wrong(String wrongText) {
        setWrongText(wrongText);
        wrong();
    }

    private void clearWrong(KeyEvent evt) {
        if (wrongFlag && !evt.isConsumed()) {
            this.wrongFlag = false;
            setForeground(foreground);
            floatingLabel.setAccentColor(accentColor);
            this.repaint();
        }
    }

    @Override
    public Object getObject() {
        return getText();
    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Formateable) {
            setText(((Formateable) object).format());
        } else {
            setText(object.toString());
        }
    }
}
