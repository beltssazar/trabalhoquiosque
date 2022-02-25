<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Clientes</title>
<style>
	h1{
		text-align: center;
	
	}
	form{
		display: flex;
		box-sizing:border-box;
		flex-direction:column;
		width: 30%;
		margin: auto;
		border: 1px solid black;
		line-height: 30px;
		padding: 10px;
		box-shadow:  10px 8px 10px #6035A1;
		background: rgba(255, 255, 255, 0.1);
		backdrop-filter: blur(10px);
		-webkit-backdrop-filter: blur(10px);
	
	}
	input{
		height: 25px;
	
	}
	
	select {
		height: 30px;
	}
	.prod{
		margin-bottom: 10px;
	}
	button {
		width: 30%;
		
	}
</style>
</head>
<body>
<h1>Cadastro de Clientes</h1>
	
	
	
	<form action="salvar" method="post">
	
	<input type="hidden" name="id" value="${cliente.id }">
		<label>Nome:</label><input type="text" name="nome" value="${cliente.nome }" required="required" placeholder="Informe seu nome">
		<label>Endereço:</label><input type="text" name="endereco" value="${cliente.endereco }" required="required" placeholder="Informe seu endereço">
		<label>Telefone:</label><input type="text" name="numero" value="${cliente.numero }" required="required" placeholder="Informe o número do telefone/celular">
		<label>Email:</label><input type="email" name="email" value="${cliente.email }" required="required" placeholder="Informe seu email">
		<label>Idade:</label><input type="number" name="idade" value="${cliente.idade }" required="required" placeholder="Informe sua idade">
		<label>Gênero:</label>
		<!-- Usando uma tag de estrutura de repetição FOR importada de uma biblioteca na pasta LIB (JSTL) -->
		<select name="genero">
			<c:forEach items="${genero }" var="g">
				<option value="${g }" <c:if test="${cliente.genero == g }">selected</c:if> >${g.toString() }</option>
			</c:forEach>
		</select>
		<label>Qual seu produto de interesse?</label><input type="text" class="prod" name="produto" value="${cliente.produto }" required="required" placeholder="Informe seu produto de interesse">
		
		<button type="submit">CADASTRAR</button>
	
	</form>
</body>
</html>