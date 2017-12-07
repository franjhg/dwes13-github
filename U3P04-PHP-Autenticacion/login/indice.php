<?php 
    session_name('idSesion13');
    session_start ();
    include('conexion.php');
  
    if ($_SESSION["log"]==0){
        header("Location: login.php");
    }else{
      
         echo "<h1>Bienvenido ".$_SESSION["nombreCompleto"]."</h1><br><br>";    //NO saca NOMBRE COMPLETO
        echo "<a href='logout.php'>Cerrar sesion</a><br>";
        echo "<a href='baja.php'>Dar de baja</a><br>";
        echo "<a href='http://localhost/U3P03-PHP-Catalogo.php/mostrarCatalogoFinal.php'>Catalogo</a>";
        
       
    }
?>

