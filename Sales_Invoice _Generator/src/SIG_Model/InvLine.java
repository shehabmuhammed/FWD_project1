
package SIG_Model;

/**
 *
 * @author Shehab
 */
public class InvLine {
    
    private String item_Name ;
    private double item_Price ;
    private int item_Count;
    private InvHeader invoiceHeader ;

    public InvLine(String itemName, double itemPrice, int itemCount, InvHeader invHeader) {
        this.item_Name = itemName;
        this.item_Price = itemPrice;
        this.item_Count = itemCount;
        this.invoiceHeader = invHeader;
    }
    
    public InvLine() {
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public double getItem_Price() {
        return item_Price;
    }

    public void setItem_Price(double item_Price) {
        this.item_Price = item_Price;
    }

    public int getItem_Count() {
        return item_Count;
    }

    public void setItem_Count(int item_Count) {
        this.item_Count = item_Count;
    }

    public InvHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    
    public double getTotalForItem (){
        return item_Count * item_Price ;
    }
    
    public String uploadLineFormat() {
            return invoiceHeader.getInvNum()+ "," +item_Name + "," + item_Price + "," + item_Count  ;
        }

    @Override
    public String toString() {
        return "InvLine{" + "itemName=" + item_Name + ", itemPrice=" + item_Price + ", itemCount=" + item_Count +  '}'+"\n";
    }
    
}
