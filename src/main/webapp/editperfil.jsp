<%@page import="com.fcfmprograweb.luggy_paginaweb.classUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge"> <!--Pa que jale el internet explorer-->
        <title>Editar Perfil</title>
        <link rel="icon" href="imageResources\logow.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">
    </head>
    <body>
        <%
            classUsuario usuario=(classUsuario)request.getSession().getAttribute("usuario");
            %>
        <img src="imageResources\logob.png" alt="logo" style="width: 100px;heigh:100px">
        <a href="menu.jsp">
            <button>Regresar</button>
        </a>
        <h1>Hola ${usuario.usuario}</h1>
        
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
        <br>
        
        <form autocomplete="off" action="EditProfileServlet" method="post">
                    
            <div class="detalles">  

                <div class="inputBox">
                    <label for="nombres">Nombre(s):</label>
                    <input 
                    value="${usuario.nombres}"
                    type="text" 
                    name="nombres" 
                    id="nombres" 
                    pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                    title="Solo letras; maximo 30 letras" 
                    placeholder="${usuario.nombres}"
                    required >
                </div>

                <div class="inputBox">
                    <label for="apellidos">Apellido(s):</label>
                    <input 
                    value="${usuario.apellidos}"
                    type="text" 
                    name="apellidos" 
                    id="apellidos" 
                    pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                    title="Solo letras; maximo 30 letras"
                    placeholder="${usuario.apellidos}"
                    required >
                </div>

                <div class="inputBox">
                    <label>Fecha de nacimiento:</label>
                    <input
                    value="${usuario.fechaNac}"
                    type="date" 
                    name="fechanac" 
                    id="fechanac"
                    min="1903-01-01"
                    max="2021-01-01"
                    placeholder="${usuario.fechaNac}"
                    required>
                </div>

                <div class="inputBox">
                    <label>Correo electrónico:</label>
                    <input 
                    type="email"
                    value="${usuario.mail}"
                    name="correoElectronico" 
                    id="correoElectronico" 
                    placeholder="${usuario.mail}"
                    required>
                </div>          

                <div class="inputBox">
                    <label>Contraseña :
                        <input 
                        value="${usuario.contraseña}"
                        type="password" 
                        name="password" 
                        id="password" 
                        pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!#$-_]).{8,16}$"
                        title="Debe contener una mayúscula, una minúscula, un número, un caracter especial(.!#$-_); mínimo de 8 caracteres no mas de 16" 
                        placeholder="••••••••••••••"
                        onkeyup='check();' 
                        required>
                    </label>
                </div>

                <div class="inputBox">
                    <label>Confirmar Contraseña:
                        <input 
                        type="password" 
                        name="confirm_password" 
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

            <div class="button">
                <input  type="submit" value="Actualizar Datos">
            </div>

        </form>
        
    </body>
</html>
