<html>
<head>
	<title>Conexión a BBDD Catalogo13</title>
	<meta charset="UTF-8"/>
</head>
<body>
<h2>Pruebas con la base de datos de Catalogo13</h2>
<?php
$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
$conexion->query("SET NAMES 'UTF8'");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>

<?php 
$resultado = $conexion -> query("SELECT * FROM obra ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Animal')) {
    // echo $animal."<br/>"; // primer intento más sencillo
    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getIdDisco()."</td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    echo "<td>".$obra->getAutor()."</td>\n";
    echo "<td>".$obra->getImagen()."</td>\n";
    echo "</tr>";
}
?>

<?php 
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>