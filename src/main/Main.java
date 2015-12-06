package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    
    static String url = "jdbc:mysql://localhost:3306/javabase";
    static String username = "java";
    static String password = "password";
    
    static Connection connection;
    static ResultSet resultados;
    static int filasResultados;
    
    public static void main(String[] args) throws SQLException {

        intentarConexion();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("SELECT * from mi_tabla");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                // System.out.print(columnValue + " " + rsmd.getColumnName(i));
                System.out.print(columnValue);
            }
            System.out.println("");
        }
    }
    
    static public void intentarConexion(){
        System.out.println("Connecting database...");
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
