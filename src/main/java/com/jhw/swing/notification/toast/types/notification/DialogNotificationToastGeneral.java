package com.jhw.swing.notification.toast.types.notification;

import com.jhw.swing.notification.toast.DialogToast;
import static com.jhw.swing.notification.toast.ToastDisplayer.DURATION;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.util.SafePropertySetter;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DialogNotificationToastGeneral extends DialogToast {

    public static final int DISTANCE = 65;

    private Animator anim;

    private static final ArrayList<DialogNotificationToastGeneral> notif = new ArrayList<>();

    private int nextY = 0;

    public DialogNotificationToastGeneral(int duration, String text, ImageIcon icon, Color back) {
        super(duration, new NotificationToast(text, icon, back));

        nextY = getYPosition() - (int) super.getSize().getHeight();
        this.setLocation(0, nextY);

        this.setActionListenerClose(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeNotif();
            }
        });

        notif.add(this);

        this.setVisible(true);
    }

    private void closeNotif() {
        notif.remove(this);
        moveAll(this);
    }

    private int getYPosition() {
        int pos = Toolkit.getDefaultToolkit().getScreenSize().height - DISTANCE;
        for (DialogNotificationToastGeneral act : notif) {
            pos -= act.getHeight();
        }
        return pos;
    }

    private static void moveAll(DialogNotificationToastGeneral actual) {
        for (DialogNotificationToastGeneral act : notif) {
            if (act.getLocation().getY() < actual.getLocation().getY()) {
                act.moveAmount((int) (actual.getSize().getHeight()));
            }
        }
    }

    private void moveAmount(int y) {
        nextY += y;
        if (anim != null) {
            anim.cancel();
        }
        anim = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(DURATION, TimeUnit.MILLISECONDS)
                .setInterpolator(new SplineInterpolator(0.1, 0.3, 0.45, 1))
                .addTarget(SafePropertySetter.getTarget(new SafePropertySetter.Setter<Integer>() {
                    @Override
                    public void setValue(Integer value) {
                        if (value != null) {
                            setLocation(getLocation().x, value);//mantiene x y mueve y
                        }
                    }
                }, getLocation().y, nextY)).build();
        anim.start();
    }

}
