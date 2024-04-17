package curso.java.tienda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.tienda.model.ProductoVO;

@WebServlet("/ActualizarCantidadServlet")
public class ActualizarCantidadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar los parámetros de la solicitud
        int productoId = Integer.parseInt(request.getParameter("productoId"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        // Obtener el carrito de la sesión
        Map<ProductoVO, Integer> carrito = (Map<ProductoVO, Integer>) request.getSession().getAttribute("carrito");
        if (carrito != null) {
            // Buscar el producto en el carrito y actualizar su cantidad
            for (Map.Entry<ProductoVO, Integer> entry : carrito.entrySet()) {
                ProductoVO producto = entry.getKey();
                if (producto.getId() == productoId) {
                    carrito.put(producto, cantidad);
                    break;
                }
            }
            // Actualizar la cantidad en la respuesta
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print(cantidad);
            out.flush();
        } else {
            // Manejar el caso en que el carrito no esté inicializado
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}