
package SIG_View;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Shehab
 */
public class SIG_InvLineDialog extends JDialog{
    private final JTextField areaOfItemName;
    private final JTextField areaOfItemCount;
    private final JTextField areaOfItemPrice;
    private final JLabel lblOfItemName;
    private final JLabel lblOfItemCount;
    private final JLabel lblOfItemPrice;
    private final JButton B_Ok;
    private final JButton B_Cancel;
    
    public SIG_InvLineDialog(InvFrame_SIG InvFr) {
        areaOfItemName = new JTextField(20);
        lblOfItemName = new JLabel("Item Name");
        
        areaOfItemCount = new JTextField(20);
        lblOfItemCount = new JLabel("Item Count");
        
        areaOfItemPrice = new JTextField(20);
        lblOfItemPrice = new JLabel("Item Price");
        
        B_Ok = new JButton("OK");
        B_Cancel = new JButton("Cancel");
        
        B_Ok.setActionCommand("itemNew_OK");
        B_Cancel.setActionCommand("itemNew_Cancel");
        
        B_Ok.addActionListener(InvFr.getAction_B());
        B_Cancel.addActionListener(InvFr.getAction_B());
        setLayout(new GridLayout(4,2));
        
        add(lblOfItemName);
        add(areaOfItemName);
        add(lblOfItemCount);
        add(areaOfItemCount);
        add(lblOfItemPrice);
        add(areaOfItemPrice);
        add(B_Ok);
        add(B_Cancel);
        
        pack();
    }

    public JTextField getAreaOfItemPrice() {
        return areaOfItemPrice;
    } 
      
    public JTextField getAreaOfItemName() {
        return areaOfItemName;
    }

    public JTextField getAreaOfItemCount() {
        return areaOfItemCount;
    }
}
