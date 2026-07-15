
package mx.com.lomas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL
            = "jdbc:mysql://localhost:3306/lomas_alejandro"
            + "?useSSL=false"
            + "&serverTimezone=America/Mexico_City"
            + "&allowPublicKeyRetrieval=true";

    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                CONTRASENA
        );
    }
}