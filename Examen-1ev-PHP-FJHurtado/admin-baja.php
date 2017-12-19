<?php
include('conexion.php');
session_start ();
if(!isset($_SESSION["nombre"])){
    header('location:admin-login.php');
}else{
    echo"<a href='admin-login.php'>Regresar a LOGIN </a>";
    $resultado = $conexion -> query("SELECT nombre_i from temas ");
    if($resultado->num_rows === 0) echo "<p>No hay temas en la base de datos</p>";
    
    while ($obra = $resultado->fetch_assoc()) {
        echo "<p>$obra[nombre_i]</p>";
    
    }
    
}