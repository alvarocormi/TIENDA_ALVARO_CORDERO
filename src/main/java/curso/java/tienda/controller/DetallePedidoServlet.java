package curso.java.tienda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.dao.ProductoDAO;
import curso.java.tienda.model.DetallePedidoVO;
import curso.java.tienda.model.ProductoVO;
import curso.java.tienda.service.DetallePedidoService;

/**
 * Servlet implementation class DetallePedidoServlet
 */
@WebServlet("/DetallePedidoServlet")
public class DetallePedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("idPedido") != null) {
			String idPedido = request.getParameter("idPedido");

			List<DetallePedidoVO> listaDetallePedido = DetallePedidoService.buscarDetallePedido(Integer.parseInt(idPedido));
			
			request.setAttribute("detallesPedido", listaDetallePedido);
			
			request.getRequestDispatcher("listadoDetallePedidos.jsp").forward(request, response);

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
