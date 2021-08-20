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
<title>Affichage des deplacements : </title>
</head>
<body>

	<table class="table">
	<tr>
	<th scope="row"> Id du deplacement </th>
	<th scope="row"> Cout du deplacement ( $ ) </th>
	<th scope="row"> Date de deplacement </th>
	<th scope="row"> Nom du Patient </th>
	<th scope="row"> Prenom du Patient </th>
	<th scope="row"> Nom de l'infirmier </th>
	<th scope="row"> Prenom de l'infirmier </th>
	
	</tr>
	<c:forEach items="${ deplacements }" var="deplacement">
	<tr>
	<td> ${ deplacement.id } </td>
	<td> ${ deplacement.cout } </td>
	<td> ${ deplacement.date } </td>
	<td> ${ deplacement.nom_patient } </td>
	<td> ${ deplacement.prenom_patient} </td>
	<td> ${ deplacement.nom_infirmiere} </td>
	<td> ${ deplacement.prenom_infirmiere} </td>
	
	<td> <a href="redirect?id=${ deplacement.id }" class="btn btn-success btn sn">X</a> </td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>