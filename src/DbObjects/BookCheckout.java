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
public class BookCheckout {
    private int id;
    private String authorName;
    private int availableCopies;
    private String title;
    
    
    public BookCheckout(int Id, String title,  String authorName, int availableCopies)
    {
        this.id = Id;
        this.title = title;
        this.authorName = authorName;
        this.availableCopies = availableCopies;
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
    
    public int getAvailableCopies()
    {
        return availableCopies;
    }
}
