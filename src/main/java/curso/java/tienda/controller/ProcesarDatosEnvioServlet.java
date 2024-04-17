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
		try {
			// LLAMAR A SERVICE PARA VALIDAR LOS DATOS RECOGIDOS POR EL FORMULARIO
			
			// ACTUALIZAR EL USUARIO EN LA TABLA 
			UsuarioDAO.agregarDatosEnvio(request.getParameter("nombre"), request.getParameter("apellidos"),
			request.getParameter("direccion"), request.getParameter("codigoPostal"), u.getEmail());
			
			request.getRequestDispatcher("metodoPago.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
