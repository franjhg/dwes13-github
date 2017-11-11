<?php
    function validarEmail($mail){
        if(!empty($mail)){
            $errorEmail=false;
        }else{
            $errorEmail=true;
        }
        return $errorEmail;
    }
    
    function validarFecha($fecha){
        if(!empty($fecha)){
            $errorFecha=false;
        }else{
            $errorFecha=true;
        }
        return $errorFecha;
    }
    
    function validarContraseña($contraseña){
        if(!empty($contraseña)){
            $errorPass=false;
        }else{
            $errorPass=true;
        }
        return $errorPass;
    }

    function validarNombre($nom){
        if(!empty($nom)){
            $errorNombre=false;
        }else{
            $errorNombre=true;
        }
        return $errorNombre;
    }
    function validarApellidos($apellido){
        if(!empty($apellido)){
            $errorApellido=false;
        }else{
            $errorApellido=true;
        }
        return $errorApellido;
    }
    
    function validarTelefono($telefono){
        if(!empty($telefono)){
            $errorTelefono=false;
        }else{
            $errorTelefono=true;
        }
        return $errorTelefono;
    }
    
    function validarDireccion($direccion){
        if(!empty($direccion)){
            $errorDireccion=false;
        }else{
            $errorDireccion=true;
        }
        return $errorDireccion;
    }
    
    

?>