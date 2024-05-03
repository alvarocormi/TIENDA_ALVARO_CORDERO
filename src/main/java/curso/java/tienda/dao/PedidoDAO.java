package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.model.ProductoVO;
import curso.java.tienda.util.Conexion;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PedidoDAO {

	public static void crearPedido(PedidoVO pedido) {
		try {
			Connection con = Conexion.getConexion();
			String query = "INSERT INTO pedidos (id_usuario, metodo_pago,estado, total) " + "VALUES (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, pedido.getIdUsuario());
			st.setString(2, pedido.getMetodoPago());
			st.setString(3, pedido.getEstado());
			st.setDouble(4, pedido.getTotal());


			int filasInsertadas = st.executeUpdate();
			if (filasInsertadas > 0) {
				System.out.println("Pedido realizado correctamente.");
			} else {
				System.out.println("Error al realizar el pedido.");
			}

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PedidoVO buscarPedidoId(int id) {
		PedidoVO pedido = null;

		try {
			Connection con = Conexion.getConexion();
			PreparedStatement st = con.prepareStatement("SELECT * FROM pedidos WHERE id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int idUsuario = rs.getInt("id_usuario");
				Timestamp fecha = rs.getTimestamp("fecha");
				String metodoPago = rs.getString("metodo_pago");
				String estado = rs.getString("estado");
				double total = rs.getDouble("total");
				String numFactura = rs.getString("num_factura");

				pedido = new PedidoVO(id, idUsuario, fecha, metodoPago, estado, numFactura, total);
			}

			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;

	}

	public static List<PedidoVO> listarPedidosUsuario(int idUsuario, String orden) {

		List<PedidoVO> lista = new ArrayList<PedidoVO>();
		PedidoVO pedido = null;

		try {
			Connection con = Conexion.getConexion();
			PreparedStatement st = con.prepareStatement("SELECT * FROM pedidos WHERE id_usuario = ? ORDER BY fecha "+ orden);
			st.setInt(1, idUsuario);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				pedido = new PedidoVO();
				pedido.setId(rs.getInt("id"));
				pedido.setFecha(rs.getTimestamp("fecha"));
				pedido.setMetodoPago(rs.getString("metodo_pago"));
				pedido.setEstado(rs.getString("estado"));
				pedido.setTotal(rs.getDouble("total"));
				pedido.setNumFactura(rs.getString("num_factura"));

				lista.add(pedido);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	

	public static String asignarNumFactura(int idUsuario) {

		int numFactura = 0;

		try {
			Connection con = Conexion.getConexion();
			PreparedStatement st = con.prepareStatement("SELECT COUNT(*) FROM pedidos");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				numFactura = rs.getInt(1);
			}

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "FA" + (numFactura + 1) + "-US" + idUsuario;
	}

	public static void cancelarPedido(int id) {
		Connection con = Conexion.getConexion();
		try {
			String sql = "UPDATE pedidos SET estado = 'PC' WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, id);

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static PedidoVO buscarUltimoPedidoPorUsuario(int id_usuario) {
	    PedidoVO pedido = null;
	 
	    try {
	        Connection con = Conexion.getConexion();
	        PreparedStatement st = con.prepareStatement("SELECT * FROM pedidos WHERE id_usuario = ? ORDER BY fecha DESC LIMIT 1");
	        st.setInt(1, id_usuario);
	 
	        ResultSet rs = st.executeQuery();
	        
	        if (rs.next()) {
	            int idPedido = rs.getInt("id");
	            Timestamp fecha = rs.getTimestamp("fecha");
	            String metodoPago = rs.getString("metodo_pago");
	            String estado = rs.getString("estado");
	            String numFactura = rs.getString("num_factura");
	            double total = rs.getDouble("total");
	 
	            pedido = new PedidoVO(idPedido, id_usuario, fecha, metodoPago, estado, numFactura, total);
	        }
	 
	        rs.close();
	        st.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pedido;
	}
}
