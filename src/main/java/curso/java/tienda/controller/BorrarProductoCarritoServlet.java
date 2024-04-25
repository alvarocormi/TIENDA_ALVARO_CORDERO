package curso.java.tienda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.model.ProductoVO;
import curso.java.tienda.service.UsuarioService;

/**
 * Servlet implementation class BorrarProductoCarritoServlet
 */
@WebServlet("/BorrarProductoCarritoServlet")
public class BorrarProductoCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarProductoCarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productoId = request.getParameter("idProducto");
        int id = Integer.parseInt(productoId);
        
        Map<ProductoVO, Integer> carrito = (Map<ProductoVO, Integer>) request.getSession().getAttribute("carrito");

        // Usar un iterador para evitar ConcurrentModificationException
        Iterator<Map.Entry<ProductoVO, Integer>> iterator = carrito.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ProductoVO, Integer> entry = iterator.next();
            ProductoVO producto = entry.getKey();
            if (producto.getId() == id) {
                iterator.remove();  // Usar el método remove del iterador para eliminar el elemento
                break;  // Terminar el bucle una vez que se elimine el producto
            }
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
