<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Command Line</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">

</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="acceuil.jsp">Gestion de commandes</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="acceuil.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="ProductCon">Product</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="ClientCon">Client</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/update.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading"></div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<form method="post" action="UpdateCon">
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Id</label> Id : <input type="number" class="form-control"
								placeholder="Id" name="id" value="${cmdLine.getIdCmdLine()}"
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>IdUser</label> <input type="number" class="form-control"
								name="idCmd" value="${cmdLine.getIdCmd()}" readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<div class="control-group">

						<label>Select a new product if you want to change it &nbsp;&nbsp;&nbsp;&nbsp; </label> <select
							name="option">
							<c:forEach items="${prod}" var="product">
								<c:if test="${ cmdLine.getIdProd() != product.getIdProd()}">
									<option value="${product.getIdProd()}">${product.getNameProd()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										${product.getPrice()}</option>
								</c:if>
								<c:if test="${ cmdLine.getIdProd() == product.getIdProd()}">
									<option value="${cmdLine.getIdProd() }"
										selected="${cmdLine.getIdProd() }">${product.getNameProd()}
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										${product.getPrice()}</option>
								</c:if>
							</c:forEach>
						</select>
						<p class="help-block text-danger"></p>
					</div>

					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Quantity</label> <input type="text" class="form-control"
								placeholder="Quantity" name="qty" required
								data-validation-required-message="Please enter the quantity"
								value="${cmdLine.getQty() }">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Update</button>
				</form>
			</div>
		</div>
	</div>

	<hr>


	<%
		String var = "cmdLine";
	session.setAttribute("page", var);
	%>
</body>
</html>