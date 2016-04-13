/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitapp1;

import DbObjects.Author;
import DbObjects.Book;
import DbObjects.BookCheckout;
import DbObjects.BookCopies;
import DbObjects.BookReturn;
import DbObjects.LibraryBranch;
import DbObjects.Publisher;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmed
 */
public class TablesColumns {
    public JTable selectPublishers(DbQueries query){
        Object[] columns = {"Id","Publisher Name","Publisher Address", "Publisher Phone"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        ArrayList<Publisher> list = query.getPublishersList();       
        Object[] row = new Object[4];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getPublisherName();
            row[2] = list.get(i).getPublisherAddress();
            row[3] = list.get(i).getPublisherPhone();
            model.addRow(row);
        }
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectLibrarianBranch(DbQueries query, String branchName){
        Object[] columns = {"Id","Branch Name","Branch Address"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        LibraryBranch libBranch = query.getLibrarianBranch(branchName);       
        Object[] row = new Object[3];        
        //model.set
        int i=0;
        row[0] = libBranch.getId();
        row[1] = libBranch.getBranchName();
        row[2] = libBranch.getBranchAddress();
        model.addRow(row);       
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectBookCopiesInBranch(DbQueries query, String branchName){
        Object[] columns = {"Id","Title","Author Name", "No of Copies"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        ArrayList<BookCopies> list = query.getBookCopiesInBranch(branchName);       
        Object[] row = new Object[4];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getAuthorName();
            row[3] = list.get(i).getNoOFCopies();
            model.addRow(row);
        }
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectUserCheckedOutBooksInBranch(DbQueries query,int id, String branchName){
        Object[] columns = {"BookId","Book Title","Author Name", "Branch Name", "Checkout Date", "Due Date"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        ArrayList<BookReturn> list = query.getUserCheckedOutBooks(id,branchName);       
        Object[] row = new Object[6];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getAuthorName();
            row[3] = list.get(i).getBranchName();
            row[4] = list.get(i).getDateOut();
            row[5] = list.get(i).getDueDate();
            model.addRow(row);
        }
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectBooksAvailableInBranch(DbQueries query,String branchName){
        Object[] columns = {"BookId","Book Title","Author Name", "Available Copies"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        ArrayList<BookCheckout> list = query.getAvailableBooksList(branchName);       
        Object[] row = new Object[4];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getAuthorName();
            row[3] = list.get(i).getAvailableCopies();
            model.addRow(row);
        }
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectAuthors(DbQueries query){
        Object[] columns = {"AuthorId","Author Name"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        ////////////////////////////////////        
        ArrayList<Author> list = query.getAuthorsList();       
        Object[] row = new Object[2];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();  
            model.addRow(row);
        }
        /////////////////////////////////////
        JTable table = new JTable();              
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        table.setModel(model); 
        return table;
    }
    public JTable selectBooks(DbQueries query){
        Object[] columns = {"BookId","Book Title","PublisherId"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);        
        ArrayList<Book> list = query.getBooksList();       
        Object[] row = new Object[3];        
        //model.set
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getPubId();
            model.addRow(row);
        }        
        JTable table = new JTable();
        table.setModel(model);        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);        
        return table;
    }
}
