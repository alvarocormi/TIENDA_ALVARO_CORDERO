<%@page import="curso.java.tienda.model.UsuarioVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
</head>
<body>
    <form action="PerfilServlet" method="post">
        <%@ page import="javax.servlet.http.HttpSession"%>
        <%
        UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
        %>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= (usuario != null && usuario.getNombre() != null) ? usuario.getNombre() : "" %>"><br><br>

        <label for="apellido1">Primer Apellido:</label>
        <input type="text" id="apellido1" name="apellido1" value="<%= (usuario != null && usuario.getApellido1() != null) ? usuario.getApellido1() : "" %>"><br><br>

        <label for="apellido2">Segundo Apellido:</label>
        <input type="text" id="apellido2" name="apellido2" value="<%= (usuario != null && usuario.getApellido2() != null) ? usuario.getApellido2() : "" %>"><br><br>

        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" value="<%= (usuario != null && usuario.getDireccion() != null) ? usuario.getDireccion() : "" %>"><br><br>

        <label for="dni">DNI:</label>
        <input type="text" id="dni" name="dni" value="<%= (usuario != null && usuario.getDni() != null) ? usuario.getDni() : "" %>"><br><br>

        <label for="localidad">Localidad:</label>
        <input type="text" id="localidad" name="localidad" value="<%= (usuario != null && usuario.getLocalidad() != null) ? usuario.getLocalidad() : "" %>"><br><br>

        <label for="provincia">Provincia:</label>
        <input type="text" id="provincia" name="provincia" value="<%= (usuario != null && usuario.getProvincia() != null) ? usuario.getProvincia() : "" %>"><br><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" value="<%= (usuario != null && usuario.getTelefono() != null) ? usuario.getTelefono() : "" %>"><br><br>
        
		<a href="AñadirProductoServlet">Volver</a>
        <input type="submit" value="Editar">
          <a href="CambiarClaveServlet">Cambiar Contraseña</a>
    </form>
</body>
</html>
