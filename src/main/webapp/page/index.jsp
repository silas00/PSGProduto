<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
</head>
<style>
html, body {
	height: 100vh;
	justify-content: center;
	align-items: center;
}
</style>
<body class="d-flex w-100">

	<div
		class="container position-absolute mb-4 d-flex align-items-center flex-column justify-content-beetwen ">

		<img class="img-fluid w-40" src="/produto/img" />
		<div class="centro w-40 bg-white">

			<c:url value="/usuario/login" var="loginUsuario" />
			
			<form action="${loginUsuario}" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Email</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Digite aqui seu email." name="login">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Senha</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Digite aqui sua senha." name="password">
				</div>
				<div>
					<small id="emailHelp" class="form-text text-muted">Nunca
						compartilharemos seus dados de acesso com ninguém.</small>
				</div>
				<br>
				<button type="submit" class="btn btn-success">Entrar</button>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#openModal">Cadastrar</button>
			</form>
			<c:url value="/usuario/cadastro" var="cadastroUsuario" />
			<div class="modal fade justify-content-beetwen" id="openModal"
				tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Cadastro
								de Usuario</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form class="align-items-center justify-content-beetwen"
							action="${cadastroUsuario}" method="post">
							<div class="modal-body">

								<div class="form-group">
									<label for="exampleInputEmail1">Digite seu email</label> <input
										type="email" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="Enter email"
										name="nome" value="${produto.nome}"> <label
										for="exampleInputPassword1">Digite uma senha</label> <input
										type="password" class="form-control"
										id="exampleInputPassword1" placeholder="Password" name="senha"
										value="${produto.senha}">
									<button type="submit" class="btn btn-success mt-4 float-right">Cadastrar</button>

								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>