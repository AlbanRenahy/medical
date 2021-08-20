<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Infirmiere Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Infirmiere Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Infirmieres</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${infirmiere != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${infirmiere == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${infirmiere != null}">
                                    Edit Infirmiere
                                </c:if>
                                <c:if test="${infirmiere == null}">
                                    Add New Infirmiere
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${infirmiere != null}">
                            <input type="hidden" name="id" value="<c:out value='${infirmiere.id}' />" />
                        </c:if>

						
						<fieldset class="form-group">
                            <label>Infirmiere Adresse_Id</label> <input type="text" value="<c:out value='${infirmiere.adresse_id}' />" class="form-control" name="id" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Infirmiere Nom</label> <input type="text" value="<c:out value='${infirmiere.nom}' />" class="form-control" name="nom" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Infirmiere Prenom</label> <input type="text" value="<c:out value='${infirmiere.prenom}' />" class="form-control" name="prenom">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Infirmiere TelPro</label> <input type="text" value="<c:out value='${infirmiere.telPro}' />" class="form-control" name="telPro">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Infirmiere TelPerso</label> <input type="text" value="<c:out value='${infirmiere.telPerso}' />" class="form-control" name="telPerso">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Infirmiere Number</label> <input type="text" value="<c:out value='${infirmiere.numeroProfessionnel}' />" class="form-control" name="numeroProfessionnel">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
