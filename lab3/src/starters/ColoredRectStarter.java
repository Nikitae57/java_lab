package starters;

import applet.ColoredRectApplet;

import javax.swing.*;

public class ColoredRectStarter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ColoredRect");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ColoredRectApplet circle = new ColoredRectApplet();
        circle.init();
        circle.start();
        frame.add(circle);
        frame.show();
    }
}
