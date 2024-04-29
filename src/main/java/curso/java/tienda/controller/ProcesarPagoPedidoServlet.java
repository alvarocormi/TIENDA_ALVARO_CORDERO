package curso.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
import curso.java.tienda.dao.DetallePedidoDAO;
import curso.java.tienda.model.DetallePedidoVO;
import curso.java.tienda.dao.ProductoDAO;

@WebServlet("/ProcesarPagoPedidoServlet")
public class ProcesarPagoPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcesarPagoPedidoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECUPERAR EL CARRITO DEL USUARIO
		// AÑADIR REGISTRO DE DATOS DEL PEDIDO Y ACTUALIZAR LAS TABLAS CORRESPONDIENTES
		// MOSTRAR MENSAJE DE QUE SEA REALIZADO LA COMPRA Y REDIRIGIR A ""

		HttpSession sessionPedido = request.getSession(false);
		HashMap<ProductoVO, Integer> carrito = (HashMap<ProductoVO, Integer>) sessionPedido.getAttribute("carrito");

		// Variable para almacenar el total
		double total = 0;

		// Verificamos si el carrito no es nulo
		if (carrito.size() > 0) {
			for (HashMap.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
				ProductoVO producto = entry.getKey();
				int cantidad = entry.getValue();
				int stock = ProductoDAO.comprobarStock(producto.getId());
				if (stock != -1) {
					if (stock < cantidad) {
						// REDIRIGIR A LA VISTA E INDICAR QUE PRODUCTO SE A QUEDADO SIN STOCK
						request.getRequestDispatcher("CarritoServlet").forward(request, response);
						return;
					}
				}

				total += producto.getPrecio() * cantidad;
			}

			UsuarioVO u = (UsuarioVO) sessionPedido.getAttribute("usuario");
			Date fechaActual = new Date();
			String numFactura = PedidoDAO.asignarNumFactura(u.getId());

			PedidoVO pedido = new PedidoVO(u.getId(), request.getParameter("metodoPago"));

			PedidoDAO.crearPedido(pedido);


			PedidoVO pedidoInsertado = PedidoDAO.buscarUltimoPedidoPorUsuario(u.getId());
			

			List<DetallePedidoVO> detalles = new ArrayList<>();

			for (HashMap.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
				ProductoVO producto = entry.getKey();
				int cantidad = entry.getValue();
				double totalMasImpuesto = ((producto.getPrecio()*producto.getImpuesto())+producto.getPrecio())*cantidad;
				DetallePedidoVO detalle = new DetallePedidoVO(pedidoInsertado.getId(), producto.getId(), producto.getPrecio(), cantidad, producto.getImpuesto(), totalMasImpuesto);
				detalles.add(detalle);
			}
			
			DetallePedidoDAO.rellenarDetallePedido(detalles);
			
			// ACTUALIZO LA TABLA DE PRODUCTOS CON EL NUEVO STOCK DESPUES DE LA VENTA
			for (HashMap.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
				ProductoVO producto = entry.getKey();
				int cantidad = entry.getValue(); 
				
				ProductoDAO.actualizarStock(producto.getId(), cantidad);
			}
			
			sessionPedido.setAttribute("carrito", null);
			request.getRequestDispatcher("thankyou.jsp").forward(request, response);

		}else {
			// REDIRIGIR E INDICAR QUE EL CARRITO ESTA VACIO
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}

	}

}
