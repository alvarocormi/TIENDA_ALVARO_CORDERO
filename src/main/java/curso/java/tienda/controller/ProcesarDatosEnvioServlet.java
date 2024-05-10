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

@WebServlet("/ProcesarDatosEnvioServlet")
public class ProcesarDatosEnvioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesarDatosEnvioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		UsuarioVO u = (UsuarioVO) session.getAttribute("usuario");
		// ACTUALIZAR EL USUARIO EN LA TABLA
		UsuarioService.agregarDatosEnvio(request.getParameter("nombre"), request.getParameter("apellido1"),
				request.getParameter("apellido2"), request.getParameter("direccion"), request.getParameter("telefono"),
				u.getEmail());

		UsuarioVO u2 = UsuarioService.recuperarUsuario(u.getEmail());
		session.setAttribute("usuario", u2);

		request.getRequestDispatcher("metodoPago.jsp").forward(request, response);
	}

}
