

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Permiso</h1>
                <form action="Controlador">
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni"><br>
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Fecha de Inicio/Termino (DD/MM/AAAA)): <br>
                    <input class="form-control" type="text" name="txtHab"><br>
                    Motivo: <br>
                    <input class="form-control" type="text" name="txtMot"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
