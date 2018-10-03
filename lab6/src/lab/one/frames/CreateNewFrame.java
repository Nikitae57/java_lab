package lab.one.frames;

import lab.one.utiil.AdditionTableModel;
import lab.one.utiil.MultiplicationTableModel;
import lab.one.utiil.StringResources;

import javax.swing.*;
import java.awt.*;

public class CreateNewFrame extends JFrame {

    public CreateNewFrame(JTable table) {

        JRadioButton rbtnMultiplicationTable = new JRadioButton(StringResources.MULTIPLICATION_TABLE);
        rbtnMultiplicationTable.setSelected(true);

        JRadioButton rbtnAdditionTable = new JRadioButton(StringResources.ADDITION_TABLE);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rbtnMultiplicationTable);
        btnGroup.add(rbtnAdditionTable);

        JButton btnOk = new JButton(StringResources.OK);
        btnOk.addActionListener(action -> {

            if (rbtnAdditionTable.isSelected()) {
                inflateAdditionTable(table);
            } else {
                inflateMultiplicationTable(table);
            }

            setVisible(false);
            dispose();
        });

        add(rbtnAdditionTable);
        add(rbtnMultiplicationTable);
        add(btnOk);

        setLayout(new GridLayout(0, 1));

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void inflateAdditionTable(JTable table) {
        if (table != null) {
            table.setModel(new AdditionTableModel());
        }
    }

    private void inflateMultiplicationTable(JTable table) {
        if (table != null) {
            table.setModel(new MultiplicationTableModel());
        }
    }
}
