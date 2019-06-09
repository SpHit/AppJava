package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionClase {
    public Connection connection;
    public  Connection getConnection(){

        String dbPath = "jdbc:mysql://db4free.net:3306/proyecto_prueba";
        String dbName="proyecto_prueba";
        String userName="proyecto";
        String password="ChangeData?";

        try{
            connection = DriverManager.getConnection(dbPath, userName, password);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            e.getMessage();
        }
        return connection;

    }
}
