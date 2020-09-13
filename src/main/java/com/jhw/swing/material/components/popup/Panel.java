/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button.MaterialButtonIcon;
import com.jhw.swing.material.components.button.MaterialButtonsFactory;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.util.MaterialDrawingUtils;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Panel extends JPanel {

    protected final MaterialShadow shadowFast = new MaterialShadow();
    private Component selectedComp = null;

    @Override
    public Component add(Component comp) {
        super.add(comp);
        addListenerComponent(comp);
        return comp;
    }

    private void addListenerComponent(Component comp) {
        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                selectedComp = comp;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selectedComp = null;
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int shadowW = (int) sizee() - margin();
        g2.drawImage(shadowFast.render(shadowW, shadowW, 5, 2, MaterialShadow.Type.CIRCULAR), margin() / 2, margin() / 2, null);

        /*if (selectedComp != null) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2.setColor(MaterialColors.GREY_50);

            Point mid = new Point(sizee() / 2, sizee() / 2);
            int x = selectedComp.getLocation().x;
            int y = selectedComp.getLocation().y;
            Point p1 = new Point(x, y);
            Point p2 = new Point(x + 10, y);
            g2.fillPolygon(new int[]{mid.x, p1.x, p2.x}, new int[]{mid.y, p1.y, p2.y}, 3);
        }*/
    }

    public void setUpActions(List<JComponent> components, int size) {
        adjustSize(components, size);
        //this.setBorder(new LineBorder(Color.red, 3));//test
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);
        //panel.setBackground(MaterialColors.YELLOW_200);//test
        this.setLayout(null);

        Point center = new Point(sizee() / 2, sizee() / 2);
        int radius = center.x;

        int numbers = (int) ((radius) * .75f);
        int max = components.size();
        for (int i = 0; i < max; i++) {
            JComponent btn = components.get(i);
            double theta = (6.283185307179586d * ((double) (i + max * .75d))) / (double) max;
            float x = (float) Math.round((((double) numbers) * Math.cos(theta)) - (size / 2.0d));
            float y = (float) Math.round((((double) numbers) * Math.sin(theta)) - (size / 2.0d));

            this.add(btn);
            btn.setSize(btn.getPreferredSize());
            btn.setLocation((int) x + sizee() / 2, (int) y + sizee() / 2);
        }

    }

    private int sizee() {
        return (int) Math.min(this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight());
    }

    private int margin() {
        return sizee() / 20;
    }

    /**
     * Ajusta el tamaño de todos los compoenntes asi como el panel en general
     * proporcionalmente a la cantidad de compoenntes.
     *
     * @param components
     * @param size
     */
    private void adjustSize(List<JComponent> components, int size) {
        if (components.isEmpty()) {
            this.setPreferredSize(new Dimension(50, 50));
        }
        for (JComponent component : components) {
            component.setPreferredSize(new Dimension(size, size));
        }
        int total = (int) ((double) (size * 3.45d));
        if (components.size() > 6) {
            total += (components.size() - 6) * 0.75 * size;
        }
        this.setPreferredSize(new Dimension(total, total));
    }
}
