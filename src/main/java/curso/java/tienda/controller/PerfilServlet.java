package curso.java.tienda.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.model.UsuarioVO;
import curso.java.tienda.service.UsuarioService;

/**
 * Servlet implementation class EditarPerfilServlet
 */
@WebServlet("/PerfilServlet")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
             
        HttpSession session = ((HttpServletRequest) request).getSession(false); 
		
		if (httpRequest.getSession().getAttribute("usuario") == null) {
	            // No hay usuario en la sesión, redirigir a la página de inicio de sesión
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
	        } else {
	        	request.getRequestDispatcher("perfil.jsp").forward(request, response);
	        }
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doPost(req, resp);
    }

	

}
