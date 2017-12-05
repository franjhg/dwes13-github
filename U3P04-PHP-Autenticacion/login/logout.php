<?php
session_name('idSesion13');
session_start ();

if (!isset($_SESSION["log"])){
    header("Location: login.php");
}else{
    
    $_SESSION=array();
    header("Location: login.php");
    
    
}