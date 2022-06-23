
package SIG_Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shehab
 */
public class InvItemsTbModel extends AbstractTableModel{

    private final ArrayList<InvLine> inLine ;
    private final String [] colNames = {"No." , "Item Name" , "Item Price" , "Count","Item Total"};
    
    public InvItemsTbModel(ArrayList<InvLine> inLine) {
        this.inLine = inLine;
    }
    @Override
    public int getRowCount() {
        return inLine.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvLine invL = inLine.get(rowIndex) ;
        switch(columnIndex){
            case 0 : return invL.getInvoiceHeader().getInvNum();
            case 1 : return invL.getItem_Name();
            case 2 : return invL.getItem_Price();
            case 3 : return invL.getItem_Count();
            case 4 : return invL.getTotalForItem();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column] ;
    }
}
