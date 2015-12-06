package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
//  Establish a connection to a mSQL database using JDBC

  public static void main (String[] args) { 
    try
    {
      // Step 1: "Load" the JDBC driver
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      // Step 2: Establish the connection to the database 
      String url = "jdbc:msql:10.0.2.15:3306"; 
      Connection conn = DriverManager.getConnection(url,"pepe_mar","secreto");  
    }
    catch (Exception e)
    {
      System.err.println("D'oh! Got an exception!"); 
      System.err.println(e.getMessage()); 
    } 
  } 
}
