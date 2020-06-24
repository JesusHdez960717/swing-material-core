package com.jhw.swing.material.components.scrollpane;

import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JScrollPane;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.ui.utils.MaterialManagerListener;
import com.jhw.swing.util.SafePropertySetter;

/**
 * Class to add a smoot movement to a JScrollPane.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SmoothScrollMouseWheelListener implements MouseWheelListener {

    public static final int DURATION = 250;
    public static final int DEPLOY_ADJUSTMENT = 3;//adjust the unit increment with the real pixels movement

    private final JScrollPane pane;

    private int maxScroll;
    private Animator anim;
    private Integer nextPosition = 0;

    public SmoothScrollMouseWheelListener(JScrollPane pane) {
        this.pane = pane;//save the panel

        //remove old listeners, if not, the old weel listener activate and do the scroll twice
        MaterialManagerListener.removeAllScrollpaneListener(this.pane);

        //to control the maxSize of the scroll, it adjust every time the size change, prevent resize bugs.
        this.pane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                maxScroll = pane.getVerticalScrollBar().getMaximum() - pane.getVerticalScrollBar().getModel().getExtent();
            }
        });
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double wheelDelta = e.getPreciseWheelRotation();//get the direction, -1: ↑, 1: ↓

        //get the movement of the viewport
        int increment = DEPLOY_ADJUSTMENT * pane.getHorizontalScrollBar().getUnitIncrement();

        //acumulate to the next position
        nextPosition += (int) (wheelDelta * increment);

        //do the scroll animated
        doAnim();
    }

    /**
     * Do the scroll animated
     */
    public void doAnim() {
        if (anim != null) {//if anim running stop it
            anim.cancel();
        }
        anim = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                //.setInterpolator(new SplineInterpolator(0.55, 0, 0.9, 0.7))//comented for linear interpolation
                .addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Integer>() {
                    @Override
                    public void setValue(Integer value) {
                        if (value != null) {
                            move(value);//move to the next position
                        }
                    }
                }, (int) pane.getViewport().getViewPosition().getY(), (int) nextPosition))
                .build();
        anim.start();
    }

    /**
     * Move the viewport to the next position.
     *
     * @param to The next position to move the scroll.
     */
    private void move(double to) {
        if (to < 0) {//if goint to move outside, don't.
            to = nextPosition = 0;//reset position
        }
        if (to > maxScroll) {//if goint to move outside, don't.
            to = nextPosition = maxScroll;//reset position
        }

        //Get the next point after movement
        Point after = new Point((int) pane.getViewport().getViewPosition().getX(), (int) to);

        //set the point to the viewport
        //here is where the movement it's done
        pane.getViewport().setViewPosition(after);
    }
}
