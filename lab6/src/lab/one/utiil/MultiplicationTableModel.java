package lab.one.utiil;

import javax.swing.table.AbstractTableModel;

public class MultiplicationTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ++rowIndex * ++columnIndex;
    }
}
