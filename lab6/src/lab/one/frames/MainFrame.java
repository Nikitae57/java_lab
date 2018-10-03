package lab.one.frames;

import lab.one.utiil.StringResources;

import javax.swing.*;

public class MainFrame extends JFrame {

    CreateNewFrame createNewFrame;
    JTable table;

    public MainFrame() {

        table = new JTable();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu(StringResources.FILE);

        JMenuItem createFileMenuItem = new JMenuItem(StringResources.CREATE);
        createFileMenuItem.addActionListener(action -> {
            createNewFrame = new CreateNewFrame(table);
            createNewFrame.show();
        });
        fileMenu.add(createFileMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(table);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.show();
    }
}
