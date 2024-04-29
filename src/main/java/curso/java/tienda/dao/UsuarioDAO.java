package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import curso.java.tienda.model.UsuarioVO;
import curso.java.tienda.util.Conexion;

public class UsuarioDAO {

	public static boolean verificarCredenciales(String email, String clave) {
		String sql = "SELECT email, clave FROM usuarios WHERE email = ?";
		Connection c = Conexion.getConexion();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = c.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				// Si hay resultados en la consulta
				String emailRecibido = rs.getString("email");
				String claveRecibida = rs.getString("clave");

				// Ejemplo de comparación para verificar credenciales
				if (emailRecibido.equals(email) && BCrypt.checkpw(clave, claveRecibida)) {
					return true; // Credenciales válidas
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false; // Credenciales inválidas o error en la consulta
	}

	public static void agregarUsuario(int rol,String email, String clave) throws SQLException {

		String sql = "INSERT INTO usuarios (id_rol, email, clave) VALUES (?,?,?)";
		Connection c = Conexion.getConexion();
		PreparedStatement stmt;

		try {

			stmt = c.prepareStatement(sql);
			stmt.setInt(1, rol);
			stmt.setString(2, email);
			stmt.setString(3, clave);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores, puedes personalizarlo según tus necesidades
		}

	}

	public static void agregarDatosEnvio(String nombre, String apellido1, String apellido2, String direccion,
			String telefono, String email) throws SQLException {

		String sql = "UPDATE usuarios SET nombre = ?, apellido1 = ?,apellido2 = ?, direccion = ?, telefono = ? WHERE email = ?";
		Connection conn = Conexion.getConexion();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, nombre);
			stmt.setString(2, apellido1);
			stmt.setString(3, apellido2);
			stmt.setString(4, direccion);
			stmt.setString(5, telefono);
			stmt.setString(6, email);

			// Ejecutar la consulta
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean editarUsuario(String nombre, String apellido1, String apellido2, String direccion, String dni,
			String email, String localidad, String provincia, String telefono) throws SQLException {

		String sql = "UPDATE usuarios SET nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, dni = ?, localidad = ?, provincia = ?, telefono = ?  WHERE email = ?";
		Connection conn = Conexion.getConexion();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, nombre);
			stmt.setString(2, apellido1);
			stmt.setString(3, apellido2);
			stmt.setString(4, direccion);
			stmt.setString(5, dni);
			stmt.setString(6, localidad);
			stmt.setString(7, provincia);
			stmt.setString(8, telefono);
			stmt.setString(9, email);

			if (stmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static UsuarioVO recuperarUsuarioPorEmail(String email) {
		Connection conexion = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsuarioVO usuario = null;

		try {
			conexion = Conexion.getConexion();
			String sql = "SELECT * FROM usuarios WHERE email = ?";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				// Si se encuentra el usuario, crear un objeto UsuarioVO con los datos
				// recuperados de la base de datos
				usuario = new UsuarioVO();
				usuario.setId(rs.getInt("id"));
				usuario.setRolId(rs.getInt("id_rol"));
				usuario.setEmail(rs.getString("email"));
				usuario.setClave(rs.getString("clave"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido1(rs.getString("apellido1"));
				usuario.setApellido2(rs.getString("apellido2"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setLocalidad(rs.getString("localidad"));
				usuario.setProvincia(rs.getString("provincia"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setDni(rs.getString("dni"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores, puedes personalizarlo según tus necesidades
		}
		return usuario;
	}

	public static boolean cambiarClave(String clave, String email) {
		String sql = "UPDATE usuarios SET clave = ?  WHERE email = ?";
		Connection conn = Conexion.getConexion();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, clave);
			stmt.setString(2, email);

			if (stmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}