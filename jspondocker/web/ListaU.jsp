<%-- 
    Document   : ListaU
    Created on : Apr 19, 2018, 4:38:42 PM
    Author     : luks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de usuários</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Listagem de Usuários!</h1>
        <table class="table table-striped table-hover">
                <thead class="thead-light">
                    <tr> 
                        <th scope="col"> # </th>
                        <th scope="col"> name </th>
                        <th scope="col">Email</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach var="u" items="${listU}">
                    <tr>
                        <td>${u.id}</td>
                    <td>${u.nome}</td>
                    <td>${u.email}</td>
                </tr>
                
            </c:forEach>
               </tbody>
        </table>
    </body>
</html>
