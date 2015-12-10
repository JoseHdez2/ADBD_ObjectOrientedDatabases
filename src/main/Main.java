package main;

import java.sql.SQLException;

public class Main {
    
    
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "password";
        
        QueryManager qm = new QueryManager(url, username, password);

        qm.enviarConsulta("SELECT * from mi_tabla");
        System.out.println(qm.recibirResultados());

    }
    

}
