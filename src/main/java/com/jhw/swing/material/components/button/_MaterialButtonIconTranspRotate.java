package com.jhw.swing.material.components.button;

import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingTargetAdapter;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.SafePropertySetter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class _MaterialButtonIconTranspRotate extends _MaterialButtonIconTransparent {

    private final int DURATION = 250;
    private Icon newIcon;
    private int anglulo = 0;
    private Animator anim;

    public static MaterialButtonIcon from() {
        return MaterialSwingInjector.getImplementation(_MaterialButtonIconTranspRotate.class);
    }

    /**
     * NO USAR ESTE CONSTRUCTOR. Usar el _MaterialButtonIconTranspRotate.from() que internamente
     * le asigna el proxy y demas para el trabajo automatizado con AOP.(Aspect
     * Oriented Programing)
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
