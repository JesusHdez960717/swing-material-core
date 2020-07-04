package com.jhw.swing.material.components.button;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingTargetAdapter;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.SafePropertySetter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialButtonIconTranspRotate extends _MaterialButtonIconTransparent {

    private final int DURATION = 250;
    private Icon newIcon;
    private int anglulo = 0;
    private Animator anim;

    public _MaterialButtonIconTranspRotate() {
    }

    public void setIconRotate(Icon icon) {
        newIcon = icon;
        if (anim != null) {
            anim.cancel();
        }
        anim = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
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

    @Override
    public void setIcon(Icon icon) {
        super.setIcon(icon);
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
