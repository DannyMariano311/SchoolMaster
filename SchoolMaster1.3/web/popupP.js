

var btn_actualizar = document.getElementById("btn-actualizar"),
        
    btn_borrar = document.getElementById("btn-optionBorrar"),
    
    actualizar = document.getElementById("actualizar"),
    borrar = document.getElementById("borrar");

btn_actualizar.addEventListener("click", function(){
  actualizar.classList.add("active");
  borrar.classList.remove("active");
});
btn_borrar.addEventListener("click", function(){
    borrar.classList.add("active");
    actualizar.classList.remove("active");
});

