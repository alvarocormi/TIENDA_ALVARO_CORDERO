package curso.java.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LineasPedidoVO {

	private int pedido_id;
	private int producto_id;
	private int unidades;
	private double precioUnidad;
	private double impuesto;
	private double total;
}
