package curso.java.tienda.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.model.UsuarioVO;
import curso.java.tienda.service.UsuarioService;

/**
 * Servlet implementation class EditarPerfilServlet
 */
@WebServlet("/EditarPerfilServlet")
public class EditarPerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
             
        HttpSession session = ((HttpServletRequest) request).getSession(false); 
		
		if (httpRequest.getSession().getAttribute("usuario") == null) {
	            // No hay usuario en la sesión, redirigir a la página de inicio de sesión
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
	        } else {
	        	request.getRequestDispatcher("editarPerfil.jsp").forward(request, response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionLogin = request.getSession(true);
		UsuarioVO usuario = (UsuarioVO) sessionLogin.getAttribute("usuario");
		
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String direccion = request.getParameter("direccion");
		String dni = request.getParameter("dni");
		String email = usuario.getEmail();
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		
		UsuarioService.editarUsuario(nombre, apellido1, apellido2, direccion, dni, email, localidad, provincia, telefono);
		
		
		sessionLogin.setAttribute("usuario", UsuarioService.recuperarUsuario(email));
    	request.getRequestDispatcher("perfil.jsp").forward(request, response);
		
	}

}
