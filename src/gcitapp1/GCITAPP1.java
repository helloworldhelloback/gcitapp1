/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcitapp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */
public class GCITAPP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.07:3306/library", "ahmed","Zdvhm#2589");
        PreparedStatement pstmt = conn.prepareStatement("select * from tbl_author where authorName = ?");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Author Name: ");
        String authorName = scan.nextLine();

        pstmt.setString(1, authorName);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
                System.out.print(rs.getInt("authorId"));
                System.out.print("    |    ");
                System.out.println(rs.getString("authorName"));
                System.out.println("---------------------------");
        }
        
       
    }
    
}
