/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.textfield;

import com.root101.swing.material.effects.DefaultFloatingLabel;
import com.root101.swing.material.effects.FloatingLabel;
import com.root101.swing.material.effects.DefaultLine;
import com.root101.swing.material.effects.DefaultWrong;
import com.root101.swing.material.effects.Line;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.Utils;
import com.root101.swing.material.effects.Wrong;
import com.root101.utils.interfaces.Formateable;
import com.root101.clean.core.app.services.ConverterHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialFormatedTextField<T> extends MaterialFormatedTextField<T> {

    public static MaterialFormatedTextField from() {
        return new _MaterialFormatedTextField();
    }

    private final Class<? extends T> clazz;

    private final FloatingLabel floatingLabel = new DefaultFloatingLabel(this);
    private final Line line = new DefaultLine(this);
    private final Wrong wrong = new DefaultWrong(this);

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

    public Class<? extends T> getClazz() {
        return clazz;
    }

    @Override
    public T getObject() {
        if (clazz == null) {
            throw new NullPointerException("Clase para convertir nula.");
        }
        try {
            return ConverterHandler.convert(getValue(), clazz);
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
