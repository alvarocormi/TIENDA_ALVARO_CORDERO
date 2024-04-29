package curso.java.tienda.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.dao.ConsultaDAO;
import curso.java.tienda.model.ConsultaVO;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String lang = request.getParameter("lang");
		
		if ("es".equals(lang)) {
//			request.setAttribute("locale", new Locale("es"));
			request.getSession().setAttribute("locale", new Locale("es"));
		} else if ("en".equals(lang)) {
//			request.setAttribute("locale", new Locale("en"));
			request.getSession().setAttribute("locale", new Locale("en"));
		} else {
//			request.setAttribute("locale", request.getLocale());
			request.getSession().setAttribute("locale", request.getLocale());
		}

		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		ConsultaVO c = new ConsultaVO(request.getParameter("name"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("mensaje"));
		try {
			ConsultaDAO.insertarConsulta(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("").forward(request, response);
	}

}
