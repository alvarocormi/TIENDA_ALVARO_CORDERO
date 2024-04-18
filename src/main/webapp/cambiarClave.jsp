<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cambiar Contraseña</title>
</head>
<body>
<form action="CambiarClaveServlet" method="post">
        <div>
            <label for="nuevaClave">Nueva Contraseña:</label>
            <input type="password" id="nuevaClave" name="nuevaClave" required>
        </div>
        <div>
            <label for="clave">Contraseña:</label>
            <input type="password" id="clave" name="clave" required>
        </div>
        <div>
            <label for="clave">Repetir Contraseña:</label>
            <input type="password" id="claveRepetida" name="claveRepetida" required>
        </div>
        <%
		String errorMessage = (String) session.getAttribute("error");
		if (errorMessage != null) {
		%>
		<p style="color: red;"><%=errorMessage%></p>
		<%
		}
		%>
		<a href="PerfilServlet">Volver</a>
        <button type="submit">Cambiar Contraseña</button>
    </form>
    
</body>
</html>