package my_scribbles.starters;

import my_scribbles.one.MyScribble;

import javax.swing.*;

public class Lab4_1 extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyScribble1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyScribble scribble = new MyScribble();
        scribble.init();
        frame.add(scribble);
        frame.setSize(600, 400);
        frame.show();
    }
}
