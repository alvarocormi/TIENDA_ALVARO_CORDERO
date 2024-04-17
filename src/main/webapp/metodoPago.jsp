<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Seleccionar Método de Pago</title>
</head>
<body>
    <h1>Seleccionar Método de Pago</h1>
    
    <form action="ProcesarPagoPedidoServlet" method="post">
        <label><input type="radio" name="metodoPago" value="paypal"> PayPal</label><br>
        <label><input type="radio" name="metodoPago" value="bizum" checked> Bizum</label><br>
        <label><input type="radio" name="metodoPago" value="tarjeta"> Tarjeta de Crédito</label><br>
        
        <input type="submit" value="Continuar">
    </form>
    <a href="PagarServlet">Volver</a>
</body>
</html>
