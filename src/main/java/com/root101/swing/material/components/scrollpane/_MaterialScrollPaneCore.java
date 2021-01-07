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
package com.root101.swing.material.components.scrollpane;

import com.root101.swing.material.effects.DefaultBorderDinamic;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import java.awt.Adjustable;
import java.awt.Color;
import javax.swing.JComponent;

/**
 * <p>
 * Para poner el focus directamente sobre el nuevo componente hacel algo como
 * esto
 * <pre>
 * JTextArea text = new JTextArea("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
 *      MaterialScrollPane scroll = new _MaterialScrollPaneCore() {
 *          @Override
 *          public JComponent getFocusableComponent() {
 *              return text;
 *          }
 *      };//MaterialScrollFactory.buildPane();
 * scroll.setViewportView(text);
 * scroll.setBorderTitle("buajajajaja");
 * </pre>
 * <p>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class _MaterialScrollPaneCore extends MaterialScrollPane {

    public static MaterialScrollPane from() {
        return new _MaterialScrollPaneCore();
    }

    private final _MaterialScrollBar verticalScrollBar = new _MaterialScrollBar(Adjustable.VERTICAL);
    private final _MaterialScrollBar horizontalScrollBar = new _MaterialScrollBar(Adjustable.HORIZONTAL);

    private final DefaultBorderDinamic borderEffect;

    public _MaterialScrollPaneCore() {//constructor publico para poder hacer: new _MaterialScrollPaneCore(){@Override}
        //para el border
        this.setBackground(MaterialColors.WHITE);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));

        //barras de material
        this.setVerticalScrollBar(verticalScrollBar);
        this.setHorizontalScrollBar(horizontalScrollBar);

        //smoot
        this.addMouseWheelListener(new SmoothScrollMouseWheelListener(this));

        //transparente
        this.setBackground(MaterialColors.TRANSPARENT);
        this.getViewport().setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);
        this.getViewport().setOpaque(false);

        //le sobra el borde
        //this.setBorder(null);
        borderEffect = new DefaultBorderDinamic(this);
    }

    @Override
    public MaterialScrollBar getMaterialVerticalScrollBar() {
        return verticalScrollBar;
    }

    @Override
    public MaterialScrollBar getMaterialHorizontalScrollBar() {
        return horizontalScrollBar;
    }

    @Override
    public JComponent getFocusableComponent() {
        return getViewport();
    }

    @Override
    public JComponent getBordeableComponent() {
        return this;
    }

    @Override
    public String getBorderTitle() {
        return borderEffect.getBorderTitle();
    }

    @Override
    public void setBorderTitle(String title) {
        borderEffect.setBorderTitle(title);
    }

    @Override
    public Color getBorderAccentColor() {
        return borderEffect.getBorderAccentColor();
    }

    @Override
    public void setBorderAccentColor(Color accentColor) {
        borderEffect.setBorderAccentColor(accentColor);
    }

}
