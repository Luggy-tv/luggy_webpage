/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var checkLogin = function(){
    if(document.getElementById('usuarioLogin').value === null||document.getElementById('usuarioLogin').value === "")
    {
        document.getElementById('msLogin').style.color= 'red';
        document.getElementById('msLogin').innerHTML ='Favor llenar campos';
    }

    if(document.getElementById('passwordLogin').value === null||document.getElementById('passwordLogin').value === "")
    {
        document.getElementById('msLogin').style.color= 'red';
        document.getElementById('msLogin').innerHTML ='Favor llenar campos';
    }
};