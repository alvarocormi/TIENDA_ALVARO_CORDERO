package curso.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.model.PedidoVO;
import curso.java.tienda.model.UsuarioVO;
import curso.java.tienda.service.ListadoPedidosService;

/**
 * Servlet implementation class ListadoPedidosServlet
 */
@WebServlet("/ListadoPedidosServlet")
public class ListadoPedidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoPedidosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		
		HttpSession session = request.getSession(true);
		UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
		
		String orden = request.getParameter("orden");
		
		if (orden == null) {	
			orden = "desc";
		}
		
		pedidos = ListadoPedidosService.listarPedidos(usuario.getId(), orden);
		System.out.println(orden);
		
		
		request.setAttribute("pedidos", pedidos);
		request.getRequestDispatcher("listadoPedidos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
