<?php
session_name('idSesion13');
session_start ();

if (!isset($_SESSION["nombre"])){
    header("Location: login.php");
}else{
    
    $_SESSION=array();
    header("Location: login.php");
    
    
}