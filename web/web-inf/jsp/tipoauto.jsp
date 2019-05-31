<%-- 
    Document   : tipoauto
    Created on : 17/05/2019, 01:50:49 AM
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
        <div class="container mt-4">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-light" href="agregarTipoAuto.htm">Nuevo Registro Tipo Auto</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>FECHA</th>
                                <th>ACTIVO</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dato" items="${listaAutos}">
                            <tr>
                                <td>${dato.id_tipo}</td>
                                <td>${dato.nombre_tipo}</td>
                                <td>${dato.fecha_creacion}</td>
                                <td>${dato.activo}</td>
                                <td>
                                    <a href="editarTipoAuto.htm?id=${dato.id_tipo}" class="btn btn-warning">Editar</a>
                                    <a href="eliminarTipoAuto.htm?id=${dato.id_tipo}" class="btn btn-danger">Borrar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>