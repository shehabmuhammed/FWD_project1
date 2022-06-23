
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
public class SIG_InvHdrDialog extends JDialog {
   private final JTextField aeraOfCustomer ;
   private final JLabel lblOfCustomer;
   private final JTextField aeraOfDate;
   private final JLabel lblOfDate;
   private final JButton B_Cancel;
   private final JButton B_Ok;

    public SIG_InvHdrDialog(InvFrame_SIG InvFr) {
        lblOfCustomer = new JLabel("Customer Name:");
        aeraOfCustomer = new JTextField(20);
        lblOfDate = new JLabel("Invoice Date:");
        aeraOfDate = new JTextField(20);
        B_Cancel = new JButton("Cancel");
        B_Ok = new JButton("OK");
        
        B_Ok.setActionCommand("InvNew_Ok");
        B_Cancel.setActionCommand("InvNew_Cancel");
        
        B_Ok.addActionListener(InvFr.getAction_B());
        B_Cancel.addActionListener(InvFr.getAction_B());
        setLayout(new GridLayout(3, 2));
        
        add(lblOfDate);
        add(aeraOfDate);
        add(lblOfCustomer);
        add(aeraOfCustomer);
        add(B_Ok);
        add(B_Cancel);
        
        pack();
        
    }

     public JTextField getAeraOfDate() { 
        return aeraOfDate;
    }
     
    public JTextField getAeraOfCustomer() { 
        return aeraOfCustomer;
    }
  
}
