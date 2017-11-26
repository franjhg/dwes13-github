<html>
<head>
	<title>Conexión a BBDD con PHP</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de animales</h2>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"animales");
$conexion->query("SET NAMES 'UTF8'");
$imagenes="img/";
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>Chip</th>
<th>Nombre</th>
<th>Especie</th>
<th>Imagen</th>
</tr>
<?php
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
while($fila=$resultado->fetch_assoc()) {
    echo "<tr style='background-color:lightgreen'>";
    echo "<td>$fila[chip]</td>";
    echo "<td>$fila[nombre]</td>";
    echo "<td>$fila[especie]</td>\n";
    echo "<td><img src=$imagenes$fila[imagen]></td>\n";
    echo "</tr>";
}

echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</table>
<a href="indice.php">Volver al índice</a>
</body>
</html>