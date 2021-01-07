package com.root101.swing.material.components.taskpane;

import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.util.MaterialDrawingUtils;
import com.root101.swing.util.interfaces.MaterialComponent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import com.root101.swing.material.standards.MaterialColors;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class TaskButton extends JButton implements MaterialComponent {

    public static TaskButton from() {
        return MaterialSwingInjector.getImplementation(TaskButton.class);
    }

    private boolean selected = false;
    private Color selectedColor = MaterialColors.BLUE_200;
    private Color deselectedColor = MaterialColors.BLUE_800;
    private Color mauseOverColor = MaterialColors.BLUE_800;

    protected TaskButton(Action a, CollapseMenu parent) {
        setAction(a);

        if (getToolTipText() != null && getToolTipText().isEmpty()) {
            this.setToolTipText((String) a.getValue(Action.NAME));
        }

        setPreferredSize(parent.getjPanelFixed().getPreferredSize());
        setHorizontalAlignment(SwingConstants.LEADING);

        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setIconTextGap(20);
        //selecciona y avisa
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.childSelected();
                select();
            }
        });

        //color cuando el mouse pasa por arriba
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!selected) {
                    setBackground(mauseOverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!selected) {
                    setBackground(deselectedColor);
                }
            }
        });
    }

    public Color getMauseOverColor() {
        return mauseOverColor;
    }

    public void setMauseOverColor(Color mauseOverColor) {
        this.mauseOverColor = mauseOverColor;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Color getDeselectedColor() {
        return deselectedColor;
    }

    public void setDeselectedColor(Color deselectedColor) {
        this.deselectedColor = deselectedColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        super.paintComponent(g2);
        if (selected) {
            int yMid = getSize().height / 2;
            ImageIcon icon = MaterialIcons.ARROW_DROP_RIGHT.deriveIcon(getForeground());
            icon.paintIcon(this, g2, (int) (this.getSize().getWidth() - getIcon().getIconHeight()), yMid - icon.getIconHeight() / 2);
        }
    }

    public void select() {
        selected = true;
        setBackground(selectedColor);
        repaint();
    }

    public void deselect() {
        selected = false;
        setBackground(deselectedColor);
        repaint();
    }
}
