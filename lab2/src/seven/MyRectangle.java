package seven;

public class MyRectangle {

    protected int x1, y1, x2, y2;

    public MyRectangle() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }

    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public MyRectangle(int width, int height) {
        this(0, height, width, 0);
    }

    public void print() {
        System.out.println("x1 = " + x1);
        System.out.println("y1 = " + y1);
        System.out.println("x2 = " + x2);
        System.out.println("y2 = " + y2);
    }

    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public MyRectangle union(MyRectangle rec) {
        int minX1 = x1 < rec.x1 ? x1 : rec.x1;
        int maxX2 = x2 > rec.x2 ? x2 : rec.x2;

        int maxY1 = y1 > rec.y1 ? y1 : rec.y1;
        int minY2 = y2 < rec.y2 ? y2 : rec.y2;

        return new MyRectangle(minX1, maxY1, maxX2, minY2);
    }
}
