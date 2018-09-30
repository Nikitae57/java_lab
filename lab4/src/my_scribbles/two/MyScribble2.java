package my_scribbles.two;

import my_scribbles.two.shapes.ColoredRect;
import my_scribbles.two.shapes.DrawableRect;
import my_scribbles.two.shapes.MyRectangle;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MyScribble2 extends Applet {

    private ArrayList<MyRectangle> rectangles;
    private int pressedX, pressedY;
    private int prevX, prevY;

    private boolean shouldMove;
    private MyRectangle draggedRec;

    @Override
    public void init() {
        rectangles = new ArrayList<>();
        shouldMove = false;

        Button btnRec = new Button("Rectangle");
        btnRec.addActionListener(e -> {
            MyRectangle rec = new MyRectangle(100, 50);
            rectangles.add(rec);

            rec.draw(getGraphics());
        });

        Button btnDrawableRec = new Button("DrawableRec");
        btnDrawableRec.addActionListener(e -> {
            DrawableRect rec = new DrawableRect(200, 50, 300, 100, Color.RED);
            rectangles.add(rec);

            rec.draw(getGraphics());
        });

        Button btnColoredRec = new Button("ColoredRec");
        btnColoredRec.addActionListener(e -> {
            ColoredRect rec = new ColoredRect(400, 50, 500, 100, Color.CYAN, Color.YELLOW);
            rectangles.add(rec);

            rec.draw(getGraphics());
        });

        this.add(btnRec);
        this.add(btnDrawableRec);
        this.add(btnColoredRec);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressedX = e.getX();
                pressedY = e.getY();

                for (int i = rectangles.size() - 1; i >= 0; i--) {
                    MyRectangle rec = rectangles.get(i);

                    if ((rec.getX1() <= pressedX && rec.getX2() >= pressedX)
                            && (rec.getY1() <= pressedY && rec.getY2() >= pressedY)) {

                        shouldMove = true;
                        draggedRec = rec;
                        prevX = pressedX;
                        prevY = pressedY;

                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                shouldMove = false;
                draggedRec = null;
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!shouldMove || draggedRec == null) { return; }

                int dx = e.getX() - prevX;
                int dy = e.getY() - prevY;
                draggedRec.move(dx, dy);

                prevX = e.getX();
                prevY = e.getY();

                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        rectangles.forEach(rec -> rec.draw(g));
    }
}
