<?php 
    session_name('idSesion13');
    session_start ();
    
    if (!isset($_SESSION["nombre"])){
        header("Location: login.php");
    }else{
        
        echo "Bienvenido ".$_SESSION["nombre"]."<br>";
       
       echo "<a href='logout.php'>Cerrar sesion</a>";
    }
    
?>

