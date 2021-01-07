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
package com.root101.swing.material.components.button;

import java.awt.*;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.standards.MaterialShadow;
import com.root101.swing.material.effects.DefaultElevationEffect;
import com.root101.swing.material.effects.DefaultRippleEffect;
import com.root101.swing.material.effects.RippleEffect;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialIcons;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;
import static com.root101.swing.material.standards.Utils.HINT_OPACITY_MASK;
import com.root101.swing.util.Utils;

/**
 * A Material Design button. A round button with a icon in the middle
 *
 * @see <a
 * href="https://www.google.com/design/spec/components/buttons.html">Buttons
 * (Google design guidelines)</a>
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialIconButtonRound extends _MaterialButton {

    public static MaterialButton from() {
        return MaterialSwingInjector.getImplementation(_MaterialIconButtonRound.class);
    }

    private final RippleEffect ripple = DefaultRippleEffect.applyFixedTo(this);

    private boolean circle = true;

    /**
     * Usar _MaterialIconButtonRound.from() para proxy y AOP
     *
     * @deprecated
     */
    @Deprecated
    protected _MaterialIconButtonRound() {
        this.setText("");

        //icon
        this.setIcon(MaterialIcons.FACE);

        //size
        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;
        this.setPreferredSize(new Dimension(3 * this.getIcon().getIconWidth() + offset_lr, 3 * this.getIcon().getIconHeight() + offset_td));

        setElevation(DefaultElevationEffect.applyCirularTo(this, MaterialShadow.ELEVATION_NONE));

        this.setUI(new BasicButtonUI() {
            @Override
            public boolean contains(JComponent c, int x, int y) {
                return getShape().contains(x - MaterialShadow.OFFSET_LEFT, y - MaterialShadow.OFFSET_TOP);
            }
        });
    }

    public boolean isCircle() {
        return circle;
    }

    public void setCircle(boolean circle) {
        this.circle = circle;
    }

    @Override
    public Color getRippleColor() {
        return ripple.getRippleColor();
    }

    @Override
    public void setRippleColor(Color color) {
        ripple.setRippleColor(color);
    }

    @Override
    public void paintRipple(Graphics2D g2) {
        ripple.paintRipple(g2);
    }

    @Override
    public boolean getPaintRipple() {
        return ripple.getPaintRipple();
    }

    @Override
    public void setPaintRipple(boolean paintRipple) {
        ripple.setPaintRipple(paintRipple);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        if (getType() != Type.FLAT && isEnabled()) {
            paintElevation(g2);
        }
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        Shape shape = getShape();
        //color de fondo
        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
        } else {
            Color bg = getBackground();
            g2.setColor(Utils.applyAlphaMask(bg, HINT_OPACITY_MASK));

            //g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
        }
        g2.fill(shape);

        //ripple
        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(shape);

            //enderezo la traslacion para el ripple
            g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
            paintRipple(g2);

            //la vuelvo a correr para el icon
            g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        }

        if (getIcon() != null) {
            getIcon().paintIcon(this, g2, (this.getSize().width - offset_lr) / 2 - getIcon().getIconWidth() / 2, (this.getSize().height - offset_td) / 2 - getIcon().getIconHeight() / 2);
        }
        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

    private Shape getShape() {
        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;

        if (isCircle()) {
            w = h = Math.min(w, h);
            x = (getWidth() - w) / 2;
            y = (getHeight() - h) / 2;
        }
        return new java.awt.geom.Ellipse2D.Float(x, y, w - offset_lr, h - offset_td);
    }

}
