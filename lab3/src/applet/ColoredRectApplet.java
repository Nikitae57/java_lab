package applet;

import shapes.ColoredRect;
import java.awt.*;

/* Создаем собственный класс,который наследуется от класса Applet
 * Данный класс реализует методы интерфейса Runnable */

public class ColoredRectApplet extends BouncingCircle implements Runnable {

    private final int MY_WIDTH = 50;
    private final int MY_HEIGHT = 20;

    private ColoredRect rect = new ColoredRect(MY_WIDTH, MY_HEIGHT, Color.RED, Color.BLACK);
    private int x = rect.getX1();
    private int y = rect.getY1();

    //Метод для рисования окружности красным цветом
    public void paint(Graphics g) {
        rect.draw(g);
    }

    public void animate() {
        Rectangle bounds = getBounds();
        if ((x + dx < 0) || (x + MY_WIDTH + dx > bounds.width))
            dx = -dx;
        if ((y + dy < 0) || (y + MY_HEIGHT + dy > bounds.height))
            dy = -dy;

        x += dx; y += dy;
        rect.move(dx, dy);

        repaint();
    }

    public void run() {
        while(!pleaseStop) {
            animate();

            try { Thread.sleep(100); }
            catch(InterruptedException ignored) {} // Игнорируем прерывания
        }
    }

    //Запускаем анимацию при запуске апплета браузером
    public void start() {
        animator = new Thread(this); // Создаем поток исполнения
        pleaseStop = false; // Пока не просим его остановиться
        animator.start(); // Запускаем поток
    }

    //Останавливаем анимацию, когда браузер останавливает апплет
    public void stop() { pleaseStop = true; }
}