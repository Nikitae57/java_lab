package applet;

import shapes.ColoredRect;
import shapes.DrawableRect;
import shapes.MyRectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Chaos extends ColoredRectApplet {

    private final int MAX_WIDTH = 100;
    private final int MIN_WIDTH = 40;
    private final int MAX_HEIGHT = 40;
    private final int MIN_HEIGHT = 10;

    private final int MAX_DELTA = 10;
    private final int MIN_DELTA = -10;

    private Random random;
    private ArrayList<MyRectangle> rectangles;

    @Override
    public void init() {
        super.init();
        random = new Random();
        rectangles = new ArrayList<>();

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
    }

    public void animate() {
        Rectangle bounds = getBounds();

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

    private int randInRange(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    private int generateWidth() {
        return randInRange(MIN_WIDTH, MAX_WIDTH);
    }

    private int generateHeight() {
        return randInRange(MIN_HEIGHT, MAX_HEIGHT);
    }
}
