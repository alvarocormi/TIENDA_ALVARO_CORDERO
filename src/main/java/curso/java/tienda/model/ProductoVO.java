package curso.java.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductoVO {
	
	int id;
	String nombre;
	String descripcion;
	Double precio;
	Double impuesto;
	int stock;
	boolean baja;
}
