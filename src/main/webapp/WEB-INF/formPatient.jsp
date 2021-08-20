<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="mb-3">
	<form method="post" action="user">
	<label class="form-label"> nom
	</label>
	<input class="form-control" type="text" name="nom" >
	</div>
	<div class="mb-3">
	<label class="form-label"> prenom
	</label>
	<input class="form-control" type="text" name="prenom" >
	</div>
	<div class="mb-3">
	<label class="form-label"> date de naissance
	</label>
	<input class="form-control" type="text" name="dateDeNaissance" >
	</div>
	<div class="mb-3">
	<label class="form-label"> sexe
	</label>
	<input class="form-control" type="text" name="sexe" >
	</div>
	<div class="mb-3">
	<label class="form-label"> numeroSecuriteSociale
	</label>
	<input class="form-control" type="text" name="numeroSecuriteSocial" >
	</div>
	<div class="mb-3">
	<label class="form-label"> numéro de rue
	</label>
	<input class="form-control" type="text" name="numero" >
	</div>
	<div class="mb-3">
	<label class="form-label"> rue
	</label>
	<input class="form-control" type="text" name="rue" >
	</div>
	<div class="mb-3">
	<label class="form-label"> code postal
	</label>
	<input class="form-control" type="text" name="cp" >
	</div>
	<div class="mb-3">
	<label class="form-label"> ville
	</label>
	<input class="form-control" type="text" name="ville" >
	</div>
	<div class="mb-3">
	<div class="text-center">
	<input class="btn btn-primary" type="submit" name="envoyer" >
	</form>
	</div>
	</div>
	
</body>
</html>