package curso.java.tienda.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.dao.ProductoDAO;
import curso.java.tienda.model.ProductoVO;

/**
 * Servlet implementation class ComprarServlet
 */
@WebServlet("/AñadirProductoServlet")
public class AñadirProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AñadirProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("id") != null) {
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			
			

			HashMap<ProductoVO, Integer> carrito = (HashMap<ProductoVO, Integer>) session.getAttribute("carrito");

			if (carrito == null) {
				carrito = new HashMap<>();
				session.setAttribute("carrito", carrito);
			}

			Integer cantidad = carrito.getOrDefault(ProductoDAO.findById(Integer.parseInt(id)), 0);
			
			carrito.put(ProductoDAO.findById(Integer.parseInt(id)), cantidad + 1);

			Integer totalCarrito = (Integer) session.getAttribute("totalCarrito");
			if (totalCarrito == null) {
				totalCarrito = 0;
			}
			session.setAttribute("totalCarrito", carrito.size());

		}

		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
