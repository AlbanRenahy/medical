<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
	<h2>Ajouter un patient</h2>
	
	<form method="post" action="addPatient">
		<div class= "mb-3">
			<label> Nom :
				<input type="text" name="nom" value="">
			</label>
		</div >
		<div class= "mb-3">
			<label> Prenom :
				<input type="text" name="prenom">
			</label>
		</div>
		
		<div class= "mb-3" >
			<label> Date de naissance :
				<input type="date" name="dateDeNaissance">
			</label>
		</div>
		
		<div class= "mb-3">
			<label> Sexe :
				<select class="form-select" aria-label="Default select example" name="sexe">
				  <option selected>vous etes :</option>
				  <option value="1">Un homme </option>
				  <option value="2">Une femme</option>
				</select>
			</label>
		</div>
		
		<div class= "mb-3">
			<label> Numero de Securite Sociale :
				<input type="number" name="numeroSecuriteSociale">
			</label>
		</div>
		
		<h4>Adresse</h4>
		<div class="mb-3">
			
			<label class="form-label">
				Numero
				<input type="text" class="form-control" name="numero">
			</label>
			<label class="form-label">
				Rue
				<input type="tel" class="form-control" name="rue">
			</label>
			<label class="form-label">
				Code Postal
				<input type="tel" class="form-control" name="cp">
			</label>
			<label class="form-label">
				Ville
				<input type="tel" class="form-control" name="ville">
			</label>
		</div>
		
		<div class= "mb-3">
			
			
			<label> Nom de l'infirmiere :
				<select class="form-select" aria-label="Default select example" name="nameInfirmiere">
					<c:forEach items="${ infirmieres }" var="infirmiere">
							<option selected value="${infirmiere.id}" name="infirmiere_id" >${infirmiere.nom}</option>
					</c:forEach>
				</select>
			</label>
			
					
			
		</div>
		
		<button type="submit" class="btn btn-primary mb-3">Envoyer</button>
		
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>