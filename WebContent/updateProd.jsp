<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>

<!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
  
</head>

<body>
	<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="acceuil.jsp">Gestion de commandes</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="acceuil.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ProductCon">Product</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ClientCon">Client</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

	  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/update.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
          </div>
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
              <label>Id</label>Id
              <input type="number" class="form-control" placeholder="Id" name="id" value="${product.getIdProd()}" readonly>
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Name of Product</label>Name of Product
              <input type="text" class="form-control" placeholder="name" name="name" value = "${product.getNameProd()}">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>Price</label>Price
              <input type="text" class="form-control" placeholder="Price" name="price" value="${product.getPrice()}" >
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
  
  <% 	   String var="product";
	   session.setAttribute("page", var);
%>
</body>
</html>