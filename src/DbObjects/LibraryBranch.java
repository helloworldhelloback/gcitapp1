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
public class LibraryBranch {
    private int id;
    private String branchName;
    private String branchAddress;
    
    
    public LibraryBranch(int Id, String branchName, String branchAddress)
    {
        this.id = Id;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }
    
    public int getId()
    {
        return id;
    }
    public String getBranchName()
    {
        return branchName;
    }
    
    public String getBranchAddress()
    {
        return branchAddress;
    }
    @Override
    public String toString(){
        return branchName;
    }
}
