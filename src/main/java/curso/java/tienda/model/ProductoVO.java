package curso.java.tienda.model;

import java.util.Date;

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
	int idCategoria;
	Date fechaAlta;
	Date fechaBaja;
	String imagen;
}
