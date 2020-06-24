package com.jhw.swing.material.components.container.panels;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import com.jhw.swing.util.MaterialDrawingUtils;
import com.jhw.swing.util.AvatarPanelAvatarChooser;
import com.jhw.swing.util.interfaces.MaterialComponent;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.material.standars.MaterialImages;

/**
 * Componente extraido su logica de edisoncorSX.
 */
public class _PanelAvatarChooser extends _PanelGradient implements MaterialComponent {

    private static final double ANIM_SCROLL_DELAY = 450.0d;
    private float alphaLevel = 0.0f;
    private int avatarAmount = 5;
    private int avatarIndex;
    private double avatarPosition = 0.0d;
    private AvatarScroller avatarScroller;
    private double avatarSpacing = 0.4d;
    private List<AvatarPanelAvatarChooser> avatars = null;
    private CursorChanger cursorChanger;
    private boolean damaged = true;
    private DrawableAvatar[] drawableAvatars;
    private double exp_member;
    private double exp_multiplier;
    private Timer faderTimer = null;
    private FocusGrabber focusGrabber;
    private KeyScroller keyScroller;
    private boolean loadingDone = false;
    private double rho;
    private Timer scrollerTimer = null;
    private double sigma;
    private float textAlphaLevel = 0.0f;
    private List<String> titulos = new ArrayList();
    private final float veilAlphaLevel = 0.0f;
    private MouseWheelScroller wheelScroller;

    private class AutoScroller implements ActionListener {

        private final int index;
        private final double position;
        private final long start;

        private AutoScroller(DrawableAvatar avatar) {
            this.index = avatar.getIndex();
            this.position = avatar.getPosition();
            this.start = System.currentTimeMillis();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long elapsed = System.currentTimeMillis() - this.start;
            if (((double) elapsed) < 225.0d) {
                _PanelAvatarChooser.this.textAlphaLevel = (float) (1.0d - (2.0d * (((double) elapsed) / _PanelAvatarChooser.ANIM_SCROLL_DELAY)));
            } else {
                _PanelAvatarChooser.this.textAlphaLevel = (float) (((((double) elapsed) / _PanelAvatarChooser.ANIM_SCROLL_DELAY) - 0.5d) * 2.0d);
                if (_PanelAvatarChooser.this.textAlphaLevel > 1.0f) {
                    _PanelAvatarChooser.this.textAlphaLevel = 1.0f;
                }
            }
            if (_PanelAvatarChooser.this.textAlphaLevel < 0.1f) {
                _PanelAvatarChooser.this.textAlphaLevel = 0.1f;
            }
            double newPosition = (((double) elapsed) / _PanelAvatarChooser.ANIM_SCROLL_DELAY) * (-this.position);
            if (((double) elapsed) >= _PanelAvatarChooser.ANIM_SCROLL_DELAY) {
                ((Timer) e.getSource()).stop();
                _PanelAvatarChooser.this.setAvatarIndex(this.index);
                _PanelAvatarChooser.this.setPosition(0.0d);
                return;
            }
            _PanelAvatarChooser.this.setPosition(newPosition);
        }
    }

    private class AvatarScroller extends MouseAdapter {

