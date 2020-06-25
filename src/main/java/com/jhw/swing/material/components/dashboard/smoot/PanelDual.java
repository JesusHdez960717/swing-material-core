package com.jhw.swing.material.components.dashboard.smoot;

import com.jhw.swing.material.components.container.panels._PanelTransparent;
import java.awt.Component;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.SafePropertySetter;
import com.jhw.utils.interfaces.Update;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class PanelDual extends _PanelTransparent implements Update {

    private final int DURATION = 250;
    private Animator anim;
    private final Component left;
    private final Component right;

    public PanelDual(Component a, Component b) {
        this.left = a;
        this.right = b;
    }

    public void setLeftComponentSize(int size) {
        move(size);
    }

    private void move(int size) {
        if (anim != null) {
            anim.cancel();
        }
        if (PersonalizationMaterial.getInstance().isUseAnimations()) {
            doAnimateMove(size);
        } else {
            doMove(size);
        }
    }

    private void doMove(Integer value) {
        if (value != null) {
            left.setSize(new Dimension(value, 0));
            update();
        }
    }

    @Override
    public void update() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, left.getSize().width)
                                .addGap(0, 0, 0)
                                .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(right, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void doAnimateMove(int size) {
        anim = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setInterpolator(new SplineInterpolator(0.1, 0.3, 0.45, 1))
                .addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Integer>() {
                    @Override
                    public void setValue(Integer value) {
                        doMove(value);
                    }

                }, (int) left.getSize().getWidth(), size))
                .build();
        anim.start();
    }

}
