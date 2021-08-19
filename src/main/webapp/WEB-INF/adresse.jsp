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
<title>Liste Adresse : </title>
</head>
<body>

	<table class="table">
	<tr>
	<th scope="row"> Numero </th>
	<th scope="row"> Rue </th>
	<th scope="row"> Code Postal </th>
	<th scope="row"> Ville </th>
	</tr>
	<c:forEach items="${ adresses }" var="adresse">
	<tr>
	<td> ${ adresse.numero } </td>
	<td> ${ adresse.rue } </td>
	<td> ${ adresse.cp } </td>
	<td> ${ adresse.ville } </td>
	<td> <a href="redirect?id=${ adresse.id }" class="btn btn-success btn sn">voir</a> </td>
	</tr>
	</c:forEach>
	</table>
	${ adresses }
</body>
</html>