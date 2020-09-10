/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.effects.DefaultFloatingLabel;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.util.interfaces.Wrong;
import com.jhw.utils.interfaces.Formateable;
import com.jhw.utils.services.ConverterService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.text.DefaultCaret;
import org.jdesktop.swingx.JXFormattedTextField;
import static com.jhw.swing.material.standards.Utils.LINE_OPACITY_MASK;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFormatedTextField<T> extends JXFormattedTextField implements Line, BindableComponent<T>, Wrong, MaterialComponent, FloatingLabel {

    private FloatingLabel floatingLabel = new DefaultFloatingLabel(this);
    private Line line = new DefaultLine(this);

    private final Class<? extends T> clazz;

    //default
    private Color foreground = MaterialColors.BLACK;

    //flags for wrong
    private Color wrongColor = PersonalizationHandler.getColor(Personalization.KEY_COLOR_WRONG);
    private String wrongText = "Error en este campo";
    private boolean wrongFlag = false;

    private int maxLength = 100;

    private String extra = "";

    public _MaterialFormatedTextField() {
        this(String.class);
    }

    /**
     * Default constructor for {@code MaterialTextField}. A default model is
     * created and the initial string is empty.
     */
    public _MaterialFormatedTextField(Class clazz) {
        this.clazz = clazz;

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
                validateSize(evt);
                repaint();
            }
        });
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                repaint();
            }
        });

        setText("");

        this.setComponentPopupMenu(CopyPastePopup.INSTANCE);
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

    private void validateSize(KeyEvent evt) {
        try {
            this.commitEdit();
            if (getValue().toString().length() + 1 > getMaxLength()) {
                throw new Exception("Tamanno muy grande");
            }
        } catch (Exception e) {
            Utils.beep();
            evt.consume();
        }
    }

    public Class<? extends T> getClazz() {
        return clazz;
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
        this.repaint();
    }

    @Override
    public void setText(String s) {
        super.setText(s);
        this.setCaretPosition(getText().length());
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
        FontMetrics metrics = g2.getFontMetrics(getFont());

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

    @Override
    public void wrong() {
//        floatingLabel.setAccentColor(wrongColor);
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
//            floatingLabel.setAccentColor(accentColor);
            this.repaint();
        }
    }

    @Override
    public T getObject() {
        if (clazz == null) {
            throw new NullPointerException("Clase para convertir nula.");
        }
        try {
            return ConverterService.convert(getValue(), clazz);
        } catch (Exception e) {
            throw new NullPointerException("Error convirtiendo.");
        }
    }

    @Override
    public void setObject(T object) {
        if (object == null) {
            setValue("");
            return;
        }
        if (object instanceof Formateable) {
            setValue(((Formateable) object).format());
        } else {
            setValue(object.toString());
        }
    }

}
