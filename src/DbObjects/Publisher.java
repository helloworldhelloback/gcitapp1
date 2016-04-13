/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbObjects;

/**
 *
 * @author tictoc
 */
public class Publisher {
    private int id;
    private String publisherName;
    private String publisherAddress;
    private String publisherPhone;
    
    public Publisher(int Id, String publisherName,String publisherAddress ,String publisherPhone)
    {
        this.id = Id;
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.publisherPhone = publisherPhone;
    }
    
    public int getId()
    {
        return id;
    }
    public String getPublisherName()
    {
        return publisherName;
    }
    public String getPublisherAddress()
    {
        return publisherAddress;
    }
    public String getPublisherPhone()
    {
        return publisherPhone;
    }
}
