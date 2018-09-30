package eight;

import seven.MyRectangle;

import java.awt.*;

public class DrawableRect extends MyRectangle {

    /**
     * Border color
     */
    private Color outColor = Color.BLACK;

    public DrawableRect(Color outColor) {
        this.outColor = outColor;
    }

    public DrawableRect(int x1, int y1, int x2, int y2, Color outColor) {
        super(x1, y1, x2, y2);
        this.outColor = outColor;
    }

    public DrawableRect(int width, int height, Color outColor) {
        super(width, height);
        this.outColor = outColor;
    }

    /**
     * Draws an empty rectangle
     */
    public void draw(Graphics g) {
        g.setColor(outColor);
        g.drawRect(this.x1, this.y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
