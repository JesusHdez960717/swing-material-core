/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples;

import com.jhw.swing.bundles.dnd.DragHandler;
import com.jhw.swing.bundles.dnd.DropHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class EXAMPLE_DRAG_DROP_PANELS implements Serializable {

    public static void main(String[] args) {
        new EXAMPLE_DRAG_DROP_PANELS();
    }

    public EXAMPLE_DRAG_DROP_PANELS() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    //Back panel that contain the blue end green
    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridLayout(1, 2));

            JPanel container = new OutterPane();

            DragPane drag = new DragPane();
            container.add(drag);

            add(container);
            add(new DropPane());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    //Rojo, el que se va a arrastrar
    public class DragPane extends JPanel {

        public DragPane() {
            System.out.println("DragPane = " + this.hashCode());
            setBackground(Color.RED);
            DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, new DragHandler(this));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }

    }

    //azul, donde se suelta
    public class DropPane extends JPanel {

        DropTarget dropTarget;
        DropHandler dropHandler;

        public DropPane() {
            setBackground(Color.BLUE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        public void addNotify() {
            super.addNotify(); //To change body of generated methods, choose Tools | Templates.
            dropHandler = new DropHandler();
            dropTarget = new DropTarget(this, DnDConstants.ACTION_MOVE, dropHandler, true);
        }

        @Override
        public void removeNotify() {
            super.removeNotify(); //To change body of generated methods, choose Tools | Templates.
            dropTarget.removeDropTargetListener(dropHandler);
        }
    }

    //verde, donde inicia, se le agrego tanquien que se 'drop' aqui
    public class OutterPane extends JPanel {

        DropTarget dropTarget;
        DropHandler dropHandler;

        public OutterPane() {
            setBackground(Color.GREEN);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        public void addNotify() {
            super.addNotify(); //To change body of generated methods, choose Tools | Templates.
            dropHandler = new DropHandler();
            dropTarget = new DropTarget(this, DnDConstants.ACTION_MOVE, dropHandler, true);
        }

        @Override
        public void removeNotify() {
            super.removeNotify(); //To change body of generated methods, choose Tools | Templates.
            dropTarget.removeDropTargetListener(dropHandler);
        }
    }

}
