package my_scribbles.one.shapes;

import java.awt.*;

public class ColoredRect extends Rectangle {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ColoredRect(Color color) {
        this.color = color;
    }

    public ColoredRect(Rectangle r, Color color) {
        super(r);
        this.color = color;
    }

    public ColoredRect(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    public ColoredRect(int width, int height, Color color) {
        super(width, height);
        this.color = color;
    }


}
