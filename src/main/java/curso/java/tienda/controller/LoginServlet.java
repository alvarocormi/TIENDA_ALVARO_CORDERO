package curso.java.tienda.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.service.UsuarioService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoginServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessionLogin = request.getSession(true);
		boolean isAuthenticated = UsuarioService.verificarCredenciales(request.getParameter("email"),
				request.getParameter("clave"));

		if (isAuthenticated) {

			if (request.getParameter("email").equals("administrador@gmail.com") && UsuarioService.compararClaves(request.getParameter("clave") ,UsuarioService.encriptarClave("admin")) ) {
				sessionLogin.setAttribute("usuario", UsuarioService.recuperarUsuario(request.getParameter("email")));
				response.sendRedirect("http://localhost:9090/");
				return;
			}

			sessionLogin.setAttribute("usuario", UsuarioService.recuperarUsuario(request.getParameter("email")));
			log.info("El usuario inició sesión.");
			request.getRequestDispatcher("").forward(request, response);

		} else {
<<<<<<< HEAD
			HttpSession sessionLogin = request.getSession(false);
			request.setAttribute("error", "Error de credenciales.");
=======
			sessionLogin.setAttribute("error", "Error de credenciales.");
>>>>>>> 7d127beb7c7dc84417bf193a3fabc5ee3def2ae8
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
