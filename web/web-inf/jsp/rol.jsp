<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
                    <a class="btn btn-light" href="agregarRol.htm">Nuevo Registro Rol</a>
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
                            <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.id_rol}</td>
                                <td>${dato.nombre_rol}</td>
                                <td>${dato.fecha_creacion}</td>
                                <td>${dato.activo}</td>
                                <td>
                                    <a href="editarRol.htm?id=${dato.id_rol}" class="btn btn-warning">Editar</a>
                                    <a href="eliminarRol.htm?id=${dato.id_rol}" class="btn btn-danger">Borrar</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        <div class="container col-12 mt-2">
          <a href="index.htm" class="btn btn-primary">Regresar al menu principal</a>
        </div>
        </div>

    </body>
</html>
