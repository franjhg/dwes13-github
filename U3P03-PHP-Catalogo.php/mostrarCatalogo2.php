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
include('Obra.php');

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
$conexion->query("SET NAMES 'UTF8'");
$ruta1="img/";

if ($conexion->connect_errno) {
    echo "<p>Error al establecer la conexión (" . $conexion->connect_errno . ") " . $conexion->connect_error . "</p>";
}
?>
<table style='border:0'>
<tr style='background-color:lightblue'>
<th>IdDisco</th>
<th>Titulo</th>
<th>Autor</th>
<th>Imagen</th>
</tr>
<?php 

/* $resultado = $conexion -> query("SELECT * FROM obra ORDER BY IdDisco");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_object('Obra')) {
   
    
    $resultado2 = $conexion -> query("SELECT Nombre FROM autor where IdAutor = ".$obra->getAutor());
    if($resultado2->num_rows === 0){
        echo "<p>No hay nombres en la base de datos</p>";
    }else{
        $resFinal=$resultado2->fetch_assoc();
        
    } */

$resultado = $conexion -> query("SELECT * from obra,autor WHERE autor.idAutor=obra.Autor");
if($resultado->num_rows === 0) echo "<p>No hay obras en la base de datos</p>";
while ($obra = $resultado->fetch_assoc()) {

    echo "<tr bgcolor='lightgreen'>";
    echo "<td>".$obra->getIdDisco()."</td>\n";
    echo "<td>".$obra->getTitulo()."</td>\n";
    //echo "<td>$resFinal[Nombre]</td>\n";
    echo "<td>".$obra->getNombreAutor()."</td>\n";
    //echo "<td>".$ruta1.$obra->getImagen()."</td>\n";
    echo "<td><img src='".$ruta1.$obra->getImagen()."'></td>\n";
    echo "</tr>";
    //mysqli_free_result($resultado2);
    
}
?>
</table>
<?php 
mysqli_free_result($resultado); //Liberamos la variable $resultado
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>
