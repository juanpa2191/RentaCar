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
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-light" href="agregarUsuario.htm">Agregar nuevo usuario</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>USUARIO</th>
                                <th>NOMBRE</th>
                                <th>APELLIDO</th>
                                <th>FECHA NACIMIENTO</th>
                                <th>DIRECCION</th>
                                <th>TELEFONO</th>
                                <th>CORREO</th>
                                <th>ACTIVO</th>
                                <th>ROL</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.id_usuario}</td>
                                <td>${dato.user_name}</td>
                                <td>${dato.nombre}</td>
                                <td>${dato.apellido}</td>
                                <td>${dato.fecha_nacimiento}</td>
                                <td>${dato.direccion}</td>
                                <td>${dato.telefono}</td>
                                <td>${dato.correo}</td>
                                <td>${dato.activo}</td>
                                <td>${dato.nombre_rol}</td>
                                <td>
                                    <a class="btn btn-warning">Editar</a>
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