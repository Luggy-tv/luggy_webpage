/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var check = function() {
    if (document.getElementById('password').value === document.getElementById('confirm_password').value) 
    { 
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'Son iguales';
    } 
    else 
    {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Tienen que ser iguales';
    }
    if(document.getElementById('password').value === null||document.getElementById('password').value=== "")
    {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Favor de llenar los campos';
    }
    if(document.getElementById('confirm_password').value === null||document.getElementById('confirm_password').value=== "")
    {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Favor de llenar los campos';
    }
};

var showButton = function(){
    
};