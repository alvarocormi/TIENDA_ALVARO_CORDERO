package curso.java.tienda.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.dao.PedidoDAO;
import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.model.ProductoVO;
import curso.java.tienda.model.UsuarioVO;

@WebServlet("/ProcesarPagoPedidoServlet")
public class ProcesarPagoPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProcesarPagoPedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// RECUPERAR EL CARRITO DEL USUARIO
		// AÑADIR REGISTRO DE DATOS DEL PEDIDO Y ACTUALIZAR LAS TABLAS CORRESPONDIENTES
		// MOSTRAR MENSAJE DE QUE SEA REALIZADO LA COMPRA Y REDIRIGIR A ""
		
		HttpSession sessionPedido = request.getSession(false);
		HashMap<ProductoVO, Integer> carrito = (HashMap<ProductoVO, Integer>) sessionPedido.getAttribute("carrito");

		// Variable para almacenar el total
		double total = 0;

		// Verificamos si el carrito no es nulo
		if (carrito != null) {
		    // Iteramos sobre las entradas del carrito
		    for (HashMap.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
		        // Obtenemos el precio del producto y la cantidad
		        ProductoVO producto = entry.getKey();
		        int cantidad = entry.getValue();

		        // Calculamos el subtotal para este producto y lo sumamos al total
		        total += producto.getPrecio() * cantidad;
		    }
		}
		
		UsuarioVO u = (UsuarioVO) sessionPedido.getAttribute("usuario");
		Date fechaActual = new Date();
		String numFactura =  "fa"+u.getId();
		PedidoVO pedido = new PedidoVO(1,u.getId(), fechaActual, request.getParameter("metodoPago"), numFactura, total,null);
		
		
		
		PedidoDAO.crearPedido(pedido);
		
	}

}
