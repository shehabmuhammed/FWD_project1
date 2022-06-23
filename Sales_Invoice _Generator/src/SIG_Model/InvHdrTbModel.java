
package SIG_Model;

import SIG_View.InvFrame_SIG;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Shehab
 */
public class InvHdrTbModel extends AbstractTableModel{

    private final ArrayList<InvHeader> invoiceHdr ;
    private final String [] col_Names = {"No." , "Date" , "Customer" , "Total"};
    public InvHdrTbModel(ArrayList<InvHeader> invHdr) {
        this.invoiceHdr = invHdr;
    }
    
    @Override
    public int getRowCount() {
        return invoiceHdr.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return col_Names.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvHeader invH = invoiceHdr.get(rowIndex) ;
        switch(columnIndex){
            case 0 : return invH.getInvNum();
            case 1 : return InvFrame_SIG.sDateFormat.format(invH.getInvDate());
            case 2 : return invH.getCustomerName();
            case 3 : return invH.getTotalForAll();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return col_Names[column] ;
    }          
}
