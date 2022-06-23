
package SIG_View;

import SIG_Controller.InvTbSelectionListener;
import SIG_Controller.SIG_ActionListener;
import SIG_Model.InvHdrTbModel;
import SIG_Model.InvHeader;
import SIG_Model.InvItemsTbModel;
import SIG_Model.InvLine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Shehab
 */
public class InvFrame_SIG extends javax.swing.JFrame {

    
    public InvFrame_SIG() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invTable_T = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invItems_T = new javax.swing.JTable();
        InvNumber_L = new javax.swing.JLabel();
        customerName_L = new javax.swing.JLabel();
        invDate_L = new javax.swing.JLabel();
        invTotal_L = new javax.swing.JLabel();
        createNewInv_B = new javax.swing.JButton();
        deleteInv_B = new javax.swing.JButton();
        save_B = new javax.swing.JButton();
        cancel_B = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFile_V = new javax.swing.JMenuItem();
        saveFile_V = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invTable_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invTable_T.getSelectionModel().addListSelectionListener(SCListener);
        jScrollPane1.setViewportView(invTable_T);

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Customer Name");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Invoice Total amount");

        invItems_T.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invItems_T.setToolTipText("");
        jScrollPane2.setViewportView(invItems_T);

        createNewInv_B.setText("Create New Invoice");
        createNewInv_B.addActionListener(action_B);

        deleteInv_B.setText("Delete Invoice");
        deleteInv_B.addActionListener(action_B);

        save_B.setText("Save");
        save_B.addActionListener(action_B);

        cancel_B.setText("Cancel");
        cancel_B.addActionListener(action_B);

        jLabel5.setText("Invoice Items");

        jLabel6.setText("Invoices Table");

        jMenuBar1.setForeground(new java.awt.Color(0, 2, 1));

        jMenu1.setText("File");

        loadFile_V.setText("Load File");
        loadFile_V.addActionListener(action_B);
        jMenu1.add(loadFile_V);

        saveFile_V.setText("Save File");
        saveFile_V.addActionListener(action_B);
        jMenu1.add(saveFile_V);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InvNumber_L))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerName_L))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invDate_L))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(invTotal_L))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(createNewInv_B)
                .addGap(117, 117, 117)
                .addComponent(deleteInv_B)
                .addGap(142, 142, 142)
                .addComponent(save_B, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel_B)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(InvNumber_L))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invDate_L))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customerName_L))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotal_L))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInv_B)
                    .addComponent(deleteInv_B)
                    .addComponent(save_B)
                    .addComponent(cancel_B))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvFrame_SIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvFrame_SIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvFrame_SIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvFrame_SIG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvFrame_SIG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel InvNumber_L;
    private javax.swing.JButton cancel_B;
    private javax.swing.JButton createNewInv_B;
    private javax.swing.JLabel customerName_L;
    private javax.swing.JButton deleteInv_B;
    private javax.swing.JLabel invDate_L;
    private javax.swing.JTable invItems_T;
    private javax.swing.JTable invTable_T;
    private javax.swing.JLabel invTotal_L;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFile_V;
    private javax.swing.JMenuItem saveFile_V;
    private javax.swing.JButton save_B;
    // End of variables declaration//GEN-END:variables

    private SIG_ActionListener action_B = new SIG_ActionListener(this) ;
    private ArrayList<InvHeader> invHdr ;
    private ArrayList<InvLine> invLine ;
    InvItemsTbModel invitemmodel ;
    InvHdrTbModel invhdrmodel ;
    public static SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private InvTbSelectionListener SCListener = new InvTbSelectionListener(this);
    
    
    public InvHeader matchedID(int id)
    {
        for(InvHeader invd : invHdr)
        {
            if(invd.getInvNum() == id)
            {
                return invd;
            }
        }
        return null;
    }

    public ArrayList<InvLine> getInvLine() {
        return invLine;
    }

    public void setInvLine(ArrayList<InvLine> invLine) {
        this.invLine = invLine;
    }

    public InvItemsTbModel getInvitemmodel() {
        return invitemmodel;
    }

    public void setInvitemmodel(InvItemsTbModel invitemmodel) {
        this.invitemmodel = invitemmodel;
    }
   
    public InvHdrTbModel getInvhdrmodel() {
        return invhdrmodel;
    }

    public void setInvhdrmodel(InvHdrTbModel invhdrmodel) {
        this.invhdrmodel = invhdrmodel;
    }

    public JTable getInvItems_T() {
        return invItems_T;
    }

    public JTable getInvTable_T() {
        return invTable_T;
    }
   

    public void setInvHdr(ArrayList<InvHeader> invHdr) {
        this.invHdr = invHdr;
    }

    public ArrayList<InvHeader> getInvHdr() {
       return invHdr;
    }

    public JLabel getInvNumber_L() {
        return InvNumber_L;
    }

    public JLabel getCustomerName_L() {
        return customerName_L;
    }

    public JLabel getInvDate_L() {
        return invDate_L;
    }

    public JLabel getInvTotal_L() {
        return invTotal_L;
    }

    public SIG_ActionListener getAction_B() {
        return action_B;
    }
   
}
