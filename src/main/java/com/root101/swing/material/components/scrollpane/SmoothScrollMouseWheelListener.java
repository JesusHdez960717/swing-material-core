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

import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JScrollPane;
import org.jdesktop.core.animation.timing.Animator;
import com.root101.swing.util.Utils;
import com.root101.swing.ui.utils.MaterialManagerListener;
import com.root101.swing.util.SafePropertySetter;
import com.root101.module.util.personalization.core.domain.Personalization;
import com.root101.module.util.personalization.services.PersonalizationHandler;

/**
 * Class to add a smoot movement to a JScrollPane.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
        move();
    }

    /**
     * Do the scroll animated
     */
    private void move() {
        if (anim != null) {//if anim running stop it
            anim.cancel();
        }
        if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_ANIMATIONS)) {
            doAnimatedMove();
        } else {
            doMove(nextPosition);//move to the next position
        }
    }

    /**
     * Move the viewport to the next position.
     *
     * @param to The next position to move the scroll.
     */
    private void doMove(double to) {
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

    private void doAnimatedMove() {
        anim = new Animator.Builder(Utils.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                //.setInterpolator(new SplineInterpolator(0.55, 0, 0.9, 0.7))//comented for linear interpolation
                .addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Integer>() {
                    @Override
                    public void setValue(Integer value) {
                        if (value != null) {
                            doMove(value);//move to the next position
                        }
                    }
                }, (int) pane.getViewport().getViewPosition().getY(), (int) nextPosition))
                .build();
        anim.start();
    }
}
