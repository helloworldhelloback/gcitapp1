/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitapp1;

/**
 *
 * @author Ahmed
 */
public enum UserRolesEnum {
    LOGIN("login"), BORROWER("borrower"), LIBRARIAN("librarian"), ADMIN("admin");
    private String value;

    private UserRolesEnum(String value) {
            this.value = value;
    }
    
    public String toString() {
       return this.value;
    }
}

