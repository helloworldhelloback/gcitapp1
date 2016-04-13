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
public class Book {
    private int id;
    private int pubId;
    private String title;
    
    public Book(int Id, String title, int pubId)
    {
        this.id = Id;
        this.pubId = pubId;
        this.title = title;
    }
    
    public int getId()
    {
        return id;
    }
    public int getPubId()
    {
        return pubId;
    }
    
    public String getTitle()
    {
        return title;
    }
}
