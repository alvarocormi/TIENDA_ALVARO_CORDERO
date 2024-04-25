package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import curso.java.tienda.model.DetallePedidoVO;
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
}
