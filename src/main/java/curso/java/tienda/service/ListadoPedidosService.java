package curso.java.tienda.service;

import java.util.List;

import curso.java.tienda.dao.PedidoDAO;
import curso.java.tienda.model.PedidoVO;

public class ListadoPedidosService {
	
	public static List<PedidoVO> listarPedidos(int idUsuario, String orden) {
		return PedidoDAO.listarPedidosUsuario(idUsuario, orden);
	}
}
