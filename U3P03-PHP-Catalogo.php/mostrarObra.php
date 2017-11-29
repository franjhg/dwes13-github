<?php 
//include('mostrarCatalogo.php');
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

$servidor = "localhost";
$usuario = "alumno";
$clave = "alumno";
$ruta="img/";

$conexion = new mysqli($servidor,$usuario,$clave,"catalogo13");
$conexion->query("SET NAMES 'UTF8'");

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
$resultado=$conexion->query("SELECT * FROM obra, autor WHERE obra.IdDisco=$paramDisco AND obra.Autor=autor.IdAutor");
if($resultado->num_rows === 0) echo "<p>No hay resultados para esta consulta</p>";
    $resul = $resultado->fetch_object('Obra');
    

echo "<tr bgcolor='lightgreen'>";
echo "<td>".$resul->getIdDisco()."</td>\n";
echo "<td>".$resul->getTitulo()."</td>\n";

$resultado2 = $conexion -> query("SELECT Nombre FROM autor where IdAutor = ".$resul->getAutor());
if($resultado2->num_rows === 0){
    echo "<p>No hay nombres en la base de datos</p>";
}else{
    $resFinal=$resultado2->fetch_assoc();
    
} 

echo "<td>$resFinal[Nombre]</td>\n";
echo "<td><img src='".$ruta.$resul->getimagen()."'></td>\n";
echo "</tr>";

}
 else{           
 echo "<p>Parámetro no recibido</p>";
 }
?>
</table>
<?php 
mysqli_free_result($resul); //Liberamos la variable $resultado  DA ERROR
echo "<h3>Desconectando...</h3>";
mysqli_close($conexion);
?>
</body>
</html>
