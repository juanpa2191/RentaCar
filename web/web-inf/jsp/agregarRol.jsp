<%-- 
    Document   : agregarRol
    Created on : 17/05/2019, 01:01:32 AM
    Author     : santi
--%>

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
                <h4>Agregar nuevo rol</h4>
            </div>
            <div class="card-body">
                <form method="post">
                    <label>Nombre</label>
                    <input type="text" name="nombreRol" id="" class="form-control">
                    <label>Fecha</label>
                    <input type="text" name="fechaCreacion" id="" class="form-control">
                    <label>Activo</label>
                      <select name="activo" class="form-control">
                          <option value="si">Si</option>
                          <option value="no">No</option>
                     </select>
                    <input type="submit" value="Enviar" class="btn btn-block btn-primary  mt-2">
                    <a href="index.htm" class="mt-2">Regresar</a>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>