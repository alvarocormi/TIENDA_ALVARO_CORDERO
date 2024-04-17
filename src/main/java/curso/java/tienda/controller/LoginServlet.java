package curso.java.tienda.controller;

import java.io.*;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.service.UsuarioService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isAuthenticated = UsuarioDAO.verificarCredenciales(request.getParameter("email"),
				request.getParameter("clave"));

		if (isAuthenticated) {
			HttpSession sessionLogin = request.getSession(true);
			sessionLogin.setAttribute("usuario", UsuarioService.agregarUsuarioEmail(request.getParameter("email")));
			request.getRequestDispatcher("").forward(request, response);

		} else {
			HttpSession sessionLogin = request.getSession(false);
			sessionLogin.setAttribute("error", "Error de credenciales.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
