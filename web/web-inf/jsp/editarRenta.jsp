<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <div class="container mt-4 col-lg-4">
        <div class="card border-info">
            <div class="card-header bg-info">
                <h4>Editar Alquiler</h4>
            </div>
            <div class="card-body">
                <form method="post">
                    <label>Precio</label>
                    <input type="number" name="precio" id="" class="form-control" value="${datosRenta[0].precio}">
                    <label>Fecha</label>
                    <input type="text" name="fecha_alquiler" id="" class="form-control" value="${datosRenta[0].fecha_alquiler}">
                    <label>Automovil</label>
                    <select name="id_automovil" class="form-control mb-3">
                       <c:forEach var="dato" items="${datosAutomovil}">
                           <option value="${dato.id_automovil}">
                                Gama: ${dato.gama} - Marca: ${dato.nombre_marca}
                           </option>
                        </c:forEach>
                    </select>
                    <label>Cliente</label>
                    <select name="id_usuario" class="form-control mb-3">
                       <c:forEach var="dato" items="${datosCliente}">
                           <option value="${dato.id_usuario}">
                                ${dato.user_name}
                           </option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Enviar" class="btn btn-block btn-primary">
                    <a href="renta.htm">Regresar</a>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>