<?php
    session_name('idTest13');
    session_start();

    if (!isset($_SESSION["usuario"])){
        header("Location: registro.php");
    }else{
     
        echo "Bienvenido ".$_SESSION["usuario"]."<br>";
        echo "<a href='test1.php'>Comenzar Test</a>";
    }

?>