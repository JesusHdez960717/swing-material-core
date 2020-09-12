package com.jhw.swing.material.components.clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D.Float;
import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.Timer;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.interfaces.MaterialComponent;

public class _ClockFace1123123 extends JComponent implements MaterialComponent {

    public static _ClockFace1123123 from() {
        return new _ClockFace1123123();
    }

    public static int FPS = 60;
    private Stroke border;
    private Stroke hourHand;
    private Stroke minuteHand;
    private boolean romano = true;
    private Stroke secondHand;
    private Stroke ticks;

    protected _ClockFace1123123() {
        setPreferredSize(new Dimension(150, 150));
        setSize(new Dimension(150, 150));
        setOpaque(false);
        Timer timer = new Timer(1000 / FPS, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _ClockFace1123123.this.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private String getRomanNumeral(int number) {
        switch (number) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 11:
                return "XI";
            default:
                return "XII";
        }
    }

    private String getGregorianNumeral(int number) {
        switch (number) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "11";
            default:
                return "12";
        }
    }

    public boolean isRomano() {
        return this.romano;
    }

    public void setRomano(boolean romano) {
        this.romano = romano;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        paintFace(graphics, Math.min(getWidth(), getHeight()));
    }

    protected void paintFace(Graphics graphics, int size) {
        int i;
        Point center = new Point(size / 2, size / 2);
        int radius = center.x;
        int margin = radius / 20;
        int w = size;

        this.border = new BasicStroke(Math.max(1.0f, ((float) w) / 150.0f), 1, 1);
        this.secondHand = new BasicStroke(Math.max(1.0f, ((float) w) / 75.0f), 1, 1);
        this.minuteHand = new BasicStroke(Math.max(1.0f, ((float) w) / 38.0f), 1, 1);
        this.hourHand = new BasicStroke(Math.max(1.5f, ((float) w) / 20.0f), 1, 1);
        this.ticks = new BasicStroke(1.0f);

        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(graphics);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        Color bg = getBackground();
        g2.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue()));
        g2.fill(new Float(0.0f, 0.0f, (float) size, (float) size));

        g2.setFont(getFont().deriveFont(1, (float) (size / 12)));
        g2.setColor(new Color(0, 0, 0, 128));
        g2.setStroke(this.border);
        g2.draw(new Float(0.0f, 0.0f, (float) (size - 1), (float) (size - 1)));
        g2.draw(new Float((float) margin, (float) margin, (float) ((size - (margin * 2)) - 1), (float) ((size - (margin * 2)) - 1)));

        Calendar c = Calendar.getInstance();
        int minute = c.get(12);
        int hour = c.get(10);
        int second = c.get(13);
        g2.translate(center.x, center.y);
        g2.setColor(getForeground());

        int numbers = (radius * 3) / 4;
        int max = 5;
        for (i = 0; i < max; i++) {
            double theta = (6.283185307179586d * ((double) (i + (2d + (max) * 1.75d)) % max)) / (double) max;
            String str = getRomanNumeral(((i + 2) % max) + 1);
            if (this.romano) {
                str = getRomanNumeral(((i + 2) % max) + 1);
            } else {
                str = getGregorianNumeral(((i + 2) % max) + 1);
            }
            float x = (float) Math.round((((double) numbers) * Math.cos(theta)) - (g2.getFontMetrics().getStringBounds(str, g2).getWidth() / 2.0d));
            float y = (float) Math.round((((double) numbers) * Math.sin(theta)) + ((double) (margin * 2)));
            g2.drawString(str, x, y);
        }

        for (i = 0; i < 60; i++) {
            g2.setColor(getForeground());
            g2.setStroke(this.ticks);
            g2.drawLine(radius - (margin * 2), 0, radius - margin, 0);
            if (i % 5 == 0) {
                g2.drawLine(radius - (margin * 3), 0, radius - margin, 0);
            }
            if ((i + 15) % 60 == minute) {
                g2.setStroke(this.minuteHand);
                g2.drawLine(0, 0, radius - (margin * 4), 0);
            }
            if ((i + 15) % 60 == (hour * 5) + ((minute * 5) / 60)) {
                g2.setStroke(this.hourHand);
                g2.drawLine(0, 0, radius / 2, 0);
            }
            if ((i + 15) % 60 == second) {
                g2.setColor(new Color(255, 0, 0, 128));
                g2.setStroke(this.secondHand);
                g2.drawLine(0, 0, radius - (margin * 4), 0);
            }
            g2.rotate(0.10471975511965977d);
        }
        g2.dispose();
    }
}
