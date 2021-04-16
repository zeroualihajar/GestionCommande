<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Command</title>
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
	<header class="masthead" style="background-image: url('img/bac.jpeg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>Command</h1>
					</div>
				</div>
			</div>
		</div>
	</header>


	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<form method="post" action="Commander">
					
					<table class="table">
						<tr>
							<th>Id</th>
							<th>Date</th>
							<th>User</th>
							<th>Update</th>
							<th>Delete</th>
							<th>Details</th>
						</tr>

						<c:forEach items="${list}" var="cmd">
							<tr>
								<td><c:out value="${cmd.getIdCmd()}" /></td>
								<td><c:out value="${cmd.getDateCmd()}" /></td>
								<td><c:out value="${cmd.getIdClient()}" /></td>
								<td><a href="UpdateCon?id=${cmd.getIdCmd()}" style="color: blue">update</a></td>
								<td><a href="DeleteCon?id=${cmd.getIdCmd()}" style="color: red">delete</a></td>
								<td><a href="Details?id=${cmd.getIdCmd()}">Show</a></td>

							</tr>
						</c:forEach>
					</table>
					<button type="submit" class="btn btn-primary" value="${id }" name="id" >Add New Command</button>
				</form>


			</div>
		</div>
	</div>

	<hr>

	<%
		String var = "command";
	session.setAttribute("page", var);
	%>

</body>
</html>