<%-- 
    Document   : menu
    Created on : 20 may 2022, 21:28:30
    Author     : luisa
--%>

<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <title>Menu principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">
    </head>
    <!--
        
        String username = miSesion.getAttribute(usuario);
        Blob image =null;
        byte[] imgData=null;
        
        try{
            
    
        }
        %>-->
     <body>
        <div class="container-fluid" style="background-color: rgb(218, 231, 238);">
            
            <div class="row">

                <div class="col-3">
                   <h3>Listado de notas</h3> 
                    
                    <ul class="list-group">
                        <a href="#" class="list-group-item">
                            <h4>Titulo de nota 1</h4>
                            <p>Contenido de nota 1</p>
                        </a>

                        <a href="#" class="list-group-item">
                            <h4>Titulo de nota 2</h4>
                            <p>Contenido de nota 2</p>
                        </a>

                        <a href="#" class="list-group-item">
                            <h4>Titulo de nota 3</h4>
                            <p>Contenido de nota 3</p>
                        </a>

                        <a href="#" class="list-group-item">
                            <h4>Titulo de nota 4</h4>
                            <p>Contenido de nota 4</p>
                        </a>
                    </ul>
                </div>

                <div class="col-6">
                    <h1>Nota</h1>
                </div>

                <div class="col-3 text-center" style="background-color: rgb(48, 60, 73);">
                    <br>
                    <img src="" style="width:60%" class="img-fluid center-block d-block mx-auto rounded-circle">
                    <br>
                    <h2 style="color: rgb(134, 214, 15);">Nombre Apellido</h2>

                    
                </div>

            </div>
          
        </div>
      
    </body>
</html>
