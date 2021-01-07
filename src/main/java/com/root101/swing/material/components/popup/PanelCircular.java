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
package com.root101.swing.material.components.popup;

import com.root101.swing.material.standards.FastGaussianBlur;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialShadow;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.utils.others.Pair;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class PanelCircular extends JPanel {

    //para la sombra de background
    protected final MaterialShadow shadowFast = new MaterialShadow();

    //para la sombra cuando le paso por arriba a cada component
    private Component selectedComp = null;

    public PanelCircular(List<JComponent> components, int eachComponentSize) {
        setUpComponents(components, eachComponentSize);
    }

    private Component addInner(Component comp) {
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

        int border = 5;
        int elevation = 2;
        int margin = margin();
        int shadowW = (int) sizee() - margin;

        //transparencia de la sombra general
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));

        g2.drawImage(shadowFast.render(shadowW, shadowW, border, elevation, MaterialShadow.Type.CIRCULAR), margin / 2, margin / 2, null);

        if (selectedComp != null) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2.drawImage(getTriangleShadow(), 0, 0, null);
        }

        g2.setColor(MaterialColors.WHITE);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        float w = 10;
        g2.fill(new java.awt.geom.Ellipse2D.Float((sizee() - w) / 2, (sizee() - w) / 2, w, w));

        w += 10;
        g2.setStroke(new BasicStroke(2));
        g2.draw(new java.awt.geom.Ellipse2D.Float((sizee() - w) / 2, (sizee() - w) / 2, w, w));

    }

    private BufferedImage getTriangleShadow() {
        BufferedImage bf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(bf.createGraphics());
        g2.setColor(MaterialColors.GREY_50);

        Point mid = new Point(sizee() / 2, sizee() / 2);
        Pair<Point> p = getPointsSelected();
        g2.fillPolygon(new int[]{mid.x, p.getA().x, p.getB().x}, new int[]{mid.y, p.getA().y, p.getB().y}, 3);

        return FastGaussianBlur.blur(bf, (int) 6, true);
        //return bf;
    }

    private Pair<Point> getPointsSelected() {
        Point mid = new Point(sizee() / 2, sizee() / 2);

        int x = selectedComp.getLocation().x;
        int y = selectedComp.getLocation().y;

        List<Point> four = new ArrayList<>();

        //1er punto, punto donde esta el component, superior izquierdo
        Point p1 = new Point(x, y);
        four.add(p1);

        //2do punto, superior derecho
        Point p2 = new Point((int) (x + selectedComp.getSize().getWidth()), y);
        four.add(p2);

        //3er punto, inferior izquierdo
        Point p3 = new Point(x, (int) (y + selectedComp.getSize().getHeight()));
        four.add(p3);

        //4to punto, inferior derecho
        Point p4 = new Point((int) (x + selectedComp.getSize().getWidth()), (int) (y + selectedComp.getSize().getHeight()));
        four.add(p4);

        Collections.sort(four, (Point o1, Point o2) -> Double.compare(o1.distance(mid), o2.distance(mid)));

        //si son los de los 4 ptos cardinales cogo los 2 mas cerca
        if (Math.abs(four.get(0).distance(mid) - four.get(1).distance(mid)) < 1) {
            return new Pair<>(four.get(0), four.get(1));
        }
        //si no, cogo los 2 del medio
        return new Pair<>(four.get(1), four.get(2));
    }

    private void setUpComponents(List<JComponent> components, int size) {
        adjustSize(components, size);

        //this.setBorder(new LineBorder(Color.red, 3));//test
        this.setBackground(MaterialColors.TRANSPARENT);
        this.setOpaque(false);
        //panel.setBackground(MaterialColors.YELLOW_200);//test
        this.setLayout(null);

        int sizee = sizee();
        Point center = new Point(sizee / 2, sizee / 2);
        int radius = center.x;

        int numbers = (int) ((radius) * .75f);
        int max = components.size();
        for (int i = 0; i < max; i++) {
            JComponent btn = components.get(i);
            double theta = (6.283185307179586d * ((double) (i + max * .75d))) / (double) max;
            float x = (float) Math.round((((double) numbers) * Math.cos(theta)) - (size / 2.0d));
            float y = (float) Math.round((((double) numbers) * Math.sin(theta)) - (size / 2.0d));

            this.addInner(btn);
            btn.setSize(btn.getPreferredSize());
            btn.setLocation((int) x + sizee / 2, (int) y + sizee / 2);
        }

    }

    private int sizee() {
        return (int) Math.min(this.getPreferredSize().getWidth(), this.getPreferredSize().getHeight());
    }

    private int margin() {
        Component c = getComponent(0);
        return (int) (c.getLocation().y + (double) c.getPreferredSize().getHeight() / 3d);
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
        int total = (int) ((double) (size * 4.1d));
        if (components.size() > 6) {
            int increase = (int) ((components.size() - 6) * ((double) size / 2d));
            total += increase;
        }
        this.setPreferredSize(new Dimension(total, total));
    }
}
