<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>buyList</title>

<c:url
	value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	var="cssPath" />
<link rel="stylesheet" href="${cssPath}" />

<c:url
	value="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	var="fontPath" />
<link rel="stylesheet" href="${fontPath}" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<style type="text/css">
body {
	text-align: center;
}

.table td, .table th {
	border-top: none;
}

.form-group .form-control {
	width: calc(100% - 15px);
}

.cadastro {
	margin-left: 15px;
}

h1 {
	font-family: 'Open Sans', sans-serif;
	letter-spacing: .4rem;
	font-size: 25px;
}

@media ( max-width :728px) {
	.table-responsive2 {
		display: none;
	}
	.table-responsive3 {
		display: block !important;
		width: 100%;
	}
}

.table thead th {
	border-bottom: none !important;
}
</style>
</head>
<body class="bg-light">

		<div class="container mb-4 bg-white">
		
		<img class="img-fluid" src="/produto/img" />
			
		<c:url value="/produto/cadastro" var="registerUrl" />

		<form class="cadastro" action="${registerUrl}" method="post"
			enctype="multipart/form-data">

			<div class="form-group row">

				<c:if test="${produto.id ne null}">

					<label for="formGroupExampleInput">Produto ID:</label>
					<input class="form-control" type="text" name="id"
						value="${produto.id}" readonly="readonly">

				</c:if>

			</div>

			<div class="form-group row">

				<label for="formGroupExampleInput">Nome do Produto:</label> <input
					class="form-control" type="text" name="nome"
					value="${produto.nome}" required>

			</div>

			<div class="form-group row">

				<label for="formGroupExampleInput">Tipo do Produto:</label> <input
					class="form-control" type="text" name="tipo"
					value="${produto.tipo}" required>

			</div>

			<div class="form-group row">

				<label for="formGroupExampleInput">Preço:</label> <input
					class="form-control" type="text" name="preco"
					value="${produto.preco}" required>

			</div>

			<div class="form-group row">

				<label for="formGroupExampleInput">Vencimento:</label> <input
					class="form-control" type="text" name="vencimento"
					value="${produto.vencimento}" required>

			</div>

			<div class="form-group row">

				<label for="formGroupExampleInput">Upload:</label> <input
					class="form-control-file" type="file" name="upload">

			</div>

			<br>

			<c:if test="${produto.id ne null}">
				<tr>
					<td colspan="2"><input class="btn btn-success mb-2" type="submit"
						value="Atualizar"></td>
				</tr>
			</c:if>
			<c:if test="${produto.id eq null}">
				<tr>
					<td colspan="2"><input class="btn btn-success mb-2" type="submit"
						value="Cadastrar"></td>
				</tr>
			</c:if>

		</form>
	</div>
	
	<div class="container bg-white">

		<h1 class="mt-6">LISTA DE PRODUTOS</h1>

		<div class="table-responsive">

			<table class="table text-center align-middle">

				<thead class="thead-dark">

					<tr>
						<th>ID</th>
						<th>Nome do Produto</th>
						<th class="table-responsive2">Tipo</th>
						<th class="table-responsive2">Preço</th>
						<th class="table-responsive2">Vencimento</th>
						<th class="table-responsive2">Update</th>
						<th class="table-responsive2">Delete</th>
						<th class="table-responsive2">Download</th>
						<th class="table-responsive3" style="display: none;">Descrição</th>

					</tr>

				</thead>

				<c:forEach items="${listProduto}" var="produto">
					<tr>
						<td class="align-middle">${produto.id}</td>
						<td class="align-middle">${produto.nome}</td>
						<td class="table-responsive2 align-middle">${produto.tipo}</td>
						<td class="table-responsive2 align-middle text-left">R$
							${produto.preco}</td>
						<td class="table-responsive2 align-middle">${produto.vencimento}</td>


						<td class="table-responsive2 align-middle">
							<form action="<c:url value="/produto/update"/>" method="post">
								<input type="hidden" name="prodId" value="${produto.id}">
								<input class="btn btn-primary" type="submit" value="Atualizar">
							</form>
						<td class="table-responsive2 align-middle">
							<form action="<c:url value="/produto/delete"/>" method="post">
								<input type="hidden" name="prodId" value="${produto.id}">
								<input class="btn btn-danger" type="submit" value="Delete">
							</form>
						<td class="table-responsive2 align-middle">
							<form action="<c:url value="/produto/download"/>" method="get">
								<input type="hidden" name="id" value="${produto.id}"> <input
									class="btn btn-info align-middle" type="submit"
									value="Download">
							</form>
						<td class="table-responsive3 align-middle" style="display: none;">
							<button type="button" class="btn btn-warning" data-toggle="modal"
								data-target="#openmodal${produto.id}">Ver Mais</button>
						</td>
					</tr>
					<!-- Modal -->
					<div class="modal fade" id="openmodal${produto.id}" tabindex="-1"
						role="dialog" aria-labelledby="TituloModalCentralizado"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">

							<div class="modal-content">

								<div class="modal-header">

									<h5 class="modal-title">Descrição do Produto</h5>

									<button type="button" class="close" data-dismiss="modal"
										aria-label="Fechar">
										<span aria-hidden="true">&times;</span>
									</button>

								</div>
								<div class="modal-body">
									<ul class="list-group">
										<li class="list-group-item"><b>Nome do Produto:</b>${produto.nome}</li>
										<li class="list-group-item"><b>Tipo:</b>${produto.tipo}</li>
										<li class="list-group-item"><b>Preço:</b>${produto.preco}</li>
										<li class="list-group-item"><b>Vencimento:</b>${produto.vencimento}</li>
									</ul>

								</div>

								<div class="modal-footer">
									<form action="<c:url value="/produto/update"/>" method="post">
										<input type="hidden" name="prodId" value="${produto.id}">
										<input class="btn btn-primary" type="submit" value="Atualizar">
									</form>
									<form action="<c:url value="/produto/delete"/>" method="post">
										<input type="hidden" name="prodId" value="${produto.id}">
										<input class="btn btn-danger" type="submit" value="Delete">
									</form>
									<form action="<c:url value="/produto/download"/>" method="get">
										<input type="hidden" name="id" value="${produto.id}">
										<input class="btn btn-info align-middle" type="submit"
											value="Download">
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</table>
		</div>
	</div>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js">
		
	</script>
</body>
</html>