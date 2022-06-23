
package SIG_Controller;

import SIG_Model.InvHeader;
import SIG_Model.InvItemsTbModel;
import SIG_Model.InvLine;
import SIG_View.InvFrame_SIG;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Shehab
 */
public class InvTbSelectionListener implements ListSelectionListener{

    private final InvFrame_SIG invoiceFrame ;

    public InvTbSelectionListener(InvFrame_SIG invFrame) {
        this.invoiceFrame = invFrame;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int scI = invoiceFrame.getInvTable_T().getSelectedRow();
        if(scI != -1)
        {
        InvHeader scInv =  invoiceFrame.getInvHdr().get(scI);
        ArrayList<InvLine> invLine = scInv.getInvLine();
        InvItemsTbModel invItemsTbM = new InvItemsTbModel(invLine);
        invoiceFrame.setInvLine(invLine);
        invoiceFrame.getInvItems_T().setModel(invItemsTbM);
        invoiceFrame.getInvNumber_L().setText(scInv.getInvNum()+"");
        invoiceFrame.getInvDate_L().setText(invoiceFrame.sDateFormat.format(scInv.getInvDate()));  
        invoiceFrame.getCustomerName_L().setText(scInv.getCustomerName());
        invoiceFrame.getInvTotal_L().setText(scInv.getTotalForAll()+"");
        }  
              
    }
    
}
