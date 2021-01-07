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

import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingTargetAdapter;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.root101.swing.util.Utils;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.SafePropertySetter;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonIconTranspRotate extends _MaterialButtonIconTransparent {

    public static MaterialButtonIcon from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonIconTranspRotate.class);
    }

    private final int DURATION = 250;
    private Icon newIcon;
    private int anglulo = 0;
    private Animator anim;

    /**
     * NO USAR ESTE CONSTRUCTOR. Usar el _MaterialButtonIconTranspRotate.from()
     * que internamente le asigna el proxy y demas para el trabajo automatizado
     * con AOP.(Aspect Oriented Programing)
     *
     * @deprecated
     */
    @Deprecated
    public _MaterialButtonIconTranspRotate() {
    }

    public void setIconRotate(Icon icon) {
        newIcon = icon;
        if (anim != null) {
            anim.cancel();
        }
        anim = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setInterpolator(new SplineInterpolator(0.55, 0, 0.9, 0.7))
                .addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Integer>() {
                    @Override
                    public void setValue(Integer value) {
                        if (value != null) {
                            anglulo = value;
                            repaint();
                        }
                    }
                }, 0, 180))
                .addTarget(new TimingTargetAdapter() {
                    @Override
                    public void end(Animator source) {
                        anglulo = 0;
                        setIconSuper(newIcon);
                    }
                }).build();
        anim.start();
    }

    private void setIconSuper(Icon newIcon) {
        super.setIcon(newIcon);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.rotate(Math.PI / 180 * anglulo, getWidth() / 2, getHeight() / 2);
        super.paintComponent(g);
    }
}
