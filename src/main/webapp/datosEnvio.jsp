<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Datos</title>
</head>
<body>
    <h1>Formulario de Datos</h1>
    <form action="ProcesarDatosEnvioServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="apellidos">Primer Apellido:</label>
        <input type="text" id="apellido1" name="apellido1" required><br><br>
        
        <label for="apellidos">Segundo Apellido:</label>
        <input type="text" id="apellido2" name="apellido2" required><br><br>
        
        <label for="direccion">Dirección:</label>
        <input type="text" id=direccion name="direccion" required><br><br>
        
         <label for="direccion">Telefono:</label>
        <input type="text" id="telefono" name="telefono" required><br><br>
        
        <input type="submit" value="Siguiente">
    </form>
    <a href="CarritoServlet">Volver</a>
</body>
</html>