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
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-light" href="agregarRenta.htm">Registrar nuevo alquiler</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>PRECIO</th>
                                <th>FECHA</th>
                                <th>MARCA</th>
                                <th>USUARIO</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.id_renta}</td>
                                <td>${dato.precio}</td>
                                <td>${dato.fecha_alquiler}</td>
                                <td>${dato.nombre_marca}</td>
                                <td>${dato.user_name}</td>
                                <td>
                                    <a class="btn btn-warning" href="editarRenta.htm?id=${dato.id_renta}">Editar</a>
                                    <a class="btn btn-danger">Borrar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
    </body>
</html>