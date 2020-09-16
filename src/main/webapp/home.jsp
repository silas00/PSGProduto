<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>

<style type="text/css">
	body{
		text-align: center;
	}
	table {
		margin-left: 15%;
		min-width: 70%; 
		border: 1px solid #CCC;
		border-collapse: collapse; 
	}
	table tr{line-height: 30px;}
	table tr th { background: #000033; color: #FFF;}
	table tr td { border:1px solid #CCC; margin: 5px;}
	input[type=text], input[type=email], input[type=tel]{
		min-width: 60%;
	}
	input[type=submit], a{
		background: green;
		padding: 5px;
		margin: 5px;
		color: #FFF;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>Cadastro de Produtos</h1>
	<c:url value="/produto/cadastro" var="registerUrl" />
	<form action="${registerUrl}" method="post" enctype="multipart/form-data">
		<table>
			<c:if test="${produto.id ne null}">
				<tr>
				<td>Produto ID:</td>
					<td><input type="text" name="id" value="${produto.id}" readonly="readonly"></td>
				</tr>
			</c:if>
			<tr>
				<td>Nome do Produto:</td>
				<td><input type="text" name="nome" value="${produto.nome}" required></td>
			</tr>
			<tr>
				<td>Tipo do Produto:</td>
				<td><input type="text" name="tipo" value="${produto.tipo}" required></td>
			</tr>
			<tr>
				<td>Preço:</td>
				<td><input type="text" name="preco" value="${produto.preco}" required></td>
			</tr>
			<tr>
				<td>Vencimento:</td>
				<td><input type="text"  name="vencimento" value="${produto.vencimento}" required></td>
			</tr>
			<tr>
				<td>Upload:</td>
				<td><input type="file" name="upload"></td>
			</tr>	
			<c:if test="${produto.id ne null}">
				<tr>
					<td colspan="2"><input type="submit" value="Atualizar"></td>
				</tr>
			</c:if>
			<c:if test="${produto.id eq null}">
				<tr>
					<td colspan="2"><input type="submit" value="Cadastrar"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>Lista de Produtos</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome do Produto</th>
			<th>Tipo</th>
			<th>Preço</th>
			<th>Vencimento</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${listProduto}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.tipo}</td>
				<td>${produto.preco}</td>
				<td>${produto.vencimento}</td>
				
				<td>
					<form action="<c:url value="/produto/update"/>" method="post">
						<input type="hidden" name="prodId" value="${produto.id}">
						<input type="submit" value="Atualizar">
					</form>
				<td>
					<form action="<c:url value="/produto/delete"/>" method="post">
						<input type="hidden" name="prodId" value="${produto.id}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>