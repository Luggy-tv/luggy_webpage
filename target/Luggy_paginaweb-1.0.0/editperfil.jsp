<%@page import="com.fcfmprograweb.luggy_paginaweb.classUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Editar Perfil</title>
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
    
        <%
            classUsuario usuario=(classUsuario)request.getSession().getAttribute("usuario");
            %>
    <body style="background-image:url('fondo.png'); background-repeat:no-repeat ; background-attachment: fixed; background-size: cover;">
        <div class="top-content">
            <div class="container" >
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>Luggy</strong> Editar Datos</h1>   
                    </div>
                    <div class="form-group">
                    <a href="menu.jsp">
                        <button  type="submit" class="btn btn-success">Regresar</button>
                    </a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 login-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Luggy</h3>
                                <h4>Tu sitio web de notas</h4>
                                <p>Editar perfil</p>
                            </div>
                            <div class="form-top-right">
                                <img src="logo_azul.png" alt="pic">
                            </div>   
                        </div>
                        <div class="form-bottom">
                            <label>Estos son tus datos actuales:</label>
                            <br>
                            <label for="usuario">Usuario:</label>
                            <label>${usuario.usuario}</label>
                            <br>
                            <label for="nombres">Nombre(s):</label>
                            <label>${usuario.nombres}</label>
                            <br>
                            <label for="apellidos">Apellido(s):</label>
                            <label>${usuario.apellidos}</label>
                            <br>
                            <label for="edad">Edad:</label>
                            <label>${usuario.edadUsuario()}</label>
                            <br>
                            <label for="mail">Correo Electrónico:</label>
                            <label>${usuario.mail}</label>
                            <br><br>
                            <form autocomplete="off" action="EditProfileServlet" method="post">   
                                <div class="detalles">  
                                    <div class="form-group">
                                        <label for="nombres">Nombre(s):</label>
                                        <input 
                                        type="text" 
                                        name="nombres" 
                                        class="form-username form-control"
                                        id="nombres" 
                                        pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                                        title="Solo letras; maximo 30 letras" 
                                        placeholder="${usuario.nombres}"
                                        required >
                                    </div>
                                    <div class="form-group">
                                        <label for="apellidos">Apellido(s):</label>
                                        <input 
                                        type="text" 
                                        name="apellidos"
                                        class="form-username form-control" 
                                        id="apellidos" 
                                        pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                                        title="Solo letras; maximo 30 letras"
                                        placeholder="${usuario.apellidos}"
                                        required >
                                    </div>
                                    <div class="form-group">
                                        <label>Fecha de nacimiento:</label>
                                        <input 
                                        type="date" 
                                        name="fechanac" 
                                        class="form-username form-control"
                                        id="fechanac"
                                        min="1903-01-01"
                                        max="2021-01-01"
                                        placeholder="${usuario.fechaNac}"
                                        required>
                                    </div>                       
                                    <div class="form-group">
                                        <label>Correo electrónico:</label>
                                        <input 
                                        type="email" 
                                        name="correoElectronico" 
                                        class="form-username form-control"
                                        id="correoElectronico" 
                                        placeholder="${usuario.mail}"
                                        required>
                                    </div>          
                                    <div class="form-group">
                                        <label>Contraseña :
                                            <input 
                                            type="password" 
                                            name="password" 
                                            class="form-username form-control"
                                            id="password" 
                                            pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!#$-_]).{8,16}$"
                                            title="Debe contener una mayúscula, una minúscula, un número, un caracter especial(.!#$-_); mínimo de 8 caracteres no mas de 16" 
                                            placeholder="••••••••••••••"
                                            onkeyup='check();' 
                                            required>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <label>Confirmar Contraseña:
                                            <input 
                                            type="password" 
                                            name="confirm_password" 
                                            class="form-username form-control"
                                            id="confirm_password"  
                                            pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!#$-_]).{8,16}$" 
                                            title="Ambas contraseñas deben ser iguales"
                                            placeholder="••••••••••••••"
                                            onkeyup='check();' 
                                            required> 
                                        <span id='message'></span>
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button  type="submit" class="btn btn-success">Actualizar datos</button>
                                </div>
                            </form> 
                        </div>
                    </div> 
                </div> 
                <p>.</p>
            </div>
        </div>
    </body>
</html>
