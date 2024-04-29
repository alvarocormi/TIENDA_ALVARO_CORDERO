package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import curso.java.tienda.model.DetallePedidoVO;
import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.util.Conexion;

public class DetallePedidoDAO {
	
	public static void rellenarDetallePedido(List<DetallePedidoVO> detalles) {
		try {
			Connection con = Conexion.getConexion();
			String query = "INSERT INTO detalles_pedido (id_pedido, id_producto, precio_unidad, unidades, impuesto, total) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(query);

			for (DetallePedidoVO detalle : detalles) {
				st.setInt(1, detalle.getIdPedido());
				st.setInt(2, detalle.getIdProducto());
				st.setDouble(3, detalle.getPrecioUnidad());
				st.setDouble(4, detalle.getUnidades());
				st.setDouble(5, detalle.getImpuesto());
				st.setDouble(6, detalle.getTotal());

				st.executeUpdate();
			}

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<DetallePedidoVO> buscarDetallePedidoId(int id) {
		List<DetallePedidoVO> listaDetallesPedido = new ArrayList<DetallePedidoVO>();
		DetallePedidoVO detallePedido = null;

		try {
			Connection con = Conexion.getConexion();
			PreparedStatement st = con.prepareStatement("SELECT * FROM detalles_pedido WHERE id_pedido = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				
				int idDetalle = rs.getInt("id");
				int idProducto = rs.getInt("id_producto");
				double precioUnidad = rs.getDouble("precio_unidad");
				int unidades = rs.getInt("unidades");
				double total = rs.getDouble("total");

				detallePedido = new DetallePedidoVO(idDetalle, idProducto, precioUnidad, unidades, total);
				
				listaDetallesPedido.add(detallePedido);
			
			}

			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaDetallesPedido;

	}
}
