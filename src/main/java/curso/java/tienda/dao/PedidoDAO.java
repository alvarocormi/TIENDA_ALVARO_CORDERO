package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.util.Conexion;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PedidoDAO {

	public static PedidoVO crearPedido(PedidoVO pedido) {
        Connection conexion = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Obtener la conexión
            conexion = Conexion.getConexion();

            // Consulta SQL para insertar un nuevo pedido
            String sql = "INSERT INTO pedidos (id_usuario, fecha, metodo_pago, num_factura, total) VALUES (?, ?, ?, ?, ?)";

            // Preparar la declaración SQL con los parámetros del pedido
            stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pedido.getIdUsuario());
            stmt.setDate(2, new java.sql.Date(pedido.getFecha().getTime())); // Convertir la fecha de java.util.Date a java.sql.Date
            stmt.setString(3, pedido.getMetodoPago());
            stmt.setString(4, pedido.getNumFactura());
            stmt.setDouble(5, pedido.getTotal());

            // Ejecutar la consulta
            int filasInsertadas = stmt.executeUpdate();

            // Verificar si se insertó correctamente y obtener el ID generado
            if (filasInsertadas > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    pedido.setId(idGenerado); // Establecer el ID generado en el objeto PedidoVO
                }
            } else {
                // Si no se insertó correctamente, retornar null o lanzar una excepción según el caso
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones (retornar null, lanzar excepción personalizada, etc.)
            return null;
        } 

        return pedido;
    }
}
