package curso.java.tienda.model;

import java.util.Date;

import lombok.Data;

@Data
public class PedidoVO {
	
	private int id; 
	private int usuario_id;
	private Date fecha;
	private String metodoPago;
	private String numFactura;
	private double total;
	
	public PedidoVO(int id, int usuario_id, Date fecha, String metodoPago, String numFactura, double total) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		this.numFactura = numFactura;
		this.total = total;
	}

	public PedidoVO(int usuario_id, Date fecha, String metodoPago, String numFactura, double total) {
		super();
		this.usuario_id = usuario_id;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		this.numFactura = numFactura;
		this.total = total;
	}	
	
}
