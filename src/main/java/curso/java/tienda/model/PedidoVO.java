package curso.java.tienda.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PedidoVO {
	
    private int id;
    private int idUsuario;
    private Timestamp fecha;
    private String metodoPago;
    private String estado;
    private String numFactura;
    private double total;
    
    


	public PedidoVO() {
	}




	public PedidoVO(int idUsuario, String metodoPago, String estado, double total) {
		this.idUsuario = idUsuario;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.total = total;
	}
	

	


	

	
    
    
}
