<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de animales</h2>
<?php
$servidor = "localhost";
$usuario = "alumno_rw";
$clave = "dwes";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");
$conexion->query("SET NAMES 'UTF8'");

//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<?php
$conexion ->query("UPDATE animal SET especie='jabali' WHERE nombre='Babe'");
echo "<h3 style='color:red'>". $conexion->error ."</h3>";

echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>

<a href="indice.php">Volver al índice</a>


</body>
</html>
