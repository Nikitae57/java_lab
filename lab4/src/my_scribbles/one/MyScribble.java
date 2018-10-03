package my_scribbles.one;

import my_scribbles.one.shapes.ColoredRect;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MyScribble extends Applet {

    private int last_x, last_y;
    private int width, height;
    private Color color;

    private boolean shouldDraw;
    private int xReversed, yReversed, xPaintCoord, yPaintCoord;
    private ArrayList<ColoredRect> drawnRectangles;

    public void init() {

        color = Color.BLACK;
        shouldDraw = false;
        drawnRectangles = new ArrayList<>();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    last_x = e.getX();
                    last_y = e.getY();
                    shouldDraw = true;
                    return;

                }

                if (e.getButton() == MouseEvent.BUTTON3){
                    color = pickRandomColor();
                    System.out.println("Color changed: " + color.toString());
                }

                shouldDraw = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!shouldDraw) { return; }

                Graphics g = getGraphics();

                ColoredRect coloredRect = new ColoredRect(xPaintCoord, yPaintCoord, width, height, color);
                g.setColor(color);
                g.fillRect(xPaintCoord, yPaintCoord, width, height);

                drawnRectangles.add(coloredRect);
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (!shouldDraw) { return; }

                int x = e.getX();
                int y = e.getY();
                width = Math.abs(last_x - x);
                height = Math.abs(last_y - y);

                xReversed = x < last_x ? 1 : 0;
                yReversed = y < last_y ? 1 : 0;
                xPaintCoord = last_x - width * xReversed;
                yPaintCoord = last_y - height * yReversed;

                repaint();
            }
        });

        Button b = new Button("Clear");
        b.addActionListener(e -> {
            Graphics g = getGraphics();
            g.setColor(getBackground());
            g.fillRect(0, 0, getSize().width, getSize().height);

            drawnRectangles.clear();
        });

        this.add(b);
    }

    @Override
    public void paint(Graphics g) {
        drawnRectangles.forEach(rectangle -> {
            int x = rectangle.x;
            int y = rectangle.y;
            int width = rectangle.width;
            int height = rectangle.height;

            g.setColor(rectangle.getColor());
            g.fillRect(x, y, width, height);
        });

        if (shouldDraw) {
            g.setColor(Color.GRAY);
            g.drawRect(xPaintCoord, yPaintCoord, width, height);
        }
    }

    private final Color[] colorsArray = {
            Color.BLUE, Color.BLACK, Color.CYAN,
            Color.RED, Color.GREEN, Color.YELLOW,
            Color.DARK_GRAY, Color.GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK
    };
    private Color pickRandomColor() {
        Color pickedColor = colorsArray[new Random().nextInt(colorsArray.length)];
        return !pickedColor.equals(color) ? pickedColor : pickRandomColor();
    }
}
