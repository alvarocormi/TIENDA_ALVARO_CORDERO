package curso.java.tienda.filters;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter("/PagarServlet")
public class PagarFilter implements Filter {
 
    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code, if needed
    }
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        
       
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        HashMap<Integer, Integer> carrito = (HashMap<Integer, Integer>) session.getAttribute("carrito");
        
        if (carrito.size() == 0) {
        	request.getRequestDispatcher("carritoVacio.jsp").forward(request, response);
        }
        // Verificar si hay un usuario en la sesión
        if (httpRequest.getSession().getAttribute("usuario") == null) {
            // No hay usuario en la sesión, redirigir a la página de inicio de sesión
        	request.getRequestDispatcher("loginCarrito.jsp").forward(request, response);
        } else {
        	request.getRequestDispatcher("datosEnvio.jsp").forward(request, response);
        }
    }
 
    public void destroy() {
        // Cleanup code, if any
    }
}
