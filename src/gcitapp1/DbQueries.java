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
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Ahmed
 */
public class DbQueries {
    Connection conn;
    public DbQueries() {
       startDbConnection();
    }
    
    public void startDbConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "ahmed","Zdvhm#2589");
        }catch(Exception db){            
        }
    }
    
    public void closeDbConnection(){
        try{
            conn.close();}
        catch(Exception dbClose){
        }
    }
    public ArrayList<BookCopies> getBookCopiesInBranch(String branchName){
        ArrayList<BookCopies> bookCopiesList = new ArrayList<>();          
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT tbl_book.bookId, tbl_book.title, tbl_author.authorName, tbl_book_copies.noOfCopies\n" +
                                                                "FROM tbl_book_copies\n" +
                                                                "INNER JOIN tbl_book ON\n" +
                                                                "	tbl_book_copies.bookId = tbl_book.bookId\n" +
                                                                "	INNER JOIN tbl_library_branch ON\n" +
                                                                "		tbl_book_copies.branchId = tbl_library_branch.branchId\n" +
                                                                "	INNER JOIN tbl_book_authors ON\n" +
                                                                "		tbl_book.bookId = tbl_book_authors.bookId\n" +
                                                                "	INNER JOIN tbl_author ON\n" +
                                                                "	tbl_book_authors.authorId = tbl_author.authorId\n" +
                                                                "WHERE tbl_library_branch.branchName= ?;");
            pstmt.setString(1,branchName );            
            ResultSet rs = pstmt.executeQuery();
            BookCopies bookCopies;
            while(rs.next())
            {
                bookCopies = new BookCopies(rs.getInt("bookId"),rs.getString("title"),rs.getString("authorName"), rs.getInt("noOfCopies"));                
                bookCopiesList.add(bookCopies);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return bookCopiesList;
    }
    public void setBranchInfo(int id, String branchName, String branchAddress){
         try {               
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_library_branch\n" +
                                                            "SET tbl_library_branch.branchName = ?\n" +
                                                            "	,tbl_library_branch.branchAddress= ? \n" +
                                                            "WHERE tbl_library_branch.branchId = ?;");
            
            pstmt.setString(1, branchName);
            pstmt.setString(2, branchAddress);
            pstmt.setInt(3, id);            
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }  
    }
    public void setBookCopiesNum(int bookId, int branchId, int noOfCopies){
         try {               
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_book_copies\n" +
                                                                "SET tbl_book_copies.noOfCopies= ?\n" +
                                                                "WHERE tbl_book_copies.bookId = ? AND tbl_book_copies.branchId=?;");
            pstmt.setInt(1, noOfCopies);  
            pstmt.setInt(2, bookId);
            pstmt.setInt(3, branchId);                      
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    public void setUserBookReturn(int bookId, int cardNo, String branchName){
         try { 
            java.sql.Date dateIn = java.sql.Date.valueOf(java.time.LocalDate.now());            
            System.out.println("Time dateOut: "+dateIn);
            //TODO change statment to use branchId directly as two branches could have the same name
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_book_loans \n" +
                                        "SET tbl_book_loans.dateIn = ? \n" +
                                        "Where tbl_book_loans.bookId = ?\n" +
                                        "AND tbl_book_loans.cardNo = ? \n" +
                                        "AND tbl_book_loans.branchId = (select tbl_library_branch.branchId From tbl_library_branch Where tbl_library_branch.branchName =?);");
            pstmt.setDate(1, dateIn);
            pstmt.setInt(2, bookId);
            pstmt.setInt(3, cardNo);
            pstmt.setString(4, branchName);
            
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }  
    }
    public ArrayList<BookReturn> getUserCheckedOutBooks(int id, String branchName){
        ArrayList<BookReturn> userBooksList = new ArrayList<>();          
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT tbl_book.bookId, tbl_book.title, tbl_author.authorName, tbl_library_branch.branchName, tbl_book_loans.dateOut, tbl_book_loans.dueDate\n" +
                                                            "FROM tbl_book_loans\n" +
                                                            "INNER JOIN tbl_book ON\n" +
                                                            "	tbl_book_loans.bookId = tbl_book.bookId\n" +
                                                            "    INNER JOIN tbl_book_authors ON \n" +
                                                            "		tbl_book_authors.bookId = tbl_book_loans.bookId\n" +
                                                            "	INNER JOIN tbl_author ON\n" +
                                                            "		tbl_author.authorId = tbl_book_authors.authorId\n" +
                                                            "	INNER JOIN tbl_library_branch ON\n" +
                                                            "		tbl_book_loans.branchId = tbl_library_branch.branchId\n" +
                                                            "	INNER JOIN tbl_borrower ON\n" +
                                                            "		tbl_book_loans.cardNo = tbl_borrower.cardNo\n" +
                                                            "WHERE  tbl_library_branch.branchName= ?\n" +
                                                            "	AND tbl_book_loans.dateIN is NULL\n" +
                                                            "	AND tbl_borrower.cardNo = ?\n" +
                                                            "Group BY tbl_library_branch.branchId, tbl_book.bookId,tbl_borrower.cardNo;");
            pstmt.setString(1,branchName );
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            BookReturn bookReturn;
            while(rs.next())
            {
                //(int Id, String title, String authorName, String branchName, java.sql.Date checkOut, java.sql.Date dueDate)
                bookReturn = new BookReturn(rs.getInt("bookId"),rs.getString("title"),rs.getString("authorName"), rs.getString("branchName"), rs.getDate("dateOut"),rs.getDate("dueDate"));                
                userBooksList.add(bookReturn);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return userBooksList;
    }
    public void insertBook_Loan(int bookId, int branchId, int cardNo){
        try {    
            //Date dateOut = new Date();
            java.sql.Date dateOut = java.sql.Date.valueOf(java.time.LocalDate.now());
            java.sql.Date dueDate = java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7));
            System.out.println("Time dateOut: "+dateOut);
            System.out.println("Time dueDate: "+dueDate);
           
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbl_book_loans( bookId, branchId, cardNo, dateOut, dueDate ) VALUE(?,?,?,?,?)");
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, branchId);
            pstmt.setInt(3, cardNo);
            pstmt.setDate(4, dateOut);
            pstmt.setDate(5, dueDate);
            
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    public ArrayList<BookCheckout> getAvailableBooksList(String branchName){
        ArrayList<BookCheckout> bookAvailableList = new ArrayList<>();          
        try {            
            PreparedStatement pstmt = conn.prepareStatement("SELECT tbl_book.bookId, tbl_book.title, tbl_author.authorName, tbl_book_copies.noOfCopies- Count(*) AS AvailableCopies\n" +
                                                                "FROM tbl_book_copies\n" +
                                                                "Left JOIN tbl_book ON\n" +
                                                                "	tbl_book_copies.bookId = tbl_book.bookId\n" +
                                                                "    LEFT JOIN tbl_book_authors ON \n" +
                                                                "		tbl_book_authors.bookId = tbl_book.bookId\n" +
                                                                "	LEFT JOIN tbl_author ON\n" +
                                                                "		tbl_author.authorId = tbl_book_authors.authorId\n" +
                                                                "	LEFT JOIN tbl_library_branch ON\n" +
                                                                "		tbl_book_copies.branchId = tbl_library_branch.branchId\n" +
                                                                "	Left outer JOIN tbl_book_loans ON\n" +
                                                                "		tbl_book.bookId = tbl_book_loans.bookId AND tbl_book_loans.branchId=tbl_library_branch.branchId \n" +
                                                                "WHERE  tbl_library_branch.branchName= ?\n" +
                                                                "Group BY tbl_book.title, tbl_book.bookId;");
            pstmt.setString(1,branchName );
            ResultSet rs = pstmt.executeQuery();
            BookCheckout book;
            while(rs.next())
            {
                book = new BookCheckout(rs.getInt("bookId"),rs.getString("title"),rs.getString("authorName"), rs.getInt("AvailableCopies"));                
                bookAvailableList.add(book);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return bookAvailableList;
    }
    public LibraryBranch getLibrarianBranch(String branchName){
        LibraryBranch libraryBranch = new LibraryBranch(1, branchName, "");          
        try {            
            PreparedStatement pstmt = conn.prepareStatement("select * from tbl_library_branch where tbl_library_branch.branchName=?");
            pstmt.setString(1, branchName);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                 libraryBranch = new LibraryBranch(rs.getInt("branchId"),rs.getString("branchName"),rs.getString("branchAddress"));                
                
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return libraryBranch;
    }
    
    public ArrayList<LibraryBranch> getBranches(){
        ArrayList<LibraryBranch> libraryBranchesList = new ArrayList<>();          
        try {            
            PreparedStatement pstmt = conn.prepareStatement("select * from tbl_library_branch");
            ResultSet rs = pstmt.executeQuery();
            LibraryBranch branch;
            while(rs.next())
            {
                branch = new LibraryBranch(rs.getInt("branchId"),rs.getString("branchName"),rs.getString("branchAddress"));                
                libraryBranchesList.add(branch);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return libraryBranchesList;
    }
    
    public ArrayList<Author> getAuthorsList() {
        ArrayList<Author> authorsList = new ArrayList<Author>();          
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("select * from tbl_author");
            ResultSet rs = pstmt.executeQuery();
            Author author;
            while(rs.next())
            {
                author = new Author(rs.getInt("authorId"),rs.getString("authorName"));
                authorsList.add(author);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return authorsList;
    }
    
    public ArrayList<Book> getBooksList() {
        ArrayList<Book> booksList = new ArrayList<>();          
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("select * from tbl_book");
            ResultSet rs = pstmt.executeQuery();
            Book book;
            while(rs.next())
            {
                book = new Book(rs.getInt("bookId"),rs.getString("title"),rs.getInt("pubId"));
                booksList.add(book);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return booksList;
    }
    ///////////////////////////////////////////////////////////////
    //select table
    public ArrayList<Publisher> getPublishersList() {
        ArrayList<Publisher> pubList = new ArrayList<>();          
        try {
            
            PreparedStatement pstmt = conn.prepareStatement("select * from tbl_publisher");
            ResultSet rs = pstmt.executeQuery();
            Publisher pub;
            while(rs.next())
            {
                pub = new Publisher(rs.getInt("publisherId"),rs.getString("publisherName"),rs.getString("publisherAddress"),rs.getString("publisherPhone"));
                pubList.add(pub);
            }
        } 
         catch (Exception e) {
            e.printStackTrace();
        }
        //add throws ClassNotFoundException, SQLException
        return pubList;
    }

    ///////////////////////////////////////////////////////////////
    //insert rows
    public void insertAuthor(String authorName){
        try {            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbl_author( authorName ) VALUE(?)");
            pstmt.setString(1, authorName);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }    
    public void insertBook(String title, int pubId){
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbl_book( title, pubId ) VALUE(?,?)");
            pstmt.setString(1, title);
            pstmt.setInt(2, pubId);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    public void insertPublisher(String pubName, String pubAddress, String pubPhone){
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tbl_publisher( publisherName,publisherAddress,publisherPhone ) VALUE(?,?,?)");
            pstmt.setString(1, pubName);
            pstmt.setString(2, pubAddress);
            pstmt.setString(3, pubPhone);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    
    ///////////////////////////////////////////////////////////////
    ///update rows
    public void updateAuthor(int authorId, String authorName){
        try {            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_author\n" +
                                                                "SET tbl_author.authorName = ? \n" +
                                                                "WHERE tbl_author.authorId = ?;");
            pstmt.setString(1, authorName);
            pstmt.setInt(2, authorId);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    public void updateBook(int bookId, String title, int pubId){
        try {            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_book\n" +
                                                                "SET tbl_book.title = ?, tbl_book.pubId =?\n" +
                                                                "WHERE tbl_book.bookId= ?;");
            pstmt.setString(1, title);
            pstmt.setInt(2, pubId);
            pstmt.setInt(3, bookId);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    public void updatePublisher(int pubId, String pubName, String pubAddress, String pubPhone){
        try {            
            PreparedStatement pstmt = conn.prepareStatement("UPDATE tbl_publisher\n" +
                                                "SET tbl_publisher.publisherName= ?, tbl_publisher.publisherAddress =?, tbl_publisher.publisherPhone =?\n" +
                                                "WHERE tbl_publisher.publisherId= ?;");
            pstmt.setString(1, pubName);
            pstmt.setString(2, pubAddress);
            pstmt.setString(3, pubPhone);
            pstmt.setInt(4, pubId);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        }         
    }
    ////////////////////////////////////////////////////////
    //delete row
    public void deleteAuthor(int id){
        try {       
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tbl_author where tbl_author.authorId=?");
            pstmt.setInt(1, id);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void deleteBook(int id){
        try {       
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tbl_book where tbl_book.bookId=?");
            pstmt.setInt(1, id);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void deletePublisher(int id){
        try {       
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tbl_publisher where tbl_publisher.publisherId=?");
            pstmt.setInt(1, id);
            pstmt.execute();   
        } 
         catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
