package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    
    static String url = "jdbc:mysql://localhost:3306/javabase";
    static String username = "java";
    static String password = "password";
    
    static Connection connection;
    static ResultSet resultados;
    static int filasResultados;
    
    public static void main(String[] args) {

        intentarConexion();
        
        //String cod=codigo_e.getText(); // <--- pinta cod, para ver que valor te llega

        //int numero=Integer.parseInt(cod); // <-- cod llega vacio ""

        consultaDePrueba();
        
        mostrarResultados();
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
    
    static public void consultaDePrueba(){
        Statement stmt;
        ResultSet rs = null, rsn = null;
        try {
            stmt = connection.createStatement();

            rs = stmt.executeQuery("SELECT * FROM mi_tabla");
            resultados = rs;
            
            rsn = stmt.executeQuery("SELECT COUNT(*) FROM mi_tabla");
            rsn.first(); // Movemos el cursor a la primera fila.
            filasResultados = rsn.getInt(1);
            
            // System.out.println(filasResultados);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    static public void mostrarResultados(){
        try {
            resultados.first(); // Movemos el cursor a la primera fila.
            
            
        for (int i = 0; i < filasResultados; i++){
            System.out.println(resultados.getString(i));
        }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
