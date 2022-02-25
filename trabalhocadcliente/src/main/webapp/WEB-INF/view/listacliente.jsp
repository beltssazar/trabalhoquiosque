<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix= "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
<style>
	h1{
		text-align: center;	
	
	
	}
	table{
		margin:auto;
		border: 1px solid black;
		border-collapse: collapse;
		background: #FFFFF0;
		
	
	}
	table tr,th,td{
		border: 1px solid black;
		padding: 5px;
		
	}
	th{
		background: #F0FFF0;
		text-transform: 
	}
	td{
		text-align: center;
	
	}


</style>
</head>
<body>
<h1>Lista de Clientes</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Telefone</th>
			<th>Email</th>
			<th>Produto de Interesse</th>
			<th>Gênero</th>
			<th>Idade</th>
			<th>Altera</th>
			<th>Exclui</th>
	<c:forEach items="${clientes }" var="c">
		<tr>
			<td>${c.id }</td>
			<td>${c.nome }</td>
			<td>${c.endereco }</td>
			<td>${c.numero }</td>
			<td>${c.email }</td>
			<td>${c.produto }</td>
			<td>${c.genero }</td>
			<td>${c.idade }</td>
			<td><a href="alterarCliente?idCliente=${c.id }" onclick="return confirm('Deseje realmente alterar dados do cliente ${c.nome}?')">Alterar</a></td>
			<td><a href="excluirCliente?idCliente=${c.id }" onclick="return confirm('Confirmar exclusão do cliente ${c.nome}?')">Excluir</a></td>
		</tr>
	</c:forEach>
	
	</table>

</body>
</html>