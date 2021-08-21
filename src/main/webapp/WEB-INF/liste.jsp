<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/liste.css" type="text/css">


<title>listes patients et infirmiers</title>
</head>
<body>

	<h1>Listes</h1>

	<div class="mesListes">
		<div class="container bloc blocPatients">
			<div class="myHead">
				<h2 class="patients">Les patients</h2>
				<a href="addPatient"><i class="fas fa-plus add"></i></a>
			</div>
			<table class="table">
				<tr>
					<th scope="row">nom</th>
					<th scope="row">prenom</th>
					<th scope="row"></th>
					<th scope="row"></th>
				</tr>
				<c:forEach items="${ patients }" var="patient">
					<tr>
						<td>${ patient.nom }</td>
						<td>${ patient.prenom }</td>
						<td><a href="updatePatient?id=${patient.id}"
							class="btn btn-success btn-sm"><i
								class="bi bi-arrow-clockwise"></i></a>
						<td><a href="deletePatient?id=${patient.id}"
							class="btn btn-danger btn-sm"><i class="fas fa-times"></i> </a></td>

					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="container bloc blocInfirmieres">
			<div class="myHead">
				<h2>Les infirmier(e)s</h2>
				<a href="addInfirmiere"><i class="fas fa-plus add"></i></a>
			</div>
			<table class="table">
				<tr>
					<th scope="row">nom</th>
					<th scope="row">prenom</th>
					<th scope="row"></th>
					<th scope="row"></th>
				</tr>
				<c:forEach items="${ infirmieres }" var="infirmiere">
					<tr>
						<td>${ infirmiere.nom }</td>
						<td>${ infirmiere.prenom }</td>
						<td><a href="updateInfirmiere?id=${infirmiere.id}"
							class="btn btn-success btn-sm"><i
								class="bi bi-arrow-clockwise"></i></a>
						<td><a href="deleteInfirmiere?id=${infirmiere.id}"
							class="btn btn-danger btn-sm"><i class="fas fa-times"></i></a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div class="container bloc blocDeplacement">
		<div class="myHead">
			<h2>Les déplacements</h2>
			<a href="addDeplacement"><i class="fas fa-plus add"></i></a>
		</div>
		<table class="table tableDep">
			<tr>
				<th scope="row">Nom patient</th>
				<th scope="row">Prénom patient</th>
				<th scope="row">Date</th>
				<th scope="row">Cout</th>
				<th scope="row">Nom infirmier</th>
				<th scope="row">Prénom infirmier</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${ deplacements }" var="deplacement">
				<tr>
					<td>${ deplacement.nomPatient }</td>
					<td>${ deplacement.prenomPatient }</td>
					<td>${ deplacement.date }</td>
					<td>${ deplacement.cout } e</td>
					<td>${ deplacement.nomInfirmiere }</td>
					<td>${ deplacement.prenomInfirmiere }</td>
					<td><a href="updateDeplacement?id=${deplacement.id}"
						class="btn btn-success btn-sm"><i
							class="bi bi-arrow-clockwise"></i></a>
					<td><a href="deleteDeplacement?id=${deplacement.id}"
						class="btn btn-danger btn-sm"><i class="fas fa-times"></i></a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>