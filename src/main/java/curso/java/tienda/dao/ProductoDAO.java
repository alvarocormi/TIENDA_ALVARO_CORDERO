package curso.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import curso.java.tienda.model.ProductoVO;
import curso.java.tienda.util.Conexion;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductoDAO {

	public static List<ProductoVO> findAll() {
		
		List<ProductoVO> lista = new ArrayList<ProductoVO>();
		ProductoVO producto = null;
		
		
		
		try {
			Connection con = Conexion.getConexion();
			PreparedStatement st = con.prepareStatement("SELECT * FROM productos");
			
			ResultSet rs = st.executeQuery();
			
			
			while (rs.next()) {
				producto = new ProductoVO();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setStock(rs.getInt("stock"));
				
				
				lista.add(producto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	public static ProductoVO findById(int id) {
	    ProductoVO producto = null;

	    try {
	        Connection con = Conexion.getConexion();
	        PreparedStatement st = con.prepareStatement("SELECT * FROM productos WHERE id = ?");
	        st.setInt(1, id);
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            producto = new ProductoVO();
	            producto.setId(rs.getInt("id"));
	            producto.setNombre(rs.getString("nombre"));
	            producto.setDescripcion(rs.getString("descripcion"));
	            producto.setPrecio(rs.getDouble("precio"));
	            producto.setStock(rs.getInt("stock"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return producto;
	}

}
