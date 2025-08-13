/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var btnAbrirPopup = document.getElementById("btnAbrirPopup"),
    btnAbrirPopup2 = document.getElementById("btnAbrirPopup2"),
    overlay = document.getElementById("overlay"),
    popup = document.getElementById("popup"),
    btnCerrarPopup = document.getElementById("btn-cerrar-popup");

btnAbrirPopup.addEventListener("click", function(){
  overlay.classList.add("active");
});
btnAbrirPopup2.addEventListener("click", function(){
  overlay.classList.add("active");
});

btnCerrarPopup.addEventListener("click", function(){
  overlay.classList.remove("active");
});


//validar formulario
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validarFormulario); 
});

function validarFormulario(evento) {
  evento.preventDefault();
  var usuario = document.getElementById('Email').value;
  if(usuario.length === 0) {
    alert('No has escrito nada en el usuario');
    return;
  }
  var clave = document.getElementById('Password1').value;
  if (clave.length < 3) {
    alert('La clave no es válida');
    return;  
  }
  
  this.submit();
}; 

/*
//pequeña validacion
var inicio = document.getElementById("inicio");
var acu = "acudiente@gmail.com",
    pass_acu = "123acudiente",
    
    admin = "administrador@gmail.com",
    pass_adm = "123admin",
    
    profe = "profesor@gmail.com",
    pass_profe = "123profe";

inicio.addEventListener("click", function(){
  var email = document.getElementById("Email1"),
      pass= document.getElementById("Password1");
  
  if(email.value==acu && pass.value==pass_acu){
    inicio.href="Acudiente.jsp";
  }
  else if(email.value==admin && pass.value==pass_adm){
    inicio.href="Administrador.jsp";
  }
  else if(email.value==profe && pass.value==pass_profe){
    inicio.href="Profesor.jsp";
  }
});
*/