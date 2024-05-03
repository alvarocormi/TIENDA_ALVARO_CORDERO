package curso.java.tienda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import curso.java.tienda.service.ListadoPedidosService;
import curso.java.tienda.service.UsuarioService;

/**
 * Servlet implementation class BorrarProductoCarritoServlet
 */
@WebServlet("/BorrarPedidoListadoServlet")
public class BorrarPedidoListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrarPedidoListadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (PedidoDAO.buscarPedidoId(Integer.parseInt(id)).getEstado() == "PE") {
			PedidoDAO.cancelarPedido(Integer.parseInt(id));
		}
		request.getRequestDispatcher("ListadoPedidosServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
