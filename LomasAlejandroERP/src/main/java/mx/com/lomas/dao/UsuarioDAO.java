
package mx.com.lomas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.com.lomas.config.Conexion;
import mx.com.lomas.modelo.Usuario;

public class UsuarioDAO {
    
    public Usuario iniciarSesion(String usuario, String contrasena) {

    Connection conexion = null;
    PreparedStatement sentencia = null;
    ResultSet resultado = null;

    Usuario usuarioEncontrado = null;

    return usuarioEncontrado;
}

}