
package SIG_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Shehab
 */
public class InvHeader {
    private SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private int invoiceNum ;
    private Date invoiceDate ;
    private String custName ;
    private ArrayList<InvLine> invLine ;
    
    public InvHeader() {
    }

    public InvHeader(int invNum, Date invDate, String customerName) {
        this.invoiceNum = invNum;
        this.invoiceDate = invDate;
        this.custName = customerName;
    }

    public String getCustomerName() {
        return custName;
    }

    public void setCustomerName(String customerName) {
        this.custName = customerName;
    }

    public int getInvNum() {
        return invoiceNum;
    }

    public void setInvNum(int invNum) {
        this.invoiceNum = invNum;
    }

    public Date getInvDate() {
        return invoiceDate;
    }

    public void setInvDate(Date invDate) {
        this.invoiceDate = invDate;
    }
    
    public ArrayList<InvLine> getInvLine() {
       
        if (invLine == null)
            invLine = new ArrayList<>();  
        
        return invLine;
    }

    public void setInvLine(ArrayList<InvLine> invLine) {
        
        this.invLine = invLine;
    }
    
    public double getTotalForAll ()
    {
        int i;
        double tAll = 0.0;
        for(i=0 ; i< getInvLine().size() ; i++)
        {
            tAll += getInvLine().get(i).getTotalForItem();
        }
        return tAll ;
    }
    
    public String uploadHdrFormat() {
            return invoiceNum + "," + sDateFormat.format(invoiceDate) + "," + custName ;
        }

    @Override
    public String toString() {
        return "InvHeader{" + "sDateFormat=" + sDateFormat + ", invNum=" + invoiceNum + ", inv_Date=" + invoiceDate + ", customerName=" + custName + '}' +"\n" + "invLine=" + invLine.toString() ;
    }  
}
