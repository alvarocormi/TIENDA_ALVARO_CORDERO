package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import curso.java.tienda.model.ConsultaVO;
import curso.java.tienda.util.Conexion;

public class ConsultaDAO {
	
	public static void insertarConsulta(ConsultaVO consulta) throws SQLException {

		String sql = "INSERT INTO consulta (id, name, apellido, email, mensaje) VALUES (?,?,?,?,?)";
		Connection c = Conexion.getConexion();
		PreparedStatement stmt;

		try {

			stmt = c.prepareStatement(sql);
			stmt.setInt(1, consulta.getId());
			stmt.setString(2, consulta.getName());
			stmt.setString(3, consulta.getApellido());
			stmt.setString(4, consulta.getEmail());
			stmt.setString(5, consulta.getMensaje());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores, puedes personalizarlo según tus necesidades
		}

	}
}
