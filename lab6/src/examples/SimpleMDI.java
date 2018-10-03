package examples;

import javax.swing.*;
public class SimpleMDI extends JFrame {

    public SimpleMDI() {
        super("examples.SimpleMDI");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // создаем рабочий стол Swing
        JDesktopPane desktopPane = new JDesktopPane();

        // добавляем его в центр окна
        add(desktopPane);

        // создаем несколько внутренних окон, применяя доступные конструкторы
        JInternalFrame frame1 = new JInternalFrame("Frame1", true);
        JInternalFrame frame2 = new JInternalFrame(
                "Frame2",
                true,
                true,
                true,
                true
        );

        // добавляем внутренние окна на рабочий стол
        desktopPane.add(frame1);
        desktopPane.add(frame2);

        // задаем размеры и расположения, делаем окна видимыми
        frame1.setSize(200, 100);
        frame1.setLocation(80, 100);
        frame1.setVisible(true);
        frame2.setSize(200, 60);
        frame2.setVisible(true);

        // выводим окно на экран
        setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleMDI();
    }
}