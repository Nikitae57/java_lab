package my_scribbles.starters;

import my_scribbles.one.MyScribble;
import my_scribbles.two.MyScribble2;

import javax.swing.*;

public class Lab4_2 extends JApplet {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyScribble2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MyScribble2 scribble = new MyScribble2();
        scribble.init();
        frame.add(scribble);
        frame.setSize(600, 400);
        frame.show();
    }
}
