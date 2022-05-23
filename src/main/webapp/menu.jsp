<%@page import="com.fcfmprograweb.luggy_paginaweb.classUsuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fcfmprograweb.luggy_paginaweb.classNota"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
         <link rel="stylesheet" href="css/bootstrap.css">
         <title>Menu principal</title>
          <meta charset="UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
         <link rel="icon" href="imageResources\logow.png">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.css%22%3E">
         <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.js%22%3E"></script>
         <script type="text/javascript">
             $(document).ready( function () {
                $('#tablNotas').DataTable();
             } );
         </script>
         <title>Tablas</title>
     </head>
     <%
        int cantNotasActivas= (int)request.getSession().getAttribute("numNotas");
        classUsuario usuario=(classUsuario)request.getSession().getAttribute("usuario");
        
        System.out.println(usuario);
        System.out.println("Cant Notas:"+cantNotasActivas);
        
        ArrayList<classNota> listaNotas= (ArrayList<classNota>)request.getSession().getAttribute("listaNotas");
        %>
    <body>
        <h1>Lista de notas</h1>

        <table id="tablaNotas" class="display">
            <thead>
                <tr>
                    <td>Id-Nota</td>
                    <td>Contenido</td>
                    <td>Fecha</td>
                </tr>
            </thead>
            <tbody>    
            <c:forEach var="nota" items="${listaNotas}">
                <tr>
                    <td>${nota.idNota}</td>
                    <td>${nota.contenido}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
        
        
</html>