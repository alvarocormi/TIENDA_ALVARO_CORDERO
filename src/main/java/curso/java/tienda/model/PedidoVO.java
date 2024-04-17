package curso.java.tienda.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoVO {
	
	private int id; 
	private int idUsuario;
	private Date fecha;
	private String metodoPago;
	private String numFactura;
	private double total;
	private String estado;
	
	
	
}
