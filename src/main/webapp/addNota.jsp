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
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Anadir Nota</title>
        <link rel="icon" href="imageResources\logow.png">
        <!-- 
        <link rel="stylesheet" href="Styles/LogStyle.css">
        -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">
        <script src="JavaScript/index.js"></script>
        <!--CSS-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,700,700i">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/elegant-font/code/style.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/awesome-bootstrap-checkbox.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
       
        
    </head>
    
    <body style="background-color:rgb(180,189,211) ;">
        <div class="top-content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>Luggy</strong></h1>
                    </div>
                </div>

                <div class="row">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h1>Añadir Nota</h1>
                        </div>
                    </div>

                    <div class="form-bottom">
                        <form autocomplete="off" action="addNServlet" method="post">
                            <label>Añada texto de su nota:</label>
                            <input type="text" class="form-username form-control" id="newNota" name="newNota" minlenght="5" maxlength="250" required><br>
                            <button  type="submit" class="btn btn-success">Añadir nota</button>
                        </form>

                    </div>

                </div>

            </div>

        </div>
    </body>
</html>