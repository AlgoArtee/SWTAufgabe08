package swt;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PlugInTable extends AbstractTableModel{
    private List<IPlugin> plugIns;

    private int a;
    private int b;

    private String[] columnNames={"Name", "Created","Group Members", "Run Result"};

    public PlugInTable(List<IPlugin> customPlugIns, int a, int b){
        this.plugIns = customPlugIns;
        this.a=a;
        this.b=b;

        fireTableDataChanged();
    }

    public void setItems(List<IPlugin> currentPlugIns){
        plugIns.clear();
        plugIns = currentPlugIns;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount(){
        return plugIns.size();
    }

    @Override
    public int getColumnCount(){
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        IPlugin selectedPlugIn=plugIns.get(rowIndex);
        switch(columnIndex){
            case 0:
                return selectedPlugIn.getPluginName();
            case 1:
                return selectedPlugIn.getCreationDate();
            case 2:
                return selectedPlugIn.getGroupMembers();
            case 3:
                try {
                    if (a != 0 && b != 0) {
                        return selectedPlugIn.run(a, b);
                    } else {
                        return "0";
                    }
                } catch (ArithmeticException e) {
                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
