
package SIG_Controller;

import SIG_Model.InvHdrTbModel;
import SIG_Model.InvHeader;
import SIG_Model.InvItemsTbModel;
import SIG_Model.InvLine;
import SIG_View.InvFrame_SIG;
import SIG_View.SIG_InvHdrDialog;
import SIG_View.SIG_InvLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Shehab
 */
public class SIG_ActionListener implements ActionListener{

    private final InvFrame_SIG invoiceFrame ;
    private SIG_InvHdrDialog invoiceHdrD ;
    private SIG_InvLineDialog invoiceLineD;
            
            
    public SIG_ActionListener(InvFrame_SIG invFrame) {
        this.invoiceFrame = invFrame;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand())
        {
            case  "Save":
                save();
            break;
            
            case  "Delete Invoice":
                deleteInvoice();
            break;
            
            case  "Create New Invoice":
                createNewInvoice();
            break;
            
            case  "Save File":
                saveFile();
                printDataInConsol();
            break;
            
            case  "Load File":         
                loadFile();   
            break;
            
            case  "Cancel":
                cancel(); 
            break;
            
            case "InvNew_Cancel":
                invNewDialog_Cancel();
            break;
            
            case "InvNew_Ok":
                invNewDialog_Ok();
            break;
            
            case "itemNew_OK" :
                itemNewDialog_Ok();
            break;
            
            case "itemNew_Cancel":
                itemNewDialog_Cancel();
            break;
            
        }
        
    }

    private void save() {
        invoiceLineD = new SIG_InvLineDialog(invoiceFrame);
        invoiceLineD.setVisible(true);
    }

    private void deleteInvoice() {
        int scInv = invoiceFrame.getInvTable_T().getSelectedRow();
        if(scInv != -1)
        {
            invoiceFrame.getInvHdr().remove(scInv);
            invoiceFrame.getInvhdrmodel().fireTableDataChanged();
            invoiceFrame.getInvItems_T().setModel(new InvItemsTbModel(new ArrayList<>()));
            
            invoiceFrame.setInvLine(null);
            
            invoiceFrame.getInvNumber_L().setText("");
            invoiceFrame.getInvDate_L().setText("");  
            invoiceFrame.getCustomerName_L().setText("");
            invoiceFrame.getInvTotal_L().setText("");
        }
        
    }

    private void createNewInvoice() {
        
        invoiceHdrD = new SIG_InvHdrDialog(invoiceFrame);
        invoiceHdrD.setVisible(true);
        
    }

    private void saveFile() {
        
        ArrayList<InvHeader> invH = invoiceFrame.getInvHdr();
        JFileChooser fileChoosed = new JFileChooser();
        try {
            int option = fileChoosed.showSaveDialog(invoiceFrame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File h_File = fileChoosed.getSelectedFile();
                FileWriter newInvLineFile;
                try (FileWriter newInvHdrFile = new FileWriter(h_File)) {
                    String textHeaders = "";
                    String textLines = "";
                    for (InvHeader inV : invH) {
                        textHeaders += inV.uploadHdrFormat();
                        textHeaders += "\n";
                        for (InvLine Ln : inV.getInvLine()) {
                            textLines += Ln.uploadLineFormat();
                            textLines += "\n";
                        }
                    }   textHeaders = textHeaders.substring(0, textHeaders.length()-1);
                    textLines = textLines.substring(0, textLines.length()-1);
                    option = fileChoosed.showSaveDialog(invoiceFrame);
                    File l_File = fileChoosed.getSelectedFile();
                    newInvLineFile = new FileWriter(l_File);
                    newInvHdrFile.write(textHeaders);
                    newInvLineFile.write(textLines);
                }
                newInvLineFile.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(invoiceFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void loadFile()  {
        
        JFileChooser selectFile = new JFileChooser();
        try{
        int option = selectFile.showOpenDialog(invoiceFrame);
        if(option == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = selectFile.getSelectedFile();
            Path filePath = Paths.get(selectedFile.getAbsolutePath());
            List<String> fileLines = Files.readAllLines(filePath);
            ArrayList<InvHeader> invHeaders = new ArrayList<>();
            for(String fileLine : fileLines)
            {
                String [] lineSplit = fileLine.split(",");
                String numS = lineSplit[0];
                String dateS = lineSplit[1];
                String customerS = lineSplit[2];
                
                int id = Integer.parseInt(numS);
                Date date = InvFrame_SIG.sDateFormat.parse(dateS);
                
                InvHeader invHeader = new InvHeader(id, date, customerS);
                invHeaders.add(invHeader);
            }
            
            invoiceFrame.setInvHdr(invHeaders);
        option = selectFile.showOpenDialog(invoiceFrame);
            if(option == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile2 = selectFile.getSelectedFile();
                Path filePath2 = Paths.get(selectedFile2.getAbsolutePath());
                List<String> itemLines = Files.readAllLines(filePath2);
               // ArrayList<InvLine> invLines = new ArrayList<>();
                for(String itemline : itemLines)
                {
                    String [] lineSplit = itemline.split(",");
                    String numS = lineSplit[0];
                    String itemNameS = lineSplit[1];
                    String priceS = lineSplit[2];
                    String amountS = lineSplit[3];
                    
                    int id = Integer.parseInt(numS);
                    double price = Double.parseDouble(priceS);
                    int amount = Integer.parseInt(amountS);
 
                    InvLine invline  = new InvLine(itemNameS , price ,amount , invoiceFrame.matchedID(id));
                    invoiceFrame.matchedID(id).getInvLine().add(invline);
                        
                }
            } 
            InvHdrTbModel hdrModel = new InvHdrTbModel(invHeaders);
            invoiceFrame.setInvhdrmodel(hdrModel);
            invoiceFrame.getInvTable_T().setModel(hdrModel);
           
        }
        
      
       }
        catch(IOException | ParseException e) {
            JOptionPane.showMessageDialog(invoiceFrame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancel() {
        int scInv = invoiceFrame.getInvItems_T().getSelectedRow();
        int index = invoiceFrame.getInvTable_T().getSelectedRow();
        if(scInv != -1)
        {
            invoiceFrame.getInvLine().remove(scInv);
            InvItemsTbModel itemmodel = (InvItemsTbModel)invoiceFrame.getInvItems_T().getModel();
            itemmodel.fireTableDataChanged();
            invoiceFrame.getInvTotal_L().setText(""+invoiceFrame.getInvHdr().get(index).getTotalForAll());
            invoiceFrame.getInvhdrmodel().fireTableDataChanged();
            invoiceFrame.getInvTable_T().setRowSelectionInterval(index, index);
        }
    }

    private void invNewDialog_Cancel() {
        invoiceHdrD.setVisible(false);
        invoiceHdrD.dispose();
        invoiceHdrD = null;
        
    }

    private void invNewDialog_Ok() {
        invoiceHdrD.setVisible(false);
        int index =0 ;
        String [] S = {"",""};
        S[0] = invoiceHdrD.getAeraOfCustomer().getText();
        S[1] = invoiceHdrD.getAeraOfDate().getText();
        
        Date date = new Date();
        try{
        date = InvFrame_SIG.sDateFormat.parse(S[1]);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(invoiceFrame,"Error Parsing", "Wrong Date Format", JOptionPane.ERROR_MESSAGE);
        }
        
        for(InvHeader hdr : invoiceFrame.getInvHdr())
        {
            if(hdr.getInvNum() > index)
            {
                index = hdr.getInvNum() ;
                
            }
        }
        index++;
        
        InvHeader invH = new InvHeader(index, date, S[0]);
        invoiceFrame.getInvHdr().add(invH);
        invoiceFrame.getInvhdrmodel().fireTableDataChanged();
        
       
        invoiceHdrD.dispose();
        invoiceHdrD = null;
    }

    private void itemNewDialog_Cancel() {
         invoiceLineD.setVisible(false);
         invoiceLineD.dispose();
         invoiceLineD = null;
    }

    
    private void itemNewDialog_Ok() {
         invoiceLineD.setVisible(false);
          int scInv = invoiceFrame.getInvTable_T().getSelectedRow();
         int cnt = 1 ; 
         double prc = 1 ;
        String [] S = {"","",""};
        S[0] = invoiceLineD.getAreaOfItemName().getText();
        S[1] = invoiceLineD.getAreaOfItemPrice().getText();
        S[2] = invoiceLineD.getAreaOfItemCount().getText();
        
        try{
            cnt = Integer.parseInt(S[2]); 
            }
        catch(NumberFormatException e)
            { 
                JOptionPane.showMessageDialog(invoiceFrame,"Error Converting", "Undefined Number Format", JOptionPane.ERROR_MESSAGE);
            }
        try{
            prc = Double.parseDouble(S[1]); 
            }
        catch(NumberFormatException e)
            { 
                JOptionPane.showMessageDialog(invoiceFrame,"Error Converting", "Undefined Number Format", JOptionPane.ERROR_MESSAGE);
            }
        if(scInv != -1)
        {       
            InvLine invL = new InvLine(S[0], prc , cnt , invoiceFrame.getInvHdr().get(scInv) );
            invoiceFrame.getInvLine().add(invL);
            
            //invFrame.getInvitemmodel().fireTableDataChanged();
            InvItemsTbModel itemmodel = (InvItemsTbModel)invoiceFrame.getInvItems_T().getModel();
            itemmodel.fireTableDataChanged();
            invoiceFrame.getInvhdrmodel().fireTableDataChanged();

        }
        invoiceFrame.getInvTable_T().setRowSelectionInterval(scInv, scInv);
         
         invoiceLineD.dispose();
         invoiceLineD = null;
         
         
    }
    
   private void printDataInConsol() {
	        System.out.println("*******************************************************************************************************");
                invoiceFrame.getInvHdr().stream().map((hdr) -> {
                    System.out.println("________________________________________________________");
            return hdr;
                }).forEach((hdr) -> {
                    System.out.println(hdr.toString());
        });
	        System.out.println("*******************************************************************************************************");
	    } 
}
