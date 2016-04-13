/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import gcitapp1.DbQueries;
import gcitapp1.TablesColumns;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Ahmed
 */
public class AdminPanel extends javax.swing.JPanel implements ActionListener{
    private DbQueries dbQueries;
    private TableEnum currentTable;
    private HashMap<String, JPanel> inputJPanelsHashMap;
    private int authorId;
    private int bookId;
    private int pubId;
    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        dbQueries = new DbQueries();
        currentTable = TableEnum.AUTHORS;
        inputJPanelsHashMap = new HashMap<>();

        run();
    }
    public void run(){
        this.jTable1.setModel(setAuthorsTable().getModel());
        this.jp_TableHolderPanel.setLayout(new FlowLayout());
        this.jp_TableHolderPanel.setPreferredSize(new Dimension(400,400));
       
        setInputPanels();
        setInputVisiblity(getCurrentTable());
        setListeners();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_TableHolderPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_TableInput = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_InsertRow = new javax.swing.JButton();
        btn_UpdateRow = new javax.swing.JButton();
        btn_DeleteRow = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btn_SelectAuthorsTable = new javax.swing.JButton();
        btn_SelectBookTable = new javax.swing.JButton();
        btn_SelectPublisherTable = new javax.swing.JButton();

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jp_TableHolderPanelLayout = new javax.swing.GroupLayout(jp_TableHolderPanel);
        jp_TableHolderPanel.setLayout(jp_TableHolderPanelLayout);
        jp_TableHolderPanelLayout.setHorizontalGroup(
            jp_TableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_TableHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_TableHolderPanelLayout.setVerticalGroup(
            jp_TableHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_TableHolderPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_TableInputLayout = new javax.swing.GroupLayout(panel_TableInput);
        panel_TableInput.setLayout(panel_TableInputLayout);
        panel_TableInputLayout.setHorizontalGroup(
            panel_TableInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_TableInputLayout.setVerticalGroup(
            panel_TableInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        btn_InsertRow.setText("Add");

        btn_UpdateRow.setText("Update");

        btn_DeleteRow.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_InsertRow, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_UpdateRow)
                .addGap(18, 18, 18)
                .addComponent(btn_DeleteRow)
                .addGap(0, 229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_InsertRow)
                    .addComponent(btn_UpdateRow)
                    .addComponent(btn_DeleteRow))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        btn_SelectAuthorsTable.setText("Authors");
        jToolBar1.add(btn_SelectAuthorsTable);

        btn_SelectBookTable.setText("Books");
        jToolBar1.add(btn_SelectBookTable);

        btn_SelectPublisherTable.setText("Publisher");
        btn_SelectPublisherTable.setFocusable(false);
        btn_SelectPublisherTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_SelectPublisherTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btn_SelectPublisherTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_TableHolderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_TableInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_TableHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_TableInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = this.jTable1.getSelectedRow();
        TableModel model = this.jTable1.getModel();
        if(getCurrentTable().equals(TableEnum.AUTHORS)){
            AuthorInput author = (AuthorInput) getInputJPanelsHashMap().get(TableEnum.AUTHORS.toString());
            author.getTxtAuthorName().setText(model.getValueAt(index,1).toString());
            setAuthorId(Integer.valueOf(model.getValueAt(index,0).toString()));
        }
        if(getCurrentTable().equals(TableEnum.BOOKS)){
            BookInput book = (BookInput) getInputJPanelsHashMap().get(TableEnum.BOOKS.toString());
            book.getTxtTitle().setText(model.getValueAt(index,1).toString());
            book.getTxtPubID().setText(model.getValueAt(index,2).toString());
            setBookId(Integer.valueOf(model.getValueAt(index,0).toString()));
        }
        if(getCurrentTable().equals(TableEnum.PUBLISHERS)){
            PublisherInput publisher = (PublisherInput)getInputJPanelsHashMap().get(TableEnum.PUBLISHERS.toString());
            publisher.getTxt_PublisherName().setText(model.getValueAt(index, 1).toString());
            publisher.getTxt_PublisherAddress().setText(model.getValueAt(index, 2).toString());
            publisher.getTxt_PublisherPhone().setText(model.getValueAt(index, 3).toString());
            setPubId(Integer.valueOf(model.getValueAt(index,0).toString()));
        }

    }//GEN-LAST:event_jTable1MouseClicked
    /////////////////////////////////////////////////////
    
    public void setInputPanels(){
        AuthorInput author = new AuthorInput();
        getInputJPanelsHashMap().put(TableEnum.AUTHORS.toString(),author );
        BookInput book = new BookInput();        
        getInputJPanelsHashMap().put(TableEnum.BOOKS.toString(),book );
        PublisherInput publisher = new PublisherInput();
        getInputJPanelsHashMap().put(TableEnum.PUBLISHERS.toString(),publisher);
        this.panel_TableInput.setLayout(new FlowLayout());
        this.panel_TableInput.add(author);
        this.panel_TableInput.add(book);
        this.panel_TableInput.add(publisher);
        this.panel_TableInput.setPreferredSize(new Dimension(400,100));
        this.panel_TableInput.setVisible(true);
    }
    public void setListeners(){        
        this.btn_SelectAuthorsTable.addActionListener(this);
        this.btn_SelectBookTable.addActionListener(this);
        this.btn_SelectPublisherTable.addActionListener(this);
        this.btn_InsertRow.addActionListener(this);   
        this.btn_DeleteRow.addActionListener(this);
        this.btn_UpdateRow.addActionListener(this);
    }
    public void setInputVisiblity(TableEnum selectedTable){       
        for(Map.Entry<String, JPanel> panel : getInputJPanelsHashMap().entrySet()){
            if(panel.getKey().equals(selectedTable.toString())){
                panel.getValue().setVisible(true);
            }
            else
                panel.getValue().setVisible(false);                
        }               
    } 
    public void reset(){
        this.jTable1.setModel(setAuthorsTable().getModel());
    }
    public JTable setAuthorsTable(){        
        TablesColumns columns= new TablesColumns();
        return columns.selectAuthors(getDbQueries());
    }
    public JTable setBooksTable(){
        TablesColumns columns= new TablesColumns();
        return columns.selectBooks(getDbQueries());
    }
    public JTable setPublishersTable(){
        TablesColumns columns= new TablesColumns();
        return columns.selectPublishers(getDbQueries());
    }
/////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btn_SelectAuthorsTable){
           setCurrentTable(TableEnum.AUTHORS);
           AdminPanel.this.jTable1.setModel(setAuthorsTable().getModel());
           setInputVisiblity(getCurrentTable());
       }
       if(e.getSource() == btn_SelectBookTable){
           setCurrentTable(TableEnum.BOOKS);
           AdminPanel.this.jTable1.setModel(setBooksTable().getModel());
           setInputVisiblity(getCurrentTable());
       }
       if(e.getSource() == btn_SelectPublisherTable){
           setCurrentTable(TableEnum.PUBLISHERS);
           AdminPanel.this.jTable1.setModel(setPublishersTable().getModel());
           setInputVisiblity(getCurrentTable());
       }
       if(e.getSource() == btn_InsertRow){
          checkWhichTableIsBeingInputed();
       }       
       if(e.getSource() == btn_UpdateRow){
           checkWhichTableIsBeingUpdated();
       }
       if(e.getSource() == btn_DeleteRow){
           checkWhichTableHasRowDeleted();
       }
    }  
    public void checkWhichTableIsBeingUpdated(){
        if(getCurrentTable().equals(TableEnum.AUTHORS)){
            AuthorInput author = (AuthorInput) getInputJPanelsHashMap().get(TableEnum.AUTHORS.toString());            
            String authorName = author.getTxtAuthorName().getText();
            dbQueries.updateAuthor(getAuthorId(),authorName);
            btn_SelectAuthorsTable.doClick();
        }   
        if(getCurrentTable().equals(TableEnum.BOOKS)){
            BookInput book = (BookInput) getInputJPanelsHashMap().get(TableEnum.BOOKS.toString());            
            String title = book.getTxtTitle().getText();
            int putId = Integer.valueOf(book.getTxtPubID().getText());
            dbQueries.updateBook(getBookId(),title, putId);
            btn_SelectBookTable.doClick();
        }
        if(getCurrentTable().equals(TableEnum.PUBLISHERS)){
            PublisherInput publisher = (PublisherInput) getInputJPanelsHashMap().get(TableEnum.PUBLISHERS.toString());            
            String pubName = publisher.getTxt_PublisherName().getText();
            String pubAddress = publisher.getTxt_PublisherAddress().getText();
            String pubPhone = publisher.getTxt_PublisherPhone().getText();
            dbQueries.updatePublisher(getPubId(), pubName, pubAddress, pubPhone);
            btn_SelectPublisherTable.doClick();
        }
        
    }
    public void checkWhichTableHasRowDeleted(){
        if(getCurrentTable().equals(TableEnum.AUTHORS)){
            
            dbQueries.deleteAuthor(getAuthorId());
            btn_SelectAuthorsTable.doClick();
        }   
        if(getCurrentTable().equals(TableEnum.BOOKS)){            
            dbQueries.deleteBook(getBookId());
            btn_SelectBookTable.doClick();
        }
        if(getCurrentTable().equals(TableEnum.PUBLISHERS)){            
            dbQueries.deletePublisher((getPubId()));
            btn_SelectPublisherTable.doClick();
        }
    }
    public void checkWhichTableIsBeingInputed(){
        if(getCurrentTable().equals(TableEnum.AUTHORS)){
            AuthorInput author = (AuthorInput) getInputJPanelsHashMap().get(TableEnum.AUTHORS.toString());            
            String authorName = author.getTxtAuthorName().getText();
            dbQueries.insertAuthor(authorName);
            btn_SelectAuthorsTable.doClick();
        }   
        if(getCurrentTable().equals(TableEnum.BOOKS)){
            BookInput book = (BookInput) getInputJPanelsHashMap().get(TableEnum.BOOKS.toString());            
            String title = book.getTxtTitle().getText();
            int putId = Integer.valueOf(book.getTxtPubID().getText());
            dbQueries.insertBook(title, putId);
            btn_SelectBookTable.doClick();
        }
        if(getCurrentTable().equals(TableEnum.PUBLISHERS)){
            PublisherInput publisher = (PublisherInput) getInputJPanelsHashMap().get(TableEnum.PUBLISHERS.toString());            
            String pubName = publisher.getTxt_PublisherName().getText();
            String pubAddress = publisher.getTxt_PublisherAddress().getText();
            String pubPhone = publisher.getTxt_PublisherPhone().getText();
            dbQueries.insertPublisher(pubName, pubAddress, pubPhone);
            btn_SelectPublisherTable.doClick();
        }
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

    

    /**
     * @return the inputJPanelsHashMap
     */
    public HashMap<String, JPanel> getInputJPanelsHashMap() {
        return inputJPanelsHashMap;
    }

    /**
     * @param inputJPanelsHashMap the inputJPanelsHashMap to set
     */
    public void setInputJPanelsHashMap(HashMap<String, JPanel> inputJPanelsHashMap) {
        this.inputJPanelsHashMap = inputJPanelsHashMap;
    }

    /**
     * @return the currentTable
     */
    public TableEnum getCurrentTable() {
        return currentTable;
    }

    /**
     * @param currentTable the currentTable to set
     */
    public void setCurrentTable(TableEnum currentTable) {
        this.currentTable = currentTable;
    }

   
    
/////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DeleteRow;
    private javax.swing.JButton btn_InsertRow;
    private javax.swing.JButton btn_SelectAuthorsTable;
    private javax.swing.JButton btn_SelectBookTable;
    private javax.swing.JButton btn_SelectPublisherTable;
    private javax.swing.JButton btn_UpdateRow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel jp_TableHolderPanel;
    private javax.swing.JPanel panel_TableInput;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the authorId
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the pubId
     */
    public int getPubId() {
        return pubId;
    }

    /**
     * @param pubId the pubId to set
     */
    public void setPubId(int pubId) {
        this.pubId = pubId;
    }
}