<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Registro</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="RegistroServlet" method="post">
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="clave">Clave:</label>
            <input type="password" id="clave" name="clave" required>
        </div>
        <div>
            <label for="clave">Repetir Clave:</label>
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
        <button type="submit">Registrarse</button>
    </form>
</body>
</html>


