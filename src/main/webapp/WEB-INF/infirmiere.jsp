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
	<table class="table">
	<tr>
	<th scope="row"> nom </th>
	<th scope="row"> prenom </th>
	<th scope="row"> numeroProfessionnel </th>
	<th scope="row"> telPro </th>
	<th scope="row"> telPerso </th>
	<th scope="row"> adresse </th>
	
	</tr>
	<c:forEach items="${ infirmieres }" var="infirmiere">
	<tr>
	<td> ${ infirmiere.nom } </td>
	<td> ${ infirmiere.prenom } </td>
	<td> ${ infirmiere.numeroProfessionnel } </td>
	<td> ${ infirmiere.telPro } </td>
	<td> ${ infirmiere.telPerso } </td>
	<td> ${ infirmiere.adresse_id } </td>
	<td> <a href="redirect?id=${ infirmiere.id }" class="btn btn-success btn sn">voir</a> </td>
	</tr>
	</c:forEach>
	</table>
	${ infirmieres }
</body>
</html>