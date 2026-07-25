package mx.com.lomas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import mx.com.lomas.config.Conexion;
import mx.com.lomas.modelo.Usuario;

public class UsuarioDAO {

    /*
     * Busca un usuario por nombre de usuario y contraseña.
     */
    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {

        Usuario usuarioEncontrado = null;

        String sql = """
                SELECT
                    id_usuario,
                    id_rol,
                    nombre,
                    apellido_paterno,
                    apellido_materno,
                    usuario,
                    contrasena,
                    telefono,
                    correo,
                    estado,
                    fecha_registro
                FROM usuarios
                WHERE usuario = ?
                  AND contrasena = ?
                LIMIT 1
                """;

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql)
        ) {

            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, contrasena);

            try (ResultSet resultado = sentencia.executeQuery()) {

                if (resultado.next()) {
                    usuarioEncontrado = convertirResultadoAUsuario(resultado);
                }
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al iniciar sesión: " + e.getMessage()
            );
            e.printStackTrace();
        }

        return usuarioEncontrado;
    }

    /*
     * Obtiene todos los usuarios registrados.
     */
    public List<Usuario> listar() {

        List<Usuario> listaUsuarios = new ArrayList<>();

        String sql = """
                SELECT
                    id_usuario,
                    id_rol,
                    nombre,
                    apellido_paterno,
                    apellido_materno,
                    usuario,
                    contrasena,
                    telefono,
                    correo,
                    estado,
                    fecha_registro
                FROM usuarios
                ORDER BY id_usuario DESC
                """;

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()
        ) {

            while (resultado.next()) {

                Usuario usuario = convertirResultadoAUsuario(resultado);
                listaUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println(
                    "Error al listar usuarios: " + e.getMessage()
            );
            e.printStackTrace();
        }

        return listaUsuarios;
    }

    /*
     * Convierte una fila de la base de datos en un objeto Usuario.
     */
    private Usuario convertirResultadoAUsuario(
            ResultSet resultado
    ) throws SQLException {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(
                resultado.getInt("id_usuario")
        );

        usuario.setIdRol(
                resultado.getInt("id_rol")
        );

        usuario.setNombre(
                resultado.getString("nombre")
        );

        usuario.setApellidoPaterno(
                resultado.getString("apellido_paterno")
        );

        usuario.setApellidoMaterno(
                resultado.getString("apellido_materno")
        );

        usuario.setUsuario(
                resultado.getString("usuario")
        );

        usuario.setContrasena(
                resultado.getString("contrasena")
        );

        usuario.setTelefono(
                resultado.getString("telefono")
        );

        usuario.setCorreo(
                resultado.getString("correo")
        );

        usuario.setEstado(
                resultado.getBoolean("estado")
        );

        Timestamp fechaRegistro =
                resultado.getTimestamp("fecha_registro");

        if (fechaRegistro != null) {
            usuario.setFechaRegistro(
                    fechaRegistro.toLocalDateTime()
            );
        }

        return usuario;
    }
    public boolean guardar(Usuario usuario) {

    String sql = """
            INSERT INTO usuarios (
                id_rol,
                nombre,
                apellido_paterno,
                apellido_materno,
                usuario,
                contrasena,
                telefono,
                correo,
                estado
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

    try (
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        sentencia.setInt(1, usuario.getIdRol());
        sentencia.setString(2, usuario.getNombre());
        sentencia.setString(3, usuario.getApellidoPaterno());
        sentencia.setString(4, usuario.getApellidoMaterno());
        sentencia.setString(5, usuario.getUsuario());
        sentencia.setString(6, usuario.getContrasena());
        sentencia.setString(7, usuario.getTelefono());
        sentencia.setString(8, usuario.getCorreo());
        sentencia.setBoolean(9, usuario.isEstado());

        return sentencia.executeUpdate() > 0;

    } catch (SQLException e) {

        System.err.println(
                "Error al guardar el usuario: " + e.getMessage()
        );

        e.printStackTrace();
        return false;
    }
}
    
    public boolean actualizar(Usuario usuario) {

    String sql = """
            UPDATE usuarios SET
                id_rol = ?,
                nombre = ?,
                apellido_paterno = ?,
                apellido_materno = ?,
                usuario = ?,
                contrasena = ?,
                telefono = ?,
                correo = ?,
                estado = ?
            WHERE id_usuario = ?
            """;

    try (
            Connection conexion = Conexion.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(sql)
    ) {

        sentencia.setInt(1, usuario.getIdRol());
        sentencia.setString(2, usuario.getNombre());
        sentencia.setString(3, usuario.getApellidoPaterno());
        sentencia.setString(4, usuario.getApellidoMaterno());
        sentencia.setString(5, usuario.getUsuario());
        sentencia.setString(6, usuario.getContrasena());
        sentencia.setString(7, usuario.getTelefono());
        sentencia.setString(8, usuario.getCorreo());
        sentencia.setBoolean(9, usuario.isEstado());
        sentencia.setInt(10, usuario.getIdUsuario());

        return sentencia.executeUpdate() > 0;

    } catch (SQLException e) {

        System.err.println(
                "Error al actualizar usuario: " + e.getMessage()
        );

        e.printStackTrace();
        return false;
    }
}
    
}



