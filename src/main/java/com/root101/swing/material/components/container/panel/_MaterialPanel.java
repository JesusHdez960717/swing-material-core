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
package com.root101.swing.material.components.container.panel;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.material.effects.DefaultElevationEffect;
import com.root101.swing.material.standards.MaterialShadow;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.effects.DefaultMaterialLineBorder;
import com.root101.swing.material.effects.MaterialLineBorder;
import com.root101.swing.material.effects.ElevationEffect;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;

/**
 * A JPanel customized for Material components. What makes these panels special
 * is the possibility of assigning them an elevation level. Elevation can help
 * distinguishing elements inside a Material-based GUI, and any changes done to
 * them result in nicely animated transitions, helping to achieve that Material
 * flow.
 * <p/>
 * However, there is a catch: shadows are kinda expensive to compute, as Java2D
 * relies on the CPU for anything other than images, so having a lot of elements
 * with a given elevation (and thus, a shadow) can reduce performance when these
 * elevations change due to the triggered animations.
 * <p/>
 * Letting the components suggest a prefered size based on their contents is
 * still under development, so it is not advised to use your favorite
 * {@link LayoutManager} inside a {@code _MaterialPanel} unless you set the
 * prefered, minimum and maximum size of each component by yourself. Currently,
 * the prefereable approach to follow is overriding {@link #doLayout()} and
 * taking care of any arrangements by yourself.
 *
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialPanel extends MaterialPanelBorder implements ElevationEffect {

    public static MaterialPanelBorder from() {
        return MaterialSwingInjector.getImplementation(_MaterialPanel.class);
    }

    private final ElevationEffect elevation = DefaultElevationEffect.applyTo(this, MaterialShadow.ELEVATION_DEFAULT);

    private final MaterialLineBorder border = DefaultMaterialLineBorder.builder().borderRadius(5).listeners(this).build();

    private double elevationLevel = MaterialShadow.ELEVATION_DEFAULT;

    private Icon icon;

    /**
     * Use _MaterialPanel.from() para proy y AOP
     *
     * Creates a new {@code MaterialPanel}. These panels cast a shadow below
     * them, although technically it is painted inside its borders. If you don't
     * need a shadow to be casted from this panel, use a {@link JPanel} instead.
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setBackground(PersonalizationHandler.getColor(Personalization.KEY_COLOR_BACKGROUND_PANEL));

        //si no usa sombra un bordecito para definir los paneles
        if (!PersonalizationHandler.getBoolean(Personalization.KEY_USE_SHADOW)) {
            this.setBorderThickness(1);
            this.setBorderColor(PersonalizationHandler.getColor(Personalization.KEY_COLOR_SHADOW_OFF));
        }
    }
//-----------------ELEVATION_EFFECT------------------------

    @Override
    public double getLevel() {
        return elevation.getLevel();
    }

    @Override
    public double getElevation() {
        return elevationLevel;
    }

    @Override
    public void paintElevation(Graphics2D g2) {
        elevation.paintElevation(g2);
    }

    public void setElevationLevel(double elevationLevel) {
        this.elevationLevel = elevationLevel;
    }
//-----------------LINE_BORDER------------------------

    @Override
    public float getBorderThickness() {
        return border.getBorderThickness();
    }

    @Override
    public void setBorderThickness(float thickness) {
        border.setBorderThickness(thickness);
    }

    @Override
    public Color getBorderColor() {
        return border.getBorderColor();
    }

    @Override
    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    @Override
    public int getBorderRadius() {
        return border.getBorderRadius();
    }

    @Override
    public void setBorderRadius(int borderRadius) {
        this.border.setBorderRadius(borderRadius);
        this.elevation.setBorderRadius(borderRadius);
    }

    @Override
    public Stroke getBorderStroke() {
        return border.getBorderStroke();
    }

    @Override
    public void setBorderStroke(Stroke stroke) {
        border.setBorderStroke(stroke);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        border.paintBorder(c, g, x, y, width, height);
    }
//-----------------LINE_BORDER------------------------

    @Override
    public Icon getIcon() {
        return this.icon;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        paintElevation(g2);
        g2.translate(MaterialShadow.OFFSET_LEFT, MaterialShadow.OFFSET_TOP);

        final int offset_lr = MaterialShadow.OFFSET_LEFT + MaterialShadow.OFFSET_RIGHT;
        final int offset_td = MaterialShadow.OFFSET_TOP + MaterialShadow.OFFSET_BOTTOM;

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - offset_lr, getHeight() - offset_td, getBorderRadius() * 2, getBorderRadius() * 2));

        g2.setClip(null);

        paintBorder(this, g2, 0, 0, (int) (getWidth() - offset_lr + getBorderThickness()), (int) (getHeight() - offset_td + getBorderThickness()));

        if (this.icon != null) {
            if (icon instanceof ImageIcon) {//si es image icon lo pinto completo de todo el tamanno
                g2.drawImage(((ImageIcon) this.icon).getImage(), 0, 0, getWidth() - offset_lr, getHeight() - offset_td, null);
            } else {//si no lo pinto como un simple icon
                icon.paintIcon(this, g2, (getWidth() - icon.getIconWidth()) / 2, (getHeight() - icon.getIconHeight()) / 2);
            }
        }

        g2.translate(-MaterialShadow.OFFSET_LEFT, -MaterialShadow.OFFSET_TOP);
    }

}
