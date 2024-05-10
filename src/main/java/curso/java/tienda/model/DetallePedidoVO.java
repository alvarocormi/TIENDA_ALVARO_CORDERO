package curso.java.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class DetallePedidoVO {
	private int id;
	private int idPedido;
	private int idProducto;
	private double precioUnidad;
	private int unidades;
	private float impuesto;
	private double total;
	
	public DetallePedidoVO(int idPedido, int idProducto, double precioUnidad, int unidades, float impuesto, double total) {
		super();
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.precioUnidad = precioUnidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
	}

	public DetallePedidoVO(int id, int idProducto, double precioUnidad, int unidades, double total) {
		this.id = id;
		this.idProducto = idProducto;
		this.precioUnidad = precioUnidad;
		this.unidades = unidades;
		this.total = total;
	}
	
	
}
