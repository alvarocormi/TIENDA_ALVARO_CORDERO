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
        
        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" required><br><br>
        
        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>
        
        <label for="codigoPostal">Código Postal:</label>
        <input type="text" id="codigoPostal" name="codigoPostal" required pattern="[0-9]{5}" title="Código Postal válido de 5 dígitos"><br><br>
        
        <input type="submit" value="Siguiente">
    </form>
    <a href="CarritoServlet">Volver</a>
</body>
</html>