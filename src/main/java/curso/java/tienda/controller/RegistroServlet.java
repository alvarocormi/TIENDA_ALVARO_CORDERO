package curso.java.tienda.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curso.java.tienda.dao.UsuarioDAO;
import curso.java.tienda.service.UsuarioService;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("registro.jsp").forward(request, response);
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String email = request.getParameter("email");
	        String clave = request.getParameter("clave");
	        String claveRepetida = request.getParameter("claveRepetida");
	        String error = null;

	        // Comprueba si los campos están vacíos
	        if (!UsuarioService.comprobarVacios(email, clave, claveRepetida)) {
	            error = "Introduce todos los campos";
	        }

	        // Comprueba si el email es incorrecto
	        if (!UsuarioService.validarEmail(email) && error == null) {
	            error = "El email es incorrecto";
	        }

	        // Comprueba si las claves coinciden
	        if (!UsuarioService.validarClaves(clave, claveRepetida) && error == null) {
	            error = "Las claves no son las mismas";
	        } 
	        

	        if (error == null) {
	            // Si no hay errores, procede con la lógica de negocio
	            if (!UsuarioService.verificarCredenciales(email, clave)) {
	                try {
	                    // El usuario no existe, así que lo agregamos a la base de dato
	                    UsuarioDAO.agregarUsuario(1,email, UsuarioService.encriptarClave(clave));
	                    HttpSession sessionRegistro = request.getSession(true);
	                    // Agregamos al usuario a la sesión
	                    sessionRegistro.setAttribute("usuario", UsuarioService.agregarUsuarioEmail(email));
	                	response.sendRedirect(request.getContextPath());
	                    return; // ¡Importante! Salir del método después de redirigir
	                } catch (SQLException ex) {
	                    error = "Error de SQL: " + ex.getMessage();
	                }
	            } else {
	                error = "El usuario ya existe";
	            }
	        }

	        // Si llegamos aquí, significa que hay errores o fallos en la lógica
	        request.setAttribute("error", error);
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    }
}
