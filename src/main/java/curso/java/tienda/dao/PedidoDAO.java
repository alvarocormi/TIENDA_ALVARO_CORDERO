package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.util.Conexion;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PedidoDAO {

	public static void crearPedido(PedidoVO pedido) {
		try {
            Connection con = Conexion.getConexion();
            String query = "INSERT INTO pedidos (id_usuario, metodo_pago, num_factura, total) " +
                           "VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, pedido.getIdUsuario());
            st.setString(2, pedido.getMetodoPago());
            st.setString(3, pedido.getNumFactura());
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
	
	public static PedidoVO buscarPedidoNumFactura(String numFactura) {
        PedidoVO pedido = null;

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM pedidos WHERE num_factura = ?");
            st.setString(1, numFactura);

            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                int idPedido = rs.getInt("id");
                int idUsuario = rs.getInt("id_usuario");
                Timestamp fecha = rs.getTimestamp("fecha");
                String metodoPago = rs.getString("metodo_pago");
                String estado = rs.getString("estado");
                double total = rs.getDouble("total");

                pedido = new PedidoVO(idPedido, idUsuario, fecha, metodoPago, estado, numFactura, total);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return pedido;

    }
}
