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
<title>Ajouter un deplacement</title>
</head>
<body>
	<h1>Ajouter un deplacement</h1>
	
	
	<form method="POST" action="addDeplacement">
		<div class="mb-3 divLab">
			<label class="form-label">
				Nom patient
				<input type="text" class="form-control" name="nomPatient">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				Prénom patient
				<input type="text" class="form-control" name="prenomPatient">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				Date
				<input type="date" class="form-control" name="date">
			</label>
		</div>
		<div class="mb-3 divLab">
			<label class="form-label">
				Coût
				<input type="number" step="0.01" class="form-control" name="cout">
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
	
	
		<div class="col-auto">
    		<button type="submit" class="btn btn-primary mb-3 btn-send">Envoyer</button>
  		</div>
	</form>

</body>
</html>