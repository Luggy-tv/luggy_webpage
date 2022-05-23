<%-- 
    Document   : editNota
    Created on : 23 may 2022, 14:32:48
    Author     : luisa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fcfmprograweb.luggy_paginaweb.classNota"%>
<%@page import="com.fcfmprograweb.luggy_paginaweb.classUsuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <title>Editar Perfil</title>
        <link rel="icon" href="imageResources\logow.png">
        
        <!-- Styles -->
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <!-- Scripts -->
         <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
         <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
         <script src="JavaScript/bootstable.js"></script>
        <script>
       $('#mytable').SetEditable({
                    columnsEd: "1" //editable columns 
      });
        
        </script>
         
    </head>
    <%
        classUsuario usuario = (classUsuario)request.getSession().getAttribute("usuario");
        ArrayList<classNota> listaNotas= (ArrayList<classNota>)request.getSession().getAttribute("listaNotas");
    %>
    
    <body> 
        <img src="imageResources\logob.png" alt="logo" style="width: 100px;heigh:100px">
        <a href="menu.jsp">
            <button>Regresar</button>
        </a>
        <h1>Editar Nota</h1>
        <div class="table content">
            
            <table id="mytable">
                <thead class="table-dark">
                    <tr>
                        <th>Id Nota</th>
                        <th>Contenido</th>
                    </tr>
                </thead>
                <tbody>    
                    <c:forEach var="nota" items="${listaNotas}">
                       <tr>
                          <td>${nota.idNota}</td>
                          <td  contenteditable='true'>${nota.contenido}</td>
                       </tr>
                    </c:forEach>
                </tbody>
            </table>
            
        </div>
       </body>
</html>
