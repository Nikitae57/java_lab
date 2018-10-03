package starters;

import applet.Chaos;

import javax.swing.*;

public class ChaosStarter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chaos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Chaos circle = new Chaos();
        circle.init();
        circle.start();
        frame.add(circle);
        frame.show();
    }
}
