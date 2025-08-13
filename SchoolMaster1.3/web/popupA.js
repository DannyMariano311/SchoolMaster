/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var mos_profesor= document.getElementById("mos_g_profesor"),
    profesor= document.getElementById("g_profesor"),
    
    mos_niveles= document.getElementById("mos_niveles"), 
    niveles= document.getElementById("niveles"),
    
    mos_alumno= document.getElementById("mos_alumno"), 
    alumno= document.getElementById("alumnos"),
    
    mos_acudiente= document.getElementById("mos_acudiente"), 
    acudiente= document.getElementById("acudiente"),

    inicio= document.getElementById("inicio");


mos_profesor.addEventListener("click", function(){
  profesor.classList.add("active");
  
  niveles.classList.remove("active");
  alumno.classList.remove("active");
  acudiente.classList.remove("active");
  inicio.classList.add("inactive");
});


mos_niveles.addEventListener("click", function(){
  niveles.classList.add('active');
  
  profesor.classList.remove("active");
  alumno.classList.remove("active");
  acudiente.classList.remove("active");
  inicio.classList.add("inactive");
});

mos_alumno.addEventListener("click", function(){
  alumno.classList.add("active");
  
  profesor.classList.remove("active");
  niveles.classList.remove("active");
  acudiente.classList.remove("active");
  inicio.classList.add("inactive");
});

mos_acudiente.addEventListener("click", function(){
  acudiente.classList.add("active");
  
  profesor.classList.remove("active");
  niveles.classList.remove("active");
  alumno.classList.remove("active");
  inicio.classList.add("inactive");
});


