package curso.java.tienda.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductoVO {
	
	private int id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private float impuesto;
	private int stock;
	private int idCategoria;
	private Date fechaAlta;
	private Date fechaBaja;
	private String imagen;
}
