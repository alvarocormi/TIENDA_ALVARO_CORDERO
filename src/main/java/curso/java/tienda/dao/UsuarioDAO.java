package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import curso.java.tienda.model.UsuarioVO;
import curso.java.tienda.util.Conexion;

public class UsuarioDAO {

	public static boolean verificarCredenciales(String email, String contrasena) {
		String sql = "SELECT COUNT(*) FROM usuario WHERE email = ? AND clave = ?";

		Connection c = Conexion.getConexion();

		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, contrasena);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Si el recuento es mayor que cero, las credenciales son válidas
			}
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void agregarUsuario(String email, String clave) throws SQLException {

		String sql = "INSERT INTO usuario (email, clave) VALUES (?,?)";
		Connection c = Conexion.getConexion();
		PreparedStatement stmt;

		try {

			stmt = c.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, clave);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores, puedes personalizarlo según tus necesidades
		}

	}

	public static void agregarDatosEnvio(String nombre, String apellidos, String direccion, String cp, String email)
			throws SQLException {

		String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, direccion = ?, cp = ? WHERE email = ?";
		Connection conn = Conexion.getConexion();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, nombre);
			stmt.setString(2, apellidos);
			stmt.setString(3, direccion);
			stmt.setString(4, cp);
			stmt.setString(5, email);

			// Ejecutar la consulta
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static UsuarioVO recuperarUsuarioPorEmail(String email) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioVO usuario = null;

        try {
            conexion = Conexion.getConexion();
            String sql = "SELECT * FROM usuario WHERE email = ?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Si se encuentra el usuario, crear un objeto UsuarioVO con los datos recuperados de la base de datos
                usuario = new UsuarioVO();
                usuario.setId(rs.getInt("id"));
                usuario.setRol_id(rs.getInt("rol_id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setClave(rs.getString("clave"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setBaja(rs.getInt("baja"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores, puedes personalizarlo según tus necesidades
        }
        return usuario;
    }
}