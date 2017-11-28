<?php 
include('Obra.php');
?>
<html>
<head>
	<title>Conexión a BBDD Catalogo13</title>
	<meta charset="UTF-8"/>
</head>
<body>

<?php
if (isset($_REQUEST['IdDisco'])){
    $paramDisco=$_REQUEST['IdDisco'];
}
             /* else{           AL FINAL
                echo "<p>Parámetro no recibido</p>"; 
                }*/
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
$conexion->query("SET NAMES 'UTF8'");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}

$resultado=$conexion->query("SELECT * FROM obra, autor")
?>