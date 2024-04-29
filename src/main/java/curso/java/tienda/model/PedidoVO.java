package curso.java.tienda.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoVO {
	
    private int id;
    private int idUsuario;
    private Timestamp fecha;
    private String metodoPago;
    private String estado;
    private String numFactura;
    private double total;
    
    
	public PedidoVO(int idUsuario, String metodoPago, String numFactura, double total) {
		super();
		this.idUsuario = idUsuario;
		this.metodoPago = metodoPago;
		this.numFactura = numFactura;
		this.total = total;
	}


	public PedidoVO(int idUsuario, String metodoPago) {
		this.idUsuario = idUsuario;
		this.metodoPago = metodoPago;
	}


	

	
    
    
}
