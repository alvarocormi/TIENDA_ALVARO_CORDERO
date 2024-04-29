package curso.java.tienda.service;

import java.util.List;

import curso.java.tienda.dao.DetallePedidoDAO;
import curso.java.tienda.model.DetallePedidoVO;

public class DetallePedidoService {
	
	public static List<DetallePedidoVO> buscarDetallePedido(int id) {
		return DetallePedidoDAO.buscarDetallePedidoId(id);
		
	}
}
