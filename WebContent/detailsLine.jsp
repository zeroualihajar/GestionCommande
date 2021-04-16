<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
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
		style="background-image: url('img/detail.png')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>Details of Command Line</h1>
					</div>
				</div>
			</div>
		</div>
	</header>


	<!-- Main Content -->

	<table class="table">
		<tr>
			<th>Id</th>
			<th>IdCommand</th>
			<th>Quantity</th>
			<th>IdProduct</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<c:forEach items="${list}" var="line">
			<tr>
				<td><c:out value="${line.getIdCmdLine()}" /></td>
				<td><c:out value="${line.getIdCmd()}" /></td>
				<td><c:out value="${line.getQty()}" /></td>
				<td><c:out value="${line.getIdProd()}" /></td>
				<td><a href="UpdateCon?id=${line.getIdCmdLine()}"
					style="color: blue">Update</a></td>
				<td><a href="DeleteCon?id=${line.getIdCmdLine()}"
					style="color: red">Delete</a></td>


			</tr>
		</c:forEach>

	</table>

	<hr>


	<div style="text-align:center">
		<a href="Add?id=${id}">New Command Line</a>
	</div>
	<br>
	<br>
	<br>
	
</body>
<%
		String var = "cmdLine";
	session.setAttribute("page", var);
	%>
</html>