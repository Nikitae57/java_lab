package starters;

import serialization.MyScribble2;

import javax.swing.*;

public class SerializationStarter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Serialization");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyScribble2 scribble = new MyScribble2();
        scribble.init();
        frame.add(scribble);
        frame.setSize(600, 400);
        frame.show();
    }
}
