/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbObjects;

import java.util.Date;

/**
 *
 * @author Ahmed
 */
public class BookReturn {
    private int id;
    private String title;
    private String authorName;
    private String branchName;
    private java.sql.Date dateOut;
    private java.sql.Date dueDate;
   // "BookId","Book Title","Author Name", "Branch Name", "Checkout Date", "Due Date"};
    
    public BookReturn(int Id, String title, String authorName, String branchName, java.sql.Date dateOut, java.sql.Date dueDate)
    {
        this.id = Id;
        this.title = title;
        this.authorName = authorName;
        this.branchName = branchName;
        this.dateOut =  dateOut;
        this.dueDate = dueDate;
    }
    
    public int getId()
    {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthorName()
    {
        return authorName;
    }    
    public String getBranchName(){
        return branchName;
    }
    public java.sql.Date getDateOut()
    {
        return dateOut;
    }    
    public java.sql.Date getDueDate()
    {
        return dueDate;
    }
}
