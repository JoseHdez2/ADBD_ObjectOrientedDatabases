package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {

    String url;
    String username;
    String password;
    
    Connection connection;
    Statement statement;
    
    ResultSet resultados;
    ResultSetMetaData metadatosResultados;
    
    public QueryManager(String url, String username, String password) throws SQLException{
        
        this.url = url;
        this.username = username;
        this.password = password;
        
        conectarConBD();
    }
    
    /**
     * Enviamos la consulta a la base de datos.
     * @param consulta
     * @throws SQLException
     */
    public void enviarConsulta(String consulta) throws SQLException{
        resultados = statement.executeQuery(consulta);
        metadatosResultados = resultados.getMetaData();
    }
    
    /**
     * Leemos los resultados fila por fila desde la base de datos.
     * @return
     * @throws SQLException
     */
    public String recibirResultados() throws SQLException{
        String salida = "";
        int columnasResultados = metadatosResultados.getColumnCount();
        
        // Mostrar los nombres de las columnas
        for (int i = 1; i <= columnasResultados; i++) {
            if (i > 1) salida += "|  ";
            String columnValue = metadatosResultados.getColumnName(i).toUpperCase();

            salida += columnValue;
        }
        
        salida += "\n";
        
        // Para cada resultado (tupla)...
        while (resultados.next()) {
            // Mostramos el valor de cada columna.
            for (int i = 1; i <= columnasResultados; i++) {
                if (i > 1) salida += "|  ";
                String columnValue = resultados.getString(i);
                salida += columnValue;
            }
            salida += "\n";
        }
        
        return salida;
    };
    
    public void conectarConBD(){
        System.out.println("Conectando con la base de datos...");
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("¡Conexion realizada con exito!");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException("Conexion fallida!", e);
        }
    }
}
