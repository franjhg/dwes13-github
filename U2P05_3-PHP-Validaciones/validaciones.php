<?php
    function validarEmail($mail){
        if(!empty($mail)){
            if(filter_var($mail, FILTER_VALIDATE_EMAIL) === FALSE){
            $errorEmail=true;
                }else{
                    $errorEmail=false;
                }
                return $errorEmail;
            }else{
                $errorEmail=true;
            }
            return $errorEmail;
    }
    function validarFecha($fecha){
        if(!empty($fecha)){
            $dia = (int)substr($fecha, 0, 2);
            $mes = (int)substr($fecha, 3, 2);
            $año = (int)substr($fecha, 6, 4);
            switch ($mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if ($dia > 0 && $dia <= 31) {
                        $errorFecha = false;
                    } else {
                        $errorFecha = true;
                    }
                    break;
                case 4:
                case 6:
                case 8:
                case 11:
                    if ($dia > 0 && $dia <= 30) {
                        $errorFecha = false;
                    } else {
                        $errorFecha = true;
                    }
                    break;
                case 2:
                    if ($dia <= 28 && $dia >= 1) {
                        $errorFecha = false;
                    } else if (($dia == 29 && (($año % 4 == 0 && $año % 100 != 0) || $año % 400 == 0))) {
                        $errorFecha = false;
                    } else {
                        $errorFecha = true;
                    }
                    break;
            }
             
           // $errorFecha=false;
        }else{
            $errorFecha=true;
        }
        return $errorFecha;
    }
    
    function validarContraseña($password){
        if(!empty($password)){
            if($password>6 && $password<16){
                $errorPass=false;
                }else{
                $errorPass=true;
                }
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
            if(preg_match("/^[9|6|7][0-9]{8}/", $telefono)){
                $errorTelefono=false;
            }else{
                $errorTelefono=true;
            }
            
            
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