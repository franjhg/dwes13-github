<?php
include 'conexion.php';
$conexion = new mysqli($servidor,$usuario,$clave,"animales");
//si quisiéramos hacerlo en dos pasos:
// $conexion = new mysqli($servidor,$usuario,$clave);
// $conexion->select_db("animales");

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
echo "<p>A continuación mostramos algunos registros:</p>";
$resultado = $conexion -> query("SELECT * FROM animal ORDER BY nombre");
if($resultado->num_rows === 0) echo "<p>No hay animales en la base de datos</p>";
$fila=$resultado->fetch_assoc();
while($fila!=null) {
    echo "<hr>";
    echo "Nombre:" . $fila['nombre'];
    echo "<br>Especie: $fila[especie]"; // observa la diferencia en el uso de comillas
    $fila=$resultado->fetch_assoc();
}
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
