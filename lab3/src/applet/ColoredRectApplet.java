package applet;

import shapes.ColoredRect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/* Создаем собственный класс,который наследуется от класса Applet
 * Данный класс реализует методы интерфейса Runnable */

public class ColoredRectApplet extends BouncingCircle implements Runnable {

    private final int MY_WIDTH = 50;
    private final int MY_HEIGHT = 20;

    private ColoredRect rect = new ColoredRect(MY_WIDTH, MY_HEIGHT, Color.RED, Color.BLACK);
    private int x = rect.getX1();
    private int y = rect.getY1();
    private Rectangle bounds;

    //Метод для рисования окружности красным цветом
    public void paint(Graphics g) {
        rect.draw(g);
    }

    public void animate() {
        //Rectangle bounds = getBounds();
        if ((x + dx < 0) || (x + MY_WIDTH + dx > bounds.width))
            dx = -dx;
        if ((y + dy < 0) || (y + MY_HEIGHT + dy > bounds.height))
            dy = -dy;

        x += dx; y += dy;
        rect.move(dx, dy);

        repaint();
    }

    public void run() {

        Timer t = new Timer(100, e -> {
            if (!pleaseStop) {
                //setSize(600, 400);
                animate();
                //setSize(601, 401);
            }
        });

        t.setRepeats(true);
        t.start();
    }

    //Запускаем анимацию при запуске апплета браузером
    public void start() {
        bounds = getBounds();

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                bounds = e.getComponent().getBounds();
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

        animator = new Thread(this); // Создаем поток исполнения
        pleaseStop = false; // Пока не просим его остановиться
        animator.start(); // Запускаем поток
    }

    //Останавливаем анимацию, когда браузер останавливает апплет
    public void stop() { pleaseStop = true; }
}