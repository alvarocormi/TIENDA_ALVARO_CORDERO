<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>Login</h2>



	<form action="LoginServlet" method="post">
		<label for="email">Email:</label> <input type="text"
			id="email" name="email" required><br> <br> <label
			for="clave">Password:</label> <input type="clave" id="clave"
			name="clave" required><br> <br>
		<!-- Agrega este código para mostrar el mensaje de error -->
		<%
		String errorMessage = (String) session.getAttribute("error");
		if (errorMessage != null) {
		%>
		<p style="color: red;"><%=errorMessage%></p>
		<%
		}
		%>
		<input type="submit" value="Login"> 
	</form>
	<a href="RegistroServlet">Registrarse</a>
</body>
</html>

