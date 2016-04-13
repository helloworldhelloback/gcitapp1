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
public class Author {
    
    private int id;
    private String Name;
    
    public Author(int Id, String Name)
    {
        this.id = Id;
        this.Name = Name;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return Name;
    }
    
}
