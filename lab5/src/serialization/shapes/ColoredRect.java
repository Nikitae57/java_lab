package serialization.shapes;

import java.awt.*;
import java.io.Serializable;

public class ColoredRect extends DrawableRect {

    /**
     * Color of a rectangle
     */
    private Color inColor = Color.BLACK;

    public ColoredRect(Color outColor, Color inColor) {
        super(outColor);
        this.inColor = inColor;
    }

    public ColoredRect(int x1, int y1, int x2, int y2, Color outColor, Color inColor) {
        super(x1, y1, x2, y2, outColor);
        this.inColor = inColor;
    }

    public ColoredRect(int width, int height, Color outColor, Color inColor) {
        super(width, height, outColor);
        this.inColor = inColor;
    }

    /**
     * Draws a colored rectangle with a border
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(inColor);
        g.fillRect(this.x1, this.y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
        super.draw(g);
    }
}
