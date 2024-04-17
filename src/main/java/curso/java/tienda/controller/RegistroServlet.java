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

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String clave = request.getParameter("clave");

        // Verificar si el usuario ya existe en la base de datos
        if (!UsuarioDAO.verificarCredenciales(email, clave)) {
            try {
                // El usuario no existe, así que lo agregamos a la base de datos
                UsuarioDAO.agregarUsuario(email, clave);
                HttpSession sessionRegistro = request.getSession(true);
                sessionRegistro.setAttribute("usuario", curso.java.tienda.service.UsuarioService.agregarUsuario(email));
                request.getRequestDispatcher("").forward(request, response);
            } catch (SQLException ex) {
                response.getWriter().println("Paso por el catch.");
            }
        } else {
            // El usuario ya existe
            response.getWriter().println("El usuario ya existe.");
        }
    }
}

