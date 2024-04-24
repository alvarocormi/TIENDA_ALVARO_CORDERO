package curso.java.tienda.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.service.UsuarioService;

@WebServlet("/LoginServletCarrito")
public class LoginServletCarrito extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("loginCarrito.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isAuthenticated = UsuarioService.verificarCredenciales(request.getParameter("email"),
				request.getParameter("clave"));

		if (isAuthenticated) {
			HttpSession sessionLogin = request.getSession(true);
			sessionLogin.setAttribute("usuario", UsuarioService.recuperarUsuario(request.getParameter("email")));
			request.getRequestDispatcher("datosEnvio.jsp").forward(request, response);

		} else {
			HttpSession sessionLogin = request.getSession(false);
			sessionLogin.setAttribute("error", "Error de credenciales.");
			request.getRequestDispatcher("loginCarrito.jsp").forward(request, response);
		}

	}
}
