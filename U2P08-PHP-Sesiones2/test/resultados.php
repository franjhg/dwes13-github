<?php
    session_name('idTest13');
    session_start();
    if( !$_SESSION["respuesta3"]){
        header("Location: test3.php");
    }
    if(isset($_REQUEST["comenzar"])){
        $_SESSION=array();
        header("Location:registro.php");
    }
    
    if (!isset($_SESSION["usuario"])){
        header("Location: registro.php");
    }

       if( $_SESSION["acierto1"]==1){
           echo "Respuesta 1 CORRECTA<br>";
       }else{
       echo  "Respuesta 1 INCORRECTA<br>";
       }
       if( $_SESSION["acierto2"]==1){
           echo "Respuesta 2 CORRECTA<br>";
       }else{
           echo  "Respuesta 2 INCORRECTA<br>";
       }
       if( $_SESSION["acierto3"]==1){
           echo "Respuesta 3 CORRECTA<br>";
       }else{
           echo  "Respuesta 3 INCORRECTA<br>";
       }
    
       echo "<a href='".$_SERVER['PHP_SELF']."?comenzar=true'>Comenzar de nuevo</a>";
    ?>