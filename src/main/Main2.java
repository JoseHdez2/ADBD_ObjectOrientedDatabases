package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main2 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306");

            // Do something with the Connection
            

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
}
