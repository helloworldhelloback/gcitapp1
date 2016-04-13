/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

/**
 *
 * @author Ahmed
 */
public enum TableEnum {
    AUTHORS("author"), BOOKS("book"), PUBLISHERS("publisher"), LIBRARYBRANCHES("librarybranch"), BORROWERS("borrower"), BOOKLOANS("bookloan"), 
    BOOKCHECKOUT("bookcheckout"), BOOKRETURN("bookreturn"), BOOKCOPIES("bookcopies"), LIBRARYINFO("libraryinfo");
    private String value;

    private TableEnum(String value) {
            this.value = value;
    }
    public String toString() {
       return this.value;
    }
}
