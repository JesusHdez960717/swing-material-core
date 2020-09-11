/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.textfield;

import com.jhw.swing.material.effects.DefaultFloatingLabel;
import com.jhw.swing.material.effects.FloatingLabel;
import com.jhw.swing.material.effects.DefaultLine;
import com.jhw.swing.material.effects.DefaultWrong;
import com.jhw.swing.material.effects.Line;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.BindableComponent;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.effects.Wrong;
import com.jhw.utils.interfaces.Formateable;
import com.jhw.utils.services.ConverterService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import org.jdesktop.swingx.JXFormattedTextField;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialFormatedTextField<T> extends JXFormattedTextField implements Line, BindableComponent<T>, Wrong, MaterialComponent, FloatingLabel {

    private final FloatingLabel floatingLabel = new DefaultFloatingLabel(this);
    private final Line line = new DefaultLine(this);
    private final Wrong wrong = new DefaultWrong(this);

    private final Class<? extends T> clazz;

    private int maxLength = 100;

    //extra
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

        this.getCaret().setBlinkRate(500);

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validateSize(evt);
                clearWrong();
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
        FontMetrics metrics = g2.getFontMetrics(getFont());

        //Paint the hint
        if (!getHint().isEmpty() && getText().isEmpty() && (getLabel().isEmpty() || isFocusOwner())) {
            paintHint(g2);
        }

        paintLabel(g2);
        
        paintLine(g2);

        //paint the wrong text if the flag is actived
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
    public T getObject() {
        if (clazz == null) {
            throw new NullPointerException("Clase para convertir nula.");
        }
        try {
            return ConverterService.convert(getValue(), clazz);
        } catch (Exception e) {
            //return null;
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
