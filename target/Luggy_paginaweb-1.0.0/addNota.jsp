<%-- 
    Document   : addNota
    Created on : 23 may 2022, 14:23:47
    Author     : luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <title>Añadir Nota</title>
        <link rel="icon" href="imageResources\logow.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">
    </head>
    <body>
        <img src="imageResources\logob.png" alt="logo" style="width: 100px;heigh:100px">
        <a href="menu.jsp">
            <button>Regresar</button>
        </a>
        <h1>Añadir Nota</h1>
        <form autocomplete="off" action="addNServlet" method="post">
            <label>Añada texto de su nota:</label>
            <input type="text" id="newNota" name="newNota" minlenght="5" maxlength="250" required><br>
            <input  type="submit" value="Añadir Nota">
        </form>
    </body>
</html>
