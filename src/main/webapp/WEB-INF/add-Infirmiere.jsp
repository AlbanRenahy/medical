<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" rel="stylesheet">
 <link rel="stylesheet" href="./css/formAddInfirmiere.css" type="text/css">
 
<title>Ajouter un infirmier</title>
</head>
<body>
	<div class="text-center">
	<h1 style="color: white; background-color: green;">Ajouter un(e) infirmier(e)</h1>
</div>
	
	<form method="POST" action="addInfirmiere">
		<div class="mb-3 divLab">
			<label class="form-label">
				Num�ro professionnel
				<input type="number" class="form-control" name="numeroProfessionnel">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				Nom
				<input type="text" class="form-control" name="nom">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				Pr�nom
				<input type="text" class="form-control" name="prenom">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				T�l�phone professionnel
				<input type="tel" class="form-control" name="telPro">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				T�l�phone personnel
				<input type="tel" class="form-control" name="telPerso">
			</label>
		</div>
		<div class="mb-3 formAdresse divLab">
			<p class="adresse">Adresse</p>
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
		<div class="col-auto">
    		<button type="submit" class="btn btn-primary mb-3 btn-send">Envoyer</button>
  		</div>
	</form>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>