<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Estat�sticas Clientes</h1>

<h2>Total de clientes por g�nero Masculino</h2>
	<table>
		<tr>
			<th>TOTAL</th>
			
	
		<tr>
			<td>${masculino }</td>
			
		</tr>
	
		
	
	</table>
	
<h2>Total de clientes por g�nero Feminino</h2>
	<table>
		<tr>
			<th>TOTAL</th>
			
	
		<tr>
			<td>${feminino }</td>
			
		</tr>
	
		
	
	</table>


</body>
</html>