package starters;

import applet.BouncingCircle;

import javax.swing.*;

public class CircleStarter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BouncingCircle circle = new BouncingCircle();
        circle.init();
        circle.start();
        frame.add(circle);
        frame.show();
    }
}
