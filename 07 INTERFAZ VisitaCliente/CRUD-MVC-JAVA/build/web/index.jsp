
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
                <h1>Agregar Visita Cliente</h1>
                <form action="Controlador">
                    Fecha y Hora de Solicitud de Visita (DD/MM/AAAA) (HH:MM 24H):<br>
                    <input class="form-control" type="text" name="txtDni"><br>
                    Nombre de Obra a Visitar: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Nombres de Visitantes: <br>
                    <input class="form-control" type="text" name="txtHab"><br>
                    Comentarios: <br>
                    <input class="form-control" type="text" name="txtMot"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controlador?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
