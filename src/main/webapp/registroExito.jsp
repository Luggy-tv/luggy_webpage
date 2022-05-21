<%-- 
    Document   : registroExito
    Created on : 19 may 2022, 17:59:16
    Author     : luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <title>Registro exitoso</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">

    </head>

    <body>
        <div class="Row">
            <div class="col-sm-8">
                <h1>¡El registro fue exitoso!</h1>
            </div>
            <div class="col-sm-4">
                <form action="index.html" method="post">
                        <input type="submit" value="Regresar a incio de sesión">
                </form>
            </div>
        </div>   
    </body>
</html>