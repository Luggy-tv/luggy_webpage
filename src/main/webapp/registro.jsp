<%-- 
    Document   : registro
    Created on : 19 may 2022, 17:18:53
    Author     : luisa
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <title>Registro de Cuenta</title>
        <script src="JavaScript/registro.js"></script> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" 
              crossorigin="anonymous">
        <link rel="icon" href="imageResources\logow.png">
    
    </head>


    <body>
        
        <img src="imageResources\logob.png" alt="logo" style="width: 100px;heigh:100px">
        <div class="registroUsuario">

            <div class="title">
                <h1>Registro de usuario</h1>
            </div>
            

                <form autocomplete="off" action="RegistroServlet" method="post" enctype="multipart/form-data">
                    
                    <div class="detalles">  

                        <div class="inputBox">
                            <label for="nombres">Nombre(s):</label>
                            <input 
                            type="text" 
                            name="nombres" 
                            id="nombres" 
                            pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                            title="Solo letras; maximo 30 letras" 
                            placeholder="Nombre(s)"
                            required >
                        </div>

                        <div class="inputBox">
                            <label for="apellidos">Apellido(s):</label>
                            <input 
                            type="text" 
                            name="apellidos" 
                            id="apellidos" 
                            pattern="[A-Za-z\u00f1\u00d1 ]{1,30}"
                            title="Solo letras; maximo 30 letras"
                            placeholder="Apellidos"
                            required >
                        </div>
                        
                        <div class="inputBox">
                            <label>Fecha de nacimiento:</label>
                            <input 
                            type="date" 
                            name="fechanac" 
                            id="fechanac"
                            min="1903-01-01"
                            max="2021-01-01"
                            required>
                        </div>

                        <div class="inputBox">
                            <label>Correo electrónico:</label>
                            <input 
                            type="email" 
                            name="correoElectronico" 
                            id="correoElectronico" 
                            placeholder="correo@electronico.com"
                            required>
                        </div>

                        <div class="inputBox">
                            <label>Nombre de usuario:</label>
                            <input 
                            type="text" 
                            name="nombreDeUsuario" 
                            id="nombreDeUsuario" 
                            pattern="[A-Za-z0-9\d\.\_\-\u00f1\u00d1]{1,15} "
                            title="Solo letras, numeros y ciertos caracteres especiales(.-_); no mas de 15 caracteres"
                            placeholder="Nombre de usuario" 
                            required>
                        </div>
                      

                        <div class="inputBox">
                            <label>Contraseña :
                                <input 
                                type="password" 
                                name="password" 
                                id="password" 
                                pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.!#$-_]).{8,16}$"
                                title="Debe contener una mayúscula, una minúscula, un número, un caracter especial(.!#$-_); mínimo de 8 caracteres no mas de 16" 
                                placeholder="Contraseña"
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
                                placeholder="Confirma Contraseña"
                                onkeyup='check();' 
                                required> 
                            <span id='message'></span>
                            </label>
                        </div>

                        <div class="inputBox">
                            <label>Imagen de perfil:</label>
                            <input 
                            type="file" 
                            name="imagenPerfil" 
                            id="imagenPerfil"
                            accept="image/png, image/jpg, image/jpeg"
                            size="50"
                            required>
                        </div>

                    </div>

                    <div class="button">
                        <input  type="submit" value="Registrar">
                    </div>

                </form>
            
        </div>
    </body>
</html>