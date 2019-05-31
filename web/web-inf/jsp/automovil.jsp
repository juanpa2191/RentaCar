<%-- 
    Document   : automovil
    Created on : 17/05/2019, 03:58:13 PM
    Author     : santi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Crud</title>
    </head>

    <body>
            <div class="container card mt-4 border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-light" href="agregarAutomovil.htm">Agregar nuevo automovil</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>GAMA</th>
                                <th>FECHA</th>
                                <th>PRECIO</th>
                                <th>OCUPADO</th>
                                <th>ACTIVO</th>
                                <th>MARCA</th>
                                <th>TIPO</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.id_automovil}</td>
                                <td>${dato.gama}</td>
                                <td>${dato.fecha_creacion}</td>
                                <td>${dato.precio}</td>
                                <td>${dato.ocupado}</td>
                                <td>${dato.activo}</td>
                                <td>${dato.nombre_marca}</td>
                                <td>${dato.nombre_tipo}</td>
                                <td>
                                    <a class="btn btn-warning" href="editarAutomovil.htm?id=${dato.id_automovil}">Editar</a>
                                    <a class="btn btn-danger" href="eliminarAutomovil.htm?id=${dato.id_automovil}">Borrar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="container  mt-2">
                <a href="index.htm" class="btn btn-primary">Regresar al menu principal</a>
            </div>
    </body>
</html>