        private AvatarScroller() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (_PanelAvatarChooser.this.faderTimer != null && _PanelAvatarChooser.this.faderTimer.isRunning()) {
                return;
            }
            if ((_PanelAvatarChooser.this.scrollerTimer == null || !_PanelAvatarChooser.this.scrollerTimer.isRunning()) && _PanelAvatarChooser.this.drawableAvatars != null && e.getButton() == 1) {
                DrawableAvatar avatar = _PanelAvatarChooser.this.getHitAvatar(e.getX(), e.getY());
                if (avatar != null && avatar.getIndex() != _PanelAvatarChooser.this.avatarIndex) {
                    _PanelAvatarChooser.this.scrollAndAnimate(avatar);
                }
            }
        }
    }

    private class CursorChanger extends MouseMotionAdapter {

        private CursorChanger() {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if ((_PanelAvatarChooser.this.scrollerTimer != null && _PanelAvatarChooser.this.scrollerTimer.isRunning()) || _PanelAvatarChooser.this.drawableAvatars == null) {
                return;
            }
            if (_PanelAvatarChooser.this.getHitAvatar(e.getX(), e.getY()) != null) {
                _PanelAvatarChooser.this.getParent().setCursor(Cursor.getPredefinedCursor(12));
            } else {
                _PanelAvatarChooser.this.getParent().setCursor(Cursor.getPredefinedCursor(0));
            }
        }
    }

    private class DamageManager extends ComponentAdapter {

        private DamageManager() {
        }

        @Override
        public void componentResized(ComponentEvent e) {
            _PanelAvatarChooser.this.damaged = true;
        }
    }

    private class DrawableAvatar implements Comparable {

        private final int height;
        private final int index;
        private final double position;
        private final int width;
        private final double x;
        private final double y;
        private final double zOrder;

        private DrawableAvatar(int index, double x, double y, int width, int height, double position, double zOrder) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.position = position;
            this.zOrder = zOrder;
        }

        @Override
        public int compareTo(Object o) {
            double zOrder2 = ((DrawableAvatar) o).zOrder;
            if (this.zOrder < zOrder2) {
                return -1;
            }
            if (this.zOrder > zOrder2) {
                return 1;
            }
            return 0;
        }

        public double getPosition() {
            return this.position;
        }

        public double getAlpha() {
            return this.zOrder * ((double) _PanelAvatarChooser.this.alphaLevel);
        }

        public int getHeight() {
            return this.height;
        }

        public int getIndex() {
            return this.index;
        }

        public int getWidth() {
            return this.width;
        }

        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }
    }

    private class FaderAction implements ActionListener {

        private long start;

        private FaderAction() {
            this.start = 0;
            _PanelAvatarChooser.this.alphaLevel = 0.0f;
            _PanelAvatarChooser.this.textAlphaLevel = 0.0f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.start == 0) {
                this.start = System.currentTimeMillis();
            }
            _PanelAvatarChooser.this.alphaLevel = ((float) (System.currentTimeMillis() - this.start)) / 500.0f;
            _PanelAvatarChooser.this.textAlphaLevel = _PanelAvatarChooser.this.alphaLevel;
            if (_PanelAvatarChooser.this.alphaLevel > 1.0f) {
                _PanelAvatarChooser.this.alphaLevel = 1.0f;
                _PanelAvatarChooser.this.textAlphaLevel = 1.0f;
                _PanelAvatarChooser.this.faderTimer.stop();
            }
            _PanelAvatarChooser.this.repaint();
        }
    }

    private class FocusGrabber extends MouseAdapter {

        private FocusGrabber() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            _PanelAvatarChooser.this.requestFocus();
        }
    }

    private class KeyScroller extends KeyAdapter {

        private KeyScroller() {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 33:
                    _PanelAvatarChooser.this.scrollAndAnimateBy((-_PanelAvatarChooser.this.avatarAmount) / 2);
                    return;
                case 34:
                    _PanelAvatarChooser.this.scrollAndAnimateBy(_PanelAvatarChooser.this.avatarAmount / 2);
                    return;
                case 35:
                    _PanelAvatarChooser.this.scrollBy((_PanelAvatarChooser.this.avatars.size() - _PanelAvatarChooser.this.avatarIndex) - 1);
                    return;
                case 36:
                    _PanelAvatarChooser.this.scrollBy((-_PanelAvatarChooser.this.avatarIndex) - 1);
                    return;
                case 37:
                case 38:
                    _PanelAvatarChooser.this.scrollAndAnimateBy(-1);
                    return;
                case 39:
                case 40:
                    _PanelAvatarChooser.this.scrollAndAnimateBy(1);
                    return;
                default:
            }
        }
    }

    private class MouseWheelScroller implements MouseWheelListener {

        private MouseWheelScroller() {
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            _PanelAvatarChooser.this.scrollAndAnimateBy(e.getWheelRotation());
        }
    }

    public _PanelAvatarChooser() {
        setAvatars(getSampleAvatar());
        setSigma(0.5d);
        addComponentListener(new DamageManager());
        initInputListeners();
        addInputListeners();
        setAvatarIndex(0);
    }

    public void setAmount(int amount) {
        if (amount > this.avatars.size()) {
            throw new IllegalArgumentException("muchos avatars");
        } else if (amount < 5) {
            throw new IllegalArgumentException("5 avatars minimo");
        }
        this.avatarAmount = amount;
        repaint();
    }

    void setPosition(double position) {
        this.avatarPosition = position;
        this.damaged = true;
        repaint();
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
        this.rho = 1.0d;
        computeEquationParts();
        this.rho = computeModifierUnprotected(0.0d);
        computeEquationParts();
        this.damaged = true;
        repaint();
    }

    public void setSpacing(double avatarSpacing) {
        if (avatarSpacing < 0.0d || avatarSpacing > 1.0d) {
            throw new IllegalArgumentException("El espacio debe ser  < 1.0 y > 0.0");
        }
        this.avatarSpacing = avatarSpacing;
        this.damaged = true;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(384, 256);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFocusable() {
        return true;
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        Composite oldComposite = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(3, this.veilAlphaLevel));
        super.paintChildren(g2);
        g2.setComposite(oldComposite);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        super.paintComponent(g2);
        if (this.loadingDone || this.faderTimer != null) {
            Insets insets = getInsets();
            int x = insets.left;
            int y = insets.top;
            int width = (getWidth() - insets.left) - insets.right;
            int height = (getHeight() - insets.top) - insets.bottom;
            Composite oldComposite = g2.getComposite();
            if (this.damaged) {
                this.drawableAvatars = sortAvatarsByDepth(x, y, width, height);
                this.damaged = false;
            }
            drawAvatars(g2, this.drawableAvatars);
            if (this.drawableAvatars.length > 0) {
                drawAvatarName(g2);
            }
            g2.setComposite(oldComposite);
        }
    }

    private void drawAvatars(Graphics2D g2, DrawableAvatar[] drawableAvatars) {
        for (DrawableAvatar avatar : drawableAvatars) {
            g2.setComposite(AlphaComposite.getInstance(3, (float) avatar.getAlpha()));
            g2.drawImage(((AvatarPanelAvatarChooser) this.avatars.get(avatar.getIndex())).getImage(), (int) avatar.getX(), (int) avatar.getY(), avatar.getWidth(), avatar.getHeight(), null);
        }
    }

    public int getAvatarIndex() {
        return this.avatarIndex;
    }

    private DrawableAvatar[] sortAvatarsByDepth(int x, int y, int width, int height) {
        List<DrawableAvatar> drawables = new LinkedList();
        for (int i = 0; i < this.avatars.size(); i++) {
            promoteAvatarToDrawable(drawables, x, y, width, height, i - this.avatarIndex);
        }
        DrawableAvatar[] drawableAvatares = (DrawableAvatar[]) drawables.toArray(new DrawableAvatar[drawables.size()]);
        Arrays.sort(drawableAvatares);
        return drawableAvatares;
    }

    private void drawAvatarName(Graphics2D g2) {
        Composite composite = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(3, this.textAlphaLevel));
        double y = (((double) (getHeight() - 164)) / 2.0d) - (1.4d * 30.0d);
        drawAvatarBullet(g2, (((double) getWidth()) - 150.0d) / 2.0d, y, 150.0d, 30.0d);
        drawAvatarText(g2, y, 30.0d);
        g2.setComposite(composite);
    }

    public List<String> getTitulos() {
        return this.titulos;
    }

    public void setTitulos(List<String> titulos) {
        this.titulos = titulos;
    }

    private String getTextoAvatar() {
        try {
            return ((AvatarPanelAvatarChooser) this.avatars.get(this.avatarIndex)).getTitulo();
        } catch (Exception e) {
            return "Avatar " + (this.avatarIndex + 1);
        }
    }

    public AvatarPanelAvatarChooser getSelectedAvatar() {
        return (AvatarPanelAvatarChooser) getAvatars().get(this.avatarIndex);
    }

    public String getSelectedTitulo() {
        try {
            return ((AvatarPanelAvatarChooser) getAvatars().get(this.avatarIndex)).getTitulo();
        } catch (Exception e) {
            return "Avatar " + (this.avatarIndex + 1);
        }
    }

    private void drawAvatarText(Graphics2D g2, double y, double bulletHeight) {
        FontRenderContext context = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(getTextoAvatar(), new Font("Dialog", 0, 18), context);
        float text_x = (float) ((((double) getWidth()) - layout.getBounds().getWidth()) / 2.0d);
        float text_y = (((float) ((((bulletHeight - ((double) layout.getAscent())) - ((double) layout.getDescent())) / 2.0d) + y)) + layout.getAscent()) - layout.getLeading();
        g2.setColor(Color.BLACK);
        layout.draw(g2, text_x, 1.0f + text_y);
        g2.setColor(Color.WHITE);
        layout.draw(g2, text_x, text_y);
    }

    private void drawAvatarBullet(Graphics2D g2, double x, double y, double bulletWidth, double bulletHeight) {
        RoundRectangle2D bullet = new Double(0.0d, 0.0d, bulletWidth, bulletHeight, bulletHeight, bulletHeight);
        Ellipse2D curve = new Ellipse2D.Double(-20.0d, bulletHeight / 2.0d, 40.0d + bulletWidth, bulletHeight);
        g2.translate(x, y);
        g2.translate(-1, -2);
        g2.setColor(new Color(0, 0, 0, 170));
        g2.fill(new Double(0.0d, 0.0d, bulletWidth + 2.0d, 4.0d + bulletHeight, 4.0d + bulletHeight, 4.0d + bulletHeight));
        g2.translate(1, 2);
        Color startColor = new Color(10, 0, 40);
        Color endColor = new Color(175, 165, 225);
        Paint paint = g2.getPaint();
        g2.setPaint(new GradientPaint(0.0f, 0.0f, startColor, 0.0f, (float) bulletHeight, endColor));
        g2.fill(bullet);
        Graphics2D graphics2D = g2;
        graphics2D.setPaint(new GradientPaint(0.0f, 0.0f, new Color(5, 0, 50), 0.0f, (float) bulletHeight, new Color(105, 100, 155)));
        Area area = new Area(bullet);
        area.intersect(new Area(curve));
        g2.fill(area);
        g2.setPaint(paint);
        g2.translate(-x, -y);
    }

    private void promoteAvatarToDrawable(List<DrawableAvatar> drawables, int x, int y, int width, int height, int offset) {
        double avatarPosicion = this.avatarPosition + (((double) offset) * this.avatarSpacing);
        if (this.avatarIndex + offset >= 0 && this.avatarIndex + offset < this.avatars.size()) {
            Image avatar = ((AvatarPanelAvatarChooser) this.avatars.get(this.avatarIndex + offset)).getImage();
            int avatarWidth = avatar.getWidth(null);
            int avatarHeight = avatar.getHeight(null);
            double result = computeModifier(avatarPosicion);
            int newWidth = (int) (((double) avatarWidth) * result);
            if (newWidth != 0) {
                int newHeight = (int) (((double) avatarHeight) * result);
                if (newHeight != 0) {
                    double avatar_y = ((double) y) + ((((double) height) - (((double) newHeight) / 2.0d)) / 2.0d);
                    double avatar_x = (((double) x) + (((double) (width - newWidth)) / 2.0d)) + (avatarPosicion * (((double) width) / 2.0d));
                    if (avatar_x < ((double) width) && avatar_x >= ((double) (-newWidth))) {
                        List<DrawableAvatar> list = drawables;
                        list.add(new DrawableAvatar(this.avatarIndex + offset, avatar_x, avatar_y, newWidth, newHeight, avatarPosicion, result));
                    }
                }
            }
        }
    }

    private void startFader() {
        this.faderTimer = new Timer(35, new FaderAction());
        this.faderTimer.start();
    }

    private void computeEquationParts() {
        this.exp_multiplier = (Math.sqrt(6.283185307179586d) / this.sigma) / this.rho;
        this.exp_member = (4.0d * this.sigma) * this.sigma;
    }

    double computeModifier(double x) {
        double result = computeModifierUnprotected(x);
        if (result > 1.0d) {
            return 1.0d;
        }
        if (result < -1.0d) {
            return -1.0d;
        }
        return result;
    }

    private double computeModifierUnprotected(double x) {
        return this.exp_multiplier * Math.exp(((-x) * x) / this.exp_member);
    }

    private void addInputListeners() {
        addMouseListener(this.focusGrabber);
        addMouseListener(this.avatarScroller);
        addMouseMotionListener(this.cursorChanger);
        addMouseWheelListener(this.wheelScroller);
        addKeyListener(this.keyScroller);
    }

    private void initInputListeners() {
        this.focusGrabber = new FocusGrabber();
        this.avatarScroller = new AvatarScroller();
        this.cursorChanger = new CursorChanger();
        this.wheelScroller = new MouseWheelScroller();
        this.keyScroller = new KeyScroller();
    }

    private void removeInputListeners() {
        removeMouseListener(this.focusGrabber);
        removeMouseListener(this.avatarScroller);
        removeMouseMotionListener(this.cursorChanger);
        removeMouseWheelListener(this.wheelScroller);
        removeKeyListener(this.keyScroller);
    }

    private List<AvatarPanelAvatarChooser> getSampleAvatar() {
        List<AvatarPanelAvatarChooser> avatares = new ArrayList();

        avatares.add(new AvatarPanelAvatarChooser("Imagen 1", MaterialIcons.TEC_ADOBE.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("Imagen 2", MaterialIcons.TEC_FLATICON.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("Imagen 3", MaterialIcons.TEC_FREEPICK.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("Imagen 4", MaterialIcons.TEC_GITHUB.getImage()));
        avatares.add(new AvatarPanelAvatarChooser("Imagen 5", MaterialIcons.TEC_XAMPP.getImage()));

        return avatares;
    }

    public void setAvatars(List<AvatarPanelAvatarChooser> avatares) {
        //setAmount(avatares.size());
        this.avatars = new ArrayList();
        int j = 0;
        for (AvatarPanelAvatarChooser avatar : avatares) {
            this.avatars.add(new AvatarPanelAvatarChooser(avatar.getId(), avatar.getTitulo(), createReflectedPicture((BufferedImage) avatar.getImage())));
            if (j == (avatares.size() / 2) + (this.avatarAmount / 2)) {
                setAvatarIndex(j - (this.avatarAmount / 2));
                startFader();
            }
            j++;
        }
        this.loadingDone = true;
        setAvatarIndex(0);
    }

    public List<AvatarPanelAvatarChooser> getAvatars() {
        return this.avatars;
    }

    public void setAvatarIndex(int index) {
        if (index >= this.avatars.size()) {
            throw new IllegalArgumentException("Invalid avatar index.");
        }
        this.avatarIndex = index;
    }

    private void scrollBy(int increment) {
        if (this.loadingDone) {
            setAvatarIndex(this.avatarIndex + increment);
            if (this.avatarIndex < 0) {
                setAvatarIndex(0);
            } else if (this.avatarIndex >= this.avatars.size()) {
                setAvatarIndex(this.avatars.size() - 1);
            }
            this.damaged = true;
            repaint();
        }
    }

    private void scrollAndAnimateBy(int increment) {
        if (!this.loadingDone) {
            return;
        }
        if (this.scrollerTimer == null || !this.scrollerTimer.isRunning()) {
            int index = this.avatarIndex + increment;
            if (index < 0) {
                index = 0;
            } else if (index >= this.avatars.size()) {
                index = this.avatars.size() - 1;
            }
            DrawableAvatar drawable = null;
            for (DrawableAvatar avatar : this.drawableAvatars) {
                if (avatar.index == index) {
                    drawable = avatar;
                    break;
                }
            }
            if (drawable != null) {
                scrollAndAnimate(drawable);
            }
        }
    }

    private void scrollAndAnimate(DrawableAvatar avatar) {
        if (this.loadingDone) {
            this.scrollerTimer = new Timer(10, new AutoScroller(avatar));
            this.scrollerTimer.start();
        }
    }

    private BufferedImage createReflectedPicture(BufferedImage avatar) {
        return createReflectedPicture(avatar, createGradientMask(avatar.getWidth(), avatar.getHeight()));
    }

    private BufferedImage createReflectedPicture(BufferedImage avatar, BufferedImage alphaMask) {
        int avatarWidth = avatar.getWidth();
        int avatarHeight = avatar.getHeight();
        BufferedImage buffer = createReflection(avatar, avatarWidth, avatarHeight);
        applyAlphaMask(buffer, alphaMask, avatarWidth, avatarHeight);
        return buffer;
    }

    private void applyAlphaMask(BufferedImage buffer, BufferedImage alphaMask, int avatarWidth, int avatarHeight) {
        Graphics2D g2 = buffer.createGraphics();
        g2.setComposite(AlphaComposite.DstOut);
        g2.drawImage(alphaMask, null, 0, avatarHeight);
        g2.dispose();
    }

    private BufferedImage createReflection(BufferedImage avatar, int avatarWidth, int avatarHeight) {
        BufferedImage buffer = new BufferedImage(avatarWidth, avatarHeight << 1, 2);
        Graphics2D g = buffer.createGraphics();
        g.drawImage(avatar, null, null);
        g.translate(0, avatarHeight << 1);
        g.drawImage(avatar, AffineTransform.getScaleInstance(1.0d, -1.0d), null);
        g.translate(0, -(avatarHeight << 1));
        g.dispose();
        return buffer;
    }

    private BufferedImage createGradientMask(int avatarWidth, int avatarHeight) {
        BufferedImage gradientThis = new BufferedImage(avatarWidth, avatarHeight, 2);
        Graphics2D g = gradientThis.createGraphics();
        g.setPaint(new GradientPaint(0.0f, 0.0f, new Color(1.0f, 1.0f, 1.0f, 0.5f), 0.0f, ((float) avatarHeight) / 2.0f, new Color(1.0f, 1.0f, 1.0f, 1.0f)));
        g.fill(new Rectangle2D.Double(0.0d, 0.0d, (double) avatarWidth, (double) avatarHeight));
        g.dispose();
        return gradientThis;
    }

    private DrawableAvatar getHitAvatar(int x, int y) {
        for (DrawableAvatar avatar : this.drawableAvatars) {
            if (new Rectangle((int) avatar.getX(), (int) avatar.getY(), avatar.getWidth(), avatar.getHeight() / 2).contains(x, y)) {
                return avatar;
            }
        }
        return null;
    }

    private static Image loadImage(String fileName) {
        try (InputStream inputStream = _PanelAvatarChooser.class.getResourceAsStream(fileName)) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Image " + fileName + " wasn't loaded");
        }
    }

}
