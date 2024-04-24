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
 * Servlet implementation class CambiarClaveServlet
 */
@WebServlet("/CambiarClaveServlet")
public class CambiarClaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CambiarClaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cambiarClave.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nuevaClave = request.getParameter("nuevaClave");
		String clave = request.getParameter("clave");
		String claveRepetida = request.getParameter("claveRepetida");
		
		if(UsuarioService.validarClaves(clave, claveRepetida)) {
			request.getRequestDispatcher("cambiarClave.jsp").forward(request, response);
		} 
		
		 HttpSession session = request.getSession(true);
		 UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
		 if(!UsuarioService.compararClaves(nuevaClave, usuario.getClave())) {
			 UsuarioService.cambiarClave(nuevaClave, usuario.getEmail());
			 
		 }
	}

}
