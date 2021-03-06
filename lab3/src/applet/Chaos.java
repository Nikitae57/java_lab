package applet;

import shapes.ColoredRect;
import shapes.DrawableRect;
import shapes.MyRectangle;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Random;

public class Chaos extends ColoredRectApplet {

    private final int MAX_WIDTH = 100;
    private final int MIN_WIDTH = 40;
    private final int MAX_HEIGHT = 40;
    private final int MIN_HEIGHT = 10;

    private final int MAX_DELTA = 10;
    private final int MIN_DELTA = -10;
    private final int FRAME_TIME = 20;

    private Random random;
    private Rectangle bounds;
    private ArrayList<MyRectangle> rectangles;

    @Override
    public void init() {
        super.init();
        super.frameTime = FRAME_TIME;
        random = new Random();
        rectangles = new ArrayList<>();
        bounds = getBounds();

        // int number = random.nextInt(max + 1 -min) + min;
        for (int i = 0; i < 10; i++) {
            rectangles.add(new MyRectangle(generateWidth(), generateHeight()));
            rectangles.add(new DrawableRect(generateWidth(), generateHeight(), Color.CYAN));
            rectangles.add(new ColoredRect(generateWidth(), generateHeight(), Color.YELLOW, Color.RED));
        }

        rectangles.forEach(r -> {
            r.setDx(randInRange(MIN_DELTA, MAX_DELTA));
            r.setDy(randInRange(MIN_DELTA, MAX_DELTA));
        });

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                bounds = getBounds();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    /**
     * Move shapes and draw one frame
     */
    public void animate() {

        rectangles.forEach(r -> {
            // Changing x direction
            if ((r.getX1() + r.getDx() < 0) || (r.getX1() + r.getWidth() + r.getDx() > bounds.width)) {
                r.setDx(-r.getDx());
            }

            // Changing y direction
            if ((r.getY1() + r.getDy() < 0) || (r.getY1() + r.getHeight() + r.getDy() > bounds.height)) {
                r.setDy(-r.getDy());
            }

            r.move();
        });

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        rectangles.forEach(r -> r.draw(g));
    }

    /**
     * Returns a number in a provided range including borders and
     * <b>excluding zero</b>
     *
     * @param min minimum possible number
     * @param max maximum possible number
     * @return number in including range between min and max
     */
    private int randInRange(int min, int max) {
        int rnd = random.nextInt(max + 1 - min) + min;
        return rnd != 0 ? rnd : randInRange(min, max);
    }

    /**
     * Generate a width in a range between MIN_WIDTH and MAX_WIDTH
     * @return width of a rectangle
     */
    private int generateWidth() {
        return randInRange(MIN_WIDTH, MAX_WIDTH);
    }

    /**
     * Generate a height in a range between MIN_WIDTH and MAX_WIDTH
     * @return height of a rectangle
     */
    private int generateHeight() {
        return randInRange(MIN_HEIGHT, MAX_HEIGHT);
    }
}
