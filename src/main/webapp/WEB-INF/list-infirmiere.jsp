<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Gestion des infirmieres </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Infirmieres</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Liste d'Infirmieres</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success"> Ajout d'infirmiere :</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Adresse_ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>TelPro</th>
						<th>TelPerso</th>
						<th>NumeroProfessionnel</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="infirmiere" items="${listInfirmiere}">

						<tr>
							<td><c:out value="${infirmiere.id}" /></td>
							<td><c:out value="${infirmiere.adresse_id}" /></td>
							<td><c:out value="${infirmiere.nom}" /></td>
							<td><c:out value="${infirmiere.prenom}" /></td>
							<td><c:out value="${infirmiere.telPro}" /></td>
							<td><c:out value="${infirmiere.telPerso}" /></td>
							<td><c:out value="${infirmiere.numeroProfessionnel}" /></td>
							<td><a href="edit?id=<c:out value='${infirmiere.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${infirmiere.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>