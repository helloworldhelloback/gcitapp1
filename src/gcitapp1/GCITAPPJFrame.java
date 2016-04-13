/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitapp1;

import Panels.AdminPanel;
import Panels.AuthorInput;
import Panels.TableEnum;
import Panels.BookInput;
import Panels.BorrowerPanel;
import Panels.LibrarianPanel;
import Panels.LoginPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Ahmed
 */
public class GCITAPPJFrame extends javax.swing.JFrame implements ActionListener{
    
    private HashMap<String, JPanel> userRoleJPanelsHashMap;
    private DbQueries dbQueries;
    /**
     * Creates new form NewJFrame
     */
   // private NewJPanel panel;
    public GCITAPPJFrame() {
        initComponents();
        userRoleJPanelsHashMap =  new HashMap<>();
        dbQueries = new DbQueries();
        this.setTitle ("GCIT APP");  
        run();
        
    }
    public void run(){        
        this.setResizable (true);
        this.setPreferredSize(new Dimension(500,800));
        this.pack();
        //to clean up resources before closing
        this.addWindowListener(new CustomWindowAdapter(this));
        setUserRolePanels();
        setListeners();
    }
    public void setUserRolePanels(){
        this.panel_MainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        LoginPanel loginPanel = new LoginPanel(getDbQueries());
        AdminPanel adminPanel = new AdminPanel();  
        LibrarianPanel librarianPanel = new LibrarianPanel(getDbQueries());
        BorrowerPanel borrowerPanel =  new BorrowerPanel(getDbQueries());
        
        //this.panel_MainPanel.setPreferredSize(new Dimension(400,400));
        this.panel_MainPanel.add(loginPanel);
        this.panel_MainPanel.add(adminPanel);
        this.panel_MainPanel.add(borrowerPanel);
        this.panel_MainPanel.add(librarianPanel);
        //loginPanel.setVisible(false);
        adminPanel.setVisible(false);
        borrowerPanel.setVisible(false);
        librarianPanel.setVisible(false);
        getUserRoleJPanelsHashMap().put(UserRolesEnum.LOGIN.toString(), loginPanel );
        getUserRoleJPanelsHashMap().put(UserRolesEnum.ADMIN.toString(), adminPanel ); 
        getUserRoleJPanelsHashMap().put(UserRolesEnum.BORROWER.toString(), borrowerPanel );   
        getUserRoleJPanelsHashMap().put(UserRolesEnum.LIBRARIAN.toString(), librarianPanel);
        setRoleVisiblity(UserRolesEnum.LOGIN);
    }
    public void setRoleVisiblity(UserRolesEnum selectedRole){       
        for(Map.Entry<String, JPanel> panel : getUserRoleJPanelsHashMap().entrySet()){
            if(panel.getKey().equals(selectedRole.toString())){
                panel.getValue().setVisible(true);
            }
            else
                panel.getValue().setVisible(false);                
        }               
    } 
    public void setListeners(){  
        LoginPanel login = (LoginPanel) getUserRoleJPanelsHashMap().get(UserRolesEnum.LOGIN.toString());
        login.getBtn_AdminScreen().addActionListener(this);
        login.getBtn_BorrowerScreen().addActionListener(this);
        login.getBtn_LibrarianScreen().addActionListener(this);
        this.btn_LogOut.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {        
        LoginPanel login= (LoginPanel) getUserRoleJPanelsHashMap().get(UserRolesEnum.LOGIN.toString());
        JButton admin =login.getBtn_AdminScreen();
        JButton borrower = login.getBtn_BorrowerScreen();
        JButton librarian = login.getBtn_LibrarianScreen();
        if(e.getSource() == admin){  
            AdminPanel adminPanel =  (AdminPanel) getUserRoleJPanelsHashMap().get(UserRolesEnum.ADMIN.toString());
            adminPanel.reset();
            setRoleVisiblity(UserRolesEnum.ADMIN);
        }
        if(e.getSource() == borrower){
            int id = Integer.valueOf(login.getTxt_borrowerId().getText());
            BorrowerPanel borrowPanel =  (BorrowerPanel) getUserRoleJPanelsHashMap().get(UserRolesEnum.BORROWER.toString());
            borrowPanel.reset(id);
            setRoleVisiblity(UserRolesEnum.BORROWER);
        }
        if(e.getSource() == librarian){
            LibrarianPanel librarianPanel = (LibrarianPanel) getUserRoleJPanelsHashMap().get(UserRolesEnum.LIBRARIAN.toString());
            librarianPanel.setBranchId(login.getBranchId());
            librarianPanel.setBranchName(login.getBranchName());
            System.out.println("main: id= "+login.getBranchId()+" name= "+login.getBranchName());
            librarianPanel.reset();
            setRoleVisiblity(UserRolesEnum.LIBRARIAN);
        }
        if(e.getSource() == this.btn_LogOut){
            setRoleVisiblity(UserRolesEnum.LOGIN);
        }
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_MainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_LogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panel_MainPanelLayout = new javax.swing.GroupLayout(panel_MainPanel);
        panel_MainPanel.setLayout(panel_MainPanelLayout);
        panel_MainPanelLayout.setHorizontalGroup(
            panel_MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_MainPanelLayout.setVerticalGroup(
            panel_MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        btn_LogOut.setText("LogOut");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 351, Short.MAX_VALUE)
                .addComponent(btn_LogOut))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_LogOut)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GCITAPPJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LogOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_MainPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the userRoleJPanelsHashMap
     */
    public HashMap<String, JPanel> getUserRoleJPanelsHashMap() {
        return userRoleJPanelsHashMap;
    }

    /**
     * @param userRoleJPanelsHashMap the userRoleJPanelsHashMap to set
     */
    public void setUserRoleJPanelsHashMap(HashMap<String, JPanel> userRoleJPanelsHashMap) {
        this.userRoleJPanelsHashMap = userRoleJPanelsHashMap;
    }

    /**
     * @return the dbQueries
     */
    public DbQueries getDbQueries() {
        return dbQueries;
    }

    /**
     * @param dbQueries the dbQueries to set
     */
    public void setDbQueries(DbQueries dbQueries) {
        this.dbQueries = dbQueries;
    }

    /////////When closing JFrame Clean Up//////////////
    class CustomWindowAdapter extends WindowAdapter {
        GCITAPPJFrame window = null;
        CustomWindowAdapter(GCITAPPJFrame window) {
            this.window = window;
        }
        // implement windowClosing method
        @Override
        public void windowClosing(WindowEvent e) {
            //close the db connection
            dbQueries.closeDbConnection();
            // exit the application when window's close button is clicked
            System.exit(0);
        }
    }

    
    
}
