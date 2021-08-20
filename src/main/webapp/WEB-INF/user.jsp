<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="table">
	<tr>
	<th scope="row"> nom </th>
	<th scope="row"> prenom </th>
	<th scope="row"> date de naissance </th>
	<th scope="row"> sexe </th>
	<th scope="row"> no de sécurité sociale </th>
	<th scope="row"> numéro de rue </th>
	<th scope="row"> rue </th>
	<th scope="row"> code postal </th>
	<th scope="row"> ville </th>
	<th scope="row"> Nom de l'infirmière </th>
	<th scope="row"> Prenom de l'infirmière </th>
	
	
	</tr>
	<c:forEach items="${ patients }" var="patient">
	<tr>
	<td> ${ patient.nom } </td>
	<td> ${ patient.prenom } </td>
	<td> ${ patient.dateDeNaissance } </td>
	<td> ${ patient.sexe } </td>
	<td> ${ patient.numeroSecuriteSocial} </td>
	<td> ${ patient.numero} </td>
	<td> ${ patient.rue} </td>
	<td> ${ patient.cp} </td>
	<td> ${ patient.ville} </td>
	<td> ${ patient.nomInfirmiere} </td>
	<td> ${ patient.prenomInfirmiere} </td>
	
	<td> <a href="redirect?id=${ patient.id }" class="btn btn-success btn sn">voir</a> </td>
	</tr>
	</c:forEach>
	</table>
	${ patients }
</body>
</html>