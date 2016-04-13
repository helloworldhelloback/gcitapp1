/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbObjects;

/**
 *
 * @author Ahmed
 */
public class BookCopies {
    private int id;
    private String authorName;
    private int noOfCopies;
    private String title;
    
    
    public BookCopies(int Id, String title,  String authorName, int noOfCopies)
    {
        this.id = Id;
        this.title = title;
        this.authorName = authorName;
        this.noOfCopies = noOfCopies;
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
    
    public int getNoOFCopies()
    {
        return noOfCopies;
    }
}
