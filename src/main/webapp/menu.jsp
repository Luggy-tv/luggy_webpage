<%@page import="com.fcfmprograweb.luggy_paginaweb.classUsuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fcfmprograweb.luggy_paginaweb.classNota"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Menu principal</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <link rel="icon" href="imageResources\logow.png">
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.js"></script>

        
        <script type="text/javascript">
            $(document).ready( function () {
               $('#tablaNotas').DataTable();
            } );
            
            $('#example tbody').on( 'click', 'img.icon-delete', function () {
            table
            .row( $(this).parents('tr') )
            .remove()
            .draw();
            } );
        </script>
        
     </head>
     <%
        int cantNotasActivas= (int)request.getSession().getAttribute("numNotas");
        classUsuario usuario=(classUsuario)request.getSession().getAttribute("usuario");
        
        System.out.println(usuario);
        System.out.println("Cant Notas:"+cantNotasActivas);
        
            ArrayList<classNota> listaNotas= (ArrayList<classNota>)request.getSession().getAttribute("listaNotas");
        %>
   <body>
        
            <div class="row" style="height:100vh">
              <div class="col-10" style="background-color: rgb(180,189,211);">
                
                <br>
                <h1>Lista de notas de ${usuario.usuario}</h1>
                <br>
                <table id="tablaNotas" class="display">
                     <thead>
                     <tr>
                        <td>Id-Nota</td>
                        <td>Fecha de Creaci??n</td>
                        <td>Contenido</td>
                     </tr>
                    </thead>
                    
                 <tbody class="container-fluid">    
                     <c:forEach var="nota" items="${listaNotas}">
                        <tr>
                           <td>${nota.idNota}</td>
                           <td>${nota.fechaCreacion}</td>
                           <td>${nota.contenido}</td>
                        </tr>
                     </c:forEach>
                 </tbody>
                </table>
              </div>
                <div class="col-2 text-center"  style="background-color: rgb(28,39,61);">
                    
                    <img src="imageResources\logow.png" style="width:60%" class="img-fluid center-block d-block mx-auto rounded-circle" alt="logo" style="width: 100px;heigh:100px">
                    <a href="addNServlet"><button type="button" class="btn btn-outline-success";>A??adir nota</button></a>
                    <br>
                    <a href="editNServlet"><button type="button" class="btn btn-outline-success";>Editar nota</button></a>
                    <br>
                    <a href="editperfil.jsp"><button type="button" class="btn btn-outline-light";>Editar perfil</button></a>
                    <br>
                    <a href="LogoutServlet"><button type="button" class="btn btn-outline-danger";>Cerrar sesi??n</button></a>
                </div>
            </div>
        
    </body>

</html>