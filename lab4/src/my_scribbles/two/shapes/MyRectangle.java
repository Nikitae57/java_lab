package my_scribbles.two.shapes;

import java.awt.*;

public class MyRectangle {

    int x1, y1, x2, y2;
    private int dx = 0, dy = 0;
    private int width, height;

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public MyRectangle() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        width = 0;
        height = 0;
    }

    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
    }

    public MyRectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public void print() {
        System.out.println("x1 = " + x1);
        System.out.println("y1 = " + y1);
        System.out.println("x2 = " + x2);
        System.out.println("y2 = " + y2);
        System.out.println("width = " + width);
        System.out.println("height = " + height);
    }

    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public void move() {
        this.move(dx, dy);
    }

    public MyRectangle union(MyRectangle rec) {
        int minX1 = x1 < rec.x1 ? x1 : rec.x1;
        int maxX2 = x2 > rec.x2 ? x2 : rec.x2;

        int maxY1 = y1 > rec.y1 ? y1 : rec.y1;
        int minY2 = y2 < rec.y2 ? y2 : rec.y2;

        return new MyRectangle(minX1, maxY1, maxX2, minY2);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.x1, this.y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
